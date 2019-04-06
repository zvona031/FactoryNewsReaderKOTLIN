package hr.ferit.zvonimirpavlovic.kotlintest.base

import android.content.Context
import hr.ferit.zvonimirpavlovic.kotlintest.base.MyApplication.Companion.BASE_API
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


val retrofitModule = module {
    single { getCache(androidContext())}

    single { getHttpLoginInteractor() }

    single { getOkHttpClient(get(),get()) }

    single { getRetrofit(get()) }

    single { getApiInterface(get()) }
}

fun getApiInterface(retrofit : Retrofit):APIInterface{
    return retrofit.create(APIInterface::class.java)
}

fun getRetrofit(okHttpClient : OkHttpClient) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_API)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}

fun getOkHttpClient(httpLoggingInterceptor : HttpLoggingInterceptor, cache : Cache) : OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .cache(cache)
        .build()

}

fun getHttpLoginInteractor() : HttpLoggingInterceptor {
    val httpLoginInterceptor = HttpLoggingInterceptor()
    httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoginInterceptor
}

fun getCache(context : Context) : Cache {
    val file = File(context.cacheDir,"responses")
    return Cache(file,10 * 1024 * 1024)
}


