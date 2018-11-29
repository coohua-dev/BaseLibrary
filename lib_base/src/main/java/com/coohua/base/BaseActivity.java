package com.coohua.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements ICView {

    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mPresenter == null) {
            mPresenter = createPresenter();
        }

        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        setContentView(layoutId());
        onInit(savedInstanceState);
    }

    /**
     * get the layout id.
     */
    protected abstract int layoutId();

    //若页面不使用mvp，则不重写此方法即可，兼容各种实际场景的变通
    protected P createPresenter() {
        return null;
    }

    /**
     * Called when doing the initialization.
     */
    protected abstract void onInit(Bundle savedInstanceState);

    @Override
    protected void onStart() {
        super.onStart();
        if (getPresenter() != null)
            getPresenter().onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    protected P getPresenter() {
        return mPresenter;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
    }


}
