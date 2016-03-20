package com.clean.api.inner.executor;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public interface MainThread {
    void post(final Runnable runnable);
}
