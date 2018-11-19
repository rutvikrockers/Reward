package com.rock.reward.volleyWebservice;

import com.google.gson.annotations.SerializedName;


// TODO: Auto-generated Javadoc

/**
 * The Class WebserviceResponse.
 */
public class WebserviceResponse  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The success. */
	private int ErrorCode;

	/** The error message. */
	@SerializedName("HasError")
	private boolean HasError;

	/** The error code. */
	@SerializedName("ResponseMessage")
	private String ResponseMessage ="";

	
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return ErrorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}

	/**
	 * @return the hasError
	 */
	public boolean getHasError() {
		return HasError;
	}

	/**
	 * @param hasError the hasError to set
	 */
	public void setHasError(boolean hasError) {
		HasError = hasError;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return ResponseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		ResponseMessage = responseMessage;
	}
 
 
	
 
}