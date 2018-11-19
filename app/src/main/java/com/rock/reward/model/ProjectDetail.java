
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectDetail {

    @SerializedName("deadline")
    @Expose
    private String deadline;
    @SerializedName("total_days")
    @Expose
    private String totalDays;
    @SerializedName("wepay_access_token")
    @Expose
    private String wepayAccessToken;
    @SerializedName("wepay_account_id")
    @Expose
    private String wepayAccountId;
    @SerializedName("commission")
    @Expose
    private String commission;
    @SerializedName("cflag")
    @Expose
    private String cflag;
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
    @SerializedName("pitch_text")
    @Expose
    private String pitchText;
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
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("pitch_image")
    @Expose
    private String pitchImage;
    @SerializedName("paypal_first_name")
    @Expose
    private String paypalFirstName;
    @SerializedName("paypal_last_name")
    @Expose
    private String paypalLastName;
    @SerializedName("project_city")
    @Expose
    private String projectCity;
    @SerializedName("project_country")
    @Expose
    private String projectCountry;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("user_role")
    @Expose
    private String userRole;
    @SerializedName("p_google_code")
    @Expose
    private String pGoogleCode;
    @SerializedName("recipient_id")
    @Expose
    private String recipientId;
    @SerializedName("reason_inactive_hidden")
    @Expose
    private String reasonInactiveHidden;
    @SerializedName("project_timezone")
    @Expose
    private String projectTimezone;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("project_category_name")
    @Expose
    private String projectCategoryName;
    @SerializedName("url_category_title")
    @Expose
    private String urlCategoryTitle;
    @SerializedName("project_category_active")
    @Expose
    private String projectCategoryActive;
    @SerializedName("icon_view")
    @Expose
    private Object iconView;
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
    @SerializedName("fb_uid")
    @Expose
    private Object fbUid;
    @SerializedName("facebook_wall_post")
    @Expose
    private String facebookWallPost;
    @SerializedName("fb_access_token")
    @Expose
    private Object fbAccessToken;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("user_website")
    @Expose
    private String userWebsite;
    @SerializedName("profile_slug")
    @Expose
    private String profileSlug;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @SerializedName("project_image_url")
    @Expose
    private String projectImageUrl;
    @SerializedName("pitch_image_url")
    @Expose
    private String pitchImageUrl;
    @SerializedName("percentage")
    @Expose
    private Double percentage;
    @SerializedName("amount_with_currency")
    @Expose
    private String amountWithCurrency;
    @SerializedName("amount_get_with_currency")
    @Expose
    private String amountGetWithCurrency;
    @SerializedName("video_type")
    @Expose
    private String videoType;
    @SerializedName("is_contribute")
    @Expose
    private String isContribute;
    @SerializedName("funding_type_text")
    @Expose
    private String fundingTypeText;
    @SerializedName("is_followed")
    @Expose
    private boolean isFollowed;
    @SerializedName("project_status")
    @Expose
    private String projectStatus;
    @SerializedName("status_color")
    @Expose
    private String statusColor;
    @SerializedName("contribute_text")
    @Expose
    private String contributeText;



    /**
     * 
     * @return
     *     The deadline
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * 
     * @param deadline
     *     The deadline
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * 
     * @return
     *     The totalDays
     */
    public String getTotalDays() {
        return totalDays;
    }

    /**
     * 
     * @param totalDays
     *     The total_days
     */
    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    /**
     * 
     * @return
     *     The wepayAccessToken
     */
    public String getWepayAccessToken() {
        return wepayAccessToken;
    }

    /**
     * 
     * @param wepayAccessToken
     *     The wepay_access_token
     */
    public void setWepayAccessToken(String wepayAccessToken) {
        this.wepayAccessToken = wepayAccessToken;
    }

    /**
     * 
     * @return
     *     The wepayAccountId
     */
    public String getWepayAccountId() {
        return wepayAccountId;
    }

    /**
     * 
     * @param wepayAccountId
     *     The wepay_account_id
     */
    public void setWepayAccountId(String wepayAccountId) {
        this.wepayAccountId = wepayAccountId;
    }

    /**
     * 
     * @return
     *     The commission
     */
    public String getCommission() {
        return commission;
    }

    /**
     * 
     * @param commission
     *     The commission
     */
    public void setCommission(String commission) {
        this.commission = commission;
    }

    /**
     * 
     * @return
     *     The cflag
     */
    public String getCflag() {
        return cflag;
    }

    /**
     * 
     * @param cflag
     *     The cflag
     */
    public void setCflag(String cflag) {
        this.cflag = cflag;
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
     *     The pitchText
     */
    public String getPitchText() {
        return pitchText;
    }

    /**
     * 
     * @param pitchText
     *     The pitch_text
     */
    public void setPitchText(String pitchText) {
        this.pitchText = pitchText;
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
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The pitchImage
     */
    public String getPitchImage() {
        return pitchImage;
    }

    /**
     * 
     * @param pitchImage
     *     The pitch_image
     */
    public void setPitchImage(String pitchImage) {
        this.pitchImage = pitchImage;
    }

    /**
     * 
     * @return
     *     The paypalFirstName
     */
    public String getPaypalFirstName() {
        return paypalFirstName;
    }

    /**
     * 
     * @param paypalFirstName
     *     The paypal_first_name
     */
    public void setPaypalFirstName(String paypalFirstName) {
        this.paypalFirstName = paypalFirstName;
    }

    /**
     * 
     * @return
     *     The paypalLastName
     */
    public String getPaypalLastName() {
        return paypalLastName;
    }

    /**
     * 
     * @param paypalLastName
     *     The paypal_last_name
     */
    public void setPaypalLastName(String paypalLastName) {
        this.paypalLastName = paypalLastName;
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
     *     The categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId
     *     The category_id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * @return
     *     The userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 
     * @param userRole
     *     The user_role
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * 
     * @return
     *     The pGoogleCode
     */
    public String getPGoogleCode() {
        return pGoogleCode;
    }

    /**
     * 
     * @param pGoogleCode
     *     The p_google_code
     */
    public void setPGoogleCode(String pGoogleCode) {
        this.pGoogleCode = pGoogleCode;
    }

    /**
     * 
     * @return
     *     The recipientId
     */
    public String getRecipientId() {
        return recipientId;
    }

    /**
     * 
     * @param recipientId
     *     The recipient_id
     */
    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    /**
     * 
     * @return
     *     The reasonInactiveHidden
     */
    public String getReasonInactiveHidden() {
        return reasonInactiveHidden;
    }

    /**
     * 
     * @param reasonInactiveHidden
     *     The reason_inactive_hidden
     */
    public void setReasonInactiveHidden(String reasonInactiveHidden) {
        this.reasonInactiveHidden = reasonInactiveHidden;
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
     *     The color
     */
    public String getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    public void setColor(String color) {
        this.color = color;
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
     *     The projectCategoryActive
     */
    public String getProjectCategoryActive() {
        return projectCategoryActive;
    }

    /**
     * 
     * @param projectCategoryActive
     *     The project_category_active
     */
    public void setProjectCategoryActive(String projectCategoryActive) {
        this.projectCategoryActive = projectCategoryActive;
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
     *     The fbUid
     */
    public Object getFbUid() {
        return fbUid;
    }

    /**
     * 
     * @param fbUid
     *     The fb_uid
     */
    public void setFbUid(Object fbUid) {
        this.fbUid = fbUid;
    }

    /**
     * 
     * @return
     *     The facebookWallPost
     */
    public String getFacebookWallPost() {
        return facebookWallPost;
    }

    /**
     * 
     * @param facebookWallPost
     *     The facebook_wall_post
     */
    public void setFacebookWallPost(String facebookWallPost) {
        this.facebookWallPost = facebookWallPost;
    }

    /**
     * 
     * @return
     *     The fbAccessToken
     */
    public Object getFbAccessToken() {
        return fbAccessToken;
    }

    /**
     * 
     * @param fbAccessToken
     *     The fb_access_token
     */
    public void setFbAccessToken(Object fbAccessToken) {
        this.fbAccessToken = fbAccessToken;
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
     *     The pitchImageUrl
     */
    public String getPitchImageUrl() {
        return pitchImageUrl;
    }

    /**
     * 
     * @param pitchImageUrl
     *     The pitch_image_url
     */
    public void setPitchImageUrl(String pitchImageUrl) {
        this.pitchImageUrl = pitchImageUrl;
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
     *     The videoType
     */
    public String getVideoType() {
        return videoType;
    }

    /**
     * 
     * @param videoType
     *     The video_type
     */
    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    /**
     * 
     * @return
     *     The isContribute
     */
    public String getIsContribute() {
        return isContribute;
    }

    /**
     * 
     * @param isContribute
     *     The is_contribute
     */
    public void setIsContribute(String isContribute) {
        this.isContribute = isContribute;
    }

    /**
     * 
     * @return
     *     The fundingTypeText
     */
    public String getFundingTypeText() {
        return fundingTypeText;
    }

    /**
     * 
     * @param fundingTypeText
     *     The funding_type_text
     */
    public void setFundingTypeText(String fundingTypeText) {
        this.fundingTypeText = fundingTypeText;
    }

    /**
     *
     * @return
     *     The fundingTypeText
     */
    public boolean getIsFollowed() {
        return isFollowed;
    }

    /**
     *
     * @param isFollowed
     *     The funding_type_text
     */
    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
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
     *     The projectStatus
     */
    public String getProjectStatus() {
        return projectStatus;
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

    /**
     *
     * @param contributeText
     *     The contribute_text
     */
    public void setContributeText(String contributeText) {
        this.contributeText = contributeText;
    }

    /**
     *
     * @return
     *     The statusColor
     */
    public String getContributeText() {
        return contributeText;
    }

}
