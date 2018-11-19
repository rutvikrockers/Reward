
package com.rock.reward.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilteredCampains {

    @SerializedName("latest_projects")
    @Expose
    private List<LatestProject> latestProjects = new ArrayList<LatestProject>();

    /**
     * 
     * @return
     *     The latestProjects
     */
    public List<LatestProject> getLatestProjects() {
        return latestProjects;
    }

    /**
     * 
     * @param latestProjects
     *     The latest_projects
     */
    public void setLatestProjects(List<LatestProject> latestProjects) {
        this.latestProjects = latestProjects;
    }

}
