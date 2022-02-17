package com.example.data.service.api

import com.example.data.response.NewsFeedResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsFeedApi {
    @GET("newsfeed.json")
    fun getNewsFeed():Call<NewsFeedResponse>
}