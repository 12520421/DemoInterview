package com.example.di

import com.example.data.repositories.NewsFeedRepositoryImpl
import com.example.data.service.NewsFeedService
import com.example.domain.repositories.NewsFeedRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single { NewsFeedService() }
    single<NewsFeedRepository> { NewsFeedRepositoryImpl(get()) }
}