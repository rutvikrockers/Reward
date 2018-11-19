package com.rock.reward.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

/*Twitter Imports*/
import com.rock.reward.ResponsePojo.ResponseUserLogin;
import com.rock.reward.activity.ForgotPasswordActivity;
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
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;


public class LoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TwitterLoginButton twitterLoginButton;

    private LoginButton facebookLoginButton;

    private Button loginButton;
    private EditText email;
    private EditText password;
    private String token;
    private UserLogin userLogin;
    private RewardRestInterface restInterface;
    private EditText editTextPassword,editTextEmail;
    private TextView forgotpassword;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    CallbackManager callbackManager;
    private TextView info;
    private Button fbLogin;
    private Button twitterButton;
    TwitterAuthClient mTwitterAuthClient;
    private TextView signup;
    private int socialType;
    private Bundle bundle;
    private static final String EMAIL = "email";
    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ((HomeActivity) getActivity()).getSupportActionBar().hide();
//        ((HomeActivity) getActivity()).mBottomBar.setVisibility(View.INVISIBLE);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        callbackManager = CallbackManager.Factory.create();

        view = inflater.inflate(R.layout.fragment_login, container, false);

        loginButton = (Button)view.findViewById(R.id.signup_button);
        email = (EditText)view.findViewById(R.id.full_name);
        password = (EditText)view.findViewById(R.id.email);
        signup = (TextView)view.findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Signup","Clicked");
                mListener.onHomeFragment("register");
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin();
            }
        });

        twitterLoginButton = (TwitterLoginButton) view.findViewById(R.id.twitter_login_button);
        forgotpassword = (TextView) view.findViewById(R.id.tv_forgot_password);
        facebookLoginButton = (LoginButton)view.findViewById(R.id.login_button);
       /* facebookLoginButton.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_birthday", "user_friends"));*/
        facebookLoginButton.setReadPermissions(Arrays.asList(EMAIL));
        facebookLoginButton.setFragment(this);

        info = (TextView)view.findViewById(R.id.info);
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
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction();
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guestUser = ((HomeActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER);
                try {
                    JSONObject jsonObject = new JSONObject(guestUser);
                    token = jsonObject.getString(Constants.TOKEN_STR);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getActivity(),ForgotPasswordActivity.class);
                intent.putExtra("www-token",token);
                startActivity(intent);


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

        // Inflate the layout for this fragment
        return view;
    }

    private void linkedInLogin(View view){
        
    }

    private void getUserData() {


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

                    mListener.onFragmentInteraction();

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

                    mListener.onSocialFragment(bundle);

//                    SocialLogin(SocialType,UserId,Email,FullName,Password,SocialImage,FbAccessToken,TwitterScreenName,TwitterOauthToken,TwitterOauthTokenSecret);
                }
            }
        });
    }

    private void doLogin(){
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        Utils.showLoader(getActivity());

        if(Validation.isValidEmailAddress(userEmail) && Validation.isValidPassword(userPassword)==null){
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
            rp.putParams(Constants.PASSWORD, userPassword);
            restInterface = ApiClient.getClient().create(RewardRestInterface.class);
            Call<ResponseUserLogin> call = restInterface.UserLogin(token,userEmail,userPassword);
            call.enqueue(new retrofit2.Callback<ResponseUserLogin>() {
                @Override
                public void onResponse(Call<ResponseUserLogin> call, Response<ResponseUserLogin> response) {
                    try {
                        Gson gson = new Gson();

                        //userLogin = gson.fromJson(result.getJSONObject(Constants.DATA).toString(),UserLogin.class);

                        String json = gson.toJson(response.body().getData());

                        //Store the user profile detail shared preferences
                        ((HomeActivity)getActivity()).preferencesHelper.putPrefString(PreferencesHelper.USER_LOGIN, json);

                        //guest logged in
                        ((HomeActivity)getActivity()).preferencesHelper.putPrefBoolean(PreferencesHelper.USER_LOGGED_IN, true);

                        mListener.onFragmentInteraction();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseUserLogin> call, Throwable t) {

                }
            });
            /*objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.USER_LOGIN , rp, new WebServiceHelper.OnWebServiceListener() {

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

                        mListener.onFragmentInteraction();

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
        }else{
            Utils.hideLoader(getActivity());
            Utils.showAlert(getActivity(), "Invalid email or password.");
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction();
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();

        void onHomeFragment(String task);

        void onSocialFragment(Bundle bundle);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        mTwitterAuthClient.onActivityResult(requestCode, resultCode, data);
        twitterLoginButton.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
