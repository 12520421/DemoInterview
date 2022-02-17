package com.example.myapplication.di

import com.example.domain.usecase.GetNewsFeedUseCase
import com.example.myapplication.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { HomeViewModel(get()) }
}

val useCasesModule = module {
    single { GetNewsFeedUseCase() }
}
