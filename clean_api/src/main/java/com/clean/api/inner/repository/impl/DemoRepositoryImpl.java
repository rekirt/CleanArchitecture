package com.clean.api.inner.repository.impl;

import android.util.Log;

import com.clean.api.inner.repository.DemoRepository;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-3-18.
 */
public class DemoRepositoryImpl implements DemoRepository {
    @Override
    public String getDemoData() {
        Log.e("test","从仓库中获取到数据");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "从网络获取到的数据";
    }
}
