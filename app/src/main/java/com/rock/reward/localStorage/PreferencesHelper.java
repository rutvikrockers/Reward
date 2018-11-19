package com.rock.reward.localStorage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * @version 1.0.
 */
public class PreferencesHelper {

    private static final String APP_SHARED_PREFS = PreferencesHelper.class.getSimpleName(); //  Name of the file -.xml

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor prefsEditor;

    /**
     * Preference string key
     */
    //For Store the application number
    public static final String GUEST_LOGGED_IN = "guest_logged_in";
    public static final String KEY_PASSCODE = "key_pass_code";

    public static final String KEY_PREFS_SELECTED_LANG_CODE = "selected_lang_code";
    public static final String CAPTURE_IMAGE_PATH = "capture_image_path";

    //For Guest Login
    public static final String GUEST_USER = "guest_user";
    public static final String CATEGORY_ID = "category_id";
    public static final String CATEGORY_NAME = "category_name";

    public static final String USER_TOKEN = "user_token";

    public static final String USER_LOGIN = "user_login";
    public static final String USER_LOGGED_IN = "user_logged_in";



    /**
     * SCANNIG and PROFILE preference key
     */
    public static final String KEY_BARCODE_NUMBER = "barcode_number";
    public static final String KEY_BARCODE_SCANNED_DETAILS = "barcode_scanned_details";


    /**
     * Device infomation
     */
    public static String DEVICE_DISPLAY_WIDTH = "device_display_width";
    public static String DEVICE_DISPLAY_HEIGHT = "device_display_height";
    public static String DEVICE_MODEL = "device_Model";
    public static String DEVICE_MANUFACTURER = "device_Manufacturer";
    public static String DEVICE_VERSION = "device_Version";
    public static String DEVICE_DENSITY = "device_density";
    public static String DEVICE_TYPE = "device_type";
    public static String DEVICE_TYPE_ANDROID = "1";
    public static String DEVICE_IMEI = "device_imei";
    public static String PUSH_TOKEN = "push_token";

    //Profile
    public static String USER_PROFILE = "user_profile";
    public static String EMPLOYEE_TOKEN = "collector_token";
    public static String KEY_PHONE_NUMBER = "key_phone_number";

    public PreferencesHelper(Context context) {
        this.sharedPreferences = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
        this.prefsEditor = sharedPreferences.edit();
    }

    public void clearSharedPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }
    public void clearSpecificSharedPreferences(String key) {
        prefsEditor.remove(key).commit();
    }

    public String getPrefString(String key) {
        return sharedPreferences.getString(key, ""); // Get our string from prefs or return an empty string
    }

    public void putPrefString(String key, String value) {
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public void putPrefBoolean(String key, Boolean value) {
        prefsEditor.putBoolean(key, value);
        prefsEditor.commit();
    }

    public boolean getPrefBoolean(String key) {
        return sharedPreferences.getBoolean(key, false); // Get our string from prefs or return an false
    }

}
