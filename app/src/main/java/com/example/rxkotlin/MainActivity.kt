package com.example.rxkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.rxkotlin.presenter.NewsPresenter
import com.example.rxkotlin.presenter.NewsView

class MainActivity : AppCompatActivity(), NewsView {

    private var presenter: NewsPresenter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = NewsPresenter(this)
        presenter?.getNews()
    }

    override fun onSuccess(msg: String, article: List<ArticlesItem?>?) {
        //bind data ke recycleview
        for (i in article?.indices!!) {
            var dataNews = article[i]?.author
            //Liatnya dari sini aja hasil dari api news untuk field author
            Toast.makeText(this, dataNews, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}