package com.clean.api.middle.presenter.impl;

import com.clean.api.inner.executor.Executor;
import com.clean.api.inner.executor.MainThread;
import com.clean.api.inner.interactor.DemoInteractor;
import com.clean.api.inner.interactor.impl.DemoInteractorImpl;
import com.clean.api.inner.repository.DemoRepository;
import com.clean.api.middle.presenter.MainPresenter;
import com.clean.api.middle.presenter.base.AbstractPresenter;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter,DemoInteractor.Callback {

    private MainPresenter.View mView;
    private DemoRepository mRepository;
    public MainPresenterImpl(Executor executor,MainThread mainThread,View view,DemoRepository repository) {
        super(executor, mainThread);
        mView = view;
        mRepository = repository;
    }

    @Override
    public void resume() {
        mView.showProgress();
        //获取数据
        DemoInteractorImpl interactor = new DemoInteractorImpl(mExecutor,mMainThread,this,mRepository);
        interactor.execute();
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onLoadSuccess(String json) {
        mView.hideProgress();
        mView.showSuccess(json);
    }

    @Override
    public void onLoadFailed(String error) {
        mView.hideProgress();
        mView.showFail(error);
    }

    @Override
    public void onLoadEmpty(String empty) {
        mView.hideProgress();
        mView.showEmpty(empty);
    }
}
