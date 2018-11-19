package com.rock.reward.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import com.rock.reward.R;


/**
 * Created by rocku28 on 29/7/16.
 */
public class CustomTextView extends TextView {

    private static final String TAG = "TextView";

    public CustomTextView(Context context){
        super(context);
    }

    public CustomTextView(Context context,AttributeSet attrs){
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public CustomTextView(Context context,AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    /**
     * Set the custom font to view
     * @param context
     * @param attrs
     */
    private void setCustomFont(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontView);
        String customFont = a.getString(R.styleable.CustomFontView_customFont);
        setCustomFont(context, customFont);
        a.recycle();
    }

    /**
     * Init the custom font and return the typeface
     *
     * @param context
     * @param asset
     * @return : return the typeface
     */
    public boolean setCustomFont(Context context, String asset) {
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(context.getAssets(), asset);
        } catch (Exception e) {
            Log.e(TAG, "Could not get typeface: " + e.getMessage());
            return false;
        }

        setTypeface(tf);
        return true;
    }
}
