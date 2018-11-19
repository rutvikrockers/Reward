package com.rock.reward.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.rock.reward.volleyWebservice.Constants;
import com.android.volley.Request;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.ResponsePojo.ResponseSignupPojo;
import com.rock.reward.activity.HomeActivity;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.UserLogin;
import com.rock.reward.utils.Utils;
import com.rock.reward.utils.Validation;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignUpFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class SignUpFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RewardRestInterface restInterface;
    private ImageView cancelSignup;
    private View view;
    private TextView fullName;
    private TextView password;
    private TextView email;
    private Button signUpButton;
    private String token;

    private TwitterLoginButton twitterLoginButton;
    private LoginButton facebookLoginButton;
    private Button fbLogin;
    private Button twitterButton;
    CallbackManager callbackManager;
    private UserLogin userLogin;

    private static final String EMAIL = "email";

    private int socialType;
    private Bundle bundle;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().hide();
//        ((HomeActivity) getActivity()).mBottomBar.setVisibility(View.GONE);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        callbackManager = CallbackManager.Factory.create();

        view = inflater.inflate(R.layout.fragment_sign_up, container, false);


        twitterLoginButton = (TwitterLoginButton) view.findViewById(R.id.twitter_login_button);
        facebookLoginButton = (LoginButton)view.findViewById(R.id.login_button);
       /* facebookLoginButton.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_birthday", "user_friends"));*/
        facebookLoginButton.setReadPermissions(Arrays.asList(EMAIL));
        facebookLoginButton.setFragment(this);

        fbLogin = (Button)view.findViewById(R.id.btn_singin_facebook);
        twitterButton= (Button)view.findViewById(R.id.btn_singin_twitter);
        fbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                facebookLoginButton.performClick();
            }
        });

        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twitterLoginButton.performClick();
            }
        });

        twitterLoginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

                TwitterSession session = Twitter.getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                final String token = authToken.token;
                final String secret = authToken.secret;
                String username = session.getUserName();
                final String email ="";
                socialType = 2;
                final String twitterId =  String.valueOf(session.getUserId());


                Twitter.getApiClient(session).getAccountService()
                        .verifyCredentials(true, false, new Callback<User>() {
                            @Override
                            public void failure(TwitterException e) {

                            }

                            @Override
                            public void success(Result<User> userResult) {
                                User user = userResult.data;
                                String twitterImage = user.profileImageUrl;
                                String twitterScreenName =  user.screenName;
                                String fullName =  user.name;

                                SocialLogin(socialType,twitterId,email, fullName,"",twitterImage,"",twitterScreenName,token,secret );
                            }
                        });

//                TwitterAuthClient authClient = new TwitterAuthClient();
//                authClient.requestEmail(session, new Callback<String>() {
//                    @Override
//                    public void success(Result<String> result) {
//                        Log.e("result.data;", String.valueOf(result));
//
//                        // Do something with the result, which provides the email address
//                    }
//
//                    @Override
//                    public void failure(TwitterException exception) {
//                        Log.e("result.data;", String.valueOf(exception));
//
//                        // Do something on failure
//                    }
//                });
            }
            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        });

        // Callback registration
        facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                // App code
                final String facebookAccessToken = String.valueOf(loginResult.getAccessToken());

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback(){

                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {

                                try {
                                    JSONObject obj = object.getJSONObject("picture").getJSONObject("data");

                                    String fbId = object.getString("id");
                                    String email = object.getString("email");
                                    String fullName = object.getString("name");
                                    String socialImage=obj.getString("url");
                                    socialType = 1;
                                    SocialLogin(socialType,fbId,email,fullName,"",socialImage,facebookAccessToken,"","","" );
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday,picture.width(300).height(300)");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                // App code
                Log.e("facebook id", "on cancel");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.e("facebook id", "on onError");

            }
        });

        cancelSignup = (ImageView)view.findViewById(R.id.cancel_signup);

        fullName = (TextView)view.findViewById(R.id.full_name);
        email = (TextView)view.findViewById(R.id.email);
        password = (TextView)view.findViewById(R.id.password);

        signUpButton = (Button)view.findViewById(R.id.signup_button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

        cancelSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("signup","signup");
                mListener.onSignUpFragment("login");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void SocialLogin(final int SocialType, final String UserId, final String Email,
                             final String FullName, final String Password, final String SocialImage, final String FbAccessToken,
                             final String TwitterScreenName, final String TwitterOauthToken,
                             final String TwitterOauthTokenSecret){

        WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
        RequestParam rp = new RequestParam();
        String guestUser = ((HomeActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER);
        try {
            JSONObject jsonObject = new JSONObject(guestUser);
            token = jsonObject.getString(Constants.TOKEN_STR);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        rp.putHeader(Constants.TOKEN, token);
        rp.putParams(Constants.SOCIAL_TYPE, String.valueOf(SocialType));
        rp.putParams(Constants.SOCIAL_ID, UserId);
        rp.putParams(Constants.EMAIL, Email);
        rp.putParams(Constants.PASSWORD, Password);
        rp.putParams(Constants.FULL_NAME, FullName);
        rp.putParams(Constants.SOCIAL_PROFILE_IMAGE, SocialImage);
        rp.putParams(Constants.TW_SCREEN_NAME, TwitterScreenName);
        rp.putParams(Constants.TW_OAUTH_TOKEN, TwitterOauthToken);
        rp.putParams(Constants.TW_OAUTH_TOKEN_SECRET, TwitterOauthTokenSecret);
        rp.putParams(Constants.FB_ACCESS_TOKEN, FbAccessToken);
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
     //   Call<UserLogin> call = restInterface.SocialLoginRegister(token,String.valueOf(SocialType),UserId,Email,Password,FullName,SocialImage,TwitterScreenName,TwitterOauthToken,TwitterOauthTokenSecret,FbAccessToken);
        /*    call.enqueue(new retrofit2.Callback<UserLogin>() {
                @Override
                public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                    try {
                        Gson gson = new Gson();
                    //    userLogin = gson.fromJson(result.getJSONObject(Constants.DATA).toString(),UserLogin.class);
                        String json = gson.toJson(userLogin);

                        //Store the user profile detail shared preferences
                        ((HomeActivity)getActivity()).preferencesHelper.putPrefString(PreferencesHelper.USER_LOGIN, json);

                        //guest logged in
                        ((HomeActivity)getActivity()).preferencesHelper.putPrefBoolean(PreferencesHelper.USER_LOGGED_IN, true);

                        mListener.onSignUpFragment("home");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<UserLogin> call, Throwable t) {
                        t.printStackTrace();
                }
            });*/

        objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.SOCIAL_LOGIN , rp, new WebServiceHelper.OnWebServiceListener() {

            @Override
            public void successResponse(JSONObject result) {
                try {
                    Gson gson = new Gson();
                    userLogin = gson.fromJson(result.getJSONObject(Constants.DATA).toString(),UserLogin.class);
                    String json = gson.toJson(userLogin);

                    //Store the user profile detail shared preferences
                    ((HomeActivity)getActivity()).preferencesHelper.putPrefString(PreferencesHelper.USER_LOGIN, json);

                    //guest logged in
                    ((HomeActivity)getActivity()).preferencesHelper.putPrefBoolean(PreferencesHelper.USER_LOGGED_IN, true);

                    mListener.onSignUpFragment("home");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.e("success", errorMessage.toString()+errorCode);
                if(errorCode==3021){
                    bundle = new Bundle();
                    bundle.putInt(Constants.SOCIAL_TYPE, SocialType);
                    bundle.putString(Constants.SOCIAL_ID, UserId);
                    bundle.putString(Constants.EMAIL, Email);
                    bundle.putString(Constants.FULL_NAME, FullName);
                    bundle.putString(Constants.SOCIAL_PROFILE_IMAGE, SocialImage);
                    bundle.putString(Constants.TW_SCREEN_NAME, TwitterScreenName);
                    bundle.putString(Constants.TW_OAUTH_TOKEN, TwitterOauthToken);
                    bundle.putString(Constants.TW_OAUTH_TOKEN_SECRET, TwitterOauthTokenSecret);
                    bundle.putString(Constants.FB_ACCESS_TOKEN, FbAccessToken);

                    mListener.onSocialSignupFragment(bundle);

//                    SocialLogin(SocialType,UserId,Email,FullName,Password,SocialImage,FbAccessToken,TwitterScreenName,TwitterOauthToken,TwitterOauthTokenSecret);
                }
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String string) {
        if (mListener != null) {
            mListener.onSignUpFragment(string);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onSignUpFragment(String string);
        void onSocialSignupFragment(Bundle bundle);
    }

    private void signUp(){
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        String userFullName = fullName.getText().toString();

        boolean validEmail = Validation.isValidEmailAddress(userEmail);
        String validFullName = Validation.isValidFullName(userFullName);
        String validPassword = Validation.isValidPassword(userPassword);

        Utils.showLoader(getActivity());

        if(validFullName!=null){
            Utils.hideLoader(getActivity());
            Utils.showAlert(getActivity(), validFullName);
        }else if(validEmail==false){
            Utils.hideLoader(getActivity());
            Utils.showAlert(getActivity(), "Invalid email");
        }else if(validPassword!=null){
            Utils.hideLoader(getActivity());
            Utils.showAlert(getActivity(),validPassword);
        }else{

            WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
            RequestParam rp = new RequestParam();
            String guestUser = ((HomeActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER);
            try {
                JSONObject jsonObject = new JSONObject(guestUser);
                token = jsonObject.getString(Constants.TOKEN_STR);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            rp.putHeader(Constants.TOKEN, token);
            rp.putHeader(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
            rp.putParams(Constants.EMAIL, userEmail);
            rp.putParams(Constants.FULL_NAME, userFullName);
            rp.putParams(Constants.PASSWORD, userPassword);
            restInterface = ApiClient.getClient().create(RewardRestInterface.class);
            Call<ResponseSignupPojo> call = restInterface.UserRegister(token,userEmail,userFullName,userPassword);
            call.enqueue(new retrofit2.Callback<ResponseSignupPojo>() {
                @Override
                public void onResponse(Call<ResponseSignupPojo> call, Response<ResponseSignupPojo> response) {
                    try {
                        Utils.showAlert(getActivity(),response.body().getMessage());
                        mListener.onSignUpFragment("home");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseSignupPojo> call, Throwable t) {
                      t.printStackTrace();
                }
            });

          /*  objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.USER_REGISTER , rp, new WebServiceHelper.OnWebServiceListener() {

                @Override
                public void successResponse(JSONObject result) {
                    try {
                        Utils.showAlert(getActivity(), result.getString("message"));
                        mListener.onSignUpFragment("home");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failureResponse(String errorMessage, int errorCode) {
                    Log.e("success", errorMessage.toString());
                    Utils.hideLoader(getActivity());
                    Utils.showAlert(getActivity(), errorMessage);
                }
            });*/
            Utils.hideLoader(getActivity());
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        twitterLoginButton.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
