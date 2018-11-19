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
import com.rock.reward.R;
import com.rock.reward.adapter.TeamMemberListAdapter;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.TeamMember;

import java.util.ArrayList;

public class TeamMemberActivity extends AppCompatActivity {

    private String projectId;
    private Bundle bundle;
    private SwipeRefreshLayout swipeRefreshLayout;
    private PreferencesHelper preferencesHelper;
    private RecyclerView recyclerView;
    private TeamMemberListAdapter teamMemberListAdapter;
    private String token;
    private String ProjectId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        projectId = intent.getStringExtra(Constants.PROJECT_ID);
        bundle = intent.getExtras();

        setContentView(R.layout.activity_team_member);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_team_members);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadMembers(projectId);
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

        preferencesHelper = new PreferencesHelper(TeamMemberActivity.this);

        recyclerView = (RecyclerView)findViewById(R.id.list_team_members);

        getMembers();
    }

    public void getMembers(){
        if(bundle.getParcelableArrayList(Constants.TEAM_MEMBERS)!=null){
            ArrayList<TeamMember> teamMemberArrayList = bundle.getParcelableArrayList(Constants.TEAM_MEMBERS);

            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setNestedScrollingEnabled(false);

            teamMemberListAdapter = new TeamMemberListAdapter(teamMemberArrayList, this);
            recyclerView.setAdapter(teamMemberListAdapter);
        }
    }

    public void loadMembers(String projectId){

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
