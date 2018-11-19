package com.rock.reward.activity.projectDashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.rock.reward.R;
import com.rock.reward.adapter.UpdateListAdapter;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.Perk;
import com.rock.reward.volleyWebservice.Constants;

public class DashboardPerkActivity extends AppCompatActivity {

    private String projectId;
    private PreferencesHelper preferencesHelper;
    private RecyclerView recyclerView;
    private Bundle bundle;
    private UpdateListAdapter updateListAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String token;
    private Perk updatesData;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_perk);

        Intent intent = getIntent();
        projectId = intent.getStringExtra(Constants.PROJECT_ID);
        bundle = intent.getExtras();

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        preferencesHelper = new PreferencesHelper(DashboardPerkActivity.this);

        recyclerView = (RecyclerView)findViewById(R.id.list_updates);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_updates);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               // loadPerks(projectId);
            }
        });

        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        //loadPerks(projectId);

    }

//    private void loadPerks(String ProjectId){
//        WebServiceHelper objWebServiceHelper = new WebServiceHelper(this);
//        RequestParam rp = new RequestParam();
//        String guestUser = (this.preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER));
//        try {
//            JSONObject jsonObject = new JSONObject(guestUser);
//            token = jsonObject.getString(Constants.TOKEN_STR);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        rp.putHeader(Constants.TOKEN, token);
//        rp.putHeader(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
//        rp.putParams(Constants.PROJECT_ID, ProjectId);
//        rp.putParams(Constants.VIEW_TYPE, "dashboard");
//
//        objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.PROJECT_UPDATES , rp, new WebServiceHelper.OnWebServiceListener() {
//
//            @Override
//            public void successResponse(JSONObject result) {
//                try {
//                    Gson gson = new Gson();
//                    updatesData = gson.fromJson(result.getJSONObject(Constants.DATA).toString(), UpdatesData.class);
//
//                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                    recyclerView.setNestedScrollingEnabled(false);
//
//                    updateListAdapter = new UpdateListAdapter(updatesData.getUpdates(),DashboardUpdateActivity.this);
//                    recyclerView.setAdapter(updateListAdapter);
//                    swipeRefreshLayout.setRefreshing(false);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void failureResponse(String errorMessage, int errorCode) {
//                Log.e("success", errorMessage.toString());
//            }
//        });
//    }
}
