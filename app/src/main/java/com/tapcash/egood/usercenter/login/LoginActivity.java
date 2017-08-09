package com.tapcash.egood.usercenter.login;

import android.widget.EditText;
import android.widget.Toast;

import com.tapcash.egood.R;
import com.tapcash.egood.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {
    @BindView(R.id.user_name)
    EditText mUserName;

    @BindView(R.id.user_password)
    EditText mUserPassword;

    @Override
    protected int provideContentViewId() {
        return R.layout.layout_login;
    }

    @Override
    protected void init() {
        mPresenter = new LoginPresenter(this);
    }


    @OnClick(R.id.user_login)
    void login(){
        mPresenter.login(mUserName.getText().toString().trim(), mUserPassword.getText().toString().trim());
    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFailure() {
        Toast.makeText(this, "showFailure", Toast.LENGTH_LONG).show();
    }
}
