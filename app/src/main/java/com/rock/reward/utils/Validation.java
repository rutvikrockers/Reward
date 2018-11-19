package com.rock.reward.utils;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation 
{
	
	/** Check validation for the mobile number */
	public static String mobileExpression ="^[+]?[0-9]{2,15}$";
	

	/** Check validation for the email address */
	public static boolean isValidEmailAddress(String emailAddress)
	{
		Log.e("emailAddress",emailAddress);
		String expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	    CharSequence inputStr;
		inputStr = emailAddress;
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(inputStr);
	    return matcher.matches();  
	 }

	public static String isValidPassword(String password){
		if(password == null || password.isEmpty()){
			return "Please enter password.";
		}else if(password.length()<8){
			return "Password should be at least 8 characters.";
		}else{
			return null;
		}

	}

	public static String isValidFullName(String password){
		Log.e("full name",password);

		if(password == null || password.isEmpty()) {
			return "Please enter full name.";
		}
		if(password.isEmpty()) {
			return "Please enter full name..";
		}else{
			return null;
		}
	}

	/** Check validation for the mobile number */
	public static boolean isValidPhoneNumber(String contactDetail)
	{
		//validate mobile number
		if(contactDetail.replace(" ","").matches(Validation.mobileExpression)){
			return true;
		}else{
			return false;
		}
	}

	/** Check validation for the Domain name */
	public static boolean isValidWebSite(String contactDetail)
	{
		if(android.util.Patterns.WEB_URL.matcher(contactDetail).matches() || android.util.Patterns.DOMAIN_NAME.matcher(contactDetail).matches()){
			return true;
		}else{
			return false;
		}



	}




}