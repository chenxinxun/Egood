package com.tapcash.egood.usercenter.login;

import com.tapcash.egood.base.BasePresenter;
import com.tapcash.egood.base.BaseView;

/**
 * Created by TC10795 on 2017/8/9.
 */
public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void showSuccess();
        void showFailure(String message);
    }

    /**
     * presenter
     */
    interface Presenter extends BasePresenter {

        void login(String userName, String passWord);

    }
}
