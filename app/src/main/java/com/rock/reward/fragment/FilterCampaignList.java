package com.rock.reward.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rock.reward.volleyWebservice.Constants;
import com.android.volley.Request;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.activity.HomeActivity;
import com.rock.reward.adapter.ProjectListAdapter;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.FilteredCampains;
import com.rock.reward.utils.Utils;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FilterCampaignList.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FilterCampaignList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilterCampaignList extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RewardRestInterface restInterface;
    private Bundle bundle;
    private Bundle browseBundle;
    private String token;

    private OnFragmentInteractionListener mListener;

    private FilteredCampains filteredCampains;
    private ProjectListAdapter adapter;
    private RecyclerView recyclerView;
    private View view;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeProjects;

    public FilterCampaignList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilterCampaignList.
     */
    // TODO: Rename and change types and number of parameters
    public static FilterCampaignList newInstance(String param1, String param2) {
        FilterCampaignList fragment = new FilterCampaignList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().show();
        ((HomeActivity) getActivity()).mBottomBar.setVisibility(View.VISIBLE);

        if (getArguments() != null) {
            bundle = getArguments();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_filter_campaign_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.listView);
        swipeProjects = (SwipeRefreshLayout)view.findViewById(R.id.swipeProjects);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setNestedScrollingEnabled(false);

        getFilteredProjects();

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Bundle bundle) {
        if (mListener != null) {
            mListener.onFragmentInteractionProjectFilter(bundle);
        }
    }

    public void getFilteredProjects(){

        Utils.showLoader(getActivity());

        WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
        RequestParam rp = new RequestParam();

        if(((HomeActivity) getActivity()).preferencesHelper.getPrefBoolean(PreferencesHelper.USER_LOGGED_IN)){
            String loginUser = ((HomeActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
            try {
                JSONObject jsonObject = new JSONObject(loginUser);
                token = jsonObject.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            String guestUser = ((HomeActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER);
            try {
                JSONObject jsonObject = new JSONObject(guestUser);
                token = jsonObject.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Log.e("data list",""+bundle.getInt(Constants.GOAL_TYPE)+bundle.getInt(Constants.GOAL_SIZE)+bundle.getInt(Constants.STATUS)+ bundle.getInt(Constants.CATEGORY_ID)+bundle.getInt(Constants.COUNTRY_ID));


        rp.putHeader(Constants.TOKEN,token);

        if(bundle.getString(Constants.TITLE)!=null){
            rp.putParams(Constants.TITLE,bundle.getString(Constants.TITLE));
        }
        if(bundle.getString(Constants.CITY)!=null){
            rp.putParams(Constants.CITY,bundle.getString(Constants.CITY));
        }

        rp.putParams(Constants.GOAL_TYPE, String.valueOf(bundle.getInt(Constants.GOAL_TYPE)));
        rp.putParams(Constants.GOAL_SIZE, String.valueOf(bundle.getInt(Constants.GOAL_SIZE)));
        rp.putParams(Constants.STATUS, String.valueOf(bundle.getInt(Constants.STATUS)));

        if(bundle.getInt(Constants.CATEGORY_ID)!=0){
            rp.putParams(Constants.CATEGORY_ID, String.valueOf(bundle.getInt(Constants.CATEGORY_ID)));
        }
        if(bundle.getInt(Constants.COUNTRY_ID)!=0){
            rp.putParams(Constants.COUNTRY_ID, String.valueOf(bundle.getInt(Constants.COUNTRY_ID)));
        }




        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
      //  Call<ResponseSearchFilterCampaign> call = restInterface.SearchFilter(token,bundle.getString(Constants.TITLE),String.valueOf(bundle.getInt(Constants.CATEGORY_ID)),bundle.getString(Constants.CITY), String.valueOf(bundle.getInt(Constants.COUNTRY_ID)),String.valueOf(bundle.getInt(Constants.GOAL_SIZE)),String.valueOf(bundle.getInt(Constants.STATUS)),String.valueOf(bundle.getInt(Constants.GOAL_TYPE)));


       /*   call.enqueue(new Callback<ResponseSearchFilterCampaign>() {
            @Override
            public void onResponse(Call<ResponseSearchFilterCampaign> call, Response<ResponseSearchFilterCampaign> response) {
                Gson gson = new Gson();
                try {
                    filteredCampains = gson.fromJson(response.body().getData().toString(),FilteredCampains.class);


                    if(filteredCampains.getLatestProjects().size()>0){
//                        adapter.clear();
                        recyclerView.setLayoutManager(linearLayoutManager);
                        adapter = new ProjectListAdapter(filteredCampains.getLatestProjects(),getActivity(),FilterCampaignList.this);
                        recyclerView.setAdapter(adapter);

                        // Now we call setRefreshing(false) to signal refresh has finished
                        swipeProjects.setRefreshing(false);
                    }else{

                    }
                    mListener.onFragmentInteractionProjectFilter(bundle);
                    Utils.hideLoader(getActivity());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseSearchFilterCampaign> call, Throwable t) {
                   t.printStackTrace();
            }
        });*/

        objWebServiceHelper.apiParamsCall(Request.Method.POST, Constants.WebServiceUrls.SEARCH,rp,new WebServiceHelper.OnWebServiceListener(){

            @Override
            public void successResponse(JSONObject content) {

                Gson gson = new Gson();
                try {
                    filteredCampains = gson.fromJson(content.getJSONObject(Constants.DATA).toString(),FilteredCampains.class);


                    if(filteredCampains.getLatestProjects().size()>0){
//                        adapter.clear();
                        recyclerView.setLayoutManager(linearLayoutManager);
                        adapter = new ProjectListAdapter(filteredCampains.getLatestProjects(),getActivity(),FilterCampaignList.this);
                        recyclerView.setAdapter(adapter);

                        // Now we call setRefreshing(false) to signal refresh has finished
                        swipeProjects.setRefreshing(false);
                    }else{

                    }
                    mListener.onFragmentInteractionProjectFilter(bundle);
                    Utils.hideLoader(getActivity());
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.i("Login Fail Response", errorMessage);
                Utils.hideLoader(getActivity());
                Utils.showAlert(getActivity(), errorMessage);
                mListener.onFragmentInteractionProjectFilter(bundle);
            }
        });
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
        void onFragmentInteractionProjectFilter(Bundle bundle);
    }
}
