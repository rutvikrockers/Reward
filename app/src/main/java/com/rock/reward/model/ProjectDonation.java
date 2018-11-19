
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectDonation {

    @SerializedName("payment_status_color")
    @Expose
    private String paymentStatusColor;
    @SerializedName("transaction_date_time")
    @Expose
    private String transactionDateTime;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("donor_email")
    @Expose
    private String donorEmail;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("pay_fee")
    @Expose
    private String payFee;
    @SerializedName("perk_title")
    @Expose
    private String perkTitle;
    @SerializedName("shipping")
    @Expose
    private String shipping;
    @SerializedName("preapproval_pay_key")
    @Expose
    private String preapprovalPayKey;
    @SerializedName("preapproval_status")
    @Expose
    private String preapprovalStatus;

    /**
     * 
     * @return
     *     The paymentStatusColor
     */
    public String getPaymentStatusColor() {
        return paymentStatusColor;
    }

    /**
     * 
     * @param paymentStatusColor
     *     The payment_status_color
     */
    public void setPaymentStatusColor(String paymentStatusColor) {
        this.paymentStatusColor = paymentStatusColor;
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
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The donorEmail
     */
    public String getDonorEmail() {
        return donorEmail;
    }

    /**
     * 
     * @param donorEmail
     *     The donor_email
     */
    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
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
     *     The perkTitle
     */
    public String getPerkTitle() {
        return perkTitle;
    }

    /**
     * 
     * @param perkTitle
     *     The perk_title
     */
    public void setPerkTitle(String perkTitle) {
        this.perkTitle = perkTitle;
    }

    /**
     * 
     * @return
     *     The shipping
     */
    public String getShipping() {
        return shipping;
    }

    /**
     * 
     * @param shipping
     *     The shipping
     */
    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    /**
     * 
     * @return
     *     The preapprovalPayKey
     */
    public String getPreapprovalPayKey() {
        return preapprovalPayKey;
    }

    /**
     * 
     * @param preapprovalPayKey
     *     The preapproval_pay_key
     */
    public void setPreapprovalPayKey(String preapprovalPayKey) {
        this.preapprovalPayKey = preapprovalPayKey;
    }

    /**
     * 
     * @return
     *     The preapprovalStatus
     */
    public String getPreapprovalStatus() {
        return preapprovalStatus;
    }

    /**
     * 
     * @param preapprovalStatus
     *     The preapproval_status
     */
    public void setPreapprovalStatus(String preapprovalStatus) {
        this.preapprovalStatus = preapprovalStatus;
    }

}
