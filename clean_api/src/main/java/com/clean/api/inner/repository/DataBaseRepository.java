package com.clean.api.inner.repository;


import com.clean.api.inner.model.SampleModel;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-2-25.
 */
public interface DataBaseRepository {

    boolean insert(SampleModel model);

    boolean update(SampleModel model);

    SampleModel get(Object id);

    boolean delete(SampleModel model);
}
