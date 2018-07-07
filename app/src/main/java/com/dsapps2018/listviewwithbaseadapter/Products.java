package com.dsapps2018.listviewwithbaseadapter;

/**
 * Created by Daniel on 7/7/2018.
 */

public class Products {

    private String title, description, rating;
    private boolean checked;

    public Products(String title, String description, String rating, boolean checked) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.checked = checked;
    }

    public Products() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
