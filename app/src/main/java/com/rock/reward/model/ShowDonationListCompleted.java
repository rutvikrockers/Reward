
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowDonationListCompleted {

    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("project_currency_code")
    @Expose
    private String projectCurrencyCode;
    @SerializedName("project_currency_symbol")
    @Expose
    private String projectCurrencySymbol;

    /**
     * 
     * @return
     *     The total
     */
    public String getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The projectCurrencyCode
     */
    public String getProjectCurrencyCode() {
        return projectCurrencyCode;
    }

    /**
     * 
     * @param projectCurrencyCode
     *     The project_currency_code
     */
    public void setProjectCurrencyCode(String projectCurrencyCode) {
        this.projectCurrencyCode = projectCurrencyCode;
    }

    /**
     * 
     * @return
     *     The projectCurrencySymbol
     */
    public String getProjectCurrencySymbol() {
        return projectCurrencySymbol;
    }

    /**
     * 
     * @param projectCurrencySymbol
     *     The project_currency_symbol
     */
    public void setProjectCurrencySymbol(String projectCurrencySymbol) {
        this.projectCurrencySymbol = projectCurrencySymbol;
    }

}
