package com.example.myapplication.ui.activities.detail

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.domain.model.NewsFeed
import com.example.myapplication.domain.usecase.GetDetailNewUseCase
import com.example.myapplication.domain.utils.Result
import com.example.myapplication.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailViewModel(
    private val getDetailNewUseCase: GetDetailNewUseCase
) : BaseViewModel() {

    val newsFeed = MutableLiveData<NewsFeed>()

    fun getNewsFeed() = launch {
        when (val result = withContext(Dispatchers.IO) { getDetailNewUseCase() }) {
            is Result.Failure -> {
            }
            is Result.Success -> {
                newsFeed.value = result.data
            }
        }
    }
}