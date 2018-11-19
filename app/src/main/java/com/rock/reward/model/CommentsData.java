package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rocku27 on 16/8/16.
 */
public class CommentsData {

    @SerializedName("comments")
    @Expose
    private List<Comment> comments = new ArrayList<Comment>();

    @SerializedName("total_count")
    @Expose
    private Integer totalCommentsCount;

    @SerializedName("offset")
    @Expose
    private Integer offset;

    /**
     *
     * @return
     *     The comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     *     The comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     *     The totalCommentsCount
     */
    public Integer getTotalCommentsCount() {
        return totalCommentsCount;
    }

    /**
     *
     * @param totalCommentsCount
     *     The total_comments_count
     */
    public void setTotalCommentsCount(Integer totalCommentsCount) {
        this.totalCommentsCount = totalCommentsCount;
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
