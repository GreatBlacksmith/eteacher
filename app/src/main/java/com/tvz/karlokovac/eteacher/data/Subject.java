package com.tvz.karlokovac.eteacher.data;

import android.graphics.drawable.Drawable;

public class Subject {
    private final String name;
    private final String average;
    private final Drawable image;

    public Subject() {
        this.name = "Test";
        this.average = "4.5";
        this.image= null;
    }

    public Subject(String name, String avarage, Drawable image) {
        this.name = name;
        this.average = avarage;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAverage() {
        return average;
    }

    public Drawable getImage() {
        return image;
    }
}
