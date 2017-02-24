package com.vb.apptempl.base;

/**
 * Created by Administrator on 2017/2/23 0023.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();

}
