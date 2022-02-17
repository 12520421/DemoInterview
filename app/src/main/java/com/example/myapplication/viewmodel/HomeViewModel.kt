package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.NewsFeed
import com.example.domain.usecase.GetNewsFeedUseCase
import com.example.domain.utils.Result
import com.example.myapplication.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(val getNewsFeedUseCase: GetNewsFeedUseCase) : BaseViewModel() {

    val newsFeed = MutableLiveData<List<NewsFeed>>()

    fun getNewsFeed() = launch {
        when (val result = withContext(Dispatchers.IO) { getNewsFeedUseCase() }) {
            is Result.Failure -> {
                Log.d("", "resutl :${result.exception}")
            }
            is Result.Success -> {
                Log.d("", "resutl :${result.data}")
            }
        }
    }
}