package com.example.domain.repositories

import com.example.domain.model.NewsFeed
import com.example.domain.utils.Result

interface NewsFeedRepository {
    fun getNewsFeed(): Result<List<NewsFeed>>
}