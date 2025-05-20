package com.loc.newsapp.presentation.search

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val allArticles: List<Article> = emptyList(),
    val filteredArticles: List<Article> = emptyList()
)