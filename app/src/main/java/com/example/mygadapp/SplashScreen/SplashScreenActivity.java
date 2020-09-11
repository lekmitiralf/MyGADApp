package com.example.mygadapp.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mygadapp.MainActivity;
import com.example.mygadapp.R;

import android.os.Handler;

import static java.lang.Thread.sleep;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getSupportActionBar().hide();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

       // Handler hand = new Handler();
      //  hand.postDelayed({
      //           Intent intent = new Intent(this,homeActivity::)
     //   })

    }
}