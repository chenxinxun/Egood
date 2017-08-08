package com.tapcash.egood.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基础Activity
 *
 * @param <T>
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    /** Presenter. */
    protected T mPresenter;

    /** ButterKnife绑定管理. */
    protected Unbinder mUnbinder;

    /** Activity 实例. */
    protected Activity mActivity;

    /** ButterKnife绑定视图 */
    protected View mContentView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        if (provideContentViewId()!= 0){
            mContentView = this.getLayoutInflater().inflate(provideContentViewId(), null);
            setContentView(mContentView);
        }
        mUnbinder = ButterKnife.bind(this, mContentView);

        init();
        getExtraDatas();
        initToolbar();

    }


    /**
     * 布局文件layout的id.
     *
     * @return layout 对应的id.
     */
    protected abstract int provideContentViewId();

    /**
     * 初始化操作.
     */
    protected abstract void init();


    /**
     * 获取 Extra 数据.
     */
    protected void getExtraDatas() {
    }

    /**
     * 初始化Toolbar.
     */
    protected void initToolbar() {
    }


}
