package com.example.kaushal.game;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import static com.example.kaushal.game.R.id.myLayout2;

public class Main2Activity extends AppCompatActivity {
    MediaPlayer sdk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sdk = MediaPlayer.create(this, R.raw.hell);


    }

    public void race(View view) {
        Intent in = new Intent(this, Main3Activity.class);
        startActivity(in);
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sdk.pause();

    }

    @Override
    protected void onResume() {
        if (sdk != null && !sdk.isPlaying()) {
            sdk.setLooping(true);
            sdk.start();

        }
        super.onResume();

    }

}

