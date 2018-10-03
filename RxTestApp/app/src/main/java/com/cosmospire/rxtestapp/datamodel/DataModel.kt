package com.cosmospire.rxtestapp.datamodel

import java.util.Arrays
import io.reactivex.Observable

import com.cosmospire.rxtestapp.model.Language
import com.cosmospire.rxtestapp.model.Language.LanguageCode

class DataModel(): IDataModel {

    override fun getSupportedLanguages(): Observable<List<Language>> {
        return Observable.fromCallable( this::getLanguages )
    }

    override fun getGreetingByLanguageCode(code: LanguageCode): Observable<String> {
        when (code) {
            Language.LanguageCode.DE -> return Observable.just("Guten Tag!")
            Language.LanguageCode.EN -> return Observable.just("Hello!")
            Language.LanguageCode.HR -> return Observable.just("Zdravo!")
            else -> return Observable.empty()
        }
    }

    private fun getLanguages(): List<Language> {
        return Arrays
                .asList(Language("English", LanguageCode.EN),
                        Language("German", LanguageCode.DE),
                        Language("Slovakian", LanguageCode.HR))
    }

}