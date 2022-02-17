package com.example.myapplication.data.repositories

import com.example.myapplication.data.mapper.NewsFeedMapper
import com.example.myapplication.data.service.NewsFeedService
import com.example.myapplication.domain.model.NewsFeed
import com.example.myapplication.domain.repositories.NewsFeedRepository
import com.example.myapplication.domain.utils.Result


class NewsFeedRepositoryImpl(
    private val newsFeedService: NewsFeedService,
    private val newsFeedMapper: NewsFeedMapper
) : NewsFeedRepository {
    override fun getNewsFeed(): Result<List<NewsFeed>> {
        val response = newsFeedService.getNewsFeed().execute()
        if (response != null) {
            if (response.isSuccessful) {
                response.body()?.items?.let { return Result.Success(newsFeedMapper.toNewsFeed(it)) }
            }
            return Result.Failure(Exception(response.message()))
        }
        return Result.Failure(Exception("Bad request/response"))
    }
}