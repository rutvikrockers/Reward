package com.rock.reward.Api;

import com.rock.reward.ResponsePojo.HomeDataResponse;
import com.rock.reward.ResponsePojo.ResponseCommentsData;
import com.rock.reward.ResponsePojo.ResponseFollowersPojo;
import com.rock.reward.ResponsePojo.ResponseFollowingPojo;
import com.rock.reward.ResponsePojo.ResponseForgotPassword;
import com.rock.reward.ResponsePojo.ResponseFunderData;
import com.rock.reward.ResponsePojo.ResponseMyProjectData;

import com.rock.reward.ResponsePojo.ResponseMyfundingRaise;
import com.rock.reward.ResponsePojo.ResponseProjectDetailData;
import com.rock.reward.ResponsePojo.ResponseSearchFilterCampaign;
import com.rock.reward.ResponsePojo.ResponseSignupPojo;
import com.rock.reward.ResponsePojo.ResponseUpdateAccount;
import com.rock.reward.ResponsePojo.ResponseUserDashboardData;
import com.rock.reward.ResponsePojo.ResponseUserLogin;
import com.rock.reward.ResponsePojo.ResponseUserProfile;
import com.rock.reward.model.CommentsData;
import com.rock.reward.model.FollowersData;
import com.rock.reward.model.FollowingProjectsData;
import com.rock.reward.model.FundersData;
import com.rock.reward.model.GuestLogin;
import com.rock.reward.model.HomeData;
import com.rock.reward.model.MyActivitiesData;
import com.rock.reward.model.MyCommentsData;
import com.rock.reward.model.MyProjectsData;
import com.rock.reward.model.UpdatesData;
import com.rock.reward.model.UserLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by rockers on 2/3/17.
 */

public interface RewardRestInterface {

    @GET("api/login/guest")
    Call<GuestLogin>loginUser(@Header("fscrwsf-token")String token );


    @FormUrlEncoded
    @POST("api/projectobj/followers")
    Call<ResponseFollowersPojo> postToFollow(@Header("www-token") String Token, @Field("projectId") String ProjectId);



    @POST("api/home/index")
    Call<HomeDataResponse> ProfileEdit(@Header("www-token")String token,@Query("offset") String Offset,@Query("category_id")String categoryid);



    @FormUrlEncoded
    @POST("api/user/update_account")
    Call<ResponseUpdateAccount> UpdateAccount(
            @Header("www-token") String token,@Field("profile_data")String profiledata );



    @POST("api/search/index")
    Call<ResponseSearchFilterCampaign> SearchFilter(
            @Header("www-token") String token,@Query("title")String title,@Query("city")String city,@Query("goal_type")String goaltype,@Query("goal_size")String goalsize,@Query("status")String status,@Query("category_id")String categoryid,@Query("country_id")String countryid);



     @FormUrlEncoded
    @POST("api/user/profile")
    Call<ResponseUserProfile> UserProfile(
            @Header("www-token") String token,@Field("user_id")String userid );



    @POST("api/user/myprojects")
    Call<ResponseMyProjectData> TrainerBookingRequest(@Header("www-token") String token,@Query("user_id")String userid);



    @POST("api/user/myprojects")
    Call<MyProjectsData> MyProjects(
            @Header("www-token") String token,@Query("user_id")String userid ,@Query("offset")String offset);



    @POST("api/user/myfollowings")
    Call<ResponseFollowingPojo> FollowingList( @Header("www-token") String token,@Query("user_id") String userid);




    @POST("api/user/updateinterest")
    Call<HomeData> UpdateInterests(
            @Header("www-token") String token,@Query("project_id") String projectid ,@Query("type") String type);



    @FormUrlEncoded
    @POST("api/projectobj/detail")
    Call<ResponseProjectDetailData> ProjectDetail(@Header("www-token") String token, @Field("project_id") String projectid);



    @FormUrlEncoded
    @POST("api/projectobj/updates")
    Call<UpdatesData> ProjectUpdates(@Header("www-token") String token, @Field("project_id") String projectid, @Field("view_type")String viewtype);



    @FormUrlEncoded
    @POST("api/projectobj/updates")
    Call<UpdatesData> ProjectUpdate(@Header("www-token") String token, @Field("project_id") String projectid);



    @FormUrlEncoded
    @POST("api/projectobj/comments")
    Call<ResponseCommentsData> ProjectComments(@Header("www-token") String token, @Field("project_id") String projectid, @Field("offset")String offset);



    @FormUrlEncoded
    @POST("api/projectobj/comments")
    Call<CommentsData> ProjectCommentsDashboard(@Header("www-token") String token, @Field("project_id") String projectid, @Field("offset")String offset,@Field("view_type")String viewtype);



    @FormUrlEncoded
    @POST("api/projectobj/funders")
    Call<FundersData> ProjectFunders(@Header("www-token") String token, @Field("project_id") String projectid, @Field("offset")String offset, @Field("view_type")String viewtype);


    @FormUrlEncoded
    @POST("api/projectobj/funders")
    Call<ResponseFunderData> Funders(@Header("www-token") String token, @Field("project_id") String projectid, @Field("offset")String offset);


    @FormUrlEncoded
    @POST("api/projectobj/followers")
    Call<FollowersData> Followers(@Header("www-token") String token, @Field("project_id") String projectid, @Field("view_type")String viewtype);



    @FormUrlEncoded
    @POST("api/user/updateprofileimage")
    Call<UserLogin> UserUpdateImage(@Header("www-token") String Token, @Field("user_image") String userimage);



    @FormUrlEncoded
    @POST("api/register")
    Call<ResponseSignupPojo> UserRegister(@Header("www-token") String Token, @Field("email") String Email, @Field("full_name") String Fullname, @Field("password") String Password);




    @POST("api/register/social")
    Call<UserLogin> SocialLoginRegister
            (@Header("www-token") String token,@Query("social_type")String SocialType,@Query("social_id")String SocialId,@Query("email")String Email,@Query("password")String Password,@Query("full_name")String FullName,@Query("social_profile_image")String Image,@Query("tw_screen_name")String Screename,@Query("tw_oauth_token")String Authtoken,@Query("tw_oauth_token_secret")String Authtokensecret,@Query("fb_access_token")String Fbtoken);




    @POST("api/user/myfollowingprojects")
    Call<FollowingProjectsData> UserFollowingProjects
            (@Header("www-token") String token,@Query("offset")String offset);


    @FormUrlEncoded
    @POST("api/projectobj/addUpdateComment")
    Call<CommentsData> AddUpdateComments(@Header("www-token") String Token, @Field("project_id") String Projectid,@Field("comment_id") String Commmentid,@Field("comment_type") String CommmentType,@Field("comment") String Commment);



    @POST("api/user/myactivities")
    Call<MyActivitiesData> UserActivities
            (@Header("www-token") String token,@Query("offset")String Offset);



    @FormUrlEncoded
    @POST("api/login/user_login")
    Call<ResponseUserLogin> UserLogin(@Header("www-token") String Token, @Field("email") String Email,@Field("password") String Password);




    @POST("api/user/user_dashboard")
    Call<ResponseUserDashboardData>UserDashboard(@Header("www-token")String token );





    @POST("api/user/raisedfund")
    Call<ResponseMyfundingRaise> UserRaiseFund
            (@Header("www-token") String token,@Query("user_id")String Userid);























/*    @POST("api/search/index")
    Call<ResponseSearchFilterCampaign> searchuser(@Header("www-token") String token, @Body FilteredCampains requestModel);*/

    @POST("api/user/mycomments")
    Call<MyCommentsData> MyComments(
            @Header("www-token") String token,@Query("user_id")String userid );



    @FormUrlEncoded
    @POST("api/login/forgetpassword")
    Call<ResponseForgotPassword> ForgotPassword(@Header("www-token") String Token, @Field("email") String Email);








}
