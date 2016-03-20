package com.clean.api.middle.presenter;


import com.clean.api.middle.presenter.base.Presenter;
import com.clean.api.outer.ui.BaseView;

public interface MainPresenter extends Presenter {
    interface View extends BaseView{
        void showEmpty(String empty);
    }

    @Override
    void resume();
}
