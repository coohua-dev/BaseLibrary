package com.coohua.base;

import android.content.Context;

import androidx.annotation.Nullable;

/**
 * @author LeoWang
 *         Create on 2017/9/8
 */

public abstract class BasePresenter<V extends ICView> implements IPresenter<V> {
    protected Context mContext;
    private V mCView;


    @Override
    public void attachView(V cView) {
        mCView = cView;
        mContext = (Context)mCView;
    }

    @Override
    public void detachView(boolean retainView) {
        mCView = null;
        mContext = null;
    }

    @Override
    @Nullable
    public V getCView() {
        return mCView;
    }

    @Override
    public boolean isViewAttached() {
        return null != mCView;
    }

    @Override
    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new RuntimeException("Please call Presenter.attach<MvpView> before requesting "
                    + "data to the Presenter");
        }
    }
}
