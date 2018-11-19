package com.rock.reward.model;

import java.util.List;

/**
 * Created by rockers on 3/3/17.
 */

public class Data {
    public List<Country> countries;
    public List<Category> categories;
    public List<LatestProject> latest_projects;
    public List<FeaturedProject> featured_projects;
    public int total_count;
    public int total_row_display;
    public int offset;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<LatestProject> getLatest_projects() {
        return latest_projects;
    }

    public void setLatest_projects(List<LatestProject> latest_projects) {
        this.latest_projects = latest_projects;
    }

    public List<FeaturedProject> getFeatured_projects() {
        return featured_projects;
    }

    public void setFeatured_projects(List<FeaturedProject> featured_projects) {
        this.featured_projects = featured_projects;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getTotal_row_display() {
        return total_row_display;
    }

    public void setTotal_row_display(int total_row_display) {
        this.total_row_display = total_row_display;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
