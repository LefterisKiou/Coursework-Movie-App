package com.example.athtechmovieapp;

import java.util.Date;

public class MovieModelClass {
    String id, name, img, backImg, description, release_date;

    public MovieModelClass(String id, String name, String img, String description, String release_date, String backImg) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.description = description;
        this.release_date = release_date;
        this.backImg = backImg;
    }

    public String getDescription() {
        return description;
    }

    public String getBackImg() {
        return backImg;
    }

    public void setBackImg(String backImg) {
        this.backImg = backImg;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public MovieModelClass() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
