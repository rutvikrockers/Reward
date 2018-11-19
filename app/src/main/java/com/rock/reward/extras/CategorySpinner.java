package com.rock.reward.extras;

/**
 * Created by rocku27 on 29/8/16.
 */
public class CategorySpinner {

    private int categoryId;
    private String categoryName;

    public CategorySpinner(int id, String categoryName){
        this.categoryId = id;
        this.categoryName=categoryName;
    }

    public String toString(){
        return categoryName;

    }
}
