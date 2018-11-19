package com.rock.reward.extras;

import android.os.Build;
import android.text.Html;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

/**
 * Created by rocku27 on 10/8/16.
 */
public class HtmlParser {
    public static String str;

    public static String getTextFromTag(String tag){
        Log.e("str parsing",tag);
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput( new StringReader( tag ) );
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if(eventType == XmlPullParser.TEXT) {
                    str = xpp.getText();
                }
            }
            Log.e("str parsing",str);
            return str;

        } catch (XmlPullParserException e) {
            Log.e("str parsing",e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static String stripHtml(String html) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html,Html.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH).toString();
        }else {
            return Html.fromHtml(html).toString();
        }
    }
}
