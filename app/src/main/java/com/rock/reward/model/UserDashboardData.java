
package com.rock.reward.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDashboardData {

    @SerializedName("show_donation_list_rec_completed")
    @Expose
    private List<ShowDonationListRecCompleted> showDonationListRecCompleted = new ArrayList<ShowDonationListRecCompleted>();
    @SerializedName("show_donation_list_rec_running")
    @Expose
    private List<ShowDonationListRecRunning> showDonationListRecRunning = new ArrayList<ShowDonationListRecRunning>();
    @SerializedName("show_donation_list_completed")
    @Expose
    private List<ShowDonationListCompleted> showDonationListCompleted = new ArrayList<ShowDonationListCompleted>();
    @SerializedName("show_donation_list_running")
    @Expose
    private List<ShowDonationListRunning> showDonationListRunning = new ArrayList<ShowDonationListRunning>();
    @SerializedName("project_follower")
    @Expose
    private Integer projectFollower;
    @SerializedName("project_following")
    @Expose
    private Integer projectFollowing;
    @SerializedName("total_running_projects")
    @Expose
    private Integer totalRunningProjects;
    @SerializedName("total_completed_projects")
    @Expose
    private Integer totalCompletedProjects;

    /**
     * 
     * @return
     *     The showDonationListRecCompleted
     */
    public List<ShowDonationListRecCompleted> getShowDonationListRecCompleted() {
        return showDonationListRecCompleted;
    }

    /**
     * 
     * @param showDonationListRecCompleted
     *     The show_donation_list_rec_completed
     */
    public void setShowDonationListRecCompleted(List<ShowDonationListRecCompleted> showDonationListRecCompleted) {
        this.showDonationListRecCompleted = showDonationListRecCompleted;
    }

    /**
     * 
     * @return
     *     The showDonationListRecRunning
     */
    public List<ShowDonationListRecRunning> getShowDonationListRecRunning() {
        return showDonationListRecRunning;
    }

    /**
     * 
     * @param showDonationListRecRunning
     *     The show_donation_list_rec_running
     */
    public void setShowDonationListRecRunning(List<ShowDonationListRecRunning> showDonationListRecRunning) {
        this.showDonationListRecRunning = showDonationListRecRunning;
    }

    /**
     * 
     * @return
     *     The showDonationListCompleted
     */
    public List<ShowDonationListCompleted> getShowDonationListCompleted() {
        return showDonationListCompleted;
    }

    /**
     * 
     * @param showDonationListCompleted
     *     The show_donation_list_completed
     */
    public void setShowDonationListCompleted(List<ShowDonationListCompleted> showDonationListCompleted) {
        this.showDonationListCompleted = showDonationListCompleted;
    }

    /**
     *
     * @return
     *     The showDonationListRunning
     */
    public List<ShowDonationListRunning> getShowDonationListRunning() {
        return showDonationListRunning;
    }

    /**
     *
     * @param showDonationListRunning
     *     The show_donation_list_running
     */
    public void setShowDonationListRunning(List<ShowDonationListRunning> showDonationListRunning) {
        this.showDonationListRunning = showDonationListRunning;
    }

    /**
     * 
     * @return
     *     The projectFollower
     */
    public Integer getProjectFollower() {
        return projectFollower;
    }

    /**
     * 
     * @param projectFollower
     *     The project_follower
     */
    public void setProjectFollower(Integer projectFollower) {
        this.projectFollower = projectFollower;
    }

    /**
     * 
     * @return
     *     The projectFollowing
     */
    public Integer getProjectFollowing() {
        return projectFollowing;
    }

    /**
     * 
     * @param projectFollowing
     *     The project_following
     */
    public void setProjectFollowing(Integer projectFollowing) {
        this.projectFollowing = projectFollowing;
    }

    /**
     * 
     * @return
     *     The totalRunningProjects
     */
    public Integer getTotalRunningProjects() {
        return totalRunningProjects;
    }

    /**
     * 
     * @param totalRunningProjects
     *     The total_running_projects
     */
    public void setTotalRunningProjects(Integer totalRunningProjects) {
        this.totalRunningProjects = totalRunningProjects;
    }

    /**
     * 
     * @return
     *     The totalCompletedProjects
     */
    public Integer getTotalCompletedProjects() {
        return totalCompletedProjects;
    }

    /**
     * 
     * @param totalCompletedProjects
     *     The total_completed_projects
     */
    public void setTotalCompletedProjects(Integer totalCompletedProjects) {
        this.totalCompletedProjects = totalCompletedProjects;
    }

}
