package com.example.admin.sheradelemanttrangaction;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by  mukesh swami
 */
public class ApplicationLifecycleHandler implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    private static final String TAG = ApplicationLifecycleHandler.class.getSimpleName();
    public static boolean isInBackground = false;

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.e(TAG, "app Activity  Created ");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.e(TAG, "app Activity start  ");
    }

    @Override
    public void onActivityResumed(Activity activity) {

        if (isInBackground) {
            Log.d(TAG, "app went to foreground");
            isInBackground = false;
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.e(TAG, "app Activity Paused ");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.e(TAG, "app Activity Stoped ");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.e(TAG, "app Save Instance ");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.e(TAG, "app Destoryed ");
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        Log.e(TAG, "app Rotade ");
    }

    @Override
    public void onLowMemory() {
        Log.e(TAG, "app memory low ");
    }

    @Override
    public void onTrimMemory(int i) {
        if (i == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            Log.d(TAG, "app went to background");
            isInBackground = true;
        }
    }
}