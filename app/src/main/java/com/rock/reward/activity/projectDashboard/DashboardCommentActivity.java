package com.rock.reward.activity.projectDashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.adapter.CommentListAdapter;
import com.rock.reward.extras.EndlessRecyclerViewScrollListener;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.Comment;
import com.rock.reward.model.CommentsData;
import com.rock.reward.volleyWebservice.Constants;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardCommentActivity extends AppCompatActivity {

    private RecyclerView commentList;

    private CommentListAdapter commentListAdapter;

    private String projectId;
    private PreferencesHelper preferencesHelper;

    private RecyclerView recyclerView;

    private Bundle bundle;
    private RewardRestInterface restInterface;
    private String token;

    private SwipeRefreshLayout swipeRefreshLayout;

    private CommentsData commentsData;
    private List<Comment> listComments;
    private int offset;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        projectId = intent.getStringExtra(Constants.PROJECT_ID);

        setContentView(R.layout.activity_comment_dashboard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        linearLayoutManager = new LinearLayoutManager(this);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_comments);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadComments(projectId,0);
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

        preferencesHelper = new PreferencesHelper(DashboardCommentActivity.this);

        recyclerView = (RecyclerView)findViewById(R.id.listView);

        loadComments(projectId,0);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager, swipeRefreshLayout) {

            @Override
            public void onLoadMore(int page, int totalItemsCount) {

                Log.e("totalItemsCount",totalItemsCount+"=="+commentsData.getTotalCommentsCount());
                if(totalItemsCount<commentsData.getTotalCommentsCount()){
                    loadComments(projectId,totalItemsCount);
                }
            }
        });
    }

    public void commentAction(String commentId, String commentType, String replyType, String commentText){

        WebServiceHelper objWebServiceHelper = new WebServiceHelper(this);
        RequestParam rp = new RequestParam();
        if(this.preferencesHelper.getPrefBoolean(PreferencesHelper.USER_LOGGED_IN)){
            String loginUser = (this.preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN));
            try {
                JSONObject jsonObject = new JSONObject(loginUser);
                token = jsonObject.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            String guestUser = (this.preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER));
            try {
                JSONObject jsonObject = new JSONObject(guestUser);
                token = jsonObject.getString(Constants.TOKEN_STR);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        rp.putHeader(Constants.TOKEN, token);
        rp.putHeader(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
        rp.putParams(Constants.PROJECT_ID, projectId);
        rp.putParams(Constants.COMMENT_ID, commentId);
        rp.putParams(Constants.COMMENT_TYPE, commentType);
        rp.putParams(Constants.COMMENT, commentText);

        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
        Call<CommentsData> call = restInterface.AddUpdateComments(token,projectId,commentId,commentType,commentText);
        call.enqueue(new Callback<CommentsData>() {
            @Override
            public void onResponse(Call<CommentsData> call, Response<CommentsData> response) {
                try {
             //       String msg = result.getString(Constants.MESSAGE);
                    String msg = response.message();
                    Toast.makeText(DashboardCommentActivity.this,msg, Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CommentsData> call, Throwable t) {
                 t.printStackTrace();
            }
        });
       /* objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.COMMENT_ACTION , rp, new WebServiceHelper.OnWebServiceListener() {

            @Override
            public void successResponse(JSONObject result) {
                try {
                    String msg = result.getString(Constants.MESSAGE);
                    Toast.makeText(DashboardCommentActivity.this,msg, Toast.LENGTH_SHORT).show();
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.e("success", errorMessage.toString());
            }
        });*/
    }

    private void loadComments(String ProjectId, final int offset){
        WebServiceHelper objWebServiceHelper = new WebServiceHelper(this);
        RequestParam rp = new RequestParam();
        if(this.preferencesHelper.getPrefBoolean(PreferencesHelper.USER_LOGGED_IN)){
            String loginUser = (this.preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN));
            try {
                JSONObject jsonObject = new JSONObject(loginUser);
                token = jsonObject.getString("token");
                Log.e("token-joiye",token);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            String guestUser = (this.preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER));
            try {
                JSONObject jsonObject = new JSONObject(guestUser);
                token = jsonObject.getString(Constants.TOKEN_STR);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        rp.putHeader(Constants.TOKEN, token);
        rp.putHeader(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
        rp.putParams(Constants.PROJECT_ID, ProjectId);
        rp.putParams(Constants.OFFSET,String.valueOf(offset));
        rp.putParams(Constants.VIEW_TYPE, "dashboard");
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
        Call<CommentsData> call = restInterface.ProjectCommentsDashboard(token,ProjectId,String.valueOf(offset),"dashboard");
            call.enqueue(new Callback<CommentsData>() {
                @Override
                public void onResponse(Call<CommentsData> call, Response<CommentsData> response) {
                    try {
                        Gson gson = new Gson();
                       // commentsData = gson.fromJson(result.getJSONObject(Constants.DATA).toString(), CommentsData.class);

                        if(offset==0){
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setNestedScrollingEnabled(false);
                            listComments = commentsData.getComments();
                            commentListAdapter = new CommentListAdapter(listComments,DashboardCommentActivity.this);
                            recyclerView.setAdapter(commentListAdapter);
                        }else{
                            int curSize = commentListAdapter.getItemCount();
                            listComments.addAll(commentsData.getComments());
                            commentListAdapter.notifyItemRangeInserted(curSize, listComments.size() - 1);
                        }
                        swipeRefreshLayout.setRefreshing(false);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<CommentsData> call, Throwable t) {
                     t.printStackTrace();
                }
            });
       /* objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.PROJECT_COMMENTS , rp, new WebServiceHelper.OnWebServiceListener() {

            @Override
            public void successResponse(JSONObject result) {
                try {
                    Gson gson = new Gson();
                    commentsData = gson.fromJson(result.getJSONObject(Constants.DATA).toString(), CommentsData.class);

                    if(offset==0){
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setNestedScrollingEnabled(false);
                        listComments = commentsData.getComments();
                        commentListAdapter = new CommentListAdapter(listComments,DashboardCommentActivity.this);
                        recyclerView.setAdapter(commentListAdapter);
                    }else{
                        int curSize = commentListAdapter.getItemCount();
                        listComments.addAll(commentsData.getComments());
                        commentListAdapter.notifyItemRangeInserted(curSize, listComments.size() - 1);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
