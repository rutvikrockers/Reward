
package com.rock.reward.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatesData {

    @SerializedName("updates")
    @Expose
    private List<Update> updates = new ArrayList<Update>();
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
     *     The updates
     */
    public List<Update> getUpdates() {
        return updates;
    }

    /**
     * 
     * @param updates
     *     The updates
     */
    public void setUpdates(List<Update> updates) {
        this.updates = updates;
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
