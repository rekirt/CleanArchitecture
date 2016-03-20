package com.clean.api.inner.interactor.impl;

import com.clean.api.inner.executor.Executor;
import com.clean.api.inner.executor.MainThread;
import com.clean.api.inner.interactor.DataBaseInteractor;
import com.clean.api.inner.interactor.base.AbstractInteractor;
import com.clean.api.inner.interactor.base.Interactor;
import com.clean.api.inner.repository.DataBaseRepository;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-3-19.
 */
public class DataBaseInteractorImpl extends AbstractInteractor implements DataBaseInteractor {

    private Callback mCallback;
    private DataBaseRepository mRepository;

    public DataBaseInteractorImpl(Executor threadExecutor, MainThread mainThread,Callback callback,DataBaseRepository repository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mRepository = repository;
    }

    @Override
    public void run() {

    }
}
