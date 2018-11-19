package com.rock.reward.volleyWebservice;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class CustomRequest extends Request<JSONObject>
{

	private final Listener<JSONObject> listener;
	private final Map<String, String> params;
	private final Map<String, String> headers;


	public CustomRequest(Context context, int method, String url,final RequestParam rp, Listener<JSONObject> reponseListener,
						 ErrorListener errorListener)
	{
		super(method, url, errorListener);
		this.listener = reponseListener;
		this.params = rp.getParam();
		this.headers = rp.getHeaderRequestParam();

	}

	@Override
	protected Map<String, String> getParams() throws AuthFailureError
	{
		return params;
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return headers;
	}

	@Override
	protected void deliverResponse(JSONObject response)
	{
		listener.onResponse(response);
	}

	@Override
	protected Response<JSONObject> parseNetworkResponse(NetworkResponse response)
	{
		try
		{
			String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
			return Response.success(new JSONObject(jsonString), HttpHeaderParser.parseCacheHeaders(response));
		}
		catch (UnsupportedEncodingException e)
		{
			return Response.error(new ParseError(e));
		}
		catch (JSONException je)
		{
			return Response.error(new ParseError(je));
		}
	}
}
