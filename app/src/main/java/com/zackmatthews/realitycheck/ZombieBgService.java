package com.zackmatthews.realitycheck;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class ZombieBgService extends Service {
    ZombieReceiver receiver;
    public ZombieBgService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            receiver = new ZombieReceiver();
            registerReceiver(receiver, new IntentFilter(Intent.ACTION_SCREEN_ON));
        }
        catch(Throwable e){
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
