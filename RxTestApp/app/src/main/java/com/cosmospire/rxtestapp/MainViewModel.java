package com.cosmospire.rxtestapp;

import android.support.annotation.NonNull;

import com.cosmospire.rxtestapp.datamodel.IDataModel;
import com.cosmospire.rxtestapp.model.Language;
import com.cosmospire.rxtestapp.schedulers.ISchedulerProvider;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * View model for the main activity.
 */
public class MainViewModel {

    @NonNull
    private final IDataModel mDataModel;

    @NonNull
    private final BehaviorSubject<Language> mSelectedLanguage = BehaviorSubject.create();

    @NonNull
    private final ISchedulerProvider mSchedulerProvider;

    public MainViewModel(@NonNull final IDataModel dataModel,
                         @NonNull final ISchedulerProvider schedulerProvider) {
        mDataModel = dataModel;
        mSchedulerProvider = schedulerProvider;
    }

    @NonNull
    public Observable<String> getGreeting() {
        return mSelectedLanguage
                .observeOn(mSchedulerProvider.computation())
                .map(Language::getCode)
                .flatMap(mDataModel::getGreetingByLanguageCode);
    }

    @NonNull
    public Observable<List<Language>> getSupportedLanguages() {
        return mDataModel.getSupportedLanguages();
    }

    public void languageSelected(@NonNull final Language language) {
        mSelectedLanguage.onNext(language);
    }

}