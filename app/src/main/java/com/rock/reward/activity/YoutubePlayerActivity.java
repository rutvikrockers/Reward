package com.rock.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.rock.reward.volleyWebservice.Constants;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.rock.reward.R;

/**
 * Created by rockers on 25/5/17.
 */

public class YoutubePlayerActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {
    private YouTubePlayerView youTubeView;
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_youtube);
        //FacebookSdk.sdkInitialize(this);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

        // Initializing video player with developer key
        youTubeView.initialize(Constants.DEVELOPER_KEY, this);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Constants.DEVELOPER_KEY, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "Enable to Play Video", errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }
    /*@Override
    protected void onResume() {
        AppEventsLogger.activateApp(this, getString(R.string.facebook_app_id));
        super.onResume();
    }*/

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        final YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            String Item = getIntent().getExtras().getString("url");
            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.loadVideo(Item);
            player.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                @Override
                public void onFullscreen(boolean b) {
                    player.setFullscreen(true);

                }
            });

            // Hiding player controls
            // player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }
}
