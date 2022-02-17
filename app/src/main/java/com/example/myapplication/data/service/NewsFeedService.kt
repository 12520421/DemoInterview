package com.example.myapplication.data.service

import com.example.myapplication.data.response.DetailNewsFeedResponse
import com.example.myapplication.data.response.NewsFeedResponse
import retrofit2.Call
import retrofit2.http.GET


interface NewsFeedService {
    @GET("newsfeed.json")
    fun getNewsFeed(): Call<NewsFeedResponse>

    @GET("detail.json")
    fun getDetailNewsFeed(): Call<DetailNewsFeedResponse>
}