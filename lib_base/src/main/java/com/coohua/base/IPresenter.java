package com.coohua.base;

/**
 * @author LeoWang
 *         Create on 2017/9/8
 */

public interface IPresenter<V extends ICView> {

    void attachView(V cView);

    void detachView(boolean retainView);

    V getCView();

    boolean isViewAttached();

    void checkViewAttached();

    void onStart();

    void onStop();

    void onDestroy();
}
