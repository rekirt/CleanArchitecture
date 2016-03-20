package com.clean.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.clean.api.inner.executor.Executor;
import com.clean.api.inner.executor.MainThread;
import com.clean.api.inner.executor.impl.MainThreadImpl;
import com.clean.api.inner.executor.impl.ThreadExecutor;
import com.clean.api.inner.repository.impl.DemoRepositoryImpl;
import com.clean.api.middle.presenter.MainPresenter;
import com.clean.api.middle.presenter.impl.MainPresenterImpl;


public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    TextView tv_success;
    TextView tv_error;
    ProgressBar pb_loading;
    MainPresenterImpl mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_success = (TextView)findViewById(R.id.tv_success);
        tv_error = (TextView)findViewById(R.id.tv_error);
        pb_loading = (ProgressBar)findViewById(R.id.pb_loading);
        Executor executor = ThreadExecutor.getInstance();
        DemoRepositoryImpl repository = new DemoRepositoryImpl();
        MainThread mainThread = MainThreadImpl.getInstance();
        mainPresenter = new MainPresenterImpl(executor,mainThread,this,repository);

        tv_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_error.setVisibility(View.GONE);
                mainPresenter.resume();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.resume();
    }

    @Override
    public void showProgress() {
        pb_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pb_loading.setVisibility(View.GONE);
    }

    @Override
    public void showFail(String error) {
        tv_error.setVisibility(View.VISIBLE);
        tv_error.setText(error);
    }

    @Override
    public void showSuccess(String json) {
        tv_success.setVisibility(View.VISIBLE);
        tv_success.setText(json);
    }


    @Override
    public void showEmpty(String empty) {
        tv_success.setVisibility(View.VISIBLE);
        tv_success.setText(empty);
    }
}
