package com.rock.reward.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.rock.reward.volleyWebservice.Constants;
import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.ResponsePojo.ResponseProjectDetailData;
import com.rock.reward.activity.projectDashboard.DashboardCommentActivity;
import com.rock.reward.activity.projectDashboard.DashboardFollowerActivity;
import com.rock.reward.activity.projectDashboard.DashboardFunderActivity;
import com.rock.reward.activity.projectDashboard.DashboardUpdateActivity;
import com.rock.reward.adapter.CommentListAdapter;
import com.rock.reward.adapter.FollowerListAdapter;
import com.rock.reward.adapter.FunderListAdapter;
import com.rock.reward.adapter.PerkListAdapter;
import com.rock.reward.adapter.TeamMemberListAdapter;
import com.rock.reward.adapter.UpdateListAdapter;
import com.rock.reward.extras.HtmlParser;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.Comment;
import com.rock.reward.model.CommentsData;
import com.rock.reward.model.Follower;
import com.rock.reward.model.Funder;
import com.rock.reward.model.ProjectDetailData;
import com.rock.reward.model.TeamMember;
import com.rock.reward.model.Update;
import com.rock.reward.utils.Utils;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectDashboardActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    private Toolbar toolbar;
    private String projectId;
    private String token;
    private PreferencesHelper preferencesHelper;
    private ProjectDetailData projectDetailData;
    private TextView projectTitle;
    private TextView projectAmount;
    private TextView projectAmountRaised;
    private TextView projectCategory;
    private TextView projectPercentageFunding;
    private TextView projectDaysLeft;
    private TextView projectTotalComments;
    private TextView projectTotalFunders;
    private TextView projectTotalFollowers;
    private TextView projectTotalUpdates;
    private TextView projectTotalTeamMembers;
    private TextView projectCommentsViewAll;
    private TextView projectUpdatesViewAll;
    private TextView projectFundersViewAll;
    private TextView projectFollowersViewAll;
    private TextView projectTeamMembersViewAll;
    private TextView projectStatus;



    private RewardRestInterface restInterface;

    private ImageView projectThumbnail;

    private RecyclerView perkList;
    private RecyclerView funderList;
    private RecyclerView followerList;
    private RecyclerView commentList;
    private RecyclerView teamMemberList;
    private RecyclerView updateList;


    private ProgressBar amountProgress;

    private PerkListAdapter adapter;
    private FunderListAdapter funderListAdapter;
    private FollowerListAdapter followerListAdapter;
    private TeamMemberListAdapter teamMemberListAdapter;
    private UpdateListAdapter updateListAdapter;

    private Bundle bundle;

    private Button contribute;

    private RelativeLayout rlFunderList;
    private RelativeLayout rlCommentList;
    private RelativeLayout rlTeamMemberList;
    private RelativeLayout rlUpdateList;
    private RelativeLayout rlfollowerList;
    private RelativeLayout rlPerkList;

    private RelativeLayout rlFunderListTop;
    private RelativeLayout rlCommentListTop;
    private RelativeLayout rlTeamMemberListTop;
    private RelativeLayout rlUpdateListTop;
    private RelativeLayout rlfollowerListTop;
    private RelativeLayout rlPerkListTop;

    VideoView vidView;
    private YouTubePlayerSupportFragment frag;
    private String youTubeId;

    private String readStoryValue;

    private CommentListAdapter commentListAdapter;
    private CommentsData commentsData;
    private LinearLayoutManager linearLayoutManager;
    private List<Comment> listComments;
    private Intent intentOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_dashboard);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        final Intent intent = getIntent();
        projectId = intent.getStringExtra(Constants.PROJECT_ID);

        preferencesHelper = new PreferencesHelper(ProjectDashboardActivity.this);

        String guestUser = (this.preferencesHelper.getPrefString(PreferencesHelper.GUEST_USER));
        try {
            JSONObject jsonObject = new JSONObject(guestUser);
            token = jsonObject.getString(Constants.TOKEN_STR);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        frag = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);

        projectTitle = (TextView) findViewById(R.id.tv_project_title);
        projectAmount = (TextView) findViewById(R.id.amount);
        projectAmountRaised = (TextView) findViewById(R.id.amount_raised);
        projectPercentageFunding = (TextView) findViewById(R.id.percentage_funded);
        projectDaysLeft = (TextView) findViewById(R.id.days_left);

//        projectCommentsViewAll = (TextView) findViewById(R.id.view_all_comments);
//        projectUpdatesViewAll = (TextView) findViewById(R.id.view_all_updates);
//        projectFundersViewAll = (TextView) findViewById(R.id.view_all_funders);
//        projectFollowersViewAll = (TextView) findViewById(R.id.view_all_followers);
//        projectTeamMembersViewAll = (TextView) findViewById(R.id.team_member_view_all);

        projectStatus = (TextView) findViewById(R.id.project_status);
        projectCategory = (TextView)findViewById(R.id.category);

        projectThumbnail = (ImageView) findViewById(R.id.project_thumbnail);

        amountProgress = (ProgressBar) findViewById(R.id.progress_amount_raised);


//        rlFunderList = (RelativeLayout)findViewById(R.id.rl_funder_list);
//        rlCommentList = (RelativeLayout)findViewById(R.id.rl_comment_list);
//        rlUpdateList = (RelativeLayout)findViewById(R.id.rl_update_list);
//        rlfollowerList = (RelativeLayout)findViewById(R.id.rl_follower_list);
//        rlPerkList = (RelativeLayout)findViewById(R.id.rl_perk_list);
//        rlTeamMemberList = (RelativeLayout)findViewById(R.id.rl_team_member_list);

        rlFunderListTop = (RelativeLayout)findViewById(R.id.rl_top_contributions);
        rlCommentListTop = (RelativeLayout)findViewById(R.id.rl_top_comments);
        rlUpdateListTop = (RelativeLayout)findViewById(R.id.rl_top_updates);
        rlfollowerListTop = (RelativeLayout)findViewById(R.id.rl_top_followers);
        rlPerkListTop = (RelativeLayout)findViewById(R.id.rl_top_perks);
        rlTeamMemberListTop = (RelativeLayout)findViewById(R.id.rl_top_team_members);
        


        getProjectDetail();


        commentList = (RecyclerView)findViewById(R.id.comment_list);
        rlCommentListTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentOne = new Intent(view.getContext(), DashboardCommentActivity.class);
                intentOne.putExtras(bundle);
                intentOne.putExtra(Constants.PROJECT_ID,projectId);
                startActivity(intentOne);
            }
        });

        rlFunderListTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentOne = new Intent(view.getContext(), DashboardFunderActivity.class);
                intentOne.putExtras(bundle);
                intentOne.putExtra(Constants.PROJECT_ID,projectId);
                startActivity(intentOne);
            }
        });

        rlUpdateListTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentOne = new Intent(view.getContext(), DashboardUpdateActivity.class);
                intentOne.putExtras(bundle);
                intentOne.putExtra(Constants.PROJECT_ID,projectId);
                startActivity(intentOne);
            }
        });

        rlfollowerListTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentOne = new Intent(view.getContext(), DashboardFollowerActivity.class);
                intentOne.putExtras(bundle);
                intentOne.putExtra(Constants.PROJECT_ID,projectId);
                startActivity(intentOne);
            }
        });
    }

    private void setProjectDetail() {

        getSupportActionBar().setTitle(projectDetailData.getProjectDetail().getProjectTitle());


        projectTitle.setText(projectDetailData.getProjectDetail().getProjectTitle());
        projectCategory.setText(projectDetailData.getProjectDetail().getProjectCategoryName());

        projectAmount.setText(projectDetailData.getProjectDetail().getAmountWithCurrency()+"");
        projectAmountRaised.setText(projectDetailData.getProjectDetail().getAmountGetWithCurrency()+" raised of");

        projectStatus.setText(projectDetailData.getProjectDetail().getProjectStatus().toUpperCase());


        projectStatus.setBackgroundResource(R.drawable.tags_rounded_corners);
        GradientDrawable drawable = (GradientDrawable) projectStatus.getBackground();
        drawable.setColor(Color.parseColor("#"+projectDetailData.getProjectDetail().getStatusColor()));

        String fundingTypeText = "<strong>"+projectDetailData.getProjectDetail().getFundingType()+"</strong>";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            fundingTypeText = String.valueOf(Html.fromHtml(fundingTypeText,Html.FROM_HTML_MODE_LEGACY));
        } else {
            fundingTypeText = String.valueOf(Html.fromHtml(fundingTypeText));
        }


        if (projectDetailData.getProjectDetail().getPercentage()!=null){
            projectPercentageFunding.setText(projectDetailData.getProjectDetail().getPercentage().toString()+"% funded");
        }
        else{

        }



        projectDaysLeft.setText(HtmlParser.stripHtml(projectDetailData.getProjectDetail().getEndDate()));

        amountProgress.setProgress(Integer.valueOf(projectDetailData.getProjectDetail().getPercentage().intValue()));

        if(projectDetailData.getProjectDetail().getPitchMedia().equals("video")){

            Log.e("is sssvideo",projectDetailData.getProjectDetail().getPitchMedia());

            projectThumbnail.setVisibility(View.GONE);

            String expandedUrl = null;
            try {
                expandedUrl = new getExpandUrl().execute(projectDetailData.getProjectDetail().getVideo()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

            Pattern compiledPattern = Pattern.compile(pattern);
            Matcher matcher = compiledPattern.matcher(expandedUrl); //url is youtube url for which you want to extract the id.
            if (matcher.find()) {
                youTubeId = matcher.group();
            }

            frag.initialize(Constants.DEVELOPER_KEY, this);

        }else{
            Glide.with(this)
                    .load(projectDetailData.getProjectDetail().getPitchImageUrl())
                    .placeholder(R.drawable.default_project_image)
                    .crossFade()
                    .into(projectThumbnail);

            View fragm = findViewById(R.id.youtube_fragment);
            fragm.setVisibility(View.GONE);
        }




    }
    public class getExpandUrl extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String[] str) {
            URL url;
            Log.e("url[0]",str[0]);
            String expandedURL = "";
            try {
                url = new URL(str[0]);
                // open connection
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                // stop following browser redirect
                httpURLConnection.setInstanceFollowRedirects(false);
                // extract location header containing the actual destination URL
                expandedURL = httpURLConnection.getHeaderField("Location");
                httpURLConnection.disconnect();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return expandedURL;
        }
    }

    private void getProjectDetail() {

        Utils.showLoader(ProjectDashboardActivity.this);

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
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
        Call<ResponseProjectDetailData> call = restInterface.ProjectDetail(token,projectId);
        call.enqueue(new Callback<ResponseProjectDetailData>() {
            @Override
            public void onResponse(Call<ResponseProjectDetailData> call, Response<ResponseProjectDetailData> response) {
                Gson gson = new Gson();
                try {

                    ArrayList<ProjectDetailData> homedate=new ArrayList<>();
                    ArrayList<String> projectDetailDatas = new ArrayList<>();
                    for (int i=0; i<response.body().getData().getComments().size(); i++) {
                        projectDetailDatas.add(response.body().getData().getProject_detail().toString());
                    }
                    if (projectDetailDatas != null) {
                        bundle = new Bundle();
                        if(response.body().getData().getComments().size()>0){
                            ArrayList<Comment> commentArrayList = new ArrayList<>();
                            for (int i=0; i<response.body().getData().getComments().size(); i++) {
                                commentArrayList.add(response.body().getData().getComments().get(i));
                            }

                            bundle.putParcelableArrayList(Constants.COMMENTS,commentArrayList);
                        }

                        if(response.body().getData().getUpdates().size()>0){
                            ArrayList<Update> updateArrayList = new ArrayList<>();
                            for (int i=0; i<response.body().getData().getUpdates().size(); i++) {
                                updateArrayList.add(response.body().getData().getUpdates().get(i));
                            }
                            bundle.putParcelableArrayList(Constants.UPDATES,updateArrayList);
                        }

                        if(response.body().getData().getFunders().size()>0){
                            ArrayList<Funder> funderArrayList = new ArrayList<>();
                            for (int i=0; i<response.body().getData().getFunders().size(); i++) {
                                funderArrayList.add(response.body().getData().getFunders().get(i));
                            }
                            bundle.putParcelableArrayList(Constants.FUNDERS,funderArrayList);
                        }
                        if (response.body().getData().getFollowers() != null) {
                            if (response.body().getData().getFollowers().size() > 0) {
                                ArrayList<Follower> followerArrayList = new ArrayList<>();
                                for (int i = 0; i < response.body().getData().getFollowers().size(); i++) {
                                    followerArrayList.add(response.body().getData().getFollowers().get(i));
                                }
                                bundle.putParcelableArrayList(Constants.FOLLOWERS, followerArrayList);
                            }
                        }
                        if (response.body().getData().getTeam_members() != null) {
                            if (response.body().getData().getTeam_members().size() > 0) {
                                ArrayList<TeamMember> teamMemberArrayList = new ArrayList<>();
                                for (int i = 0; i < response.body().getData().getFollowers().size(); i++) {
                                    teamMemberArrayList.add(response.body().getData().getTeam_members().get(i));
                                }
                                bundle.putParcelableArrayList(Constants.TEAM_MEMBERS, teamMemberArrayList);
                            }
                        }
                        getSupportActionBar().setTitle(response.body().getData().getProject_detail().getProjectTitle());


                        projectTitle.setText(response.body().getData().getProject_detail().getProjectTitle());
                        projectCategory.setText(response.body().getData().getProject_detail().getProjectCategoryName());

                        projectAmount.setText(response.body().getData().getProject_detail().getAmountWithCurrency()+"");
                        projectAmountRaised.setText(response.body().getData().getProject_detail().getAmountGetWithCurrency()+" raised of");

                        projectStatus.setText(response.body().getData().getProject_detail().getProjectStatus().toUpperCase());


                        projectStatus.setBackgroundResource(R.drawable.tags_rounded_corners);
                        GradientDrawable drawable = (GradientDrawable) projectStatus.getBackground();
                        drawable.setColor(Color.parseColor("#"+response.body().getData().getProject_detail().getStatusColor()));

                        String fundingTypeText = "<strong>"+response.body().getData().getProject_detail().getFundingType()+"</strong>";
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                            fundingTypeText = String.valueOf(Html.fromHtml(fundingTypeText,Html.FROM_HTML_MODE_LEGACY));
                        } else {
                            fundingTypeText = String.valueOf(Html.fromHtml(fundingTypeText));
                        }


                        if (response.body().getData().getProject_detail().getPercentage()!=null){
                            projectPercentageFunding.setText(response.body().getData().getProject_detail().getPercentage().toString()+"% funded");
                        }
                        else{

                        }



                        projectDaysLeft.setText(HtmlParser.stripHtml(response.body().getData().getProject_detail().getEndDate()));

                        amountProgress.setProgress(Integer.valueOf(response.body().getData().getProject_detail().getPercentage().intValue()));

                        if(response.body().getData().getProject_detail().getPitchMedia().equals("video")){

                            Log.e("is sssvideo",response.body().getData().getProject_detail().getPitchMedia());

                            projectThumbnail.setVisibility(View.GONE);

                            String expandedUrl = null;
                            try {
                                expandedUrl = new getExpandUrl().execute(response.body().getData().getProject_detail().getVideo()).get();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                            String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

                            Pattern compiledPattern = Pattern.compile(pattern);
                            Matcher matcher = compiledPattern.matcher(expandedUrl); //url is youtube url for which you want to extract the id.
                            if (matcher.find()) {
                                youTubeId = matcher.group();
                            }

                            frag.initialize(Constants.DEVELOPER_KEY, ProjectDashboardActivity.this);

                        }else{
                            Glide.with(ProjectDashboardActivity.this)
                                    .load(response.body().getData().getProject_detail().getPitchImageUrl())
                                    .placeholder(R.drawable.default_project_image)
                                    .crossFade()
                                    .into(projectThumbnail);

                            View fragm = findViewById(R.id.youtube_fragment);
                            fragm.setVisibility(View.GONE);
                        }


                        Utils.hideLoader(ProjectDashboardActivity.this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseProjectDetailData> call, Throwable t) {
                       t.printStackTrace();
            }
        });
      /*  objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.PROJECT_DETAIL , rp, new WebServiceHelper.OnWebServiceListener() {

            @Override
            public void successResponse(JSONObject result) {
                try {
                    Gson gson = new Gson();
                    projectDetailData = gson.fromJson(result.getJSONObject(Constants.DATA).toString(), ProjectDetailData.class);
                    if (projectDetailData.getProjectDetail() != null) {
                        bundle = new Bundle();
                        if(projectDetailData.getComments().size()>0){
                            ArrayList<Comment> commentArrayList = new ArrayList<>();
                            for (int i=0; i<projectDetailData.getComments().size(); i++) {
                                commentArrayList.add(projectDetailData.getComments().get(i));
                            }

                            bundle.putParcelableArrayList(Constants.COMMENTS,commentArrayList);
                        }

                        if(projectDetailData.getUpdates().size()>0){
                            ArrayList<Update> updateArrayList = new ArrayList<>();
                            for (int i=0; i<projectDetailData.getUpdates().size(); i++) {
                                updateArrayList.add(projectDetailData.getUpdates().get(i));
                            }
                            bundle.putParcelableArrayList(Constants.UPDATES,updateArrayList);
                        }

                        if(projectDetailData.getFunders().size()>0){
                            ArrayList<Funder> funderArrayList = new ArrayList<>();
                            for (int i=0; i<projectDetailData.getFunders().size(); i++) {
                                funderArrayList.add(projectDetailData.getFunders().get(i));
                            }
                            bundle.putParcelableArrayList(Constants.FUNDERS,funderArrayList);
                        }

                        if(projectDetailData.getFollowers().size()>0){
                            ArrayList<Follower> followerArrayList = new ArrayList<>();
                            for (int i=0; i<projectDetailData.getFollowers().size(); i++) {
                                followerArrayList.add(projectDetailData.getFollowers().get(i));
                            }
                            bundle.putParcelableArrayList(Constants.FOLLOWERS,followerArrayList);
                        }
                        if(projectDetailData.getTeamMembers().size()>0){
                            ArrayList<TeamMember> teamMemberArrayList = new ArrayList<>();
                            for (int i=0; i<projectDetailData.getFollowers().size(); i++) {
                                teamMemberArrayList.add(projectDetailData.getTeamMembers().get(i));
                            }
                            bundle.putParcelableArrayList(Constants.TEAM_MEMBERS,teamMemberArrayList);
                        }

                        setProjectDetail();
                        Utils.hideLoader(ProjectDashboardActivity.this);
                    }
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            //I assume the below String value is your video id
            Log.e("youTubeId",youTubeId);
            player.cueVideo(youTubeId);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
//            youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(getString(R.string.error_player), youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

}
