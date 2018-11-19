
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserActivity {

    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("project_id")
    @Expose
    private Integer projectId;
    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("action_detail")
    @Expose
    private String actionDetail;

    /**
     * 
     * @return
     *     The datetime
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * 
     * @param datetime
     *     The datetime
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * 
     * @return
     *     The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     The projectId
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 
     * @param projectId
     *     The project_id
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
     *     The actionDetail
     */
    public String getActionDetail() {
        return actionDetail;
    }

    /**
     * 
     * @param actionDetail
     *     The action_detail
     */
    public void setActionDetail(String actionDetail) {
        this.actionDetail = actionDetail;
    }

}
