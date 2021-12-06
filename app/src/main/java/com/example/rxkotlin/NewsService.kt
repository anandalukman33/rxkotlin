package com.example.rxkotlin

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

    @GET("everything?q=tesla&from=2021-11-05&sortBy=publishedAt&apiKey=d365302acf244531b773ab7075bf271d")
    fun getData():Observable<ResponseServer>     //Call<ResponseServer> --> tidak memakai call lagi karena RX berarti memakai observable
}