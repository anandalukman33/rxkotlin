package com.example.rxkotlin.presenter

import android.util.Log
import com.example.rxkotlin.ConfigRetrofit
import com.example.rxkotlin.ResponseServer
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPresenter(val news: NewsView) {

    fun getNews() {
        ConfigRetrofit.getRetrofit().getData().enqueue(object : Callback<ResponseServer>{
            override fun onResponse(call: Call<ResponseServer>, response: Response<ResponseServer>) {
                if (response.isSuccessful) {
                    val dataNews = response.body()?.articles
                    if ((dataNews?.size ?: 0) > 0) {
                        news.onSuccess(response.message(), dataNews)
                    } else {
                        news.onError("data kosong")
                    }
                }
            }

            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                news.onError(t.localizedMessage)
            }
        })
    }
}