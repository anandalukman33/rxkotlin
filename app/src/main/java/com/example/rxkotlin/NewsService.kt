package com.example.rxkotlin

import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

    @GET("everything?q=tesla&from=2021-11-05&sortBy=publishedAt&apiKey=d365302acf244531b773ab7075bf271d")
    fun getData():Call<ResponseServer>
}