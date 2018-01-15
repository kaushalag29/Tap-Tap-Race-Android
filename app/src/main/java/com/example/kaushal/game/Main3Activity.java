package com.example.kaushal.game;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.gesture.Gesture;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Main3Activity extends AppCompatActivity {
MediaPlayer sdk,pk;
    ImageView img, img2;

int c=1;
    public int c1 = 0, c2 = 0;

    //600 is winner
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sdk= MediaPlayer.create(this,R.raw.animal);
        pk= MediaPlayer.create(this,R.raw.count);


        img2 = (ImageView) findViewById(R.id.imageView);

        img = (ImageView) findViewById(R.id.imageView3);




    }



    public void Player2(View view) {


                float x1 = img2.getX();
                float y1 = img2.getY();



                img2.setY(y1 - 40);




c2+=5;


check();

    }

    public void Player1(View view) {



                float x = img.getX();
                float y = img.getY();



                img.setY(y - 40);



c1+=5;
check();

    }
    public void check()
    {
        if((c1==180)&&(c2!=180))
        {
            Button a=(Button) findViewById(R.id.button1);
            a.setEnabled(false);
            Button b=(Button) findViewById(R.id.button2);
            b.setEnabled(false);
            TextView my=(TextView) findViewById(R.id.myText);
            my.setText("Winner Is Player 1");
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                   System.exit(0);

                }
            }, 8000);

        }

        else if((c2==180)&&(c1!=180))
        {
            Button b=(Button) findViewById(R.id.button2);
            b.setEnabled(false);
            Button a=(Button) findViewById(R.id.button1);
            a.setEnabled(false);
            TextView my=(TextView) findViewById(R.id.myText);
            my.setText("Winner Is Player 2");
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    System.exit(0);
                }
            }, 8000);

        }

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
        final Handler handler = new Handler();
        final TextView textView = (TextView) findViewById(R.id.textView2);
        final java.util.concurrent.atomic.AtomicInteger n = new AtomicInteger(3);
        final Runnable counter = new Runnable() {
            @Override
            public void run() {
                textView.setText(Integer.toString(n.get()));
                if (n.getAndDecrement() >= 1)
                    handler.postDelayed(this, 1000);
                else {


                    textView.setVisibility(View.GONE);
                    Button b = (Button) findViewById(R.id.button2);
                    b.setEnabled(true);
                    Button a = (Button) findViewById(R.id.button1);
                    a.setEnabled(true);
                    // start the game
                }
            }

        };

        handler.postDelayed(counter, 1000);


        if(c==1) {
            Button bc = (Button) findViewById(R.id.button2);
            bc.setEnabled(false);
            Button ac = (Button) findViewById(R.id.button1);
            ac.setEnabled(false);
            c++;
            pk.start();
        }


        super.onResume();
      }


}
