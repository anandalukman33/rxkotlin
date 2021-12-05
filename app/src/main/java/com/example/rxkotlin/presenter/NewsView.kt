package com.example.rxkotlin.presenter

import com.example.rxkotlin.ArticlesItem

interface NewsView {

    fun onSuccess(msg: String, article: List<ArticlesItem?>?)
    fun onError(msg: String)
}