package com.clean.api.inner.executor;


import com.clean.api.inner.interactor.base.AbstractInteractor;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public interface Executor {
    void execute(final AbstractInteractor interactor);
}
