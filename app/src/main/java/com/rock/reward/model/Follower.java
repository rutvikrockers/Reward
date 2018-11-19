
package com.rock.reward.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Follower implements Parcelable {

    @SerializedName("project_follow_id")
    @Expose
    private String projectFollowId;
    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("project_follow_user_id")
    @Expose
    private String projectFollowUserId;
    @SerializedName("project_follow_date")
    @Expose
    private String projectFollowDate;
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
    private Object image;
    @SerializedName("profile_slug")
    @Expose
    private String profileSlug;
    @SerializedName("user_image")
    @Expose
    private String userImage;

    protected Follower(Parcel in) {
        projectFollowId = in.readString();
        projectId = in.readString();
        projectFollowUserId = in.readString();
        projectFollowDate = in.readString();
        userId = in.readString();
        userName = in.readString();
        lastName = in.readString();
        address = in.readString();
        profileSlug = in.readString();
        userImage = in.readString();
    }

    public static final Creator<Follower> CREATOR = new Creator<Follower>() {
        @Override
        public Follower createFromParcel(Parcel in) {
            return new Follower(in);
        }

        @Override
        public Follower[] newArray(int size) {
            return new Follower[size];
        }
    };

    /**
     * 
     * @return
     *     The projectFollowId
     */
    public String getProjectFollowId() {
        return projectFollowId;
    }

    /**
     * 
     * @param projectFollowId
     *     The project_follow_id
     */
    public void setProjectFollowId(String projectFollowId) {
        this.projectFollowId = projectFollowId;
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
     *     The projectFollowUserId
     */
    public String getProjectFollowUserId() {
        return projectFollowUserId;
    }

    /**
     * 
     * @param projectFollowUserId
     *     The project_follow_user_id
     */
    public void setProjectFollowUserId(String projectFollowUserId) {
        this.projectFollowUserId = projectFollowUserId;
    }

    /**
     * 
     * @return
     *     The projectFollowDate
     */
    public String getProjectFollowDate() {
        return projectFollowDate;
    }

    /**
     * 
     * @param projectFollowDate
     *     The project_follow_date
     */
    public void setProjectFollowDate(String projectFollowDate) {
        this.projectFollowDate = projectFollowDate;
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
        parcel.writeString(projectFollowId);
        parcel.writeString(projectId);
        parcel.writeString(projectFollowUserId);
        parcel.writeString(projectFollowDate);
        parcel.writeString(userId);
        parcel.writeString(userName);
        parcel.writeString(lastName);
        parcel.writeString(address);
        parcel.writeString(profileSlug);
        parcel.writeString(userImage);
    }
}
