package com.example.data.repositories

import com.example.data.service.NewsFeedService
import com.example.domain.model.NewsFeed
import com.example.domain.repositories.NewsFeedRepository
import com.example.domain.utils.Result

class NewsFeedRepositoryImpl(
    private val newsFeedService: NewsFeedService
) : NewsFeedRepository {
    override fun getNewsFeed(): Result<List<NewsFeed>> {
        return newsFeedService.getNewsFeed()
    }
}