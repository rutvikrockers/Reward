
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Donation {

    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("project_image_url")
    @Expose
    private String projectImageUrl;
    @SerializedName("transaction_date_time")
    @Expose
    private String transactionDateTime;
    @SerializedName("amount")
    @Expose
    private String amount;

    /**
     * 
     * @return
     *     The projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 
     * @param projectId
     *     The project_id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * 
     * @return
     *     The projectTitle
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     * 
     * @param projectTitle
     *     The project_title
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     * 
     * @return
     *     The projectImageUrl
     */
    public String getProjectImageUrl() {
        return projectImageUrl;
    }

    /**
     * 
     * @param projectImageUrl
     *     The project_image_url
     */
    public void setProjectImageUrl(String projectImageUrl) {
        this.projectImageUrl = projectImageUrl;
    }

    /**
     * 
     * @return
     *     The transactionDateTime
     */
    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    /**
     * 
     * @param transactionDateTime
     *     The transaction_date_time
     */
    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    /**
     * 
     * @return
     *     The amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount
     *     The amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

}
