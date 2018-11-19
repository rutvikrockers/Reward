package com.rock.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.rock.reward.volleyWebservice.Constants;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.ResponsePojo.ResponseFunderData;
import com.rock.reward.adapter.FunderListAdapterMain;
import com.rock.reward.extras.EndlessRecyclerViewScrollListener;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.Funder;
import com.rock.reward.model.FundersData;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FunderActivity extends AppCompatActivity {

    private String projectId;
    private Bundle bundle;
    private SwipeRefreshLayout swipeRefreshLayout;
    private PreferencesHelper preferencesHelper;
    private RecyclerView recyclerView;
    private FunderListAdapterMain funderListAdapterMain;
    private FundersData fundersData;
    private String token;
    private int offset;
    private LinearLayoutManager linearLayoutManager;
    private List<Funder> fundersList;
    private RewardRestInterface restInterface;
    int TotalItemCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        projectId = intent.getStringExtra(Constants.PROJECT_ID);
        bundle = intent.getExtras();

        setContentView(R.layout.activity_funder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_comments);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadFunders(projectId,offset);
            }
        });

        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        preferencesHelper = new PreferencesHelper(FunderActivity.this);

        recyclerView = (RecyclerView)findViewById(R.id.listView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setNestedScrollingEnabled(false);

        loadFunders(projectId,0);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager,swipeRefreshLayout) {

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                TotalItemCount = linearLayoutManager.getItemCount();
                if(totalItemsCount<TotalItemCount){
                    loadFunders(projectId,totalItemsCount);
                }
            }
        });
    }
    private void getFunders(){
        if(bundle.getParcelableArrayList(Constants.FUNDERS)!=null){
            ArrayList<Funder> funderArrayList = bundle.getParcelableArrayList(Constants.FUNDERS);

            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            funderListAdapterMain = new FunderListAdapterMain(funderArrayList, this);
            recyclerView.setAdapter(funderListAdapterMain);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void loadFunders(String projectId, final int offset){

        WebServiceHelper objWebServiceHelper = new WebServiceHelper(this);
        RequestParam rp = new RequestParam();
        String guestUser = (this.preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER));
        try {
            JSONObject jsonObject = new JSONObject(guestUser);
            token = jsonObject.getString(Constants.TOKEN_STR);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rp.putHeader(Constants.TOKEN, token);
        rp.putHeader(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
        rp.putParams(Constants.PROJECT_ID, projectId);
        rp.putParams(Constants.OFFSET,String.valueOf(offset));
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
        Call<ResponseFunderData> call = restInterface.Funders(token,projectId,String.valueOf(offset));
        call.enqueue(new Callback<ResponseFunderData>() {
            @Override
            public void onResponse(Call<ResponseFunderData> call, Response<ResponseFunderData> response) {
                try {

                    ArrayList<Funder> homedate=new ArrayList<>();
                    Gson gson = new Gson();
                   // fundersData = gson.fromJson(response.body().toString(), FundersData.class);
                        for(int i=0;i< response.body().getData().getFunders().size();i++){
                            FundersData fundersData = new FundersData();

                            homedate.add(response.body().getData().getFunders().get(i));
                        }
                    if(offset==0){
                        recyclerView.setLayoutManager(linearLayoutManager);
                        fundersList = homedate;
                        funderListAdapterMain = new FunderListAdapterMain(fundersList,FunderActivity.this);
                        recyclerView.setAdapter(funderListAdapterMain);
                    }else{
                        int curSize = funderListAdapterMain.getItemCount();
                        fundersList.addAll(fundersData.getFunders());
                        funderListAdapterMain.notifyItemRangeInserted(curSize, fundersList.size() - 1);
                    }
                    swipeRefreshLayout.setRefreshing(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseFunderData> call, Throwable t) {
                     t.printStackTrace();
            }
        });
      /*  objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.PROJECT_FUNDERS , rp, new WebServiceHelper.OnWebServiceListener() {

            @Override
            public void successResponse(JSONObject result) {
                try {
                    Gson gson = new Gson();
                    fundersData = gson.fromJson(result.getJSONObject(Constants.DATA).toString(), FundersData.class);

                    if(offset==0){
                        recyclerView.setLayoutManager(linearLayoutManager);
                        fundersList = fundersData.getFunders();
                        funderListAdapterMain = new FunderListAdapterMain(fundersList,FunderActivity.this);
                        recyclerView.setAdapter(funderListAdapterMain);
                    }else{
                        int curSize = funderListAdapterMain.getItemCount();
                        fundersList.addAll(fundersData.getFunders());
                        funderListAdapterMain.notifyItemRangeInserted(curSize, fundersList.size() - 1);
                    }
                    swipeRefreshLayout.setRefreshing(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.e("success", errorMessage.toString());
            }
        });*/
    }

}
