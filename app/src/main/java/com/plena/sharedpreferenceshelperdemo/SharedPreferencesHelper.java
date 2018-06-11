package com.plena.sharedpreferenceshelperdemo;

import android.content.Context;
import android.content.SharedPreferences;

import com.plena.sharedpreferenceshelper.BaseSharedPreferencesHelper;

/**
 * Copyright © 1997 - 2018 Plena. All Rights Reserved.
 * Created by Plena on 2018/6/11.
 * Describe：
 */
public class SharedPreferencesHelper extends BaseSharedPreferencesHelper {
    private static SharedPreferencesHelper defaultSharedPreferencesHelper;

    @Override
    public void initDefaultValue() {
        DEFAULTNAME = "mydefaultname";
        KEYSTORE = "1234567887654321";
    }

    public SharedPreferencesHelper(Context context, String name) {
        super(context, name);
    }

    public static SharedPreferencesHelper getDefaultSharedPreferencesHelper() {
        context = MyApplication.getInstance();
        return new SharedPreferencesHelper(MyApplication.getInstance(), DEFAULTNAME);
    }
}

