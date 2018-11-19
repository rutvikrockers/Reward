package com.rock.reward.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rocku27 on 3/8/16.
 */
public class GuestLogin implements Serializable {

    private String token;

    @SerializedName("site_name")
    private String siteName;

    @SerializedName("perk_enable")
    private String perkEnable;

    public void setToken(String Token){
        token=Token;
    }
    public void setSite_name(String SiteName){
        siteName=SiteName;
    }
    public void setPerk_enable(String PerkEnable){
        perkEnable=PerkEnable;
    }

    public String getToken(){
        return token;
    }
    public String getSite_name(){
        return siteName;
    }
    public String getPerk_enable(){
        return perkEnable;
    }
}
