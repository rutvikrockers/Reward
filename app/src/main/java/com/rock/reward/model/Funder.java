
package com.rock.reward.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Funder implements Parcelable {

    @SerializedName("wallet_payment_status")
    @Expose
    private String walletPaymentStatus;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("preapproval_status")
    @Expose
    private String preapprovalStatus;
    @SerializedName("donor_id")
    @Expose
    private String donorId;
    @SerializedName("transaction_date_time")
    @Expose
    private String transactionDateTime;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("pay_fee")
    @Expose
    private String payFee;
    @SerializedName("preapproval_total_amount")
    @Expose
    private String preapprovalTotalAmount;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("trans_anonymous")
    @Expose
    private String transAnonymous;
    @SerializedName("shipping")
    @Expose
    private String shipping;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("perk_delivered")
    @Expose
    private String perkDelivered;
    @SerializedName("perk_id")
    @Expose
    private String perkId;
    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("profile_slug")
    @Expose
    private Object profileSlug;
    @SerializedName("user_image")
    @Expose
    private String userImage;
    @SerializedName("amount_with_currency")
    @Expose
    private String amountWithCurrency;
    @SerializedName("funder_name")
    @Expose
    private String funderName;
    @SerializedName("allowviewprofile")
    @Expose
    private Boolean allowviewprofile;

    protected Funder(Parcel in) {
        walletPaymentStatus = in.readString();
        name = in.readString();
        preapprovalStatus = in.readString();
        donorId = in.readString();
        transactionDateTime = in.readString();
        email = in.readString();
        payFee = in.readString();
        preapprovalTotalAmount = in.readString();
        amount = in.readString();
        comment = in.readString();
        transAnonymous = in.readString();
        shipping = in.readString();
        transactionId = in.readString();
        perkDelivered = in.readString();
        perkId = in.readString();
        projectId = in.readString();
        userId = in.readString();
        userName = in.readString();
        lastName = in.readString();
        address = in.readString();
        userImage = in.readString();
        amountWithCurrency = in.readString();
        funderName = in.readString();
    }

    public static final Creator<Funder> CREATOR = new Creator<Funder>() {
        @Override
        public Funder createFromParcel(Parcel in) {
            return new Funder(in);
        }

        @Override
        public Funder[] newArray(int size) {
            return new Funder[size];
        }
    };

    /**
     * 
     * @return
     *     The walletPaymentStatus
     */
    public String getWalletPaymentStatus() {
        return walletPaymentStatus;
    }

    /**
     * 
     * @param walletPaymentStatus
     *     The wallet_payment_status
     */
    public void setWalletPaymentStatus(String walletPaymentStatus) {
        this.walletPaymentStatus = walletPaymentStatus;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * 
     * @return
     *     The donorId
     */
    public String getDonorId() {
        return donorId;
    }

    /**
     * 
     * @param donorId
     *     The donor_id
     */
    public void setDonorId(String donorId) {
        this.donorId = donorId;
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
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
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
     *     The preapprovalTotalAmount
     */
    public String getPreapprovalTotalAmount() {
        return preapprovalTotalAmount;
    }

    /**
     * 
     * @param preapprovalTotalAmount
     *     The preapproval_total_amount
     */
    public void setPreapprovalTotalAmount(String preapprovalTotalAmount) {
        this.preapprovalTotalAmount = preapprovalTotalAmount;
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
     *     The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @param comment
     *     The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 
     * @return
     *     The transAnonymous
     */
    public String getTransAnonymous() {
        return transAnonymous;
    }

    /**
     * 
     * @param transAnonymous
     *     The trans_anonymous
     */
    public void setTransAnonymous(String transAnonymous) {
        this.transAnonymous = transAnonymous;
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
     *     The transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 
     * @param transactionId
     *     The transaction_id
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 
     * @return
     *     The perkDelivered
     */
    public String getPerkDelivered() {
        return perkDelivered;
    }

    /**
     * 
     * @param perkDelivered
     *     The perk_delivered
     */
    public void setPerkDelivered(String perkDelivered) {
        this.perkDelivered = perkDelivered;
    }

    /**
     * 
     * @return
     *     The perkId
     */
    public String getPerkId() {
        return perkId;
    }

    /**
     * 
     * @param perkId
     *     The perk_id
     */
    public void setPerkId(String perkId) {
        this.perkId = perkId;
    }

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
     *     The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName
     *     The user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The image
     */
    public Object getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(Object image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The profileSlug
     */
    public Object getProfileSlug() {
        return profileSlug;
    }

    /**
     * 
     * @param profileSlug
     *     The profile_slug
     */
    public void setProfileSlug(Object profileSlug) {
        this.profileSlug = profileSlug;
    }

    /**
     * 
     * @return
     *     The userImage
     */
    public String getUserImage() {
        return userImage;
    }

    /**
     * 
     * @param userImage
     *     The user_image
     */
    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    /**
     * 
     * @return
     *     The amountWithCurrency
     */
    public String getAmountWithCurrency() {
        return amountWithCurrency;
    }

    /**
     * 
     * @param amountWithCurrency
     *     The amount_with_currency
     */
    public void setAmountWithCurrency(String amountWithCurrency) {
        this.amountWithCurrency = amountWithCurrency;
    }

    /**
     * 
     * @return
     *     The funderName
     */
    public String getFunderName() {
        return funderName;
    }

    /**
     * 
     * @param funderName
     *     The funder_name
     */
    public void setFunderName(String funderName) {
        this.funderName = funderName;
    }

    /**
     * 
     * @return
     *     The allowviewprofile
     */
    public Boolean getAllowviewprofile() {
        return allowviewprofile;
    }

    /**
     * 
     * @param allowviewprofile
     *     The allowviewprofile
     */
    public void setAllowviewprofile(Boolean allowviewprofile) {
        this.allowviewprofile = allowviewprofile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(walletPaymentStatus);
        parcel.writeString(name);
        parcel.writeString(preapprovalStatus);
        parcel.writeString(donorId);
        parcel.writeString(transactionDateTime);
        parcel.writeString(email);
        parcel.writeString(payFee);
        parcel.writeString(preapprovalTotalAmount);
        parcel.writeString(amount);
        parcel.writeString(comment);
        parcel.writeString(transAnonymous);
        parcel.writeString(shipping);
        parcel.writeString(transactionId);
        parcel.writeString(perkDelivered);
        parcel.writeString(perkId);
        parcel.writeString(projectId);
        parcel.writeString(userId);
        parcel.writeString(userName);
        parcel.writeString(lastName);
        parcel.writeString(address);
        parcel.writeString(userImage);
        parcel.writeString(amountWithCurrency);
        parcel.writeString(funderName);
    }
}
