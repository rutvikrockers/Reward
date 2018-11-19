package com.rock.reward.ResponsePojo;

/**
 * Created by rockers on 3/3/17.
 */
public class FollowingData {
    public String user_id;
    public String first_name;
    public String last_name;
    public String user_image_url;
    public String follow_date;
    public int is_followed;

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

    public String getUser_image_url() {
        return user_image_url;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }

    public String getFollow_date() {
        return follow_date;
    }

    public void setFollow_date(String follow_date) {
        this.follow_date = follow_date;
    }

    public int getIs_followed() {
        return is_followed;
    }

    public void setIs_followed(int is_followed) {
        this.is_followed = is_followed;
    }
}
