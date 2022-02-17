package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repositories.NewsFeedRepository
import org.koin.core.KoinComponent

class GetNewsFeedUseCase(
    private val newsFeedRepository: NewsFeedRepository
) : KoinComponent {
    operator fun invoke() = newsFeedRepository.getNewsFeed()
}