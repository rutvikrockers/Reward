package com.rock.reward.fragment.userProfile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.rock.reward.volleyWebservice.Constants;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.ResponsePojo.ResponseUpdateAccount;
import com.rock.reward.activity.EditUserProfileActivity;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.utils.Utils;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EditSocialDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EditSocialDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditSocialDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Bundle mParam;

    private EditText facebookUrl;
    private EditText twitterUrl;
    private EditText websiteUrl;
    private EditText linkedInUrl;
    private EditText googlePlusUrl;
    private EditText bandcampUrl;
    private EditText youTubeUrl;
    private EditText mySpaceUrl;
    private Button saveChanges;

    private String facebookUrlValue;
    private String twitterUrlValue;
    private String websiteUrlValue;
    private String linkedInUrlValue;
    private String googlePlusUrlValue;
    private String bandcampUrlValue;
    private String youTubeUrlValue;
    private String mySpaceUrlValue;
    private RewardRestInterface restInterface;
    private String firstName;
    private String lastName;
    private String address;
    private String zipcode;


    private String token;

    private OnFragmentInteractionListener mListener;
    private View view;

    public EditSocialDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment EditSocialDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditSocialDetailsFragment newInstance(Bundle param1) {
        EditSocialDetailsFragment fragment = new EditSocialDetailsFragment();
        Bundle args = new Bundle();
        args.putAll(param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_edit_social_details, container, false);

        facebookUrl = (EditText)view.findViewById(R.id.facebook_url);
        twitterUrl = (EditText)view.findViewById(R.id.twitter_url);
        linkedInUrl = (EditText)view.findViewById(R.id.linkedin_url);
        youTubeUrl = (EditText)view.findViewById(R.id.youtube_url);
        googlePlusUrl = (EditText)view.findViewById(R.id.google_plus_url);
        websiteUrl = (EditText)view.findViewById(R.id.website);
        bandcampUrl = (EditText)view.findViewById(R.id.bandcamp_url);
        mySpaceUrl = (EditText)view.findViewById(R.id.myspace_url);

        saveChanges = (Button)view.findViewById(R.id.save_changes);

        facebookUrl.setText(mParam.getString(Constants.FACEBOOK_URL));
        twitterUrl.setText(mParam.getString(Constants.TWITTER_URL));
        linkedInUrl.setText(mParam.getString(Constants.LINKEDIN_URL));
        youTubeUrl.setText(mParam.getString(Constants.YOUTUBE_URL));
        googlePlusUrl.setText(mParam.getString(Constants.GOOGLEPLUS_URL));
        websiteUrl.setText(mParam.getString(Constants.WEBSITE_URL));
        bandcampUrl.setText(mParam.getString(Constants.BANDCAMP_URL));
        mySpaceUrl.setText(mParam.getString(Constants.MYSPACE_URL));

        firstName = mParam.getString(Constants.FIRSTNAME);
        lastName = mParam.getString(Constants.LASTNAME);
        address = mParam.getString(Constants.ADDRESS);
        zipcode = mParam.getString(Constants.ZIPCODE);

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSocialDetails();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
    private String validateUrls(){

        facebookUrlValue = String.valueOf(facebookUrl.getText());
        twitterUrlValue = String.valueOf(twitterUrl.getText());
        linkedInUrlValue = String.valueOf(linkedInUrl.getText());
        googlePlusUrlValue = String.valueOf(googlePlusUrl.getText());
        websiteUrlValue = String.valueOf(websiteUrl.getText());
        mySpaceUrlValue = String.valueOf(mySpaceUrl.getText());
        youTubeUrlValue = String.valueOf(youTubeUrl.getText());
        bandcampUrlValue = String.valueOf(bandcampUrl.getText());

        return null;
    }
    private void saveSocialDetails(){
        validateUrls();
        JSONObject social = null;
        try {
            JSONObject profile = new JSONObject();
            JSONObject profiles = new JSONObject();
            profile.put(Constants.FACEBOOK_URL,facebookUrlValue);
            profile.put(Constants.TWITTER_URL,twitterUrlValue);
            profile.put(Constants.LINKEDIN_URL,linkedInUrlValue);
            profile.put(Constants.GOOGLEPLUS_URL,googlePlusUrlValue);
            profile.put(Constants.WEBSITE_URL,websiteUrlValue);
            profile.put(Constants.BANDCAMP_URL,bandcampUrlValue);
            profile.put(Constants.YOUTUBE_URL,youTubeUrlValue);
            profile.put(Constants.MYSPACE_URL,mySpaceUrlValue);

            profiles.put(Constants.FIRSTNAME,firstName);
            profiles.put(Constants.LASTNAME,lastName);
            profiles.put(Constants.ZIPCODE,zipcode);
            profiles.put(Constants.ADDRESS,address);

            social = new JSONObject();
            social.put("social_links",profile);
            social.put("profile",profiles);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Utils.showLoader(getActivity());

        WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
        RequestParam rp = new RequestParam();
        String guestUser = ((EditUserProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
        try {
            JSONObject jsonObject = new JSONObject(guestUser);
            token = jsonObject.getString(Constants.TOKEN_STR);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        rp.putHeader(Constants.TOKEN, token);
        rp.putHeader(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
        rp.putParams(Constants.PROFILE_DATA, String.valueOf(social));


        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
        Call<ResponseUpdateAccount> call = restInterface.UpdateAccount(token,String.valueOf(social));
        call.enqueue(new Callback<ResponseUpdateAccount>() {
            @Override
            public void onResponse(Call<ResponseUpdateAccount> call, Response<ResponseUpdateAccount> response) {
                Toast.makeText(getActivity(), "Information saved.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseUpdateAccount> call, Throwable t) {
                Log.e("success", t.toString());
                Utils.hideLoader(getActivity());
              //  Utils.showAlert(getActivity(), t.printStackTrace());
            }
        });
     /*   objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.UPDATE_ACCOUNT , rp, new WebServiceHelper.OnWebServiceListener() {

            @Override
            public void successResponse(JSONObject result) {
                Toast.makeText(getActivity(), "Information saved.", Toast.LENGTH_SHORT).show();
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
        void onFragmentInteraction(Uri uri);
    }
}
