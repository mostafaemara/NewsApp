package com.example.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Thread mThread= new Thread(){
            @Override
            public void run() {
          try {
              sleep(3000);
              Intent mIntent = new Intent(getApplicationContext(),MainMenu.class);
              startActivity(mIntent);
          }catch (InterruptedException e){

e.printStackTrace();

          }


            }
        };
        mThread.start();
    }
}
