package com.rock.reward.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rocku27 on 4/8/16.
 */
public class ProjectCategories {

    @SerializedName("project_category_id")
    private int projectCategoryId;

    @SerializedName("language_id")
    private int languageId;

    @SerializedName("url_category_title")
    private String urlCategoryTitle;

    @SerializedName("image")
    private String image;

    @SerializedName("active")
    private int status;

    @SerializedName("parent_project_category_id")
    private int parentProjectCategoryId;

    @SerializedName("project_category_name")
    private String projectCategoryName;

    @SerializedName("project_category_desc")
    private String projectCategoryDescription;

    @SerializedName("icon_view")
    private String iconView;

    @SerializedName("category_icon_url")
    private String categoryIconUrl;

    @SerializedName("category_image_url")
    private String categoryImageUrl;


    public void setProjectCategoryId(int ProjectCategoryId){
        projectCategoryId=ProjectCategoryId;
    }
    public void setLanguageId(int LanguageId){
        languageId=LanguageId;
    }
    public void setUrlCategoryTitle(String UrlCategoryTitle){
        urlCategoryTitle=UrlCategoryTitle;
    }
    public void setImage(String Image){
        image=Image;
    }
    public void setStatus(int Status){
        status=Status;
    }
    public void setParentProjectCategoryId(int ParentProjectCategoryId){
        parentProjectCategoryId=ParentProjectCategoryId;
    }
    public void setProjectCategoryName(String ProjectCategoryName){
        projectCategoryName=ProjectCategoryName;
    }
    public void setProjectCategoryDescription(String ProjectCategoryDescription){
        projectCategoryDescription=ProjectCategoryDescription;
    }
    public void setIconView(String IconView){
        iconView=IconView;
    }
    public void setCategoryIconUrl(String CategoryIconUrl){
        categoryIconUrl=CategoryIconUrl;
    }
    public void setCategoryImageUrl(String CategoryImageUrl){
        categoryImageUrl=CategoryImageUrl;
    }

    public int getProjectCategoryId(){
        return projectCategoryId;
    }
    public int getLanguageId(){
        return languageId;
    }
    public String getUrlCategoryTitle(){
        return urlCategoryTitle;
    }
    public String getImage(){
        return image;
    }
    public int getStatus(){
        return status;
    }
    public int getParentProjectCategoryId(){
        return parentProjectCategoryId;
    }
    public String getProjectCategoryName(){
        return projectCategoryName;
    }
    public String getProjectCategoryDescription(){
        return projectCategoryDescription;
    }
    public String getIconView(){
        return iconView;
    }
    public String getCategoryIconUrl(){
        return categoryIconUrl;
    }
    public String getCategoryImageUrl(){
        return categoryImageUrl;
    }
}
