package com.zackmatthews.realitycheck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private SharedPreferences pref;
    private Intent zombieServiceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        setZombieCount();
        findViewById(R.id.start_service_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(zombieServiceIntent == null){
                    zombieServiceIntent = new Intent(getApplicationContext(), ZombieBgService.class);
                }
                startService(zombieServiceIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setZombieCount();
    }

    private void setZombieCount(){
        TextView zombieCount = findViewById(R.id.tv_zombieCount);
        if(zombieCount == null) return;
        if(pref == null) return;
        zombieCount.setText(String.format(getString(R.string.zombie_text), pref.getInt(ZombieReceiver.ZOMBIE_COUNT_KEY, 0)));
    }

}
