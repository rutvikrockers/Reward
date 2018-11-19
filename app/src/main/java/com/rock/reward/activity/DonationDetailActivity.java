package com.rock.reward.activity;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.rock.reward.R;
import com.rock.reward.extras.WebViewJavascriptBridge;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.volleyWebservice.Constants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rocku27 on 22/8/16.
 */


public class DonationDetailActivity extends AppCompatActivity {

    private WebView myWebView;
    private String projectId;
    private String perkId;
    public WebViewJavascriptBridge bridge;
    private PreferencesHelper preferencesHelper;
    private String userId;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        projectId = intent.getStringExtra(Constants.PROJECT_ID);
        perkId = intent.getStringExtra(Constants.PERK_ID);

        setContentView(R.layout.activity_donation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        preferencesHelper = new PreferencesHelper(DonationDetailActivity.this);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new MyBrowser());

        if(perkId!=null && !perkId.isEmpty()){
            url =Constants.WebServiceUrls.PROJECT_DONATION_DETAIL+projectId+"/"+perkId;
        }else{
            url =Constants.WebServiceUrls.PROJECT_DONATION_DETAIL+projectId;
        }

        if(this.preferencesHelper.getPrefBoolean(PreferencesHelper.USER_LOGGED_IN)){
            String loginUser = (this.preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN));
            try {
                JSONObject jsonObject = new JSONObject(loginUser);
                userId = jsonObject.getString("user_id");
                url = url+"?app=application&device=android&uid="+userId;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            url = url+"?app=application&device=android";
        }

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Inject WebAppInterface methods into Web page by having Interface 'Android'
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        myWebView.loadUrl(url);

//        bridge=new WebViewJavascriptBridge(this,myWebView,new UserServerHandler()) ;
//        myWebView.addJavascriptInterface(new Payment(), "interface");



    }

    private class MyBrowser extends WebViewClient {

        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.e("url",url);
            view.loadUrl(url);
            return true;
        }

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            final Uri uri = request.getUrl();
            Log.e("url",uri.toString());
            view.loadUrl(uri.toString());
            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
//
//    private class Payment {
//        @JavascriptInterface
//        public void PaymentSuccess() {
//            Toast.makeText(DonationDetailActivity.this, "JavaScript interface call", Toast.LENGTH_LONG).show();
//        }
//    }

    class UserServerHandler implements WebViewJavascriptBridge.WVJBHandler{
        @Override
        public void handle(String data, WebViewJavascriptBridge.WVJBResponseCallback jsCallback) {
            Log.e("test","Received message from javascript: "+ data);
            if (null !=jsCallback) {
                jsCallback.callback("Java said:Right back atcha");
            }
            bridge.send("I expect a response!",new WebViewJavascriptBridge.WVJBResponseCallback() {
                @Override
                public void callback(String responseData) {
                    Log.e("test","Got response! "+responseData);
                }
            });
            bridge.send("Hi");

            bridge.registerHandler("handler1",new WebViewJavascriptBridge.WVJBHandler() {
                @Override
                public void handle(String data, WebViewJavascriptBridge.WVJBResponseCallback jsCallback) {
                    Log.e("test","handler1 got:"+data);
                    if(null!=jsCallback){
                        jsCallback.callback("handler1 answer");
                    }
                    bridge.callHandler("showAlert","42");
                }
            });
        }
    }
    //Class to be injected in Web page
    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /**
         * Show Toast Message
         * @param toast
         */
        @JavascriptInterface
        public void showToast(String toast) {
            try {
               // Log.e("toast",toast);
                JSONObject jsonObject = new JSONObject(toast);

                if(jsonObject.getBoolean("success")){
                    String message = jsonObject.getString("message");

                    Intent intent = new Intent(DonationDetailActivity.this,ProjectDetailActivity.class);
                    intent.putExtra(Constants.PROJECT_ID,projectId);
                    intent.putExtra("donation_success",message);
                    startActivity(intent);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
//            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        /**
         * Show Dialog
         * @param dialogMsg
         */
        @JavascriptInterface
        public void showDialog(String dialogMsg){
            AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

            // Setting Dialog Title
            alertDialog.setTitle("JS triggered Dialog");

            // Setting Dialog Message
            alertDialog.setMessage(dialogMsg);

            // Setting alert dialog icon
            //alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(mContext, "Dialog dismissed!", Toast.LENGTH_SHORT).show();
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }

        /**
         * Intent - Move to next screen
         */
        @JavascriptInterface
        public void moveToNextScreen(){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
            // Setting Dialog Title
            alertDialog.setTitle("Alert");
            // Setting Dialog Message
            alertDialog.setMessage("Are you sure you want to leave to next screen?");
            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Move to Next screen
//                            Intent chnIntent = new Intent(AndroidJSWebView.this, ChennaiIntent.class);
//                            startActivity(chnIntent);
                        }
                    });
            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Cancel Dialog
                            dialog.cancel();
                        }
                    });
            // Showing Alert Message
            alertDialog.show();
        }
    }
}