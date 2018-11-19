package com.rock.reward.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.rock.reward.volleyWebservice.Constants;
import com.android.volley.Request;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.Contact;
import com.rock.reward.ContactsAdapter;
import com.rock.reward.R;
import com.rock.reward.ResponsePojo.HomeDataResponse;
import com.rock.reward.activity.HomeActivity;
import com.rock.reward.adapter.ProjectListAdapter;
import com.rock.reward.extras.EndlessRecyclerViewScrollListener;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.Category;
import com.rock.reward.model.Country;
import com.rock.reward.model.HomeData;
import com.rock.reward.model.LatestProject;
import com.rock.reward.utils.Utils;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String token;
    private ProjectListAdapter adapter;
    private View view;
    private TextView tvNoDataFound;
    private RecyclerView recyclerView;
    private Context context;
    public HomeData homeData;
    int TotalItemCount;
    public Bundle bundle;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeProjects;
    private List<LatestProject> latestProjectsList;
    List<LatestProject> getLatests = new ArrayList<LatestProject>();
    private RewardRestInterface restInterface;
    public   HomeDataResponse recyclerdata;
    int responsedata1;

    /*scrolling vars*/
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 2;
    int firstVisibleItem, visibleItemCount, totalItemCount;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String categoryId;

    private OnFragmentInteractionListener mListener;


    List<Contact> allContacts;
    ContactsAdapter adapter1;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            Bundle b = this.getArguments();
            categoryId = b.getString(Constants.CATEGORY_ID);
            Log.e("categ",categoryId);
        }
        setHasOptionsMenu(true);
    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_flip:
//                onButtonPressed();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        tvNoDataFound = (TextView) view.findViewById(R.id.tv_no_data_found);
        recyclerView = (RecyclerView)view.findViewById(R.id.listView);

        linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setLayoutManager(linearLayoutManager);


        context = view.getContext();

        // Lookup the swipe container view
        swipeProjects = (SwipeRefreshLayout)view.findViewById(R.id.swipeProjects);

        // Setup refresh listener which triggers new data loading
        swipeProjects.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                getProjects(0,0);
            }
        });
        // Configure the refreshing colors
        swipeProjects.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        List<LatestProject> getLatest = getProjects(0,0);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager,swipeProjects) {

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
         //       Log.e("total-offset",homeData.getTotalCount()+"=="+totalItemsCount);
            //    TotalItemCount = linearLayoutManager.getItemCount();
                if(totalItemsCount<homeData.getTotalCount()){
                    List<LatestProject> getLatest = getProjects(totalItemsCount,page);
                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction(bundle);
        }
    }

    public void favouriteProject(String ProjectId, int pos){
        makeProjectFavourite(ProjectId,pos);
    }

    public void makeProjectFavourite(String ProjectId, final int pos){

        if(((HomeActivity) getActivity()).preferencesHelper.getPrefBoolean(PreferencesHelper.USER_LOGGED_IN)){
            String loginUser = ((HomeActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
            try {
                JSONObject jsonObject = new JSONObject(loginUser);
                token = jsonObject.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
        RequestParam rp = new RequestParam();
        rp.putHeader(Constants.TOKEN,token);
        rp.putParams(Constants.TYPE_ID,ProjectId);
        rp.putParams(Constants.TYPE,"2");
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
        Call<HomeData> call = restInterface.UpdateInterests(token,ProjectId,"2");

        objWebServiceHelper.apiParamsCall(Request.Method.POST, Constants.WebServiceUrls.FOLLOW,rp,new WebServiceHelper.OnWebServiceListener(){

            @Override
            public void successResponse(JSONObject content) {

                try {
                    int isFollowed = content.getJSONObject(Constants.DATA).getInt("is_followed");
                    View v = recyclerView.getChildAt(pos);
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.FILENAME_LOGIN_DETAILS), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(getActivity().getString(R.string.KEY_USER_ID), content.getJSONObject(Constants.USER_ID).getString("user_id"));
                    editor.apply();
                    if(v == null)
                        return;

                    if(isFollowed==1){

                        ImageView is_follow = (ImageView) v.findViewById(R.id.is_follow);
                        Glide.with(getActivity())
                                .load("")
                                .placeholder(R.drawable.ic_favorite_black_36dp)
                                .into(is_follow);

                    }else{
                        ImageView is_follow = (ImageView) v.findViewById(R.id.is_follow);
                        Glide.with(getActivity())
                                .load("")
                                .placeholder(R.drawable.ic_fav)
                                .into(is_follow);
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.i("Login Fail Response", errorMessage);
                Utils.showAlert(getActivity(), errorMessage);
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
        void onFragmentInteraction(Bundle bundle);
    }


    public List<LatestProject> getProjects(final int offset, int page){
        final List<LatestProject> latestProjectsC = new ArrayList<>();

        if(offset==0){
            Utils.showLoader(getActivity());
        }

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

        rp.putHeader(Constants.TOKEN,token);
        rp.putParams(Constants.OFFSET,String.valueOf(offset));
        String CategoryId = ((HomeActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.CATEGORY_ID);

        if(CategoryId!=null)rp.putParams(Constants.CATEGORY_ID,CategoryId);

         // CallApi mCallApi = new CallApi(getActivity(),token);
       //   mCallApi.setGuestLogin(homeData);
       // String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJyb2NrZXJzdGVjaC5jb20iLCJpYXQiOjE0ODg0NTc2OTQsImV4cCI6MTQ4OTMyMTY5NCwidXNlcl9pZCI6MCwidXNlcl9zYWx0IjoiNzM0ZDdlNzI4YmY1NjY3ZGE2ZWM1NTE1ZDFmYWQ0YzciLCJsYW5nIjoiZW4ifQ.YzAkRViWgVZDSwq-DRKxPDASRSu_KXgpieVV3klDGU8";

     //
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
        Call<HomeDataResponse> call = restInterface.ProfileEdit(token,String.valueOf(offset),CategoryId);

        objWebServiceHelper.apiParamsCall(Request.Method.POST, Constants.WebServiceUrls.HOME,rp,new WebServiceHelper.OnWebServiceListener(){

            @Override
            public void successResponse(JSONObject content) {

                Gson gson = new Gson();
                try {
                    homeData = gson.fromJson(content.getJSONObject(Constants.DATA).toString(),HomeData.class);
                    if(homeData.getLatestProjects().size()>0){

                        int curSize = 0;
                        latestProjectsC.addAll(homeData.getLatestProjects());

                        returnProjects(homeData.getLatestProjects(),offset,curSize);

                        if(offset==0){
                            ArrayList<Category> categoryArrayList = new ArrayList<>();
                            for (int i=0; i<homeData.getCategories().size(); i++) {
                                categoryArrayList.add(homeData.getCategories().get(i));
                            }
                            bundle = new Bundle();
                            bundle.putParcelableArrayList("categoryList",categoryArrayList);

                            ArrayList<Country> countryArrayList = new ArrayList<>();
                            for (int i=0; i<homeData.getCountries().size(); i++) {
                                countryArrayList.add(homeData.getCountries().get(i));
                            }
                            bundle.putParcelableArrayList("countryList",countryArrayList);

                            mListener.onFragmentInteraction(bundle);
                        }
                        // Now we call setRefreshing(false) to signal refresh has finished
                        swipeProjects.setRefreshing(false);

                    }else{

                        recyclerView.setVisibility(View.GONE);
                        tvNoDataFound.setVisibility(View.VISIBLE);
                    }
                    if(offset==0){
                        Utils.hideLoader(getActivity());
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.i("Login Fail Response", errorMessage);
                if(offset==0){
                    Utils.hideLoader(getActivity());
                }
                Utils.showAlert(getActivity(), errorMessage);
            }
        });
        Log.e("latestProjectsC bottom",latestProjectsC.size()+"");

        return latestProjectsC;
    }

        public List<LatestProject> returnProjects(List<LatestProject> list, int offset, int curSizes){

            if(offset!=0){
                int curSize = adapter.getItemCount();
                latestProjectsList.addAll(list);
                adapter.notifyItemRangeInserted(curSize, list.size() - 1);
            }else{
                if(latestProjectsList!=null){
                    latestProjectsList.clear();
                }
                latestProjectsList = list;
                if(adapter!=null){
                    adapter.clear();
                }
                adapter = new ProjectListAdapter(list,getActivity(),HomeFragment.this);
                recyclerView.setAdapter(adapter);
            }
            return list;
        }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Uri uri);

    }


   }















//
//
//



































//
//
//


















