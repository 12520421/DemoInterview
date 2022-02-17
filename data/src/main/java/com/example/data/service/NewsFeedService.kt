package com.example.data.service

import com.example.data.mapper.NewsFeedMapper
import com.example.data.mapper.NewsFeedMapperImpl
import com.example.data.service.api.NewsFeedApi
import com.example.domain.model.NewsFeed
import com.example.domain.utils.Result

class NewsFeedService {

    private val api: RequestGenerator = RequestGenerator()
    private val mapper: NewsFeedMapper = NewsFeedMapperImpl()

    fun getNewsFeed(): Result<List<NewsFeed>> {
        val callResponse = api.createService(NewsFeedApi::class.java).getNewsFeed()
        val response = callResponse.execute()

        if (response != null) {
            if (response.isSuccessful) {

                response.body()?.items?.let { mapper.toNewsFeed(it) }
                    ?.let { return Result.Success(it) }
            }
            return Result.Failure(Exception(response.message()))
        }
        return Result.Failure(Exception("Bad request/response"))
    }
}