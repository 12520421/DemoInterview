package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repositories.DetailRepository
import org.koin.core.KoinComponent

class GetDetailNewUseCase(
    private val detailRepository: DetailRepository
) : KoinComponent {
    operator fun invoke() = detailRepository.getDetail()
}