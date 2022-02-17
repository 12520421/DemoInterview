package com.example.myapplication.data.repositories

import com.example.myapplication.data.mapper.NewsFeedMapper
import com.example.myapplication.data.service.NewsFeedService
import com.example.myapplication.domain.model.NewsFeed
import com.example.myapplication.domain.repositories.DetailRepository
import com.example.myapplication.domain.utils.Result

class DetailRepositoryImpl(
    private val newsFeedService: NewsFeedService,
    private val newsFeedMapper: NewsFeedMapper
) : DetailRepository {
    override fun getDetail(): Result<NewsFeed> {
        val response = newsFeedService.getDetailNewsFeed().execute()
        if (response != null) {
            if (response.isSuccessful) {
                response.body()?.let { return Result.Success(newsFeedMapper.toDetailNewsFeed(it)) }
            }
            return Result.Failure(Exception(response.message()))
        }
        return Result.Failure(Exception("Bad request/response"))
    }
}