package com.rock.reward.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.rock.reward.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * This the common class function that provide the static method
 *
 * @version 1.0.
 */
public class Utils {

    private static Context context;
    public static final String NEWS_IMAGE_GALLERY_ID = "news_image_gallery";
    public static final String NEWS_IMAGE_GALLERY_TEXT = "news_image_gallery_text";
    public static final String IMAGE_GALLERY_ID = "image_gallery";
    public static final String IMAGE_GALLERY_TEXT = "image_gallery_text";
    public static final String IMAGE_GALLERY_BANNER = "image_gallery_banner";
    public static final String FAV_IMAGE_GALLERY_POSITION = "fav_image_gallery_position";
    public static final String DEAL_DURATION = "deal_create_id";
    private static Dialog popupDialog;

    /**
     * Used to initialize preference of the application
     * This method should be called very first line of activity
     *
     * @param ctx : Context
     */
    public static void initializePreferences(Context ctx) {
        context = ctx;
    }

    /**
     * Used to check Internet connection available or not
     *
     * @return
     */
    public static boolean isNetworkAvailable() {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            showLog(INFO, "***Available***");
            return true;
        }
        Log.e("Network Testing", "***Not Available***");
        return false;
    }

    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    public static void showLog(int log, String message) {

        switch (log) {
            case INFO:
                Log.i("LOG", message);
                break;

            case DEBUG:
                Log.d("LOG", message);
                break;

            case ERROR:
                Log.e("LOG", message);
                break;

        }
    }


    /**
     * Used to set language of the application
     *
     * @param act
     * @param lanCode
     */
    public static void setLanguage(Activity act, String lanCode) {
        Locale locale = new Locale(lanCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;
        act.getBaseContext()
                .getResources()
                .updateConfiguration(config,
                        act.getBaseContext().getResources().getDisplayMetrics());
        // onCreate(null);
    }


    /**
     * Used to show loader in application
     *
     * @param act
     */
    public static void showLoader(Activity act) {
        if (act != null && !act.isFinishing()) {

            if (popupDialog != null && popupDialog.isShowing()) {
//                popupDialog.cancel();
            } else {
                LayoutInflater inflater = LayoutInflater.from(act);
                View contentView = inflater.inflate(R.layout.loading_layout, null);
                popupDialog = new Dialog(act, R.style.DialogSlideAnim);// R.style.DialogSlideAnim);//
                // R.style.fadeInFadeOut);
                popupDialog.setCanceledOnTouchOutside(false);
                popupDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                    }
                });

                popupDialog.getWindow();

                popupDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                popupDialog.setContentView(contentView);

                popupDialog.show();
            }
        }
    }

    /**
     * Used to hide loader of the application
     *
     * @param act
     */
    public static void hideLoader(Activity act) {
        if (act != null && !act.isFinishing() && popupDialog != null)
            popupDialog.cancel();
    }


    public interface OnClickAlertViewListner {
        void okClick();

    }

    /**
     * Genral message display for errors
     *
     * @param activity
     */
    public static void showAlert(final Activity activity, String msg, final OnClickAlertViewListner onClickAlertViewListner) {

        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);

            // Setting Dialog Title
            //alertDialog.setTitle("");

            // Setting Dialog Message
            alertDialog.setMessage(msg);

            // On pressing Settings button
            alertDialog.setPositiveButton(activity.getString(R.string.login_validation_ok_action), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    onClickAlertViewListner.okClick();
                }
            });
            /*// on pressing cancel button
            alertDialog.setNegativeButton(activity.getString(R.string.login_validation_ok_action), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    onClickAlertViewListner.cancelClick();
                }
            });*/

            // Showing Alert Message
            alertDialog.show();

        }
    }

    public interface OnClickAlertViewOkCancelListner {
        void okClick();

        void cancelClick();
    }

    /**
     * Genral message display for errors
     *
     * @param activity
     */
    public static void showAlert(final Activity activity, String msg, final OnClickAlertViewOkCancelListner onClickAlertViewOkCancelListner) {

        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);

            // Setting Dialog Title
            //alertDialog.setTitle("");

            // Setting Dialog Message
            alertDialog.setMessage(msg);

            // On pressing Settings button
            alertDialog.setPositiveButton(activity.getString(R.string.login_validation_ok_action), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    onClickAlertViewOkCancelListner.okClick();
                }
            });

            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    onClickAlertViewOkCancelListner.cancelClick();
                }
            });

            alertDialog.setNegativeButton(activity.getString(R.string.login_cancel_action), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    onClickAlertViewOkCancelListner.cancelClick();
                }
            });
            /*// on pressing cancel button
            alertDialog.setNegativeButton(activity.getString(R.string.login_validation_ok_action), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    onClickAlertViewListner.cancelClick();
                }
            });*/

            // Showing Alert Message
            alertDialog.show();

        }
    }

    /**
     * Genral message display for errors
     *
     * @param activity
     */
    public static void showAlert(final Activity activity, String msg) {

        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);

            // Setting Dialog Title
            //alertDialog.setTitle("");

            // Setting Dialog Message
            alertDialog.setMessage(msg);

            // On pressing Settings button
            alertDialog.setPositiveButton(activity.getString(R.string.login_validation_ok_action), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            /*// on pressing cancel button
            alertDialog.setNegativeButton(activity.getString(R.string.login_validation_ok_action), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    onClickAlertViewListner.cancelClick();
                }
            });*/

            // Showing Alert Message
            alertDialog.show();

        }
    }

    public static String formateDateFromString(String inputFormat, String outputFormat, String dateBefore) {

        Date parsed = null;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, Locale.getDefault());

        try {
            parsed = df_input.parse(dateBefore);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
            showLog(INFO, "ParseException - dateFormat");
        }

        return outputDate;

    }

}
