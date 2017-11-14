package com.zackmatthews.realitycheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ZombieReceiver extends BroadcastReceiver {

    public static final String ZOMBIE_COUNT_KEY = "ZOMBIE_COUNT";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(context == null) return;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if(prefs == null) return;
        prefs.edit().putInt(ZOMBIE_COUNT_KEY, prefs.getInt(ZOMBIE_COUNT_KEY, 0) + 1).apply();
    }
}
