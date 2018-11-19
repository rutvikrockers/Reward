package com.rock.reward.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.rock.reward.volleyWebservice.Constants;
import com.android.volley.Request;
import com.google.gson.Gson;
import com.rock.reward.R;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.GuestLogin;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class TempActivity extends AppCompatActivity {

    private String encodedStringToken;
    private static PreferencesHelper preferencesHelper;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        context = getApplicationContext();
        preferencesHelper = new PreferencesHelper(TempActivity.this);
    }

    public void TempTempActivity(){

    }
    public static void guestLogin(){

        WebServiceHelper objWebServiceHelper = new WebServiceHelper(context);
        RequestParam rp = new RequestParam();
        String encodedStringToken = SplashActivity.encriptString();
        rp.putHeader(Constants.GUEST_TOKEN,encodedStringToken);

        objWebServiceHelper.apiCall(Request.Method.GET, Constants.WebServiceUrls.GUEST_LOGIN,rp,new WebServiceHelper.OnWebServiceListener(){

            @Override
            public void successResponse(JSONObject content) {
                Log.e("resStr",content.toString());

                Gson gson = new Gson();
                try {
                    Log.e("resStrStr",content.getJSONObject(Constants.DATA).toString());

                    GuestLogin guestLogin = gson.fromJson(content.getJSONObject(Constants.DATA).toString(),GuestLogin.class);
                    String json = gson.toJson(guestLogin);

                    //Store the user profile detail shared preferences
                    preferencesHelper.putPrefString(PreferencesHelper.GUEST_USER, json);

                    //guest logged in
                    preferencesHelper.putPrefBoolean(PreferencesHelper.GUEST_LOGGED_IN, true);

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.i("Login Fail Response", errorMessage);
            }
        });

    }
}
