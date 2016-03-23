package com.example.wasabi.firebasechatlab;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Wasabi on 3/23/2016.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
