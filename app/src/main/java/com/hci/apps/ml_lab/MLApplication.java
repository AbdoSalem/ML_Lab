package com.hci.apps.ml_lab;

import android.app.Application;
import android.content.Context;

/**
 * Created by abdo on 26/12/17.
 */

public class MLApplication extends Application{
    public static Context ctxt;

    @Override
    public void onCreate() {
        super.onCreate();
        ctxt = getApplicationContext();
    }
}
