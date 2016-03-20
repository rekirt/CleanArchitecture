package com.clean.api.inner.interactor.impl;

import com.clean.api.inner.executor.Executor;
import com.clean.api.inner.executor.MainThread;
import com.clean.api.inner.interactor.NetworkInteractor;
import com.clean.api.inner.interactor.base.AbstractInteractor;
import com.clean.api.inner.repository.NetworkRepository;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-3-19.
 */
public class NetworkInteractorImpl extends AbstractInteractor implements NetworkInteractor {

    private Callback mCallback;
    private NetworkRepository mRepository;

    public NetworkInteractorImpl(Executor threadExecutor, MainThread mainThread,Callback callback,NetworkRepository repository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mRepository = repository;

    }

    @Override
    public void run() {

    }
}
