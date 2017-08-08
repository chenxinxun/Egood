package com.tapcash.egood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.crash.FirebaseCrash;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            int i = 0;
            i = 10/i;
        }catch (Exception e) {
            FirebaseCrash.report(new Exception("Exception error"));
        }

        int j = 10/0;
    }
}
