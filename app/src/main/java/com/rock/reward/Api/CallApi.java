package com.rock.reward.Api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rock.reward.activity.HomeActivity;
import com.rock.reward.model.FilteredCampains;
import com.rock.reward.model.GuestLogin;
import com.rock.reward.model.HomeData;
import com.rock.reward.model.MyProjectsData;
import com.rock.reward.model.UserFollowersData;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by rockers on 2/3/17.
 */

public class CallApi {
    Context mContext;
    GuestLogin guestLogin;
    HomeData homeData;
    private String userId = "10";
    MyProjectsData myProjectsData;
    UserFollowersData userFollowersData;
    FilteredCampains filteredCampains;
    String token;
    public CallApi(Context mContext,  String token) {
        this.mContext = mContext;
        this.token = token;
    }

   /* public  void  setGuestLogin(HomeData requestModel){

        this.homeData = requestModel;
        RewardRestInterface mServices = ApiClient.getClient().create(RewardRestInterface.class);
        Call<HomeDataResponse> call = mServices.ProfileEdit(token, requestModel);
        call.enqueue(new CallBackRequest<HomeDataResponse>() {


            @Override
            public void onResponse(Call<HomeDataResponse> call, Response<HomeDataResponse> response) {
                Log.e("Response Code", "SUCCESS");

                if(response.code()==200){
                    Log.e("Response::::", new Gson().toJson(response.body()));



                }
                else{
                    Log.e("Login_call", response.code() + "");

                    //  ApiError error = ErrorUtils.parseError(ApiClient.getClient(),response);
                    Utils.showAlert((Activity) mContext,"pls fill all the field");
                }


            }

            @Override
            public void onFailure(Call<HomeDataResponse> call, Throwable t) {
                Log.e("Response Code", "FAILURE");
            }
        });
    }
*/
    public void loginUser(){

       // this.guestLogin = requestModel;

        RewardRestInterface mServices = ApiClient.getClient().create(RewardRestInterface.class);
        Call<GuestLogin> call = mServices.loginUser(token);
        call.enqueue(new CallBackRequest<GuestLogin>(){

            @Override
            public void onResponse(Call<GuestLogin> call, Response<GuestLogin> response) {
                Log.e("Response Code", "SUCCESS");

                if(response.code()==200){
                    Log.e("200ok","OK");

                    Log.e("Response::::", new Gson().toJson(response.body()));

                    Intent intent = new Intent();
                    intent.setClass(mContext,HomeActivity.class);
                    mContext.startActivity(intent);

//

                }

//                if (response.isSuccessful()) {
//
//                }
                else {
                    Log.e("Login_call", response.code() + "");

                //    ApiError error = ErrorUtils.parseError(ApiClient.getClient(),response);
                    Toast.makeText(mContext, "invalid phone no or password", Toast.LENGTH_SHORT).show();

//                    Log.e("Login_call_error3", error.toString() + "");
                }
            }

            @Override
            public void onFailure(Call<GuestLogin> call, Throwable t) {
                Log.e("Response Code", "FAILURE");
                Toast.makeText(mContext, "invalid phone no or password", Toast.LENGTH_SHORT).show();
                Log.e("Throwable", String.valueOf(t));
            }
        });
    }






}
