package com.example.admin.sheradelemanttrangaction;

import android.app.Application;

/**
 * Created by admin on 01-03-2017.
 */

public class AppClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationLifecycleHandler handler = new ApplicationLifecycleHandler();
        registerActivityLifecycleCallbacks(handler);
        registerComponentCallbacks(handler);


    }
}
