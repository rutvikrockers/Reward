package com.rock.reward.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rocku27 on 4/8/16.
 */
public class ProjectCountries {
    @SerializedName("country_id")
    private int countryId;

    @SerializedName("country_name")
    private String countryName;

    private String fips;

    private String iso2;

    private String iso3;

    private String ison;

    private String internet;

    private String capital;

    @SerializedName("map_ref")
    private String mapReference;

    private String singular;

    private String plural;

    private String currency;

    @SerializedName("currency_code")
    private String currencyCode;

    private int population;

    private String title;

    private String comment;

    @SerializedName("active")
    private int status;


    public void setCountryId(int CountryId){
        countryId=CountryId;
    }
    public void setCountryName(String CountryName){
        countryName=CountryName;
    }
    public void setFips(String Fips){
        fips=Fips;
    }
    public void setIso2(String Iso2){
        iso2=Iso2;
    }
    public void setIso3(String Iso3){
        iso3=Iso3;
    }
    public void setIson(String Ison){
        ison=Ison;
    }
    public void setInternet(String Internet){
        internet=Internet;
    }
    public void setCapital(String Capital) {
        capital = Capital;
    }
    public void setMapReference(String MapReference){
        mapReference=MapReference;
    }
    public void setSingular(String Singular){
        singular=Singular;
    }
    public void setPlural(String Plural){
        plural=Plural;
    }
    public void setCurrency(String Currency){
        currency=Currency;
    }
    public void setCurrencyCode(String CurrencyCode) {
        currencyCode = CurrencyCode;
    }
    public void setPopulation(int Population){
        population=Population;
    }
    public void setTitle(String Title){
        title=Title;
    }
    public void setComment(String Comment){
        comment=Comment;
    }
    public void setStatus(int Status){
        status=Status;
    }

    public int getCountryId(){
        return countryId;
    }
    public String getCountryName(){
        return countryName;
    }
    public String getFips(){
        return fips;
    }
    public String getIso2(){
        return iso2;
    }
    public String getIso3(){
        return iso3;
    }
    public String getIson(){
        return ison;
    }
    public String getInternet(){
        return internet;
    }
    public String getCapital(){
        return capital;
    }
    public String getMapReference(){
        return mapReference;
    }
    public String getSingular(){
        return singular;
    }
    public String getPlural(){
        return plural;
    }
    public String getCurrency(){
        return currency;
    }
    public String getCurrencyCode(){
        return currencyCode;
    }
    public int getPopulation(){
        return population;
    }
    public String getTitle(){
        return title;
    }
    public String getComment(){
        return comment;
    }
    public int getStatus(){
        return status;
    }
}
