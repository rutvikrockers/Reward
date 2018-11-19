package com.rock.reward.fragment.userProfile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rock.reward.volleyWebservice.Constants;
import com.android.volley.Request;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.ResponsePojo.ResponseUserProfile;
import com.rock.reward.activity.ProfileActivity;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.ProfileData;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserOverviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserOverviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserOverviewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_USER_ID = "user_id";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String token;
    private String userId;

    private View view;

    private TextView aboutMe;
    private TextView occupation;
    private TextView interest;
    private TextView skills;

    private LinearLayout layoutSkills;
    private LinearLayout layoutAboutMe;
    private LinearLayout layoutInterest;
    private LinearLayout layoutOccupation;
    private RewardRestInterface restInterface;
    private String fbUrl;
    private String googleUrl;
    private String linkedInUrl;
    private String mySpaceUrl;
    private String twitterUrl;
    private String youtubeUrl;
    private String userid;

    private ProfileData profileData;
    private TextView noData;





    private OnFragmentInteractionListener mListener;

    public UserOverviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param userId Parameter 1.
     * @return A new instance of fragment UserOverviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserOverviewFragment newInstance(String userId) {

        Log.e("UseruserIdFragment",userId+"<=user_id");

        UserOverviewFragment fragment = new UserOverviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_ID, userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userId = getArguments().getString(ARG_USER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_overview2, container, false);

        aboutMe = (TextView)view.findViewById(R.id.about_me);
        skills = (TextView)view.findViewById(R.id.skills);
        interest = (TextView)view.findViewById(R.id.interest);
        occupation = (TextView)view.findViewById(R.id.occupation);

        layoutSkills = (LinearLayout)view.findViewById(R.id.layout_skills);
        layoutAboutMe = (LinearLayout)view.findViewById(R.id.layout_about_me);
        layoutInterest = (LinearLayout)view.findViewById(R.id.layout_interest);
        layoutOccupation = (LinearLayout)view.findViewById(R.id.layout_occupation);


        ((ProfileActivity) getActivity()).fbIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkInBrowser(fbUrl);
            }
        });
        ((ProfileActivity) getActivity()).twIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkInBrowser(twitterUrl);
            }
        });
        ((ProfileActivity) getActivity()).lnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkInBrowser(linkedInUrl);
            }
        });
        ((ProfileActivity) getActivity()).googleIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkInBrowser(googleUrl);
            }
        });
        ((ProfileActivity) getActivity()).mySpaceIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkInBrowser(mySpaceUrl);
            }
        });
        ((ProfileActivity) getActivity()).youtubeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkInBrowser(youtubeUrl);
            }
        });

        Log.e("userIdFragment",userId+"<=user_id");
        noData = (TextView)view.findViewById(R.id.no_data);

        getUserInfo();

        // Inflate the layout for this fragment
        return view;
    }

    private void openLinkInBrowser(String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(browserIntent);
    }

    private void getUserInfo(){
        WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
        RequestParam rp = new RequestParam();
        if(((ProfileActivity) getActivity()).preferencesHelper.getPrefBoolean(PreferencesHelper.USER_LOGGED_IN)){
            String loginUser = (((ProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN));
            try {
                JSONObject jsonObject = new JSONObject(loginUser);
                token = jsonObject.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            String guestUser = (((ProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER));
            try {
                JSONObject jsonObject = new JSONObject(guestUser);
                token = jsonObject.getString(Constants.TOKEN_STR);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        rp.putHeader(Constants.TOKEN, token);
        rp.putHeader(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
        rp.putParams(Constants.USER_ID, userId);

        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
        Call<ResponseUserProfile> call = restInterface.UserProfile(token,userId);
    /*   call.enqueue(new Callback<ResponseUserProfile>() {
            @Override
            public void onResponse(Call<ResponseUserProfile> call, Response<ResponseUserProfile> response) {
                try{
              //      boolean showNoData = false;



                    fbUrl = response.body().getData().getSocial_links().getFacebookUrl();
                    googleUrl = response.body().getData().getSocial_links().getGoogleplusUrl();
                    linkedInUrl =response.body().getData().getSocial_links().getLinkedlnUrl();
                    mySpaceUrl =response.body().getData().getSocial_links().getMyspaceUrl();
                    twitterUrl = response.body().getData().getSocial_links().getTwitterUrl();
                    youtubeUrl = response.body().getData().getSocial_links().getYoutubeUrl();

                    if(fbUrl==null || fbUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).fbIcon.setVisibility(View.INVISIBLE);
                    }
                    if(googleUrl==null || googleUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).googleIcon.setVisibility(View.INVISIBLE);
                    }
                    if(linkedInUrl==null || linkedInUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).lnIcon.setVisibility(View.INVISIBLE);
                    }
                    if(mySpaceUrl==null || mySpaceUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).mySpaceIcon.setVisibility(View.INVISIBLE);
                    }
                    if(twitterUrl==null || twitterUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).twIcon.setVisibility(View.INVISIBLE);
                    }
                    if(youtubeUrl==null || youtubeUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).youtubeIcon.setVisibility(View.INVISIBLE);
                    }


                    String userImageUrl = response.body().getData().getProfile().getUserImageUrl();
                    String userSkill = response.body().getData().getProfile().getUserSkill();
                    String userInterest = response.body().getData().getProfile().getUserInterest();
                    String userOccupation =response.body().getData().getProfile().getUserOccupation();
                    String userAboutMe = response.body().getData().getProfile().getUserAbout();

                    ((ProfileActivity) getActivity()).userName.setText(response.body().getData().getProfile().getFirstName()+" "+response.body().getData().getProfile().getLastName());

                    if(userSkill!=null && !userSkill.isEmpty()){
                        skills.setText(userSkill);
                    }else{
                        layoutSkills.setVisibility(View.GONE);
                    }
                    if(userInterest!=null && !userInterest.isEmpty()){
                        interest.setText(userInterest);
                    }else{
                        layoutInterest.setVisibility(View.GONE);
                    }
                    if(userOccupation!=null && !userOccupation.isEmpty()){
                        occupation.setText(userOccupation);
                    }else{
                        layoutOccupation.setVisibility(View.GONE);
                    }
                    if(userAboutMe!=null && !userAboutMe.isEmpty()){
                        aboutMe.setText(userAboutMe);
                    }else{
                        layoutAboutMe.setVisibility(View.GONE);
                    }

//                    if(userSkill.isEmpty() && userInterest.isEmpty() && userOccupation.isEmpty() && userAboutMe.isEmpty()){
//                        noData.setText("No data found.");
//                    }

                    Glide.with(getActivity())
                            .load(userImageUrl)
                            .crossFade()
                            .into(((ProfileActivity) getActivity()).userImage);

                    Glide.with(getActivity())
                            .load(userImageUrl)
                            .crossFade()
                            .into(((ProfileActivity) getActivity()).userImageCircular);

//                    noData.setVisibility(View.INVISIBLE);

                    Bundle bundle = new Bundle();

                    bundle.putString(Constants.FIRSTNAME,response.body().getData().getProfile().getFirstName());
                    bundle.putString(Constants.USER_ID,response.body().getData().getProfile().getUserId());
                    bundle.putString(Constants.USER_IMAGE,response.body().getData().getProfile().getUserImageUrl());
                    bundle.putString(Constants.LASTNAME,response.body().getData().getProfile().getLastName());
                    bundle.putString(Constants.ZIPCODE,response.body().getData().getProfile().getZipCode());
                    bundle.putString(Constants.PROFILE_SLUG,response.body().getData().getProfile().getProfileSlug());
                    bundle.putString(Constants.EMAIL,response.body().getData().getProfile().getEmail());
                    bundle.putString(Constants.ADDRESS,response.body().getData().getProfile().getAddress());
                    bundle.putString(Constants.USER_ABOUT,response.body().getData().getProfile().getUserAbout());
                    bundle.putString(Constants.USER_OCCUPATION,response.body().getData().getProfile().getUserOccupation());
                    bundle.putString(Constants.USER_INTEREST,response.body().getData().getProfile().getUserInterest());
                    bundle.putString(Constants.USER_SKILL,response.body().getData().getProfile().getUserSkill());

                    bundle.putString(Constants.FACEBOOK_URL,response.body().getData().getSocial_links().getFacebookUrl());
                    bundle.putString(Constants.TWITTER_URL,response.body().getData().getSocial_links().getTwitterUrl());
                    bundle.putString(Constants.LINKEDIN_URL,response.body().getData().getSocial_links().getLinkedlnUrl());
                    bundle.putString(Constants.BANDCAMP_URL,response.body().getData().getSocial_links().getBandcampUrl());
                    bundle.putString(Constants.YOUTUBE_URL,response.body().getData().getSocial_links().getYoutubeUrl());
                    bundle.putString(Constants.GOOGLEPLUS_URL,response.body().getData().getSocial_links().getGoogleplusUrl());
                    bundle.putString(Constants.WEBSITE_URL,response.body().getData().getSocial_links().getUserWebsite());
                    bundle.putString(Constants.MYSPACE_URL,response.body().getData().getSocial_links().getMyspaceUrl());

                    mListener.onFragmentInteraction(bundle);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseUserProfile> call, Throwable t) {
                   t.printStackTrace();
            }
        });*/
        objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.USER_PROFILE , rp, new WebServiceHelper.OnWebServiceListener() {

            @Override
            public void successResponse(JSONObject result) {
                try {
                    boolean showNoData = false;

                    Log.e("result",result.toString());
                    Gson gson = new Gson();
                    profileData = gson.fromJson(result.getJSONObject(Constants.DATA).toString(), ProfileData.class);



                    fbUrl = profileData.getSocialLinks().getFacebookUrl();
                    googleUrl = profileData.getSocialLinks().getGoogleplusUrl();
                    linkedInUrl = profileData.getSocialLinks().getLinkedlnUrl();
                    mySpaceUrl = profileData.getSocialLinks().getMyspaceUrl();
                    twitterUrl = profileData.getSocialLinks().getTwitterUrl();
                    youtubeUrl = profileData.getSocialLinks().getYoutubeUrl();

                    if(fbUrl==null || fbUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).fbIcon.setVisibility(View.INVISIBLE);
                    }
                    if(googleUrl==null || googleUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).googleIcon.setVisibility(View.INVISIBLE);
                    }
                    if(linkedInUrl==null || linkedInUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).lnIcon.setVisibility(View.INVISIBLE);
                    }
                    if(mySpaceUrl==null || mySpaceUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).mySpaceIcon.setVisibility(View.INVISIBLE);
                    }
                    if(twitterUrl==null || twitterUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).twIcon.setVisibility(View.INVISIBLE);
                    }
                    if(youtubeUrl==null || youtubeUrl.isEmpty()){
                        ((ProfileActivity) getActivity()).youtubeIcon.setVisibility(View.INVISIBLE);
                    }

                    String userImageUrl = profileData.getProfile().getUserImageUrl();
                    String userSkill = profileData.getProfile().getUserSkill();
                    String userInterest = profileData.getProfile().getUserInterest();
                    String userOccupation = profileData.getProfile().getUserOccupation();
                    String userAboutMe = profileData.getProfile().getUserAbout();

                    ((ProfileActivity) getActivity()).userName.setText(profileData.getProfile().getFirstName()+" "+profileData.getProfile().getLastName());

                    if(userSkill!=null && !userSkill.isEmpty()){
                        skills.setText(userSkill);
                    }else{
                        layoutSkills.setVisibility(View.GONE);
                    }
                    if(userInterest!=null && !userInterest.isEmpty()){
                        interest.setText(userInterest);
                    }else{
                        layoutInterest.setVisibility(View.GONE);
                    }
                    if(userOccupation!=null && !userOccupation.isEmpty()){
                        occupation.setText(userOccupation);
                    }else{
                        layoutOccupation.setVisibility(View.GONE);
                    }
                    if(userAboutMe!=null && !userAboutMe.isEmpty()){
                        aboutMe.setText(userAboutMe);
                    }else{
                        layoutAboutMe.setVisibility(View.GONE);
                    }

//                    if(userSkill.isEmpty() && userInterest.isEmpty() && userOccupation.isEmpty() && userAboutMe.isEmpty()){
//                        noData.setText("No data found.");
//                    }

                    Glide.with(getActivity())
                            .load(userImageUrl)
                            .crossFade()
                            .into(((ProfileActivity) getActivity()).userImage);

                    Glide.with(getActivity())
                            .load(userImageUrl)
                            .crossFade()
                            .into(((ProfileActivity) getActivity()).userImageCircular);

//                    noData.setVisibility(View.INVISIBLE);

                    Bundle bundle = new Bundle();

                    bundle.putString(Constants.FIRSTNAME,profileData.getProfile().getFirstName());
                    bundle.putString(Constants.USER_ID,profileData.getProfile().getUserId());

                    bundle.putString(Constants.USER_IMAGE,profileData.getProfile().getUserImageUrl());
                    bundle.putString(Constants.LASTNAME,profileData.getProfile().getLastName());
                    bundle.putString(Constants.ZIPCODE,profileData.getProfile().getZipCode());
                    bundle.putString(Constants.PROFILE_SLUG,profileData.getProfile().getProfileSlug());
                    bundle.putString(Constants.EMAIL,profileData.getProfile().getEmail());
                    bundle.putString(Constants.ADDRESS,profileData.getProfile().getAddress());
                    bundle.putString(Constants.USER_ABOUT,profileData.getProfile().getUserAbout());
                    bundle.putString(Constants.USER_OCCUPATION,profileData.getProfile().getUserOccupation());
                    bundle.putString(Constants.USER_INTEREST,profileData.getProfile().getUserInterest());
                    bundle.putString(Constants.USER_SKILL,profileData.getProfile().getUserSkill());

                    bundle.putString(Constants.FACEBOOK_URL,profileData.getSocialLinks().getFacebookUrl());
                    bundle.putString(Constants.TWITTER_URL,profileData.getSocialLinks().getTwitterUrl());
                    bundle.putString(Constants.LINKEDIN_URL,profileData.getSocialLinks().getLinkedlnUrl());
                    bundle.putString(Constants.BANDCAMP_URL,profileData.getSocialLinks().getBandcampUrl());
                    bundle.putString(Constants.YOUTUBE_URL,profileData.getSocialLinks().getYoutubeUrl());
                    bundle.putString(Constants.GOOGLEPLUS_URL,profileData.getSocialLinks().getGoogleplusUrl());
                    bundle.putString(Constants.WEBSITE_URL,profileData.getSocialLinks().getUserWebsite());
                    bundle.putString(Constants.MYSPACE_URL,profileData.getSocialLinks().getMyspaceUrl());

                    mListener.onFragmentInteraction(bundle);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.e("success", errorMessage.toString());
                noData.setText(errorMessage);
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Bundle uri) {
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Bundle uri);
    }


}
