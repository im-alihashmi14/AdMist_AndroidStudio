package com.example.admist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    ImageView SplashImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SplashImg= (ImageView)findViewById(R.id.Splash);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.splash);
        SplashImg.startAnimation(animation);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                   sleep(3000);
                   startApp();
                   finish();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
        });
        thread.start();

    }
    public void startApp(){
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }
}
