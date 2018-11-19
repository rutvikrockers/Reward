
package com.rock.reward.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyDonations {

    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("transaction_date_time")
    @Expose
    private String transactionDateTime;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("pay_fee")
    @Expose
    private String payFee;
    @SerializedName("project_status")
    @Expose
    private String projectStatus;
    @SerializedName("project_donation")
    @Expose
    private List<ProjectDonation> projectDonation = new ArrayList<ProjectDonation>();

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

    /**
     * 
     * @return
     *     The payFee
     */
    public String getPayFee() {
        return payFee;
    }

    /**
     * 
     * @param payFee
     *     The pay_fee
     */
    public void setPayFee(String payFee) {
        this.payFee = payFee;
    }

    /**
     * 
     * @return
     *     The projectStatus
     */
    public String getProjectStatus() {
        return projectStatus;
    }

    /**
     * 
     * @param projectStatus
     *     The project_status
     */
    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    /**
     * 
     * @return
     *     The projectDonation
     */
    public List<ProjectDonation> getProjectDonation() {
        return projectDonation;
    }

    /**
     * 
     * @param projectDonation
     *     The project_donation
     */
    public void setProjectDonation(List<ProjectDonation> projectDonation) {
        this.projectDonation = projectDonation;
    }

}
