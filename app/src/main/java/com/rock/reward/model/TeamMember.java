
package com.rock.reward.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamMember implements Parcelable {

    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("url_project_title")
    @Expose
    private String urlProjectTitle;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("member_role")
    @Expose
    private String memberRole;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("profile_slug")
    @Expose
    private Object profileSlug;
    @SerializedName("admin")
    @Expose
    private String admin;
    @SerializedName("user_role")
    @Expose
    private Object userRole;
    @SerializedName("user_image")
    @Expose
    private String userImage;

    protected TeamMember(Parcel in) {
        projectId = in.readString();
        urlProjectTitle = in.readString();
        email = in.readString();
        code = in.readString();
        memberRole = in.readString();
        userId = in.readString();
        userName = in.readString();
        lastName = in.readString();
        admin = in.readString();
        userImage = in.readString();
    }

    public static final Creator<TeamMember> CREATOR = new Creator<TeamMember>() {
        @Override
        public TeamMember createFromParcel(Parcel in) {
            return new TeamMember(in);
        }

        @Override
        public TeamMember[] newArray(int size) {
            return new TeamMember[size];
        }
    };

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
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The memberRole
     */
    public String getMemberRole() {
        return memberRole;
    }

    /**
     * 
     * @param memberRole
     *     The member_role
     */
    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
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
     *     The admin
     */
    public String getAdmin() {
        return admin;
    }

    /**
     * 
     * @param admin
     *     The admin
     */
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    /**
     * 
     * @return
     *     The userRole
     */
    public Object getUserRole() {
        return userRole;
    }

    /**
     * 
     * @param userRole
     *     The user_role
     */
    public void setUserRole(Object userRole) {
        this.userRole = userRole;
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
        parcel.writeString(projectId);
        parcel.writeString(urlProjectTitle);
        parcel.writeString(email);
        parcel.writeString(code);
        parcel.writeString(memberRole);
        parcel.writeString(userId);
        parcel.writeString(userName);
        parcel.writeString(lastName);
        parcel.writeString(admin);
        parcel.writeString(userImage);
    }
}
