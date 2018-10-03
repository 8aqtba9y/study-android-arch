package com.cosmospire.rxtestapp.datamodel

import com.cosmospire.rxtestapp.model.Language.LanguageCode

import com.cosmospire.rxtestapp.model.Language

import io.reactivex.Observable;

interface IDataModel {

    fun getSupportedLanguages(): Observable<List<Language>>

    fun getGreetingByLanguageCode(code: LanguageCode): Observable<String>
}