package com.rock.reward.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.util.Log;

import com.rock.reward.R;

/**
 * Created by rocku28 on 29/7/16.
 */
public class CustomEditText extends AppCompatEditText {

    private static final String TAG = "TextView";

    public CustomEditText(Context context){
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs){
        super(context,attrs);
        setCustomFont(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    /**
     * Set the custom font to view
     * @param ctx
     * @param attrs
     */
    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomFontView);
        String customFont = a.getString(R.styleable.CustomFontView_customFont);
        setCustomFont(ctx, customFont);
        a.recycle();
    }

    /**
     * Init the custom font and return the typeface
     *
     * @param ctx
     * @param asset
     * @return : return the typeface
     */
    public boolean setCustomFont(Context ctx, String asset) {
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), asset);
        } catch (Exception e) {
            Log.e(TAG, "Could not get typeface: " + e.getMessage());
            return false;
        }

        setTypeface(tf);
        return true;
    }
}
