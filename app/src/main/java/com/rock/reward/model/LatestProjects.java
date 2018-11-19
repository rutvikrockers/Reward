package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rocku27 on 4/8/16.
 */
public class LatestProjects {

    @SerializedName("latest_projects")
    @Expose
    private List<LatestProject> latestProjects;

    public List<LatestProject> getLatestProjects() {
        return latestProjects;
    }
    public void setLatestProjects(List<LatestProject> latestProjects) {
        this.latestProjects = latestProjects;
    }
}
