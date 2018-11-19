package com.rock.reward.fragment.user_dashboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rock.reward.volleyWebservice.Constants;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.ResponsePojo.ResponseUserDashboardData;
import com.rock.reward.TabActivityAction;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.ShowDonationListCompleted;
import com.rock.reward.model.ShowDonationListRecCompleted;
import com.rock.reward.model.ShowDonationListRecRunning;
import com.rock.reward.model.ShowDonationListRunning;
import com.rock.reward.model.UserDashboardData;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RewardRestInterface restInterface;
    private OnFragmentInteractionListener mListener;

    private TextView completedCampaigns;
    private TextView runningCampaigns;
    private TextView campaignFollowed;
    private TextView campaignFollowing;
    private TextView myFunds;
    private TextView myProjectFunds;
    private TextView fundsReceived;
    private TextView pendingFunds;

    private View view;
    private String token;
    private UserDashboardData userDashboardData;


    public UserOverviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserOverviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserOverviewFragment newInstance(String param1, String param2) {
        UserOverviewFragment fragment = new UserOverviewFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_overview, container, false);

        completedCampaigns = (TextView)view.findViewById(R.id.completed_campaigns);
        runningCampaigns = (TextView)view.findViewById(R.id.running_campaigns);
        campaignFollowed = (TextView)view.findViewById(R.id.campaign_followed);
        campaignFollowing = (TextView)view.findViewById(R.id.campaign_following);
        myFunds = (TextView)view.findViewById(R.id.my_fund);
        myProjectFunds = (TextView)view.findViewById(R.id.my_project_funds);
        fundsReceived = (TextView)view.findViewById(R.id.funds_received);
        pendingFunds = (TextView)view.findViewById(R.id.pending_funds);

        getUserOverviewData();
        return view;
    }

    private void getUserOverviewData(){
//        Utils.showLoader(getActivity());

        WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
        RequestParam rp = new RequestParam();

        if(((TabActivityAction) getActivity()).preferencesHelper.getPrefBoolean(PreferencesHelper.USER_LOGGED_IN)){
            String loginUser = ((TabActivityAction) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
            try {
                JSONObject jsonObject = new JSONObject(loginUser);
                Log.e("jsonObject",jsonObject.toString());
                token = jsonObject.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        rp.putHeader(Constants.TOKEN,token);
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
          Call<ResponseUserDashboardData> call = restInterface.UserDashboard(token);
        call.enqueue(new Callback<ResponseUserDashboardData>() {
            @Override
            public void onResponse(Call<ResponseUserDashboardData> call, Response<ResponseUserDashboardData> response) {
                Gson gson = new Gson();
                try {

                    ArrayList<ShowDonationListCompleted> homedate=new ArrayList<>();

                    Gson gson2 = new Gson();
                    for (int j = 0; j < response.body().getData().getShow_donation_list_completed().size(); j++) {
                        homedate.add(response.body().getData().getShow_donation_list_completed().get(j));

                    }
                    int CompletedCampaigns = response.body().getData().getTotal_completed_projects();
                    int RunningCampaigns = response.body().getData().getTotal_running_projects();
                    int CampaignFollowed = response.body().getData().getProject_follower();
                    int CampaignFollowing = response.body().getData().getProject_following();


                    String MyProjectFunds ="--";
                    String PendingFunds="--";
                    String MyFunds="--";
                    String FundsReceived="--";

                    if(homedate.size()>0){
                        MyProjectFunds = homedate.get(0).getProjectCurrencySymbol()+
                                homedate.get(0).getTotal()+" ("+homedate.get(0).getTotal()+")";
                    }

                    ArrayList<ShowDonationListRecRunning> homedates=new ArrayList<>();


                    for (int j = 0; j < response.body().getData().getShow_donation_list_rec_running().size(); j++) {
                        homedates.add(response.body().getData().getShow_donation_list_rec_running().get(j));

                    }

                    if(homedates.size()>0){
                        PendingFunds = homedates.get(0).getProjectCurrencySymbol()+
                                homedates.get(0).getTotal()+" ("+homedates.get(0).getProjectCurrencyCode()+")";
                    }
                    ArrayList<ShowDonationListRunning> homedatesw=new ArrayList<>();


                    for (int j = 0; j < response.body().getData().getShow_donation_list_running().size(); j++) {
                        homedatesw.add(response.body().getData().getShow_donation_list_running().get(j));

                    }
                    if(homedatesw.size()>0){
                        MyFunds = homedatesw.get(0).getProjectCurrencySymbol()+
                                homedatesw.get(0).getTotal()+" ("+homedatesw.get(0).getProjectCurrencyCode()+")";
                    }

                    if(homedatesw.size()>0){
                        MyFunds = homedatesw.get(0).getProjectCurrencySymbol()+
                                homedatesw.get(0).getTotal()+" ("+homedatesw.get(0).getProjectCurrencyCode()+")";
                    }
                    ArrayList<ShowDonationListRecCompleted> homedatesws=new ArrayList<>();
                    for (int j = 0; j < response.body().getData().getShow_donation_list_rec_completed().size(); j++) {
                        homedatesws.add(response.body().getData().getShow_donation_list_rec_completed().get(j));

                    }
                    if(homedatesws.size()>0){
                        FundsReceived = homedatesws.get(0).getProjectCurrencySymbol()+
                                homedatesws.get(0).getTotal()+" ("+homedatesws.get(0).getProjectCurrencyCode()+")";
                    }

                    completedCampaigns.setText(String.valueOf(CompletedCampaigns));
                    runningCampaigns.setText(String.valueOf(RunningCampaigns));
                    campaignFollowed.setText(String.valueOf(CampaignFollowed));
                    campaignFollowing.setText(String.valueOf(CampaignFollowing));

                    myFunds.setText(MyFunds);
                    myProjectFunds.setText(MyProjectFunds);
                    fundsReceived.setText(FundsReceived);
                    pendingFunds.setText(PendingFunds);

//                    Utils.hideLoader(getActivity());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseUserDashboardData> call, Throwable t) {
                 t.printStackTrace();
            }
        });
       /* objWebServiceHelper.apiParamsCall(Request.Method.POST, Constants.WebServiceUrls.USER_DASHBOARD,rp,new WebServiceHelper.OnWebServiceListener(){

            @Override
            public void successResponse(JSONObject content) {

                Gson gson = new Gson();
                try {
                    userDashboardData = gson.fromJson(content.getJSONObject(Constants.DATA).toString(),UserDashboardData.class);

                    int CompletedCampaigns = userDashboardData.getTotalCompletedProjects();
                    int RunningCampaigns = userDashboardData.getTotalRunningProjects();
                    int CampaignFollowed = userDashboardData.getProjectFollower();
                    int CampaignFollowing = userDashboardData.getProjectFollowing();


                    String MyProjectFunds ="--";
                    String PendingFunds="--";
                    String MyFunds="--";
                    String FundsReceived="--";

                    if(userDashboardData.getShowDonationListCompleted().size()>0){
                        MyProjectFunds = userDashboardData.getShowDonationListCompleted().get(0).getProjectCurrencySymbol()+
                                userDashboardData.getShowDonationListCompleted().get(0).getTotal()+" ("+userDashboardData.getShowDonationListCompleted().get(0).getTotal()+")";
                    }

                    if(userDashboardData.getShowDonationListRecRunning().size()>0){
                        PendingFunds = userDashboardData.getShowDonationListRecRunning().get(0).getProjectCurrencySymbol()+
                                userDashboardData.getShowDonationListRecRunning().get(0).getTotal()+" ("+userDashboardData.getShowDonationListRecRunning().get(0).getProjectCurrencyCode()+")";
                    }

                    if(userDashboardData.getShowDonationListRunning().size()>0){
                        MyFunds = userDashboardData.getShowDonationListRunning().get(0).getProjectCurrencySymbol()+
                                userDashboardData.getShowDonationListRunning().get(0).getTotal()+" ("+userDashboardData.getShowDonationListRunning().get(0).getProjectCurrencyCode()+")";
                    }
                    if(userDashboardData.getShowDonationListRecCompleted().size()>0){
                        FundsReceived = userDashboardData.getShowDonationListRecCompleted().get(0).getProjectCurrencySymbol()+
                                userDashboardData.getShowDonationListRecCompleted().get(0).getTotal()+" ("+userDashboardData.getShowDonationListRecCompleted().get(0).getProjectCurrencyCode()+")";
                    }

                    completedCampaigns.setText(String.valueOf(CompletedCampaigns));
                    runningCampaigns.setText(String.valueOf(RunningCampaigns));
                    campaignFollowed.setText(String.valueOf(CampaignFollowed));
                    campaignFollowing.setText(String.valueOf(CampaignFollowing));

                    myFunds.setText(MyFunds);
                    myProjectFunds.setText(MyProjectFunds);
                    fundsReceived.setText(FundsReceived);
                    pendingFunds.setText(PendingFunds);

//                    Utils.hideLoader(getActivity());
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
//                Utils.hideLoader(getActivity());
//                Utils.showAlert(getActivity(), errorMessage);
            }
        });*/
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
