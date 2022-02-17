package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.model.NewsFeed
import com.example.myapplication.domain.utils.Result

interface DetailRepository {
    fun getDetail(): Result<NewsFeed>
}