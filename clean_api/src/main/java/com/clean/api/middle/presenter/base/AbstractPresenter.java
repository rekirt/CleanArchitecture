package com.clean.api.middle.presenter.base;


import com.clean.api.inner.executor.Executor;
import com.clean.api.inner.executor.MainThread;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
