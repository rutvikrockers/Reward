package com.rock.reward.fragment.userProfile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rock.reward.volleyWebservice.Constants;
import com.android.volley.Request;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.activity.ProfileActivity;
import com.rock.reward.adapter.userProfile.UserFollowerListAdapter;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.UserFollowersData;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserFollowersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserFollowersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFollowersFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_USER_ID = "param1";

    // TODO: Rename and change types of parameters
    private String userId;
    private String token;
    private View view;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private UserFollowersData userFollowersData;
    private UserFollowerListAdapter adapter;
    private TextView noData;
    private RewardRestInterface restInterface;
    private OnFragmentInteractionListener mListener;

    public UserFollowersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment UserFollowersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFollowersFragment newInstance(String param1) {
        UserFollowersFragment fragment = new UserFollowersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_ID, param1);
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

        view = inflater.inflate(R.layout.fragment_user_followers, container, false);
        gridLayoutManager = new GridLayoutManager(getActivity(),3);

        recyclerView = (RecyclerView)view.findViewById(R.id.user_followings);
        noData = (TextView)view.findViewById(R.id.no_data);

        getuserFollowers();
        // Inflate the layout for this fragment
        return view;
    }

    private void getuserFollowers(){
        WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
        RequestParam rp = new RequestParam();

        if(((ProfileActivity) getActivity()).preferencesHelper.getPrefBoolean(PreferencesHelper.USER_LOGGED_IN)){
            String loginUser = ((ProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
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
       // rp.putHeader(Constants.TOKEN,token);
      //  rp.putParams(Constants.USER_ID,userId);
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
       // Call<ResponseFollowingPojo> call = restInterface.FollowingList(token,userId);
    /*    call.enqueue(new Callback<ResponseFollowingPojo>() {
            @Override
            public void onResponse(Call<ResponseFollowingPojo> call, Response<ResponseFollowingPojo> response) {
                Gson gson = new Gson();
                try {

                    userFollowersData = gson.fromJson(response.body().toString(),UserFollowersData.class);
                    noData.setVisibility(View.INVISIBLE);
                    adapter = new UserFollowerListAdapter(userFollowersData.getFollowingData(),getActivity(),UserFollowersFragment.this);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(gridLayoutManager);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseFollowingPojo> call, Throwable t) {
                    t.printStackTrace();
            }
        });*/

        objWebServiceHelper.apiParamsCall(Request.Method.POST, Constants.WebServiceUrls.USER_FOLLOWERS,rp,new WebServiceHelper.OnWebServiceListener(){

            @Override
            public void successResponse(JSONObject content) {

                Gson gson = new Gson();
                try {
                    userFollowersData = gson.fromJson(content.getString(Constants.DATA),UserFollowersData.class);
                    noData.setVisibility(View.INVISIBLE);
                    adapter = new UserFollowerListAdapter(userFollowersData.getFollowingData(),getActivity(),UserFollowersFragment.this);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(gridLayoutManager);

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                noData.setText(errorMessage);
            }
        });
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
