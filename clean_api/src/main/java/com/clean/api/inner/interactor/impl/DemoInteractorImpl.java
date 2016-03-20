package com.clean.api.inner.interactor.impl;

import com.clean.api.inner.executor.Executor;
import com.clean.api.inner.executor.MainThread;
import com.clean.api.inner.interactor.DemoInteractor;
import com.clean.api.inner.interactor.base.AbstractInteractor;
import com.clean.api.inner.repository.DemoRepository;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public class DemoInteractorImpl extends AbstractInteractor implements DemoInteractor {

    private Callback mCallback;
    private DemoRepository mRepository;

    public DemoInteractorImpl(Executor threadExecutor, MainThread mainThread, Callback callback, DemoRepository repository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mRepository = repository;
    }

    private void postError(final String error){
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onLoadFailed(error);
            }
        });
    }

    private void postSuccess(final  String json){
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onLoadSuccess(json);
            }
        });
    }

    private void postEmpty(){
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onLoadEmpty("没有数据");
            }
        });
    }


    @Override
    public void run() {
        String data = mRepository.getDemoData();
        if(null==data){
            postError("重试");
            return;
        }
        if(null!=data && data.length()==0){
            postEmpty();
            return;
        }
        if(null!=data && data.length()!=0){
            postSuccess(data);
            return;
        }
    }
}
