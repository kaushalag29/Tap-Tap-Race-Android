package com.example.kaushal.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import static android.media.AudioManager.STREAM_MUSIC;
import static com.example.kaushal.game.R.drawable.original;

public class MainActivity extends AppCompatActivity {
public boolean flag;

    MediaPlayer sdk;

    public static final String SERVICECMD = "com.android.music.musicservicecommand";
    public static final String CMDNAME = "command";
    public static final String CMDSTOP = "stop";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        AudioManager mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        if(mAudioManager.isMusicActive()) {
            Intent i = new Intent(SERVICECMD);
            i.putExtra(CMDNAME , CMDSTOP );
            MainActivity.this.sendBroadcast(i);
        }
       sdk=MediaPlayer.create(this,R.raw.sherlock);


        flag=true;
    }


public void startGame(View view)
{
    Intent i=new Intent(this,Main2Activity.class);
    startActivity(i);
}
    public void sound(View view){

        TextView a=(TextView) findViewById(R.id.myText2);

        if(flag==false)
        {
            sdk.setLooping(true);
            sdk.start();
            a.setText("Pause");
            flag=true;
        }
        else
        {
            sdk.pause();

            a.setText("Play");
            flag=false;
        }




        }


    public void quitGame(View V){
        finish();
        System.exit(0);
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
        flag=false;
        TextView b=(TextView) findViewById(R.id.myText2);
        b.setText("Play");


    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView b=(TextView) findViewById(R.id.myText2);
        b.setText("Pause");
        if (sdk != null && !sdk.isPlaying()) {
            sdk.setLooping(true);
            sdk.start();

        }


    }
}
