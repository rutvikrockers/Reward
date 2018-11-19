
package com.rock.reward.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable {

    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @SerializedName("fips")
    @Expose
    private String fips;
    @SerializedName("iso2")
    @Expose
    private String iso2;
    @SerializedName("iso3")
    @Expose
    private String iso3;
    @SerializedName("ison")
    @Expose
    private String ison;
    @SerializedName("internet")
    @Expose
    private String internet;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("map_ref")
    @Expose
    private String mapRef;
    @SerializedName("singular")
    @Expose
    private String singular;
    @SerializedName("plural")
    @Expose
    private String plural;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("currency_code")
    @Expose
    private String currencyCode;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("active")
    @Expose
    private String active;

    protected Country(Parcel in) {
        countryId = in.readString();
        countryName = in.readString();
        fips = in.readString();
        iso2 = in.readString();
        iso3 = in.readString();
        ison = in.readString();
        internet = in.readString();
        capital = in.readString();
        mapRef = in.readString();
        singular = in.readString();
        plural = in.readString();
        currency = in.readString();
        currencyCode = in.readString();
        population = in.readString();
        title = in.readString();
        comment = in.readString();
        active = in.readString();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    /**
     *
     * @return
     *     The countryId
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     *
     * @param countryId
     *     The country_id
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     *
     * @return
     *     The countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     *
     * @param countryName
     *     The country_name
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * @return
     *     The fips
     */
    public String getFips() {
        return fips;
    }

    /**
     *
     * @param fips
     *     The fips
     */
    public void setFips(String fips) {
        this.fips = fips;
    }

    /**
     *
     * @return
     *     The iso2
     */
    public String getIso2() {
        return iso2;
    }

    /**
     *
     * @param iso2
     *     The iso2
     */
    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    /**
     *
     * @return
     *     The iso3
     */
    public String getIso3() {
        return iso3;
    }

    /**
     *
     * @param iso3
     *     The iso3
     */
    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    /**
     *
     * @return
     *     The ison
     */
    public String getIson() {
        return ison;
    }

    /**
     *
     * @param ison
     *     The ison
     */
    public void setIson(String ison) {
        this.ison = ison;
    }

    /**
     *
     * @return
     *     The internet
     */
    public String getInternet() {
        return internet;
    }

    /**
     *
     * @param internet
     *     The internet
     */
    public void setInternet(String internet) {
        this.internet = internet;
    }

    /**
     *
     * @return
     *     The capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     *
     * @param capital
     *     The capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     *
     * @return
     *     The mapRef
     */
    public String getMapRef() {
        return mapRef;
    }

    /**
     *
     * @param mapRef
     *     The map_ref
     */
    public void setMapRef(String mapRef) {
        this.mapRef = mapRef;
    }

    /**
     *
     * @return
     *     The singular
     */
    public String getSingular() {
        return singular;
    }

    /**
     *
     * @param singular
     *     The singular
     */
    public void setSingular(String singular) {
        this.singular = singular;
    }

    /**
     *
     * @return
     *     The plural
     */
    public String getPlural() {
        return plural;
    }

    /**
     *
     * @param plural
     *     The plural
     */
    public void setPlural(String plural) {
        this.plural = plural;
    }

    /**
     *
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     *     The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     *
     * @return
     *     The currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     *
     * @param currencyCode
     *     The currency_code
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     *
     * @return
     *     The population
     */
    public String getPopulation() {
        return population;
    }

    /**
     *
     * @param population
     *     The population
     */
    public void setPopulation(String population) {
        this.population = population;
    }

    /**
     *
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     *     The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     *     The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     *     The active
     */
    public String getActive() {
        return active;
    }

    /**
     *
     * @param active
     *     The active
     */
    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(countryId);
        parcel.writeString(countryName);
        parcel.writeString(fips);
        parcel.writeString(iso2);
        parcel.writeString(iso3);
        parcel.writeString(ison);
        parcel.writeString(internet);
        parcel.writeString(capital);
        parcel.writeString(mapRef);
        parcel.writeString(singular);
        parcel.writeString(plural);
        parcel.writeString(currency);
        parcel.writeString(currencyCode);
        parcel.writeString(population);
        parcel.writeString(title);
        parcel.writeString(comment);
        parcel.writeString(active);
    }

    @Override
    public String toString () {
        return getCountryName();
    }
}
