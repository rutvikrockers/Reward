
package com.rock.reward.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectDetailData {

    @SerializedName("project_detail")
    @Expose
    private ProjectDetail projectDetail;
    @SerializedName("total_updates_count")
    @Expose
    private Integer totalUpdatesCount;
    @SerializedName("updates")
    @Expose
    private List<Update> updates = new ArrayList<Update>();
    @SerializedName("total_comments_count")
    @Expose
    private Integer totalCommentsCount;
    @SerializedName("comments")
    @Expose
    private List<Comment> comments = new ArrayList<Comment>();
    @SerializedName("total_funders_count")
    @Expose
    private Integer totalFundersCount;
    @SerializedName("funders")
    @Expose
    private List<Funder> funders = new ArrayList<Funder>();
    @SerializedName("total_perks_count")
    @Expose
    private Integer totalPerksCount;
    @SerializedName("perks")
    @Expose
    private List<Perk> perks = new ArrayList<Perk>();
    @SerializedName("total_followers_count")
    @Expose
    private Integer totalFollowersCount;
    @SerializedName("followers")
    @Expose
    private List<Follower> followers = new ArrayList<Follower>();
    @SerializedName("team_members_count")
    @Expose
    private Integer teamMembersCount;
    @SerializedName("team_members")
    @Expose
    private List<TeamMember> teamMembers = new ArrayList<TeamMember>();

    /**
     * 
     * @return
     *     The projectDetail
     */
    public ProjectDetail getProjectDetail() {
        return projectDetail;
    }

    /**
     * 
     * @param projectDetail
     *     The project_detail
     */
    public void setProjectDetail(ProjectDetail projectDetail) {
        this.projectDetail = projectDetail;
    }

    /**
     * 
     * @return
     *     The totalUpdatesCount
     */
    public Integer getTotalUpdatesCount() {
        return totalUpdatesCount;
    }

    /**
     * 
     * @param totalUpdatesCount
     *     The total_updates_count
     */
    public void setTotalUpdatesCount(Integer totalUpdatesCount) {
        this.totalUpdatesCount = totalUpdatesCount;
    }

    /**
     * 
     * @return
     *     The updates
     */
    public List<Update> getUpdates() {
        return updates;
    }

    /**
     * 
     * @param updates
     *     The updates
     */
    public void setUpdates(List<Update> updates) {
        this.updates = updates;
    }

    /**
     * 
     * @return
     *     The totalCommentsCount
     */
    public Integer getTotalCommentsCount() {
        return totalCommentsCount;
    }

    /**
     * 
     * @param totalCommentsCount
     *     The total_comments_count
     */
    public void setTotalCommentsCount(Integer totalCommentsCount) {
        this.totalCommentsCount = totalCommentsCount;
    }

    /**
     * 
     * @return
     *     The comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * 
     * @param comments
     *     The comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * 
     * @return
     *     The totalFundersCount
     */
    public Integer getTotalFundersCount() {
        return totalFundersCount;
    }

    /**
     * 
     * @param totalFundersCount
     *     The total_funders_count
     */
    public void setTotalFundersCount(Integer totalFundersCount) {
        this.totalFundersCount = totalFundersCount;
    }

    /**
     * 
     * @return
     *     The funders
     */
    public List<Funder> getFunders() {
        return funders;
    }

    /**
     * 
     * @param funders
     *     The funders
     */
    public void setFunders(List<Funder> funders) {
        this.funders = funders;
    }

    /**
     * 
     * @return
     *     The totalPerksCount
     */
    public Integer getTotalPerksCount() {
        return totalPerksCount;
    }

    /**
     * 
     * @param totalPerksCount
     *     The total_perks_count
     */
    public void setTotalPerksCount(Integer totalPerksCount) {
        this.totalPerksCount = totalPerksCount;
    }

    /**
     * 
     * @return
     *     The perks
     */
    public List<Perk> getPerks() {
        return perks;
    }

    /**
     * 
     * @param perks
     *     The perks
     */
    public void setPerks(List<Perk> perks) {
        this.perks = perks;
    }

    /**
     * 
     * @return
     *     The totalFollowersCount
     */
    public Integer getTotalFollowersCount() {
        return totalFollowersCount;
    }

    /**
     * 
     * @param totalFollowersCount
     *     The total_followers_count
     */
    public void setTotalFollowersCount(Integer totalFollowersCount) {
        this.totalFollowersCount = totalFollowersCount;
    }

    /**
     * 
     * @return
     *     The followers
     */
    public List<Follower> getFollowers() {
        return followers;
    }

    /**
     * 
     * @param followers
     *     The followers
     */
    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    /**
     *
     * @return
     *     The teamMembersCount
     */
    public Integer getTeamMembersCount() {
        return teamMembersCount;
    }

    /**
     *
     * @param teamMembersCount
     *     The team_members_count
     */
    public void setTeamMembersCount(Integer teamMembersCount) {
        this.teamMembersCount = teamMembersCount;
    }

    /**
     *
     * @return
     *     The teamMembers
     */
    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    /**
     *
     * @param teamMembers
     *     The team_members
     */
    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

}
