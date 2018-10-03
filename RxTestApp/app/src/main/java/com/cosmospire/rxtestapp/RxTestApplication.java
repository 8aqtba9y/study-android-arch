package com.cosmospire.rxtestapp;

import android.app.Application;
import android.support.annotation.NonNull;

import com.cosmospire.rxtestapp.datamodel.DataModel;
import com.cosmospire.rxtestapp.datamodel.IDataModel;
import com.cosmospire.rxtestapp.schedulers.ISchedulerProvider;
import com.cosmospire.rxtestapp.schedulers.SchedulerProvider;

public class RxTestApplication extends Application {

    @NonNull
    private final IDataModel mDataModel;

    public RxTestApplication() {
        mDataModel = new DataModel();
    }

    @NonNull
    public IDataModel getDataModel() {
        return mDataModel;
    }

    @NonNull
    public ISchedulerProvider getSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

    @NonNull
    public MainViewModel getViewModel() {
        return new MainViewModel(getDataModel(), getSchedulerProvider());
    }

}
