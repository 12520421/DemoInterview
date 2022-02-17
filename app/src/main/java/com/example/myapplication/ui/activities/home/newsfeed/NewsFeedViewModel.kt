package com.example.myapplication.ui.activities.home.newsfeed

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.domain.model.NewsFeed
import com.example.myapplication.domain.usecase.GetNewsFeedUseCase
import com.example.myapplication.domain.utils.Result
import com.example.myapplication.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsFeedViewModel(
    val getNewsFeedUseCase: GetNewsFeedUseCase
) : BaseViewModel() {

    val newsFeeds = MutableLiveData<List<NewsFeed>>()

    fun getNewsFeeds() = launch {
        when (val result = withContext(Dispatchers.IO) { getNewsFeedUseCase() }) {
            is Result.Failure -> {
            }
            is Result.Success -> {
                newsFeeds.value = result.data
            }
        }
    }
}