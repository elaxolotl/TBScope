package com.loc.newsapp.util

import com.loc.newsapp.domain.model.Article
import android.content.Context
import com.google.gson.Gson
import com.loc.newsapp.R
import com.loc.newsapp.data.remote.dto.NewsResponse


fun loadArticlesFromJson(context: Context): List<Article> {
    return try {
        val jsonString = context.resources.openRawResource(R.raw.articles)
            .bufferedReader().use { it.readText() }
        val newsResponse = Gson().fromJson(jsonString, NewsResponse::class.java)
        newsResponse.articles
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}