package com.rock.reward.volleyWebservice;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class RequestParam {


	//Parent json object
	private JSONObject objparent = new JSONObject();

	//Child json object
	private JSONObject objchild = new JSONObject();

	//HashMap for the Header Request call
	private Map<String, String> map  = new HashMap<>();

	//HashMap for the parameters
	private Map<String, String> paramMap  = new HashMap<>();
	  
	public RequestParam()
	{
		objparent = new JSONObject();
		objchild = new JSONObject();
		map  = new HashMap<>();
		paramMap  = new HashMap<>();
	}
	public void addParent(String key)
	{
		try {
			objparent.accumulate(key, objchild);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addParent(String key,String value)
	{
		try {
			objparent.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void addChild(String key,JSONObject value)
	{
		try {
			objchild.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addChild(String key,String value)
	{
		try {
			objchild.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addChild(String key,int value)
	{
		try {
			objchild.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addChild(String key,Object value)
	{
		try {
			objchild.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addChild(String key,boolean value)
	{
		try {
			objchild.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addChild(String key,double value)
	{
		try {
			objchild.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addChild(String key,float value)
	{
		try {
			objchild.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addChild(String key,long value)
	{
		try {
			objchild.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public String getChildString()
	{
		return objchild.toString();
	}


	public String getParentString()
	{
		return objparent.toString();
	}

	public JSONObject getChild()
	{
		return objchild;
	}
	
	public boolean removeChildObject(String paramName)
	{
		try {
			 objchild.remove(paramName);
			 return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public void putHeader(String key, String value){
		map.put(key, value);
	}

	public Map<String, String> getHeaderRequestParam(){
		return map;
	}

	public void putParams(String key, String value){
		paramMap.put(key, value);
	}

	public Map<String, String> getParam(){
		return paramMap;
	}
	
   
}
