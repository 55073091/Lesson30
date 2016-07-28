package com.hsj.example.screenadapterdemo02;

import android.app.Application;

/**
 * Created by hsjwcf on 16/7/28.
 */
public class MyApp extends Application {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
