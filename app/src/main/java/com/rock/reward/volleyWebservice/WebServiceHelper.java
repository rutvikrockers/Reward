package com.rock.reward.volleyWebservice;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.rock.reward.activity.HomeActivity;
import com.rock.reward.R;
import com.rock.reward.activity.SplashActivity;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.GuestLogin;
import com.rock.reward.utils.Utils;

//import com.rockers.reward.model.AuthenticationCollectorVo;
//import com.rockers.reward.model.CollectorProfileVo;
//import com.rockers.reward.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WebServiceHelper {

    private Gson gson;
    private Context context;
    private int method;
    private RequestParam rp;
    private String url;
    private OnWebServiceListener onWebServiceListener;

    public WebServiceHelper(Context context) {
        super();
        gson = new Gson();
        this.context = context;

    }

    public void apiParamsCall(int method, final String url, final RequestParam rp, final OnWebServiceListener onWebServiceListener){
        this.method = method;
        this.url = url;
        this.rp = rp;
        this.onWebServiceListener = onWebServiceListener;

        Log.i("url : ", url);
        Utils.showLog(Utils.INFO, "REQUEST BODY : " + rp.getParam().toString());
        Utils.showLog(Utils.INFO, "REQUEST HEADER : " + rp.getHeaderRequestParam().toString());
        gson = new Gson();
        final Integer[] errorCodes = {1,2,3,4,5,1009,2001,2004,2003,2005,2010,2011};
        final List<Integer> list = Arrays.asList(errorCodes);


        RequestQueue mRequestQueue = Volley.newRequestQueue(context);

        CustomRequest customRequest = new CustomRequest(context,method,url,rp,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("response",response.toString());

                        if (response.has(Constants.SUCCESS)) {
                            try {
                                Boolean code = response.getBoolean(Constants.SUCCESS);

                                if (code==true)
                                    onWebServiceListener.successResponse(response);
                                else {
                                    int errorCode = response.getInt(Constants.ERRORCODE);

                                    if (list.contains(errorCode)) {
                                        apiReGuestlogin();
                                    }
                                    if (response.has(Constants.MESSAGE)) {
                                        onWebServiceListener.failureResponse(response.getString(Constants.MESSAGE), errorCode);
                                    } else {
                                        Log.i("WS ERROR", "" + response.toString());
                                        onWebServiceListener.failureResponse(context.getString(R.string.request_error), errorCode);
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            try {
                                int code = response.getInt(Constants.ERRORCODE);

                                if (list.contains(code)) {
                                    apiReGuestlogin();
                                }else{
                                    onWebServiceListener.failureResponse(response.getString(Constants.MESSAGE), 404);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        try {
                            if (error != null) {
                                String responseBody = new String(error.networkResponse.data, "utf-8");
                                JSONObject response = new JSONObject(responseBody);
                                int code = response.getInt(Constants.ERRORCODE);

                                if (list.contains(code)) {
                                    apiReGuestlogin();
                                } else {
                                    if (response.has(Constants.MESSAGE))
                                        onWebServiceListener.failureResponse(response.getString(Constants.MESSAGE), code);
                                    else
                                        onWebServiceListener.failureResponse(context.getString(R.string.request_error), code);
                                }
                            } else {
                                onWebServiceListener.failureResponse(context.getString(R.string.request_error), 0);
                            }
                        } catch (JSONException e) {
                            //Handle a malformed json response
                        } catch (UnsupportedEncodingException e) {

                        } catch (Exception e) {
                        }
                    }
                });
        mRequestQueue.add(customRequest);
    }

    public void apiReGuestlogin(){
        Log.e("guest login","guest");
        final int method = Request.Method.GET;
        final String urls = Constants.WebServiceUrls.GUEST_LOGIN;
        final RequestParam rp = new RequestParam();
        rp.putHeader(Constants.GUEST_TOKEN,SplashActivity.encriptString());

        gson = new Gson();

        RequestQueue mRequestQueue = Volley.newRequestQueue(context);

        Utils.showLog(Utils.INFO, "REQUEST BODY : " + rp.getChild().toString());
        Utils.showLog(Utils.INFO, "REQUEST HEADER : " + rp.getHeaderRequestParam().toString());

        Log.e("guest login url",urls);

        JsonObjectRequest req = new JsonObjectRequest(method, urls, rp.getChild(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("response",response.toString());
                        GuestLogin guestLogin = null;
                        try {
                            ((HomeActivity) context).preferencesHelper.clearSpecificSharedPreferences(PreferencesHelper.USER_LOGIN);
                            ((HomeActivity) context).preferencesHelper.putPrefBoolean(PreferencesHelper.USER_LOGGED_IN,false);

                            guestLogin = gson.fromJson(response.getJSONObject(Constants.DATA).toString(),GuestLogin.class);
                            String json = gson.toJson(guestLogin);

                            //Store the user profile detail shared preferences
                            ((HomeActivity) context).preferencesHelper.putPrefString(PreferencesHelper.GUEST_USER, json);

                            //guest logged in
                            ((HomeActivity) context).preferencesHelper.putPrefBoolean(PreferencesHelper.GUEST_LOGGED_IN, true);

                             rp.putHeader(Constants.TOKEN,guestLogin.getToken());

                             apiParamsCall(method, url, rp, onWebServiceListener);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Utils.showLog(Utils.INFO, "API FAILURE : " + error.toString());
                    }
                }

             )

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return rp.getHeaderRequestParam();
            }

        };
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        req.setRetryPolicy(policy);

        //Add request queue
        mRequestQueue.add(req);
    }

    public void apiCall(int method, final String url, final RequestParam rp, final OnWebServiceListener onWebServiceListener) {
        // public void setUserLogin() {
        this.method = method;
        this.url = url;
        this.rp = rp;
        this.onWebServiceListener = onWebServiceListener;

        Log.i("url : ", url);
        gson = new Gson();

        /*client.setUserAgent(System.getProperty("http.agent"));
        client.addHeader("User-Agent", System.getProperty("http.agent"));*/

        //Add Request Queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);


    /*   CustomRequest CustomRequest request=new CustomRequest(context, Request.Method.POST,url,rp.getrequestParam(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                //ArrayList<LoginResponse> loginResponse= (ArrayList<LoginResponse>) VolleySingleton.parseReponse(response.toString(), LoginResponse.class);

                GsonBuilder gb = new GsonBuilder();
                //gb.registerTypeAdapter(String.class, new StringConverter());
                gson = gb.create();

                //Using GSON class convert string to class obj
                webServiceResponse = gson.fromJson("JsonString", WebserviceResponse.class);

                //Check error response if true or false
                if (!webServiceResponse.getHasError()) {
                    webServiceListener.webServiceSuccessResponse("JsonString");
                } else {
                    //Check for expire the token
                    if (webServiceResponse.getErrorCode() == INVALID_OR_EXPIRED_TOKEN || webServiceResponse.getErrorCode() == TOKEN_REQUIRED) {

                        //Check for if manually expire the token then get the configuration
                        if (webServiceResponse.getErrorCode() == MANUALLY_EXPIRED_TOKEN || webServiceResponse.getErrorCode() == TOKEN_NOT_EXIST) {
                            //Perform Manually Login
                        }
                    } else {
                        webServiceListener.webServiceFailResponse(webServiceResponse.getResponseMessage() + "", webServiceResponse.getErrorCode());
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                webServiceListener.webServiceFailResponse("Error message", 100); //pass error code and error message
            }
        });*/

        Utils.showLog(Utils.INFO, "REQUEST BODY : " + rp.getChild().toString());
        Utils.showLog(Utils.INFO, "REQUEST HEADER : " + rp.getHeaderRequestParam().toString());


        JsonObjectRequest req = new JsonObjectRequest(method, url, rp.getChild(),
                new Response.Listener<JSONObject>() {

//                    @Override
//                    public String getBodyContentType() {
//                        return "application/json; charset=utf-8";
//                    }
                    @Override
                    public void onResponse(JSONObject response) {
                        Utils.showLog(Utils.INFO, "RESPONSE : " + response.toString());
                        if (response.has(Constants.SUCCESS)) {
                            try {
                                Boolean code = response.getBoolean(Constants.SUCCESS);
                                if (code==true)
                                    onWebServiceListener.successResponse(response);
                                else {
                                    if (response.has(Constants.MESSAGE)) {
                                        onWebServiceListener.failureResponse(response.getString(Constants.MESSAGE), 404);
                                    } else {
                                        Log.i("WS ERROR", "" + response.toString());
                                        onWebServiceListener.failureResponse(context.getString(R.string.request_error), 404);
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            try {
                                onWebServiceListener.failureResponse(response.getString(Constants.MESSAGE), 404);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                , new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showLog(Utils.INFO, "API FAILURE : " + error.toString());
                try {
                    if (error != null) {
                        String responseBody = new String(error.networkResponse.data, "utf-8");
                        JSONObject response = new JSONObject(responseBody);
                        int code = response.getInt(Constants.CODE);
                        if (code == 401) {
                            apiRelogin();
                        } else {
                            if (response.has(Constants.MESSAGE))
                                onWebServiceListener.failureResponse(response.getString(Constants.MESSAGE), code);
                            else
                                onWebServiceListener.failureResponse(context.getString(R.string.request_error), code);
                        }
                    } else {
                        onWebServiceListener.failureResponse(context.getString(R.string.request_error), 0);
                    }
                } catch (JSONException e) {
                    //Handle a malformed json response
                } catch (UnsupportedEncodingException e) {

                } catch (Exception e) {
                }
            }
        }

        )

        {
//            @Override
//            public String getBodyContentType() {
//                return "application/x-www-form-urlencoded; charset=UTF-8";
//            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return rp.getHeaderRequestParam();
            }

        };
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        req.setRetryPolicy(policy);

        //Add request queue
        mRequestQueue.add(req);

    }


    public void apiRelogin() {
        // public void setUserLogin() {


        final RequestParam requestParam = new RequestParam();

        //add header value
        //rp.putHeader(ConstantsLocal.CONTENT_TYPE, ConstantsLocal.CONTENT_TYPE_VALUE);

        //add body value in JSON

        requestParam.addChild(Constants.PHONE_NUMBER, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.KEY_PHONE_NUMBER));
        requestParam.addChild(Constants.PASSWORD, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.KEY_PASSCODE));

        JSONObject UserDeviceTracks = new JSONObject();

        try {
            // Userdevicetracks
            UserDeviceTracks.put(Constants.USER_DEVICE_HEIGHT, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.DEVICE_DISPLAY_HEIGHT));
            UserDeviceTracks.put(Constants.USER_DEVICE_IMEI, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.DEVICE_IMEI));
            UserDeviceTracks.put(Constants.USER_DEVICE_MENUFACTURE, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.DEVICE_MANUFACTURER));
            UserDeviceTracks.put(Constants.USER_DEVICE_DEVICE_MODEL, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.DEVICE_MODEL));
            UserDeviceTracks.put(Constants.USER_DEVICE_OS, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.DEVICE_VERSION));
            UserDeviceTracks.put(Constants.USER_DEVICE_SCALE, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.DEVICE_DENSITY));
            UserDeviceTracks.put(Constants.USER_DEVICE_TOKEN, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.PUSH_TOKEN));
            UserDeviceTracks.put(Constants.USER_DEVICE_TYPE, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.DEVICE_TYPE));
            UserDeviceTracks.put(Constants.USER_DEVICE_WIDTH, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.DEVICE_DISPLAY_WIDTH));

        } catch (Exception e) {
        }

        requestParam.addChild(Constants.USER_DEVICE_TRACKS, UserDeviceTracks);
        /*client.setUserAgent(System.getProperty("http.agent"));
        client.addHeader("User-Agent", System.getProperty("http.agent"));*/

        //Add Request Queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);

        Utils.showLog(Utils.INFO, "REQUEST BODY : " + requestParam.getChild().toString());
        Utils.showLog(Utils.INFO, "REQUEST HEADER : " + requestParam.getHeaderRequestParam().toString());
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, Constants.WebServiceUrls.GUEST_LOGIN, requestParam.getChild(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Utils.showLog(Utils.INFO, "RESPONSE : " + response.toString());
                        if (response.has(Constants.CODE)) {
//                            try {
//                                AuthenticationCollectorVo authenticationCollectorVo = gson.fromJson(response.getJSONObject(Constants.DATA).toString(), AuthenticationCollectorVo.class);
//                                CollectorProfileVo collectorProfileVo = gson.fromJson(response.getJSONObject(Constants.DATA).toString(), CollectorProfileVo.class);
//                                String json = gson.toJson(collectorProfileVo);
//
//                                //Store the user profile detail shared preferences
//                                ((HomeActivity) context).preferencesHelper.putPrefString(PreferencesHelper.USER_PROFILE, json);
//
//                                //Store the token for the access the other api
//                                ((HomeActivity) context).preferencesHelper.putPrefString(PreferencesHelper.EMPLOYEE_TOKEN, authenticationCollectorVo.getAuthToken());
//                                rp.putHeader(Constants.TOKEN, ((HomeActivity) context).preferencesHelper.getPrefString(PreferencesHelper.EMPLOYEE_TOKEN));
//
//                                apiCall(method, url, rp, onWebServiceListener);
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
                        }
                    }
                }

                , new Response.ErrorListener()

        {


            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showLog(Utils.INFO, "API FAILURE : " + error.toString());
                try {
                    String responseBody = new String(error.networkResponse.data, "utf-8");
                    JSONObject response = new JSONObject(responseBody);
                    int code = response.getInt(Constants.CODE);

                    //Goto Introduction page

                } catch (JSONException e) {
                    //Handle a malformed json response
                } catch (UnsupportedEncodingException e) {

                }
            }
        }

        )

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return requestParam.getHeaderRequestParam();
            }
        };
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        req.setRetryPolicy(policy);

        //Add request queue
        mRequestQueue.add(req);

    }

    public interface OnWebServiceListener {

        //Webservice success response
        void successResponse(JSONObject content);

        //Webservice failure response
        void failureResponse(String errorMessage, int errorCode);
    }

}
