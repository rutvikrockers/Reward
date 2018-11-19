package com.rock.reward.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.rock.reward.volleyWebservice.Constants;
import com.android.volley.Request;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.activity.HomeActivity;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.UserLogin;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SocialLoginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SocialLoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SocialLoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText email;
    private EditText fullName;
    private View view;
    private Button signUp;
    private Bundle bundle;
    private String token;
    private UserLogin userLogin;
    private RewardRestInterface restInterface;


    private OnFragmentInteractionListener mListener;

    public SocialLoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SocialLoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SocialLoginFragment newInstance(String param1, String param2) {
        SocialLoginFragment fragment = new SocialLoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           bundle = this.getArguments();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_social_login, container, false);

        email = (EditText)view.findViewById(R.id.email);
        fullName = (EditText)view.findViewById(R.id.full_name);
        signUp = (Button)view.findViewById(R.id.signup_button);

        fullName.setText(bundle.getString(Constants.FULL_NAME));


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitSocialLogin();
            }
        });

        return view;
    }

    private void submitSocialLogin(){
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
        rp.putParams(Constants.SOCIAL_TYPE, String.valueOf(bundle.getInt(Constants.SOCIAL_TYPE)));
        rp.putParams(Constants.SOCIAL_ID, bundle.getString(Constants.SOCIAL_ID));
        rp.putParams(Constants.EMAIL, String.valueOf(email.getText()));
        rp.putParams(Constants.PASSWORD, "");
        rp.putParams(Constants.FULL_NAME, String.valueOf(fullName.getText()));
        rp.putParams(Constants.SOCIAL_PROFILE_IMAGE, bundle.getString(Constants.SOCIAL_PROFILE_IMAGE));
        rp.putParams(Constants.TW_SCREEN_NAME, bundle.getString(Constants.TW_SCREEN_NAME));
        rp.putParams(Constants.TW_OAUTH_TOKEN, bundle.getString(Constants.TW_OAUTH_TOKEN));
        rp.putParams(Constants.TW_OAUTH_TOKEN_SECRET, bundle.getString(Constants.TW_OAUTH_TOKEN_SECRET));
        rp.putParams(Constants.FB_ACCESS_TOKEN, bundle.getString(Constants.FB_ACCESS_TOKEN));
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
     //   Call<UserLogin> call = restInterface.SocialLoginRegister(token,String.valueOf(bundle.getInt(Constants.SOCIAL_TYPE)),bundle.getString(Constants.SOCIAL_ID),String.valueOf(email.getText()),"",String.valueOf(fullName.getText()),bundle.getString(Constants.SOCIAL_PROFILE_IMAGE),bundle.getString(Constants.TW_SCREEN_NAME),bundle.getString(Constants.TW_OAUTH_TOKEN),bundle.getString(Constants.TW_OAUTH_TOKEN_SECRET),bundle.getString(Constants.FB_ACCESS_TOKEN));
     /* call.enqueue(new Callback<UserLogin>() {
          @Override
          public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
              try {
                  Gson gson = new Gson();
                 // userLogin = gson.fromJson(result.getJSONObject(Constants.DATA).toString(),UserLogin.class);
                  String json = gson.toJson(userLogin);

                  //Store the user profile detail shared preferences
                  ((HomeActivity)getActivity()).preferencesHelper.putPrefString(PreferencesHelper.USER_LOGIN, json);

                  //guest logged in
                  ((HomeActivity)getActivity()).preferencesHelper.putPrefBoolean(PreferencesHelper.USER_LOGGED_IN, true);

                  mListener.onSocialLoginInteraction();

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

                    mListener.onSocialLoginInteraction();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSocialLoginInteraction();
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
        void onSocialLoginInteraction();
    }
}
