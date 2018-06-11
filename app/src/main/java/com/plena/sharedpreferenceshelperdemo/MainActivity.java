package com.plena.sharedpreferenceshelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferencesHelper.getDefaultSharedPreferencesHelper()
                .put("11", "111")
                .putEncryptSting("password", "123455")
                .commit();
    }
}
