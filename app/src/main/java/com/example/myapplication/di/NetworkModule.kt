package com.example.myapplication.di

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single {
        createRetrofit(
            okHttpClient = get(),
        )
    }

    single {
        provideOkHttpClient(
            cache = provideCache(context = androidApplication()),
        )
    }

    single<Converter.Factory> {
        GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .create()
        )
    }
}

private fun createRetrofit(
    okHttpClient: OkHttpClient,
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

private fun provideOkHttpClient(
    cache: Cache
): OkHttpClient {
    return OkHttpClient.Builder().apply {

        addInterceptor(HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        })
        addInterceptor { chain ->
            val defaultRequest = chain.request()

            val defaultHttpUrl = defaultRequest.url()

            val httpUrl = defaultHttpUrl.newBuilder().build()

            val requestBuilder = defaultRequest.newBuilder()
                .url(httpUrl)

            chain.proceed(requestBuilder.build())
        }
        addInterceptor { chain ->
            val request = chain.request()
            var response = chain.proceed(request)
            var tryOuts = INIT_TRYOUT

            while (!response.isSuccessful && tryOuts < MAX_TRYOUTS) {
                Log.d(
                    this.javaClass.simpleName, "intercept: timeout/connection failure, " +
                            "performing automatic retry ${(tryOuts + 1)}"
                )
                tryOuts++
                response = chain.proceed(request)
            }

            response
        }

        connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        readTimeout(TIME_OUT, TimeUnit.SECONDS)

        cache(cache)
    }.build()
}

private fun provideCache(context: Context): Cache {
    val size = (10 * 1024 * 1024).toLong() // 10 Mb
    return Cache(context.cacheDir, size)
}

private const val BASE_URL = "https://raw.githubusercontent.com/Akaizz/static/master/"
private const val TIME_OUT = 60L
private const val MAX_TRYOUTS = 3
private const val INIT_TRYOUT = 1
