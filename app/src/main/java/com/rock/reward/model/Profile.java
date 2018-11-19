
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("user_image_url")
    @Expose
    private String userImageUrl;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("user_about")
    @Expose
    private String userAbout;
    @SerializedName("user_occupation")
    @Expose
    private String userOccupation;
    @SerializedName("user_interest")
    @Expose
    private String userInterest;
    @SerializedName("user_skill")
    @Expose
    private String userSkill;
    @SerializedName("profile_slug")
    @Expose
    private String profileSlug;

    /**
     * 
     * @return
     *     The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The userImageUrl
     */
    public String getUserImageUrl() {
        return userImageUrl;
    }

    /**
     * 
     * @param userImageUrl
     *     The user_image_url
     */
    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    /**
     * 
     * @return
     *     The zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 
     * @param zipCode
     *     The zip_code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 
     * @return
     *     The userAbout
     */
    public String getUserAbout() {
        return userAbout;
    }

    /**
     * 
     * @param userAbout
     *     The user_about
     */
    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    /**
     * 
     * @return
     *     The userOccupation
     */
    public String getUserOccupation() {
        return userOccupation;
    }

    /**
     * 
     * @param userOccupation
     *     The user_occupation
     */
    public void setUserOccupation(String userOccupation) {
        this.userOccupation = userOccupation;
    }

    /**
     * 
     * @return
     *     The userInterest
     */
    public String getUserInterest() {
        return userInterest;
    }

    /**
     * 
     * @param userInterest
     *     The user_interest
     */
    public void setUserInterest(String userInterest) {
        this.userInterest = userInterest;
    }

    /**
     * 
     * @return
     *     The userSkill
     */
    public String getUserSkill() {
        return userSkill;
    }

    /**
     * 
     * @param userSkill
     *     The user_skill
     */
    public void setUserSkill(String userSkill) {
        this.userSkill = userSkill;
    }

    /**
     * 
     * @return
     *     The profileSlug
     */
    public String getProfileSlug() {
        return profileSlug;
    }

    /**
     * 
     * @param profileSlug
     *     The profile_slug
     */
    public void setProfileSlug(String profileSlug) {
        this.profileSlug = profileSlug;
    }

}
