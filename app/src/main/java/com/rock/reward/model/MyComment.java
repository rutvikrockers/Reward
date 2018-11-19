
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyComment {

    @SerializedName("comment_date")
    @Expose
    private String commentDate;
    @SerializedName("comment_time")
    @Expose
    private String commentTime;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("project_image_url")
    @Expose
    private String projectImageUrl;

    /**
     * 
     * @return
     *     The commentDate
     */
    public String getCommentDate() {
        return commentDate;
    }

    /**
     * 
     * @param commentDate
     *     The comment_date
     */
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    /**
     * 
     * @return
     *     The commentTime
     */
    public String getCommentTime() {
        return commentTime;
    }

    /**
     * 
     * @param commentTime
     *     The comment_time
     */
    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
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

}
