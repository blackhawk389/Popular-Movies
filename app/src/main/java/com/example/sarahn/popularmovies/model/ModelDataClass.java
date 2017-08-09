package com.example.sarahn.popularmovies.model;

import android.graphics.PorterDuff;
import android.util.Log;

/**
 * Created by SarahN on 8/8/2017.
 */
public class ModelDataClass {

    private String title;
    private String image;
    private Double rating;
    private String description;

    private int totalResult;


    public ModelDataClass() {}

    public String getTitle() {
        return title;
    }

//    public static ModelDataClass getInstance(){
//        if(mInstance.equals("")){
//            mInstance = new ModelDataClass();
//        }
//
//        return mInstance;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        image.replace("'\'", "''");
        image = "http://image.tmdb.org/t/p/w342//"+image;
        this.image = image;
    }
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }
}
