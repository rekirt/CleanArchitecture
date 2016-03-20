package com.clean.api.inner.interactor.base;

import com.clean.api.inner.executor.Executor;
import com.clean.api.inner.executor.MainThread;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public abstract class AbstractInteractor implements Interactor {

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public AbstractInteractor(Executor threadExecutor, MainThread mainThread) {
        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }

    public abstract void run();

    public void cancel() {
        mIsCanceled = true;
        mIsRunning = false;
    }

    public boolean isRunning() {
        return mIsRunning;
    }

    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }

    public void execute() {
        this.mIsRunning = true;
        mThreadExecutor.execute(this);
    }

}
