package com.cosmospire.retrofittestapp

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {
    private lateinit var weatherApi: IWeatherApi
    private val compositeDisposable = CompositeDisposable()

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModel::class.java)

        val disposable: Disposable = mainViewModel.whether.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                            mTextView_Telop.text = it.forecasts!!.get(0).telop
                            mEditText_Desc.text = it.description!!.text
                        },
                        {
                            mTextView_Telop.text = it.localizedMessage
                        })

        compositeDisposable.add(disposable)

//        val retrofit = Retrofit.Builder()
//                .baseUrl("http://weather.livedoor.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//
//        weatherApi = retrofit.create(IWeatherApi::class.java)
//
//        onButtonClicked.setOnClickListener {
//            val disposable: Disposable = weatherApi.getWhether("200010")
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(
//                            { response ->
//                                mTextView_Telop.text = response.forecasts!!.get(0).telop
//                                mEditText_Desc.text = response.description!!.text
//                            },
//                            { err ->
//                                mTextView_Telop.text = err.localizedMessage
//                            })
//
//            compositeDisposable.add(disposable)
//        }
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear() // this gonna be reusable.
    }
}
