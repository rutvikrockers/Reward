package com.rock.reward.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.rock.reward.R;

/**
 * Created by rockers on 8/3/17.
 */

public class SharedPreferenceUtils {
    Context context;
    private static String UserD;


    public static String getuserid(Context mcontext) {
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(mcontext.getString(R.string.FILENAME_LOGIN_DETAILS), Context.MODE_PRIVATE);
        UserD = sharedPreferences.getString(mcontext.getString(R.string.KEY_USER_ID), null);
        return UserD;
    }
}
