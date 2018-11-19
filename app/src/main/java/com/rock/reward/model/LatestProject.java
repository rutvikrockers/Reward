
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LatestProject {

    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("url_project_title")
    @Expose
    private String urlProjectTitle;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("amount_get")
    @Expose
    private String amountGet;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("project_summary")
    @Expose
    private String projectSummary;
    @SerializedName("pimage")
    @Expose
    private String pimage;
    @SerializedName("pitch_media")
    @Expose
    private String pitchMedia;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("pitch_video")
    @Expose
    private String pitchVideo;
    @SerializedName("paypal_email")
    @Expose
    private String paypalEmail;
    @SerializedName("funding_type")
    @Expose
    private String fundingType;
    @SerializedName("project_currency_code")
    @Expose
    private String projectCurrencyCode;
    @SerializedName("project_currency_symbol")
    @Expose
    private String projectCurrencySymbol;
    @SerializedName("video_image")
    @Expose
    private Object videoImage;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("project_country")
    @Expose
    private String projectCountry;
    @SerializedName("project_city")
    @Expose
    private String projectCity;
    @SerializedName("project_timezone")
    @Expose
    private String projectTimezone;
    @SerializedName("percentage")
    @Expose
    private Double percentage;
    @SerializedName("project_category_name")
    @Expose
    private String projectCategoryName;
    @SerializedName("url_category_title")
    @Expose
    private String urlCategoryTitle;
    @SerializedName("icon_view")
    @Expose
    private Object iconView;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("user_website")
    @Expose
    private String userWebsite;
    @SerializedName("profile_slug")
    @Expose
    private String profileSlug;
    @SerializedName("project_image_url")
    @Expose
    private String projectImageUrl;
    @SerializedName("category_icon_url")
    @Expose
    private String categoryIconUrl;
    @SerializedName("amount_with_currency")
    @Expose
    private String amountWithCurrency;
    @SerializedName("amount_get_with_currency")
    @Expose
    private String amountGetWithCurrency;
    @SerializedName("is_followed")
    @Expose
    private boolean isFollowed;

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
     *     The dateAdded
     */
    public String getDateAdded() {
        return dateAdded;
    }

    /**
     * 
     * @param dateAdded
     *     The date_added
     */
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
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
     *     The amountGet
     */
    public String getAmountGet() {
        return amountGet;
    }

    /**
     * 
     * @param amountGet
     *     The amount_get
     */
    public void setAmountGet(String amountGet) {
        this.amountGet = amountGet;
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
     *     The pimage
     */
    public String getPimage() {
        return pimage;
    }

    /**
     * 
     * @param pimage
     *     The pimage
     */
    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    /**
     * 
     * @return
     *     The pitchMedia
     */
    public String getPitchMedia() {
        return pitchMedia;
    }

    /**
     * 
     * @param pitchMedia
     *     The pitch_media
     */
    public void setPitchMedia(String pitchMedia) {
        this.pitchMedia = pitchMedia;
    }

    /**
     * 
     * @return
     *     The video
     */
    public String getVideo() {
        return video;
    }

    /**
     * 
     * @param video
     *     The video
     */
    public void setVideo(String video) {
        this.video = video;
    }

    /**
     * 
     * @return
     *     The pitchVideo
     */
    public String getPitchVideo() {
        return pitchVideo;
    }

    /**
     * 
     * @param pitchVideo
     *     The pitch_video
     */
    public void setPitchVideo(String pitchVideo) {
        this.pitchVideo = pitchVideo;
    }

    /**
     * 
     * @return
     *     The paypalEmail
     */
    public String getPaypalEmail() {
        return paypalEmail;
    }

    /**
     * 
     * @param paypalEmail
     *     The paypal_email
     */
    public void setPaypalEmail(String paypalEmail) {
        this.paypalEmail = paypalEmail;
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
     *     The videoImage
     */
    public Object getVideoImage() {
        return videoImage;
    }

    /**
     * 
     * @param videoImage
     *     The video_image
     */
    public void setVideoImage(Object videoImage) {
        this.videoImage = videoImage;
    }

    /**
     * 
     * @return
     *     The active
     */
    public String getActive() {
        return active;
    }

    /**
     * 
     * @param active
     *     The active
     */
    public void setActive(String active) {
        this.active = active;
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
     *     The projectTimezone
     */
    public String getProjectTimezone() {
        return projectTimezone;
    }

    /**
     * 
     * @param projectTimezone
     *     The project_timezone
     */
    public void setProjectTimezone(String projectTimezone) {
        this.projectTimezone = projectTimezone;
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
     *     The urlCategoryTitle
     */
    public String getUrlCategoryTitle() {
        return urlCategoryTitle;
    }

    /**
     * 
     * @param urlCategoryTitle
     *     The url_category_title
     */
    public void setUrlCategoryTitle(String urlCategoryTitle) {
        this.urlCategoryTitle = urlCategoryTitle;
    }

    /**
     * 
     * @return
     *     The iconView
     */
    public Object getIconView() {
        return iconView;
    }

    /**
     * 
     * @param iconView
     *     The icon_view
     */
    public void setIconView(Object iconView) {
        this.iconView = iconView;
    }

    /**
     * 
     * @return
     *     The countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * 
     * @param countryName
     *     The country_name
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
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
     *     The userWebsite
     */
    public String getUserWebsite() {
        return userWebsite;
    }

    /**
     * 
     * @param userWebsite
     *     The user_website
     */
    public void setUserWebsite(String userWebsite) {
        this.userWebsite = userWebsite;
    }

    /**
     * 
     * @return
     *     The profileSlug
     */
    public String getProfileSlug() {
        return profileSlug;
    }

    /**
     * 
     * @param profileSlug
     *     The profile_slug
     */
    public void setProfileSlug(String profileSlug) {
        this.profileSlug = profileSlug;
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
     *     The isFollowed
     */
    public boolean getIsFollowed() {
        return isFollowed;
    }

    /**
     *
     * @param isFollowed
     *     The is_followed
     */
    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
    }

}
