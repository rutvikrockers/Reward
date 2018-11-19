
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserFollowers {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("user_image_url")
    @Expose
    private String userImageUrl;
    @SerializedName("follow_date")
    @Expose
    private String followDate;
    @SerializedName("is_followed")
    @Expose
    private Integer isFollowed;

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
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
     *     The userImageUrl
     */
    public String getUserImageUrl() {
        return userImageUrl;
    }

    /**
     * 
     * @param userImageUrl
     *     The user_image_url
     */
    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    /**
     * 
     * @return
     *     The followDate
     */
    public String getFollowDate() {
        return followDate;
    }

    /**
     * 
     * @param followDate
     *     The follow_date
     */
    public void setFollowDate(String followDate) {
        this.followDate = followDate;
    }

    /**
     * 
     * @return
     *     The isFollowed
     */
    public Integer getIsFollowed() {
        return isFollowed;
    }

    /**
     * 
     * @param isFollowed
     *     The is_followed
     */
    public void setIsFollowed(Integer isFollowed) {
        this.isFollowed = isFollowed;
    }

}
