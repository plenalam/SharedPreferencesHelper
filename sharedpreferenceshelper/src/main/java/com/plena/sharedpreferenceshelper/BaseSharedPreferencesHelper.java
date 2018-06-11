package com.plena.sharedpreferenceshelper;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.StringRes;
import android.text.TextUtils;

/**
 * Copyright © 1997 - 2018 Plena. All Rights Reserved.
 * Created by Plena on 2018/6/11.
 * Describe：
 */
public abstract class BaseSharedPreferencesHelper {
    private SharedPreferences sharedPreferences;
    private int mode = Context.MODE_PRIVATE;
    private SharedPreferences.Editor editor;
    protected static Context context;
    protected static String DEFAULTNAME = "defaultSharedPreferencesHelper";
    /**
     * multiple of 16
     */
    protected static String KEYSTORE = "abc@123#efgh4567";

    public abstract void initDefaultValue();

    public BaseSharedPreferencesHelper(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, mode);
        editor = sharedPreferences.edit();
    }

    public BaseSharedPreferencesHelper put(@StringRes int key, Object value) {
        return put(context.getResources().getString(key), value);
    }

    public BaseSharedPreferencesHelper put(String key, Object value) {
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else {
            editor.putString(key, value.toString());
        }
        return this;
    }

    public BaseSharedPreferencesHelper put(String key, int value) {
        editor.putInt(key, value);
        return this;
    }

    public BaseSharedPreferencesHelper put(String key, boolean value) {
        editor.putBoolean(key, value);
        return this;
    }

    public BaseSharedPreferencesHelper put(String key, float value) {
        editor.putFloat(key, value);
        return this;
    }

    public BaseSharedPreferencesHelper put(String key, long value) {
        editor.putLong(key, value);
        return this;
    }


    public BaseSharedPreferencesHelper putEncryptSting(String key, String value) {
        String encryptText = null;
        try {
            encryptText = KeyStoreTool.Encrypt(value);
            if (!TextUtils.isEmpty(encryptText)) {
                editor.putString(key, encryptText);
            }
            return this;
        } catch (Exception e) {
        }
        editor.putString(key, encryptText);
        return this;
    }

    public void apply() {
        if (editor != null) {
            editor.apply();
        }
    }

    public void commit() {
        if (editor != null) {
            editor.commit();
        }
    }

    public Object get(@StringRes int key, Object defaultObject) {
        return get(context.getResources().getString(key), defaultObject);
    }

    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public float getFloat(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public long getLong(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }


    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sharedPreferences.getInt(key, (int) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sharedPreferences.getFloat(key, (float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sharedPreferences.getLong(key, (long) defaultObject);
        }
        return null;
    }

    public String getDecryptSting(String key, String defaultStr) {
        String decryptStr = sharedPreferences.getString(key, defaultStr);
        try {
            decryptStr = KeyStoreTool.Decrypt(decryptStr);
            if (!TextUtils.isEmpty(decryptStr)) {
                return decryptStr;
            }
        } catch (Exception e) {
        }
        return defaultStr;
    }
}