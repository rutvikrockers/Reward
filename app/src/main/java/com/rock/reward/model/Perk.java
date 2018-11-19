
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Perk {

    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("url_project_title")
    @Expose
    private String urlProjectTitle;
    @SerializedName("project_owner_id")
    @Expose
    private String projectOwnerId;
    @SerializedName("perk_id")
    @Expose
    private String perkId;
    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("perk_title")
    @Expose
    private String perkTitle;
    @SerializedName("perk_description")
    @Expose
    private String perkDescription;
    @SerializedName("perk_amount")
    @Expose
    private String perkAmount;
    @SerializedName("perk_total")
    @Expose
    private String perkTotal;
    @SerializedName("perk_get")
    @Expose
    private String perkGet;
    @SerializedName("estdate")
    @Expose
    private String estdate;
    @SerializedName("shipping_status")
    @Expose
    private String shippingStatus;

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
     *     The urlProjectTitle
     */
    public String getUrlProjectTitle() {
        return urlProjectTitle;
    }

    /**
     * 
     * @param urlProjectTitle
     *     The url_project_title
     */
    public void setUrlProjectTitle(String urlProjectTitle) {
        this.urlProjectTitle = urlProjectTitle;
    }

    /**
     * 
     * @return
     *     The projectOwnerId
     */
    public String getProjectOwnerId() {
        return projectOwnerId;
    }

    /**
     * 
     * @param projectOwnerId
     *     The project_owner_id
     */
    public void setProjectOwnerId(String projectOwnerId) {
        this.projectOwnerId = projectOwnerId;
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
     *     The perkDescription
     */
    public String getPerkDescription() {
        return perkDescription;
    }

    /**
     * 
     * @param perkDescription
     *     The perk_description
     */
    public void setPerkDescription(String perkDescription) {
        this.perkDescription = perkDescription;
    }

    /**
     * 
     * @return
     *     The perkAmount
     */
    public String getPerkAmount() {
        return perkAmount;
    }

    /**
     * 
     * @param perkAmount
     *     The perk_amount
     */
    public void setPerkAmount(String perkAmount) {
        this.perkAmount = perkAmount;
    }

    /**
     * 
     * @return
     *     The perkTotal
     */
    public String getPerkTotal() {
        return perkTotal;
    }

    /**
     * 
     * @param perkTotal
     *     The perk_total
     */
    public void setPerkTotal(String perkTotal) {
        this.perkTotal = perkTotal;
    }

    /**
     * 
     * @return
     *     The perkGet
     */
    public String getPerkGet() {
        return perkGet;
    }

    /**
     * 
     * @param perkGet
     *     The perk_get
     */
    public void setPerkGet(String perkGet) {
        this.perkGet = perkGet;
    }

    /**
     * 
     * @return
     *     The estdate
     */
    public String getEstdate() {
        return estdate;
    }

    /**
     * 
     * @param estdate
     *     The estdate
     */
    public void setEstdate(String estdate) {
        this.estdate = estdate;
    }

    /**
     * 
     * @return
     *     The shippingStatus
     */
    public String getShippingStatus() {
        return shippingStatus;
    }

    /**
     * 
     * @param shippingStatus
     *     The shipping_status
     */
    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

}
