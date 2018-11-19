
package com.rock.reward.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeaturedProject {

    @SerializedName("view_order")
    @Expose
    private String viewOrder;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("dynamic_image_title")
    @Expose
    private Object dynamicImageTitle;
    @SerializedName("dynamic_image_paragraph")
    @Expose
    private Object dynamicImageParagraph;
    @SerializedName("dynamic_image_image")
    @Expose
    private Object dynamicImageImage;
    @SerializedName("small_text")
    @Expose
    private Object smallText;
    @SerializedName("dynamic_slider_id")
    @Expose
    private Object dynamicSliderId;
    @SerializedName("color_picker_content")
    @Expose
    private Object colorPickerContent;
    @SerializedName("color_picker")
    @Expose
    private Object colorPicker;
    @SerializedName("link_name")
    @Expose
    private Object linkName;
    @SerializedName("link")
    @Expose
    private Object link;
    @SerializedName("project_title")
    @Expose
    private String projectTitle;
    @SerializedName("url_project_title")
    @Expose
    private String urlProjectTitle;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("project_summary")
    @Expose
    private String projectSummary;
    @SerializedName("featured_image_url")
    @Expose
    private String featuredImageUrl;

    /**
     * 
     * @return
     *     The viewOrder
     */
    public String getViewOrder() {
        return viewOrder;
    }

    /**
     * 
     * @param viewOrder
     *     The view_order
     */
    public void setViewOrder(String viewOrder) {
        this.viewOrder = viewOrder;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The dynamicImageTitle
     */
    public Object getDynamicImageTitle() {
        return dynamicImageTitle;
    }

    /**
     * 
     * @param dynamicImageTitle
     *     The dynamic_image_title
     */
    public void setDynamicImageTitle(Object dynamicImageTitle) {
        this.dynamicImageTitle = dynamicImageTitle;
    }

    /**
     * 
     * @return
     *     The dynamicImageParagraph
     */
    public Object getDynamicImageParagraph() {
        return dynamicImageParagraph;
    }

    /**
     * 
     * @param dynamicImageParagraph
     *     The dynamic_image_paragraph
     */
    public void setDynamicImageParagraph(Object dynamicImageParagraph) {
        this.dynamicImageParagraph = dynamicImageParagraph;
    }

    /**
     * 
     * @return
     *     The dynamicImageImage
     */
    public Object getDynamicImageImage() {
        return dynamicImageImage;
    }

    /**
     * 
     * @param dynamicImageImage
     *     The dynamic_image_image
     */
    public void setDynamicImageImage(Object dynamicImageImage) {
        this.dynamicImageImage = dynamicImageImage;
    }

    /**
     * 
     * @return
     *     The smallText
     */
    public Object getSmallText() {
        return smallText;
    }

    /**
     * 
     * @param smallText
     *     The small_text
     */
    public void setSmallText(Object smallText) {
        this.smallText = smallText;
    }

    /**
     * 
     * @return
     *     The dynamicSliderId
     */
    public Object getDynamicSliderId() {
        return dynamicSliderId;
    }

    /**
     * 
     * @param dynamicSliderId
     *     The dynamic_slider_id
     */
    public void setDynamicSliderId(Object dynamicSliderId) {
        this.dynamicSliderId = dynamicSliderId;
    }

    /**
     * 
     * @return
     *     The colorPickerContent
     */
    public Object getColorPickerContent() {
        return colorPickerContent;
    }

    /**
     * 
     * @param colorPickerContent
     *     The color_picker_content
     */
    public void setColorPickerContent(Object colorPickerContent) {
        this.colorPickerContent = colorPickerContent;
    }

    /**
     * 
     * @return
     *     The colorPicker
     */
    public Object getColorPicker() {
        return colorPicker;
    }

    /**
     * 
     * @param colorPicker
     *     The color_picker
     */
    public void setColorPicker(Object colorPicker) {
        this.colorPicker = colorPicker;
    }

    /**
     * 
     * @return
     *     The linkName
     */
    public Object getLinkName() {
        return linkName;
    }

    /**
     * 
     * @param linkName
     *     The link_name
     */
    public void setLinkName(Object linkName) {
        this.linkName = linkName;
    }

    /**
     * 
     * @return
     *     The link
     */
    public Object getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(Object link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The projectTitle
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     * 
     * @param projectTitle
     *     The project_title
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     * 
     * @return
     *     The urlProjectTitle
     */
    public String getUrlProjectTitle() {
        return urlProjectTitle;
    }

    /**
     * 
     * @param urlProjectTitle
     *     The url_project_title
     */
    public void setUrlProjectTitle(String urlProjectTitle) {
        this.urlProjectTitle = urlProjectTitle;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 
     * @param projectId
     *     The project_id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * 
     * @return
     *     The projectSummary
     */
    public String getProjectSummary() {
        return projectSummary;
    }

    /**
     * 
     * @param projectSummary
     *     The project_summary
     */
    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary;
    }

    /**
     * 
     * @return
     *     The featuredImageUrl
     */
    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    /**
     * 
     * @param featuredImageUrl
     *     The featured_image_url
     */
    public void setFeaturedImageUrl(String featuredImageUrl) {
        this.featuredImageUrl = featuredImageUrl;
    }

}
