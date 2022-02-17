package com.example.myapplication.di

import com.example.myapplication.data.service.NewsFeedService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { provideService(retrofit = get()) }

}

private fun provideService(retrofit: Retrofit): NewsFeedService {
    return retrofit.create(NewsFeedService::class.java)
}