
package com.rock.reward.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyFundingData {

    @SerializedName("total_fund")
    @Expose
    private List<String> totalFund = new ArrayList<String>();
    @SerializedName("successful_fund")
    @Expose
    private List<String> successfulFund = new ArrayList<String>();
    @SerializedName("unsuccessful_fund")
    @Expose
    private List<String> unsuccessfulFund = new ArrayList<String>();
    @SerializedName("donation_data")
    @Expose
    private List<MyDonations> donationData = new ArrayList<MyDonations>();
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("total_row_display")
    @Expose
    private Integer totalRowDisplay;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    /**
     * 
     * @return
     *     The totalFund
     */
    public List<String> getTotalFund() {
        return totalFund;
    }

    /**
     * 
     * @param totalFund
     *     The total_fund
     */
    public void setTotalFund(List<String> totalFund) {
        this.totalFund = totalFund;
    }

    /**
     * 
     * @return
     *     The successfulFund
     */
    public List<String> getSuccessfulFund() {
        return successfulFund;
    }

    /**
     * 
     * @param successfulFund
     *     The successful_fund
     */
    public void setSuccessfulFund(List<String> successfulFund) {
        this.successfulFund = successfulFund;
    }

    /**
     * 
     * @return
     *     The unsuccessfulFund
     */
    public List<String> getUnsuccessfulFund() {
        return unsuccessfulFund;
    }

    /**
     * 
     * @param unsuccessfulFund
     *     The unsuccessful_fund
     */
    public void setUnsuccessfulFund(List<String> unsuccessfulFund) {
        this.unsuccessfulFund = unsuccessfulFund;
    }

    /**
     * 
     * @return
     *     The donationData
     */
    public List<MyDonations> getDonationData() {
        return donationData;
    }

    /**
     * 
     * @param donationData
     *     The donation_data
     */
    public void setDonationData(List<MyDonations> donationData) {
        this.donationData = donationData;
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

}
