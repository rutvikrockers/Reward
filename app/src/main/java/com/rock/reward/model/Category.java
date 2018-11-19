
package com.rock.reward.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category implements Parcelable {

    @SerializedName("project_category_id")
    @Expose
    private String projectCategoryId;
    @SerializedName("language_id")
    @Expose
    private String languageId;
    @SerializedName("url_category_title")
    @Expose
    private String urlCategoryTitle;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("parent_project_category_id")
    @Expose
    private String parentProjectCategoryId;
    @SerializedName("project_category_name")
    @Expose
    private String projectCategoryName;
    @SerializedName("project_category_desc")
    @Expose
    private String projectCategoryDesc;
    @SerializedName("icon_view")
    @Expose
    private Object iconView;
    @SerializedName("category_icon_url")
    @Expose
    private String categoryIconUrl;
    @SerializedName("category_image_url")
    @Expose
    private String categoryImageUrl;

    protected Category(Parcel in) {
        projectCategoryId = in.readString();
        languageId = in.readString();
        urlCategoryTitle = in.readString();
        image = in.readString();
        active = in.readString();
        parentProjectCategoryId = in.readString();
        projectCategoryName = in.readString();
        projectCategoryDesc = in.readString();
        categoryIconUrl = in.readString();
        categoryImageUrl = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

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
     *     The languageId
     */
    public String getLanguageId() {
        return languageId;
    }

    /**
     * 
     * @param languageId
     *     The language_id
     */
    public void setLanguageId(String languageId) {
        this.languageId = languageId;
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
     *     The parentProjectCategoryId
     */
    public String getParentProjectCategoryId() {
        return parentProjectCategoryId;
    }

    /**
     * 
     * @param parentProjectCategoryId
     *     The parent_project_category_id
     */
    public void setParentProjectCategoryId(String parentProjectCategoryId) {
        this.parentProjectCategoryId = parentProjectCategoryId;
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
     *     The projectCategoryDesc
     */
    public String getProjectCategoryDesc() {
        return projectCategoryDesc;
    }

    /**
     * 
     * @param projectCategoryDesc
     *     The project_category_desc
     */
    public void setProjectCategoryDesc(String projectCategoryDesc) {
        this.projectCategoryDesc = projectCategoryDesc;
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
     *     The categoryImageUrl
     */
    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    /**
     * 
     * @param categoryImageUrl
     *     The category_image_url
     */
    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(projectCategoryId);
        parcel.writeString(languageId);
        parcel.writeString(urlCategoryTitle);
        parcel.writeString(image);
        parcel.writeString(active);
        parcel.writeString(parentProjectCategoryId);
        parcel.writeString(projectCategoryName);
        parcel.writeString(projectCategoryDesc);
        parcel.writeString(categoryIconUrl);
        parcel.writeString(categoryImageUrl);
    }

    @Override
    public String toString () {
        return getProjectCategoryName();
    }
}
