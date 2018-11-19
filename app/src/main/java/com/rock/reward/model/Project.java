
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("is_followed")
    @Expose
    private Boolean isFollowed;
    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("project_user_id")
    @Expose
    private String projectUserId;
    @SerializedName("project_first_name")
    @Expose
    private String projectFirstName;
    @SerializedName("project_last_name")
    @Expose
    private String projectLastName;
    @SerializedName("project_image_url")
    @Expose
    private String projectImageUrl;
    @SerializedName("project_summary")
    @Expose
    private String projectSummary;
    @SerializedName("project_currency_code")
    @Expose
    private String projectCurrencyCode;
    @SerializedName("project_currency_symbol")
    @Expose
    private String projectCurrencySymbol;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("amount_get")
    @Expose
    private Object amountGet;
    @SerializedName("amount_with_currency")
    @Expose
    private String amountWithCurrency;
    @SerializedName("amount_get_with_currency")
    @Expose
    private String amountGetWithCurrency;
    @SerializedName("funding_type")
    @Expose
    private String fundingType;
    @SerializedName("percentage")
    @Expose
    private Double percentage;
    @SerializedName("project_category_name")
    @Expose
    private String projectCategoryName;
    @SerializedName("project_category_id")
    @Expose
    private String projectCategoryId;
    @SerializedName("category_icon_url")
    @Expose
    private String categoryIconUrl;
    @SerializedName("project_status")
    @Expose
    private String projectStatus;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("project_country")
    @Expose
    private String projectCountry;
    @SerializedName("project_city")
    @Expose
    private String projectCity;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("is_contribute")
    @Expose
    private Boolean isContribute;
    @SerializedName("status_color")
    @Expose
    private String statusColor;


    /**
     * 
     * @return
     *     The isFollowed
     */
    public Boolean getIsFollowed() {
        return isFollowed;
    }

    /**
     * 
     * @param isFollowed
     *     The is_followed
     */
    public void setIsFollowed(Boolean isFollowed) {
        this.isFollowed = isFollowed;
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
     *     The projectUserId
     */
    public String getProjectUserId() {
        return projectUserId;
    }

    /**
     * 
     * @param projectUserId
     *     The project_user_id
     */
    public void setProjectUserId(String projectUserId) {
        this.projectUserId = projectUserId;
    }

    /**
     * 
     * @return
     *     The projectFirstName
     */
    public String getProjectFirstName() {
        return projectFirstName;
    }

    /**
     * 
     * @param projectFirstName
     *     The project_first_name
     */
    public void setProjectFirstName(String projectFirstName) {
        this.projectFirstName = projectFirstName;
    }

    /**
     * 
     * @return
     *     The projectLastName
     */
    public String getProjectLastName() {
        return projectLastName;
    }

    /**
     * 
     * @param projectLastName
     *     The project_last_name
     */
    public void setProjectLastName(String projectLastName) {
        this.projectLastName = projectLastName;
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
     *     The projectSummary
     */
    public String getProjectSummary() {
        return projectSummary;
    }

    /**
     * 
     * @param projectSummary
     *     The project_summary
     */
    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary;
    }

    /**
     * 
     * @return
     *     The projectCurrencyCode
     */
    public String getProjectCurrencyCode() {
        return projectCurrencyCode;
    }

    /**
     * 
     * @param projectCurrencyCode
     *     The project_currency_code
     */
    public void setProjectCurrencyCode(String projectCurrencyCode) {
        this.projectCurrencyCode = projectCurrencyCode;
    }

    /**
     * 
     * @return
     *     The projectCurrencySymbol
     */
    public String getProjectCurrencySymbol() {
        return projectCurrencySymbol;
    }

    /**
     * 
     * @param projectCurrencySymbol
     *     The project_currency_symbol
     */
    public void setProjectCurrencySymbol(String projectCurrencySymbol) {
        this.projectCurrencySymbol = projectCurrencySymbol;
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
     *     The amountGet
     */
    public Object getAmountGet() {
        return amountGet;
    }

    /**
     * 
     * @param amountGet
     *     The amount_get
     */
    public void setAmountGet(Object amountGet) {
        this.amountGet = amountGet;
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
     *     The amountGetWithCurrency
     */
    public String getAmountGetWithCurrency() {
        return amountGetWithCurrency;
    }

    /**
     * 
     * @param amountGetWithCurrency
     *     The amount_get_with_currency
     */
    public void setAmountGetWithCurrency(String amountGetWithCurrency) {
        this.amountGetWithCurrency = amountGetWithCurrency;
    }

    /**
     * 
     * @return
     *     The fundingType
     */
    public String getFundingType() {
        return fundingType;
    }

    /**
     * 
     * @param fundingType
     *     The funding_type
     */
    public void setFundingType(String fundingType) {
        this.fundingType = fundingType;
    }

    /**
     * 
     * @return
     *     The percentage
     */
    public Double getPercentage() {
        return percentage;
    }

    /**
     * 
     * @param percentage
     *     The percentage
     */
    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    /**
     * 
     * @return
     *     The projectCategoryName
     */
    public String getProjectCategoryName() {
        return projectCategoryName;
    }

    /**
     * 
     * @param projectCategoryName
     *     The project_category_name
     */
    public void setProjectCategoryName(String projectCategoryName) {
        this.projectCategoryName = projectCategoryName;
    }

    /**
     * 
     * @return
     *     The projectCategoryId
     */
    public String getProjectCategoryId() {
        return projectCategoryId;
    }

    /**
     * 
     * @param projectCategoryId
     *     The project_category_id
     */
    public void setProjectCategoryId(String projectCategoryId) {
        this.projectCategoryId = projectCategoryId;
    }

    /**
     * 
     * @return
     *     The categoryIconUrl
     */
    public String getCategoryIconUrl() {
        return categoryIconUrl;
    }

    /**
     * 
     * @param categoryIconUrl
     *     The category_icon_url
     */
    public void setCategoryIconUrl(String categoryIconUrl) {
        this.categoryIconUrl = categoryIconUrl;
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
     *     The projectCountry
     */
    public String getProjectCountry() {
        return projectCountry;
    }

    /**
     * 
     * @param projectCountry
     *     The project_country
     */
    public void setProjectCountry(String projectCountry) {
        this.projectCountry = projectCountry;
    }

    /**
     * 
     * @return
     *     The projectCity
     */
    public String getProjectCity() {
        return projectCity;
    }

    /**
     * 
     * @param projectCity
     *     The project_city
     */
    public void setProjectCity(String projectCity) {
        this.projectCity = projectCity;
    }

    /**
     * 
     * @return
     *     The endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 
     * @param endDate
     *     The end_date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 
     * @return
     *     The isContribute
     */
    public Boolean getIsContribute() {
        return isContribute;
    }

    /**
     * 
     * @param isContribute
     *     The is_contribute
     */
    public void setIsContribute(Boolean isContribute) {
        this.isContribute = isContribute;
    }

    /**
     *
     * @param statusColor
     *     The status_color
     */
    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    /**
     *
     * @return
     *     The statusColor
     */
    public String getStatusColor() {
        return statusColor;
    }

}
