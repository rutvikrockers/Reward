package com.rock.reward.ResponsePojo;


import com.rock.reward.model.Category;
import com.rock.reward.model.Comment;
import com.rock.reward.model.Country;
import com.rock.reward.model.FeaturedProject;
import com.rock.reward.model.Follower;
import com.rock.reward.model.Funder;
import com.rock.reward.model.LatestProject;
import com.rock.reward.model.Perk;
import com.rock.reward.model.Profile;
import com.rock.reward.model.ProjectDetail;
import com.rock.reward.model.ShowDonationListCompleted;
import com.rock.reward.model.ShowDonationListRecCompleted;
import com.rock.reward.model.ShowDonationListRecRunning;
import com.rock.reward.model.ShowDonationListRunning;
import com.rock.reward.model.SocialLinks;
import com.rock.reward.model.TeamMember;
import com.rock.reward.model.Update;

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

    public ProjectDetail project_detail;
    public Integer total_updates_count;
    public Integer total_comments_count;
    public Integer total_funders_count;
    public List<Funder> funders;



    public Profile profile;
    public SocialLinks social_links;
    public int total_user_project;
    public int total_user_comment;
    public int total_user_followers;
    public int total_user_followings;
    public int total_my_donation;




    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public SocialLinks getSocial_links() {
        return social_links;
    }

    public void setSocial_links(SocialLinks social_links) {
        this.social_links = social_links;
    }

    public int getTotal_user_project() {
        return total_user_project;
    }

    public void setTotal_user_project(int total_user_project) {
        this.total_user_project = total_user_project;
    }

    public int getTotal_user_comment() {
        return total_user_comment;
    }

    public void setTotal_user_comment(int total_user_comment) {
        this.total_user_comment = total_user_comment;
    }

    public int getTotal_user_followers() {
        return total_user_followers;
    }

    public void setTotal_user_followers(int total_user_followers) {
        this.total_user_followers = total_user_followers;
    }

    public int getTotal_user_followings() {
        return total_user_followings;
    }

    public void setTotal_user_followings(int total_user_followings) {
        this.total_user_followings = total_user_followings;
    }

    public int getTotal_my_donation() {
        return total_my_donation;
    }

    public void setTotal_my_donation(int total_my_donation) {
        this.total_my_donation = total_my_donation;
    }

    public String user_id;
    public String first_name;
    public String last_name;
    public String email;
    public String user_image_url;
    public String token;


    public List<ShowDonationListRecCompleted> show_donation_list_rec_completed;
    public List<ShowDonationListRecRunning> show_donation_list_rec_running;
    public List<ShowDonationListCompleted> show_donation_list_completed;
    public List<ShowDonationListRunning> show_donation_list_running;
    public int project_follower;
    public int project_following;
    public int total_running_projects;
    public int total_completed_projects;


    public List<String> total_fund;
    public List<String> successful_fund;
    public List<String> unsuccessful_fund;
    public List<DonationData> donation_data;

    public List<String> getTotal_fund() {
        return total_fund;
    }

    public void setTotal_fund(List<String> total_fund) {
        this.total_fund = total_fund;
    }

    public List<String> getSuccessful_fund() {
        return successful_fund;
    }

    public void setSuccessful_fund(List<String> successful_fund) {
        this.successful_fund = successful_fund;
    }

    public List<String> getUnsuccessful_fund() {
        return unsuccessful_fund;
    }

    public void setUnsuccessful_fund(List<String> unsuccessful_fund) {
        this.unsuccessful_fund = unsuccessful_fund;
    }

    public List<DonationData> getDonation_data() {
        return donation_data;
    }

    public void setDonation_data(List<DonationData> donation_data) {
        this.donation_data = donation_data;
    }

    public List<ShowDonationListRecCompleted> getShow_donation_list_rec_completed() {
        return show_donation_list_rec_completed;
    }

    public void setShow_donation_list_rec_completed(List<ShowDonationListRecCompleted> show_donation_list_rec_completed) {
        this.show_donation_list_rec_completed = show_donation_list_rec_completed;
    }

    public List<ShowDonationListRecRunning> getShow_donation_list_rec_running() {
        return show_donation_list_rec_running;
    }

    public void setShow_donation_list_rec_running(List<ShowDonationListRecRunning> show_donation_list_rec_running) {
        this.show_donation_list_rec_running = show_donation_list_rec_running;
    }

    public List<ShowDonationListCompleted> getShow_donation_list_completed() {
        return show_donation_list_completed;
    }

    public void setShow_donation_list_completed(List<ShowDonationListCompleted> show_donation_list_completed) {
        this.show_donation_list_completed = show_donation_list_completed;
    }

    public List<ShowDonationListRunning> getShow_donation_list_running() {
        return show_donation_list_running;
    }

    public void setShow_donation_list_running(List<ShowDonationListRunning> show_donation_list_running) {
        this.show_donation_list_running = show_donation_list_running;
    }

    public int getProject_follower() {
        return project_follower;
    }

    public void setProject_follower(int project_follower) {
        this.project_follower = project_follower;
    }

    public int getProject_following() {
        return project_following;
    }

    public void setProject_following(int project_following) {
        this.project_following = project_following;
    }

    public int getTotal_running_projects() {
        return total_running_projects;
    }

    public void setTotal_running_projects(int total_running_projects) {
        this.total_running_projects = total_running_projects;
    }

    public int getTotal_completed_projects() {
        return total_completed_projects;
    }

    public void setTotal_completed_projects(int total_completed_projects) {
        this.total_completed_projects = total_completed_projects;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_image_url() {
        return user_image_url;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Update> updates;

    public List<Comment> comments;

    public int total_perks_count;
    public List<Perk> perks;
    public Integer total_followers_count;
    public List<Follower> followers;
    public Integer team_members_count;
    public List<TeamMember> team_members;

    public ProjectDetail getProject_detail() {
        return project_detail;
    }

    public void setProject_detail(ProjectDetail project_detail) {
        this.project_detail = project_detail;
    }

    public List<Update> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Update> updates) {
        this.updates = updates;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getTotal_perks_count() {
        return total_perks_count;
    }

    public void setTotal_perks_count(int total_perks_count) {
        this.total_perks_count = total_perks_count;
    }

    public List<Perk> getPerks() {
        return perks;
    }

    public void setPerks(List<Perk> perks) {
        this.perks = perks;
    }

    public Integer getTotal_followers_count() {
        return total_followers_count;
    }

    public void setTotal_followers_count(Integer total_followers_count) {
        this.total_followers_count = total_followers_count;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public Integer getTeam_members_count() {
        return team_members_count;
    }

    public void setTeam_members_count(Integer team_members_count) {
        this.team_members_count = team_members_count;
    }

    public List<TeamMember> getTeam_members() {
        return team_members;
    }

    public void setTeam_members(List<TeamMember> team_members) {
        this.team_members = team_members;
    }



    public Integer getTotal_updates_count() {
        return total_updates_count;
    }

    public void setTotal_updates_count(Integer total_updates_count) {
        this.total_updates_count = total_updates_count;
    }





    public Integer getTotal_comments_count() {
        return total_comments_count;
    }

    public void setTotal_comments_count(Integer total_comments_count) {
        this.total_comments_count = total_comments_count;
    }





    public Integer getTotal_funders_count() {
        return total_funders_count;
    }

    public void setTotal_funders_count(Integer total_funders_count) {
        this.total_funders_count = total_funders_count;
    }

    public List<Funder> getFunders() {
        return funders;
    }

    public void setFunders(List<Funder> funders) {
        this.funders = funders;
    }

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
