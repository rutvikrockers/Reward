package com.rock.reward.fragment.userProfile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.rock.reward.volleyWebservice.Constants;
import com.android.volley.Request;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.ResponsePojo.ResponseUpdateAccount;
import com.rock.reward.activity.EditUserProfileActivity;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.ProfileData;
import com.rock.reward.model.UserLogin;
import com.rock.reward.utils.Utils;
import com.rock.reward.volleyWebservice.RequestParam;
import com.rock.reward.volleyWebservice.WebServiceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EditUserBasicInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EditUserBasicInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditUserBasicInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_POSITION = "position";
    // TODO: Rename and change types of parameters
    private Bundle mParam;
    private RewardRestInterface restInterface;
    private TextView firstName;
    private TextView lastName;
    private TextView profileSlug;
    private TextView zipcode;
    private TextView aboutYourself;
    private TextView skills;
    private TextView interest;
    private TextView occupation;
    private TextView email;
    private TextView address;
    private ImageView userImage;

    private String firstNameValue;
    private String lastNameValue;
    private String profileSlugValue;
    private String zipcodeValue;
    private String aboutYourselfValue;
    private String skillsValue;
    private String interestValue;
    private String occupationValue;
    private String emailValue;
    private String addressValue;
    private String token;
    private Button saveChanges;
    private Button changeImage;

    private ProfileData profileData;

    private View view;

    private int IMAGE_PICKER_SELECT = 1;

    private OnFragmentInteractionListener mListener;

    public EditUserBasicInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment EditUserBasicInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
/*   *//* public static EditUserBasicInfoFragment newInstance(Bundle param1) {
        EditUserBasicInfoFragment fragment = new EditUserBasicInfoFragment();

        Bundle args = new Bundle();

        args.putAll(param1);
        fragment.setArguments(args);
        return fragment;
    *//*}*/

    public static EditUserBasicInfoFragment newInstance(Bundle param1) {
        EditUserBasicInfoFragment f = new EditUserBasicInfoFragment();
        Bundle b = new Bundle();

        b.putAll(param1);
        f.setArguments(b);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_edit_user_basic_info, container, false);

        mParam.getString(Constants.FIRSTNAME);

        firstName = (TextView)view.findViewById(R.id.first_name);
        lastName = (TextView)view.findViewById(R.id.last_name);
        skills = (TextView)view.findViewById(R.id.skills);
        occupation = (TextView)view.findViewById(R.id.occupation);
        interest = (TextView)view.findViewById(R.id.interest);
        profileSlug = (TextView)view.findViewById(R.id.profile_slug);
        aboutYourself = (TextView)view.findViewById(R.id.about_yourself);
        email = (TextView)view.findViewById(R.id.email);
        address = (TextView)view.findViewById(R.id.address);
        zipcode = (TextView)view.findViewById(R.id.zipcode);

        saveChanges = (Button)view.findViewById(R.id.save_changes);
        changeImage = (Button)view.findViewById(R.id.change_image);



        userImage = (ImageView)view.findViewById(R.id.user_image);

        firstName.setText(mParam.getString(Constants.FIRSTNAME));
        lastName.setText(mParam.getString(Constants.LASTNAME));
        skills.setText(mParam.getString(Constants.USER_SKILL));
        occupation.setText(mParam.getString(Constants.USER_OCCUPATION));
        interest.setText(mParam.getString(Constants.USER_INTEREST));
        profileSlug.setText(mParam.getString(Constants.PROFILE_SLUG));
        aboutYourself.setText(mParam.getString(Constants.USER_ABOUT));
        email.setText(mParam.getString(Constants.EMAIL));
        address.setText(mParam.getString(Constants.ADDRESS));
        zipcode.setText(mParam.getString(Constants.ZIPCODE));

//        user_image

        Glide.with(getActivity())
                .load(mParam.getString(Constants.USER_IMAGE))
                .crossFade()
                .into(userImage);

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInformation();
            }
        });

        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, IMAGE_PICKER_SELECT);
            }
        });
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IMAGE_PICKER_SELECT
                && resultCode == Activity.RESULT_OK) {
            String path = getPathFromCameraData(data, this.getActivity());
            Log.i("PICTURE", "Path: " + path);
            if (path != null) {
                uploadUserImage(path);
            }
        }
    }

    private void uploadUserImage(String imagePath){
        String imageBase64 = convertImageToBase64(imagePath);

        Utils.showLoader(getActivity());

        WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
        RequestParam rp = new RequestParam();
        String guestUser = ((EditUserProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
        try {
            JSONObject jsonObject = new JSONObject(guestUser);
            token = jsonObject.getString(Constants.TOKEN_STR);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        rp.putHeader(Constants.TOKEN, token);
        rp.putHeader(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
        rp.putParams(Constants.USER_IMAGE_PASS,imageBase64);
        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
   //     Call<UserLogin> call = restInterface.UserUpdateImage(token,imageBase64);
     /*   call.enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                try {
                    Gson gson = new Gson();
             //       String newImageUrl = result.getJSONObject(Constants.DATA).getString(Constants.USER_IMAGE);

                    String loginUser = ((EditUserProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
                    ((EditUserProfileActivity) getActivity()).preferencesHelper.clearSpecificSharedPreferences(PreferencesHelper.USER_LOGIN);


                    JSONObject getLoginUserInfo;
                    JSONObject loginObject;

                    getLoginUserInfo = new JSONObject(loginUser);
                    String userId = getLoginUserInfo.getString(Constants.USER_ID);
                    String userToken = getLoginUserInfo.getString(Constants.TOKEN_STR);
                    String firstName = getLoginUserInfo.getString(Constants.FIRSTNAME);
                    String lastName = getLoginUserInfo.getString(Constants.LASTNAME);
                    String email = getLoginUserInfo.getString(Constants.EMAIL);
                  //  String userImage = newImageUrl;

                    loginObject= new JSONObject();
                    loginObject.put(Constants.USER_ID,userId);
                    loginObject.put(Constants.TOKEN_STR,userToken);
                    loginObject.put(Constants.FIRSTNAME,firstName);
                    loginObject.put(Constants.LASTNAME,lastName);
                    loginObject.put(Constants.EMAIL,email);
                    loginObject.put(Constants.USER_IMAGE,userImage);

                    UserLogin userLogin = gson.fromJson(loginObject.toString(),UserLogin.class);
                    String json = gson.toJson(userLogin);

                    ((EditUserProfileActivity)getActivity()).preferencesHelper.putPrefString(PreferencesHelper.USER_LOGIN, json);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                    t.printStackTrace();
            }
        });*/
        objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.UPDATE_USER_IMAGE , rp, new WebServiceHelper.OnWebServiceListener() {

            @Override
            public void successResponse(JSONObject result) {
                try {
                    Gson gson = new Gson();
                    String newImageUrl = result.getJSONObject(Constants.DATA).getString(Constants.USER_IMAGE);

                    String loginUser = ((EditUserProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
                    ((EditUserProfileActivity) getActivity()).preferencesHelper.clearSpecificSharedPreferences(PreferencesHelper.USER_LOGIN);


                    JSONObject getLoginUserInfo;
                    JSONObject loginObject;

                    getLoginUserInfo = new JSONObject(loginUser);
                    String userId = getLoginUserInfo.getString(Constants.USER_ID);
                    String userToken = getLoginUserInfo.getString(Constants.TOKEN_STR);
                    String firstName = getLoginUserInfo.getString(Constants.FIRSTNAME);
                    String lastName = getLoginUserInfo.getString(Constants.LASTNAME);
                    String email = getLoginUserInfo.getString(Constants.EMAIL);
                    String userImage = newImageUrl;

                    loginObject= new JSONObject();
                    loginObject.put(Constants.USER_ID,userId);
                    loginObject.put(Constants.TOKEN_STR,userToken);
                    loginObject.put(Constants.FIRSTNAME,firstName);
                    loginObject.put(Constants.LASTNAME,lastName);
                    loginObject.put(Constants.EMAIL,email);
                    loginObject.put(Constants.USER_IMAGE,userImage);

                    UserLogin userLogin = gson.fromJson(loginObject.toString(),UserLogin.class);
                    String json = gson.toJson(userLogin);

                    ((EditUserProfileActivity)getActivity()).preferencesHelper.putPrefString(PreferencesHelper.USER_LOGIN, json);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.e("success", errorMessage.toString());
                Utils.hideLoader(getActivity());
                Utils.showAlert(getActivity(), errorMessage);
            }
        });
        Utils.hideLoader(getActivity());
    }

    private String convertImageToBase64(String imagepath){

        Bitmap bm = BitmapFactory.decodeFile(imagepath);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteArrayImage = baos.toByteArray();

        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
        return encodedImage;
    }

    public static String getPathFromCameraData(Intent data, Context context) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = context.getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }

    private String validateUserInformation(){
        firstNameValue = String.valueOf(firstName.getText());
        lastNameValue = String.valueOf(lastName.getText());
        interestValue = String.valueOf(interest.getText());
        occupationValue = String.valueOf(occupation.getText());
        skillsValue = String.valueOf(skills.getText());
        emailValue = String.valueOf(email.getText());
        profileSlugValue = String.valueOf(profileSlug.getText());
        aboutYourselfValue = String.valueOf(aboutYourself.getText());
        zipcodeValue = String.valueOf(zipcode.getText());
        addressValue = String.valueOf(address.getText());
        return null;
    }

    private void saveUserInformation(){
        validateUserInformation();
        JSONObject prof = null;
        try {
            JSONObject profile = new JSONObject();
            profile.put(Constants.FIRSTNAME,firstNameValue);
            profile.put(Constants.LASTNAME,lastNameValue);
            profile.put(Constants.USER_ABOUT,aboutYourselfValue);
            profile.put(Constants.USER_OCCUPATION,occupationValue);
            profile.put(Constants.USER_INTEREST,interestValue);
            profile.put(Constants.ZIPCODE,zipcodeValue);
            profile.put(Constants.PROFILE_SLUG,profileSlugValue);
            profile.put(Constants.USER_SKILL,skillsValue);
            profile.put(Constants.ADDRESS,addressValue);
            prof = new JSONObject();
            prof.put("profile",profile);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("data",String.valueOf(prof));

        Utils.showLoader(getActivity());

        WebServiceHelper objWebServiceHelper = new WebServiceHelper(getActivity());
        RequestParam rp = new RequestParam();
        String guestUser = ((EditUserProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
        try {
            JSONObject jsonObject = new JSONObject(guestUser);
            token = jsonObject.getString(Constants.TOKEN_STR);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        rp.putHeader(Constants.TOKEN, token);
        rp.putHeader(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
        rp.putParams(Constants.PROFILE_DATA, String.valueOf(prof));


        restInterface = ApiClient.getClient().create(RewardRestInterface.class);
        Call<ResponseUpdateAccount> call = restInterface.UpdateAccount(token,String.valueOf(prof));
     /*   call.enqueue(new Callback<ResponseUpdateAccount>() {
            @Override
            public void onResponse(Call<ResponseUpdateAccount> call, Response<ResponseUpdateAccount> response) {
                Gson gson = new Gson();
                try {
                    profileData = gson.fromJson(response.body().toString(), ProfileData.class);
                    String loginUser = ((EditUserProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
                    ((EditUserProfileActivity) getActivity()).preferencesHelper.clearSpecificSharedPreferences(PreferencesHelper.USER_LOGIN);

                    JSONObject getLoginUserInfo;
                    JSONObject loginObject;
                    String userId="";
                    String userToken="";

                    getLoginUserInfo = new JSONObject(loginUser);
                    userId = getLoginUserInfo.getString(Constants.USER_ID);
                    userToken = getLoginUserInfo.getString(Constants.TOKEN_STR);

                    loginObject= new JSONObject();
                    loginObject.put(Constants.USER_ID,userId);
                    loginObject.put(Constants.TOKEN_STR,userToken);
                    loginObject.put(Constants.FIRSTNAME,profileData.getProfile().getFirstName());
                    loginObject.put(Constants.LASTNAME,profileData.getProfile().getLastName());
                    loginObject.put(Constants.EMAIL,profileData.getProfile().getEmail());
                    loginObject.put(Constants.USER_IMAGE,profileData.getProfile().getUserImageUrl());

                    UserLogin userLogin = gson.fromJson(loginObject.toString(),UserLogin.class);
                    String json = gson.toJson(userLogin);

                    ((EditUserProfileActivity)getActivity()).preferencesHelper.putPrefString(PreferencesHelper.USER_LOGIN, json);

                    Toast.makeText(getActivity(), "Information saved.", Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<ResponseUpdateAccount> call, Throwable t) {
                        t.printStackTrace();
            }
        });*/

       objWebServiceHelper.apiParamsCall(Request.Method.POST,Constants.WebServiceUrls.UPDATE_ACCOUNT , rp, new WebServiceHelper.OnWebServiceListener() {

            @Override
            public void successResponse(JSONObject result) {
                Gson gson = new Gson();
                try {
                    profileData = gson.fromJson(result.getJSONObject(Constants.DATA).toString(), ProfileData.class);
                    String loginUser = ((EditUserProfileActivity) getActivity()).preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN);
                    ((EditUserProfileActivity) getActivity()).preferencesHelper.clearSpecificSharedPreferences(PreferencesHelper.USER_LOGIN);

                    JSONObject getLoginUserInfo;
                    JSONObject loginObject;
                    String userId="";
                    String userToken="";

                    getLoginUserInfo = new JSONObject(loginUser);
                    userId = getLoginUserInfo.getString(Constants.USER_ID);
                    userToken = getLoginUserInfo.getString(Constants.TOKEN_STR);

                    loginObject= new JSONObject();
                    loginObject.put(Constants.USER_ID,userId);
                    loginObject.put(Constants.TOKEN_STR,userToken);
                    loginObject.put(Constants.FIRSTNAME,profileData.getProfile().getFirstName());
                    loginObject.put(Constants.LASTNAME,profileData.getProfile().getLastName());
                    loginObject.put(Constants.EMAIL,profileData.getProfile().getEmail());
                    loginObject.put(Constants.USER_IMAGE,profileData.getProfile().getUserImageUrl());

                    UserLogin userLogin = gson.fromJson(loginObject.toString(),UserLogin.class);
                    String json = gson.toJson(userLogin);

                    ((EditUserProfileActivity)getActivity()).preferencesHelper.putPrefString(PreferencesHelper.USER_LOGIN, json);

                    Toast.makeText(getActivity(), "Information saved.", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                preferencesHelper.putPrefBoolean(PreferencesHelper.USER_LOGGED_IN,false);
            }

            @Override
            public void failureResponse(String errorMessage, int errorCode) {
                Log.e("success", errorMessage.toString());
                Utils.hideLoader(getActivity());
                Utils.showAlert(getActivity(), errorMessage);
            }
        });
        Utils.hideLoader(getActivity());

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
