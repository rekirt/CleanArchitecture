package com.clean.api.inner.executor.impl;

import android.os.Handler;
import android.os.Looper;

import com.clean.api.inner.executor.MainThread;


/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public class MainThreadImpl implements MainThread {

    private static MainThread sMainThread;

    private Handler mHandler;

    private MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static MainThread getInstance() {
        if (sMainThread == null)sMainThread = new MainThreadImpl();
        return sMainThread;
    }
}
