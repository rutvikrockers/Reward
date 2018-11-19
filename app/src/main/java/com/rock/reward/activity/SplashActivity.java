package com.rock.reward.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.rock.reward.volleyWebservice.Constants;
import com.android.volley.Request;
import com.google.gson.Gson;
import com.rock.reward.R;
import com.rock.reward.encryption.CryptLib;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.GuestLogin;
import com.rock.reward.utils.Utils;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {

    private String encodedStringToken;
    private PreferencesHelper preferencesHelper;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        encodedStringToken = encriptString();
        preferencesHelper = new PreferencesHelper(SplashActivity.this);
        sharedPreferences = getSharedPreferences(getString(R.string.FILENAME_LOGIN_DETAILS), Context.MODE_PRIVATE);
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    //Check if already login then ask passcode verification other goto introduction screen
                    if (!preferencesHelper.getPrefBoolean(PreferencesHelper.GUEST_LOGGED_IN)) {//Introduction screen
                        //Guest Login
                        guestLogin(encodedStringToken);
                    } else {
                        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }

                }
            }
        };
        timerThread.start();
    }
    private void guestLogin(String encodedStringToken){
        WebServiceHelper objWebServiceHelper = new WebServiceHelper(this);
        RequestParam rp = new RequestParam();
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

                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.i("Login Fail Response", errorMessage);
                Utils.hideLoader(SplashActivity.this);
                Utils.showAlert(SplashActivity.this, errorMessage);
            }
        });
    }

    public static String encriptString(){
        try {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            String randString = Constants.ENC_FIRST_PART+String.valueOf(year)+Constants.ENC_LAST_PART;
            String key = Constants.ENC_KEY;
            String iv = Constants.ENC_IV;

            CryptLib _crypt = new CryptLib();
            String output= "";
            String key_enc = CryptLib.SHA256(key, 32); //32 bytes = 256 bit
            String iv_enc = CryptLib.SHA256(iv, 16); //32 bytes = 256 bit

            output = _crypt.encrypt(randString, key_enc, iv_enc); //encrypt
            return output;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
