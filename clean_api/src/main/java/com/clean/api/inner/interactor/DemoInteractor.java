package com.clean.api.inner.interactor;

import com.clean.api.inner.interactor.base.Interactor;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-3-19.
 */
public interface DemoInteractor extends Interactor {
    //数据加载后回调
    interface Callback {
        void onLoadSuccess(String json);
        void onLoadFailed(String error);
        void onLoadEmpty(String empty);
    }
}
