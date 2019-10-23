package com.vhd.androgeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private static int splash_time = 3000;

    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        if(mUser != null)
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent homeIntent = new Intent(MainActivity.this,homeActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }, splash_time);
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(loginIntent);
                    finish();
                }
            }, splash_time);
        }
    }
}
