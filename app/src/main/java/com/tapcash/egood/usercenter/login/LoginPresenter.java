package com.tapcash.egood.usercenter.login;


import com.tapcash.egood.base.RetrofitService;
import com.tapcash.egood.usercenter.User;
import com.tapcash.egood.usercenter.UserService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TC10795 on 2017/8/9.
 */
public class LoginPresenter implements LoginContract.Presenter {
    /** 注入view 到presenter中. */
    private final LoginContract.View mView;

    public LoginPresenter(LoginContract.View view){
        mView = view;
    }


    @Override
    public void login(String userName, String passWord) {
        UserService service = RetrofitService.getInstance().createApi(UserService.class);
        service.login(new User(userName, passWord))               //获取Observable对象
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(Schedulers.io())         //请求完成后在io线程中执行
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new Observer<User>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                        mView.showFailure();
                    }

                    @Override
                    public void onComplete() {
                        mView.showSuccess();
                    }
                });
    }
}
