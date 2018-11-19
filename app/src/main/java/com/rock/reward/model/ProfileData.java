
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileData {

    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("social_links")
    @Expose
    private SocialLinks socialLinks;
    @SerializedName("total_user_project")
    @Expose
    private Integer totalUserProject;
    @SerializedName("total_user_comment")
    @Expose
    private Integer totalUserComment;
    @SerializedName("total_user_followers")
    @Expose
    private Integer totalUserFollowers;
    @SerializedName("total_user_followings")
    @Expose
    private Integer totalUserFollowings;
    @SerializedName("total_my_donation")
    @Expose
    private Integer totalMyDonation;

    /**
     * 
     * @return
     *     The profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * 
     * @param profile
     *     The profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * 
     * @return
     *     The socialLinks
     */
    public SocialLinks getSocialLinks() {
        return socialLinks;
    }

    /**
     * 
     * @param socialLinks
     *     The social_links
     */
    public void setSocialLinks(SocialLinks socialLinks) {
        this.socialLinks = socialLinks;
    }

    /**
     * 
     * @return
     *     The totalUserProject
     */
    public Integer getTotalUserProject() {
        return totalUserProject;
    }

    /**
     * 
     * @param totalUserProject
     *     The total_user_project
     */
    public void setTotalUserProject(Integer totalUserProject) {
        this.totalUserProject = totalUserProject;
    }

    /**
     * 
     * @return
     *     The totalUserComment
     */
    public Integer getTotalUserComment() {
        return totalUserComment;
    }

    /**
     * 
     * @param totalUserComment
     *     The total_user_comment
     */
    public void setTotalUserComment(Integer totalUserComment) {
        this.totalUserComment = totalUserComment;
    }

    /**
     * 
     * @return
     *     The totalUserFollowers
     */
    public Integer getTotalUserFollowers() {
        return totalUserFollowers;
    }

    /**
     * 
     * @param totalUserFollowers
     *     The total_user_followers
     */
    public void setTotalUserFollowers(Integer totalUserFollowers) {
        this.totalUserFollowers = totalUserFollowers;
    }

    /**
     * 
     * @return
     *     The totalUserFollowings
     */
    public Integer getTotalUserFollowings() {
        return totalUserFollowings;
    }

    /**
     * 
     * @param totalUserFollowings
     *     The total_user_followings
     */
    public void setTotalUserFollowings(Integer totalUserFollowings) {
        this.totalUserFollowings = totalUserFollowings;
    }

    /**
     * 
     * @return
     *     The totalMyDonation
     */
    public Integer getTotalMyDonation() {
        return totalMyDonation;
    }

    /**
     * 
     * @param totalMyDonation
     *     The total_my_donation
     */
    public void setTotalMyDonation(Integer totalMyDonation) {
        this.totalMyDonation = totalMyDonation;
    }

}
