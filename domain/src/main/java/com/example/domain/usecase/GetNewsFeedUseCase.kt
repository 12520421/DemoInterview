package com.example.domain.usecase

import com.example.domain.repositories.NewsFeedRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetNewsFeedUseCase : KoinComponent {
    private val newsFeedRepository: NewsFeedRepository by inject()

    operator fun invoke() = newsFeedRepository.getNewsFeed()
}