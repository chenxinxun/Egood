package com.tapcash.egood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.crash.FirebaseCrash;
import com.tapcash.egood.base.RetrofitService;
import com.tapcash.egood.usercenter.User;
import com.tapcash.egood.usercenter.UserService;
import com.tapcash.egood.usercenter.login.LoginActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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


    }

    public void jumpTo(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
