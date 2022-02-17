package com.example.myapplication.di

import com.example.myapplication.data.mapper.NewsFeedMapper
import com.example.myapplication.data.mapper.NewsFeedMapperImpl
import com.example.myapplication.data.repositories.DetailRepositoryImpl
import com.example.myapplication.data.repositories.NewsFeedRepositoryImpl
import com.example.myapplication.domain.repositories.DetailRepository
import com.example.myapplication.domain.repositories.NewsFeedRepository
import com.example.myapplication.domain.usecase.GetDetailNewUseCase
import com.example.myapplication.domain.usecase.GetNewsFeedUseCase
import com.example.myapplication.ui.activities.detail.DetailViewModel
import com.example.myapplication.ui.activities.home.newsfeed.NewsFeedViewModel
import com.example.myapplication.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { HomeViewModel() }
    viewModel { NewsFeedViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}

val useCasesModule = module {
    single { GetNewsFeedUseCase(get()) }
    single { GetDetailNewUseCase(get()) }
}

val repositoriesModule = module {
    single<NewsFeedRepository> {
        NewsFeedRepositoryImpl(
            newsFeedService = get(),
            newsFeedMapper = get()
        )
    }

    single<DetailRepository> {
        DetailRepositoryImpl(
            newsFeedService = get(),
            newsFeedMapper = get()
        )
    }

    factory<NewsFeedMapper> {
        NewsFeedMapperImpl()
    }
}

