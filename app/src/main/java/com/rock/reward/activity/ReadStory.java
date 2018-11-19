package com.rock.reward.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import com.rock.reward.volleyWebservice.Constants;
import com.rock.reward.R;
import com.rock.reward.localStorage.PreferencesHelper;

public class ReadStory extends AppCompatActivity {

    private String projectId;
    private PreferencesHelper preferencesHelper;
    private String readStory;
    private TextView readStoryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        projectId = intent.getStringExtra(Constants.PROJECT_ID);
        readStory = intent.getStringExtra(Constants.READ_STORY);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        preferencesHelper = new PreferencesHelper(ReadStory.this);

        readStoryText = (TextView)findViewById(R.id.read_story);
        readStoryText.setText(readStory);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
