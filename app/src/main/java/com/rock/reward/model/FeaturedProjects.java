package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rocku27 on 4/8/16.
 */
public class FeaturedProjects {

    @SerializedName("featured_projects")
    @Expose
    private List<FeaturedProject> featuredProjects;

    public List<FeaturedProject> getFeaturedProjects() {
        return featuredProjects;
    }
    public void setFeaturedProjects(List<FeaturedProject> featuredProjects) {
        this.featuredProjects = featuredProjects;
    }
}
