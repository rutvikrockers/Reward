
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SocialLinks {

    @SerializedName("facebook_url")
    @Expose
    private String facebookUrl;
    @SerializedName("twitter_url")
    @Expose
    private String twitterUrl;
    @SerializedName("user_website")
    @Expose
    private String userWebsite;
    @SerializedName("linkedln_url")
    @Expose
    private String linkedlnUrl;
    @SerializedName("googleplus_url")
    @Expose
    private String googleplusUrl;
    @SerializedName("bandcamp_url")
    @Expose
    private String bandcampUrl;
    @SerializedName("youtube_url")
    @Expose
    private String youtubeUrl;
    @SerializedName("myspace_url")
    @Expose
    private String myspaceUrl;

    /**
     * 
     * @return
     *     The facebookUrl
     */
    public String getFacebookUrl() {
        return facebookUrl;
    }

    /**
     * 
     * @param facebookUrl
     *     The facebook_url
     */
    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    /**
     * 
     * @return
     *     The twitterUrl
     */
    public String getTwitterUrl() {
        return twitterUrl;
    }

    /**
     * 
     * @param twitterUrl
     *     The twitter_url
     */
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    /**
     * 
     * @return
     *     The userWebsite
     */
    public String getUserWebsite() {
        return userWebsite;
    }

    /**
     * 
     * @param userWebsite
     *     The user_website
     */
    public void setUserWebsite(String userWebsite) {
        this.userWebsite = userWebsite;
    }

    /**
     * 
     * @return
     *     The linkedlnUrl
     */
    public String getLinkedlnUrl() {
        return linkedlnUrl;
    }

    /**
     * 
     * @param linkedlnUrl
     *     The linkedln_url
     */
    public void setLinkedlnUrl(String linkedlnUrl) {
        this.linkedlnUrl = linkedlnUrl;
    }

    /**
     * 
     * @return
     *     The googleplusUrl
     */
    public String getGoogleplusUrl() {
        return googleplusUrl;
    }

    /**
     * 
     * @param googleplusUrl
     *     The googleplus_url
     */
    public void setGoogleplusUrl(String googleplusUrl) {
        this.googleplusUrl = googleplusUrl;
    }

    /**
     * 
     * @return
     *     The bandcampUrl
     */
    public String getBandcampUrl() {
        return bandcampUrl;
    }

    /**
     * 
     * @param bandcampUrl
     *     The bandcamp_url
     */
    public void setBandcampUrl(String bandcampUrl) {
        this.bandcampUrl = bandcampUrl;
    }

    /**
     * 
     * @return
     *     The youtubeUrl
     */
    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    /**
     * 
     * @param youtubeUrl
     *     The youtube_url
     */
    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    /**
     * 
     * @return
     *     The myspaceUrl
     */
    public String getMyspaceUrl() {
        return myspaceUrl;
    }

    /**
     * 
     * @param myspaceUrl
     *     The myspace_url
     */
    public void setMyspaceUrl(String myspaceUrl) {
        this.myspaceUrl = myspaceUrl;
    }

}
