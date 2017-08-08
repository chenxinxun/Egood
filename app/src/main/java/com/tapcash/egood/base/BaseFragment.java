package com.tapcash.egood.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基础Fragment 基本操作.
 *
 * @param <T> 基类presenter
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    /** 日志. */
    public static final String TAG = BaseFragment.class.getSimpleName();

    /** Presenter. */
    protected T mPresenter;

    /** ButterKnife绑定管理. */
    protected Unbinder mUnbinder;

    /** ButterKnife绑定视图 */
    protected View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(provideViewLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        if (mPresenter != null) {
            mPresenter = null;
        }
        release();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        release();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * 布局文件layout的id.
     *
     * @return layout 对应的id.
     */
    protected abstract int provideViewLayoutId();

    /**
     * 视图的设置操作.
     */
    protected abstract void setViews();

    /**
     * 释放相关操作.
     */
    protected void release(){}

}
