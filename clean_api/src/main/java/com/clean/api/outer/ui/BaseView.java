package com.clean.api.outer.ui;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public interface BaseView {

    void showProgress();

    void hideProgress();

    void showFail(String error);

    void showSuccess(String json);

}
