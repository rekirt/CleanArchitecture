package com.clean.api.middle.presenter.base;
/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public interface Presenter {
    /**
     * 与activity或fragment的resume方法同步
     */
    void resume();

    /**
     * 与activity或fragment的pause方法同步
     */
    void pause();

    /**
     * 与activity或fragment的stop方法同步
     */
    void stop();

    /**
     * 与activity或fragment的destroy方法同步
     */
    void destroy();

}
