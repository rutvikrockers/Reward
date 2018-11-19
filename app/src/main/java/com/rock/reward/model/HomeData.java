
package com.rock.reward.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeData {

    @SerializedName("countries")
    @Expose
    private List<Country> countries = new ArrayList<Country>();
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("latest_projects")
    @Expose
    private List<LatestProject> latestProjects = new ArrayList<LatestProject>();
    @SerializedName("featured_projects")
    @Expose
    private List<FeaturedProject> featuredProjects = new ArrayList<FeaturedProject>();
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("total_row_display")
    @Expose
    private Integer totalRowDisplay;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    private ArrayList<String> attachment = new ArrayList<>();

    public ArrayList<String> getAttachment() {
        return attachment;
    }

    public void setAttachment(ArrayList<String> attachment) {
        this.attachment = attachment;
    }

    /**
     *
     * @return
     *     The countries
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     *
     * @param countries
     *     The countries
     */
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    /**
     *
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

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

    /**
     *
     * @return
     *     The featuredProjects
     */
    public List<FeaturedProject> getFeaturedProjects() {
        return featuredProjects;
    }

    /**
     *
     * @param featuredProjects
     *     The featured_projects
     */
    public void setFeaturedProjects(List<FeaturedProject> featuredProjects) {
        this.featuredProjects = featuredProjects;
    }

    /**
     *
     * @return
     *     The totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     *
     * @param totalCount
     *     The total_count
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     *
     * @return
     *     The totalRowDisplay
     */
    public Integer getTotalRowDisplay() {
        return totalRowDisplay;
    }

    /**
     *
     * @param totalRowDisplay
     *     The total_row_display
     */
    public void setTotalRowDisplay(Integer totalRowDisplay) {
        this.totalRowDisplay = totalRowDisplay;
    }

    /**
     *
     * @return
     *     The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     *
     * @param offset
     *     The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    public void addAttachmentId(String attachmentId){
        this.attachment.add(attachmentId);
    }
}