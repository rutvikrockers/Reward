
package com.rock.reward.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment implements Parcelable {

    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("url_project_title")
    @Expose
    private String urlProjectTitle;
    @SerializedName("project_owner_id")
    @Expose
    private String projectOwnerId;
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("comment_ip")
    @Expose
    private String commentIp;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("comment_type")
    @Expose
    private String commentType;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("user_name")
    @Expose
    private String userName;
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

    protected Comment(Parcel in) {
        projectTitle = in.readString();
        urlProjectTitle = in.readString();
        projectOwnerId = in.readString();
        commentId = in.readString();
        comments = in.readString();
        dateAdded = in.readString();
        userId = in.readString();
        commentIp = in.readString();
        status = in.readString();
        commentType = in.readString();
        parentId = in.readString();
        userName = in.readString();
        lastName = in.readString();
        image = in.readString();
        profileSlug = in.readString();
        userImage = in.readString();
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
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
     *     The commentId
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * 
     * @param commentId
     *     The comment_id
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * 
     * @return
     *     The comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * 
     * @param comments
     *     The comments
     */
    public void setComments(String comments) {
        this.comments = comments;
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
     *     The commentIp
     */
    public String getCommentIp() {
        return commentIp;
    }

    /**
     * 
     * @param commentIp
     *     The comment_ip
     */
    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
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
     *     The commentType
     */
    public String getCommentType() {
        return commentType;
    }

    /**
     * 
     * @param commentType
     *     The comment_type
     */
    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    /**
     * 
     * @return
     *     The parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId
     *     The parent_id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
        parcel.writeString(commentId);
        parcel.writeString(comments);
        parcel.writeString(dateAdded);
        parcel.writeString(userId);
        parcel.writeString(commentIp);
        parcel.writeString(status);
        parcel.writeString(commentType);
        parcel.writeString(parentId);
        parcel.writeString(userName);
        parcel.writeString(lastName);
        parcel.writeString(image);
        parcel.writeString(profileSlug);
        parcel.writeString(userImage);
    }
}
