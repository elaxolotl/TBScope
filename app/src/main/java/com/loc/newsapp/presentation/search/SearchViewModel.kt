package com.loc.newsapp.presentation.search

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.domain.usecases.news.SearchNews
import com.loc.newsapp.util.loadArticlesFromJson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {

    private var _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    init {
        loadArticles()
    }

    private fun loadArticles() {
        val all = loadArticlesFromJson(context)
        _state.value = _state.value.copy(allArticles = all, filteredArticles = all)
    }

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                _state.value = _state.value.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.SearchNews -> {
                val query = _state.value.searchQuery.lowercase()
                val filtered = _state.value.allArticles.filter {
                    it.title?.lowercase()?.contains(query) == true ||
                            it.description?.lowercase()?.contains(query) == true
                }
                _state.value = _state.value.copy(filteredArticles = filtered)
            }
        }
    }
}
