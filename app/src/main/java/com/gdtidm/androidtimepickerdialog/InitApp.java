package com.gdtidm.androidtimepickerdialog;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class InitApp extends Application {

    public static final String NIGHT_MODE       =   "NIGHT_MODE";
    private boolean isNightModeEnabled          =   false;
    private static InitApp singleton    =   null;

    public static InitApp getInstance() {
        if (singleton == null) {
            singleton = new InitApp();
        }
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton                   =   this;
        SharedPreferences mPrefs    =   PreferenceManager.getDefaultSharedPreferences(InitApp.this);
        this.isNightModeEnabled     =   mPrefs.getBoolean(NIGHT_MODE, false);
    }

    public boolean isNightModeEnabled() {
        return isNightModeEnabled;
    }

    public void setIsNightModeEnabled(boolean isNightModeEnabled) {
        this.isNightModeEnabled = isNightModeEnabled;

        SharedPreferences mPrefs        =   PreferenceManager.getDefaultSharedPreferences(InitApp.this);
        SharedPreferences.Editor editor =   mPrefs.edit();
        editor.putBoolean(NIGHT_MODE, isNightModeEnabled);
        editor.apply();
    }
}
