
package com.rock.reward.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Update implements Parcelable {

    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("url_project_title")
    @Expose
    private String urlProjectTitle;
    @SerializedName("project_owner_id")
    @Expose
    private String projectOwnerId;
    @SerializedName("updates")
    @Expose
    private String updates;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("update_id")
    @Expose
    private String updateId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("profile_slug")
    @Expose
    private String profileSlug;
    @SerializedName("user_image")
    @Expose
    private String userImage;

    protected Update(Parcel in) {
        projectTitle = in.readString();
        urlProjectTitle = in.readString();
        projectOwnerId = in.readString();
        updates = in.readString();
        dateAdded = in.readString();
        updateId = in.readString();
        userName = in.readString();
        userId = in.readString();
        lastName = in.readString();
        image = in.readString();
        profileSlug = in.readString();
        userImage = in.readString();
    }

    public static final Creator<Update> CREATOR = new Creator<Update>() {
        @Override
        public Update createFromParcel(Parcel in) {
            return new Update(in);
        }

        @Override
        public Update[] newArray(int size) {
            return new Update[size];
        }
    };

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
     *     The updates
     */
    public String getUpdates() {
        return updates;
    }

    /**
     * 
     * @param updates
     *     The updates
     */
    public void setUpdates(String updates) {
        this.updates = updates;
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
     *     The updateId
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 
     * @param updateId
     *     The update_id
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(projectTitle);
        parcel.writeString(urlProjectTitle);
        parcel.writeString(projectOwnerId);
        parcel.writeString(updates);
        parcel.writeString(dateAdded);
        parcel.writeString(updateId);
        parcel.writeString(userName);
        parcel.writeString(userId);
        parcel.writeString(lastName);
        parcel.writeString(image);
        parcel.writeString(profileSlug);
        parcel.writeString(userImage);
    }
}
