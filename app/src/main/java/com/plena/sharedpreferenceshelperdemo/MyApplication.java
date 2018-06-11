package com.plena.sharedpreferenceshelperdemo;

import android.app.Application;

/**
 * Copyright © 1997 - 2018 Plena. All Rights Reserved.
 * Created by Plena on 2018/6/11.
 * Describe：
 */
public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    private static MyApplication application;

    public static MyApplication getInstance() {
        return application;
    }
}