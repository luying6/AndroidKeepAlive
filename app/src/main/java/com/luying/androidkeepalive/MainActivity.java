package com.luying.androidkeepalive;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            openJobService();
        } else {
            openTwoService();
        }

    }

    private void openTwoService() {
        startService(new Intent(this, LocalService.class));
        startService(new Intent(this, RemoteService.class));
    }

    private void openJobService() {

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, JobHandlerService.class);
        startService(intent);

    }
}
