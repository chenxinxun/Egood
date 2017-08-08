package com.tapcash.egood.base;

/**
 * 基础类按
 * @param <T> presenter 类型
 */
public interface BaseView<T> {

    /**
     * view中注入Presenter.
     * @param presenter Presenter
     */
    void setPresenter(T presenter);
}