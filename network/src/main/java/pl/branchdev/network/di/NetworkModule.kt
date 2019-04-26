package pl.branchdev.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import pl.branchdev.network.BuildConfig
import pl.branchdev.network.EventsApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<EventsApi> { get<Retrofit>().create(EventsApi::class.java) }
    single { buildRetrofit(get(),get(),BuildConfig.API_URL)}
    single { provideOkHttpClient(get()) }
    single { provideGson() }
    single { provideHttpLoggingInterceptor() }
}

private fun provideGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG)
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}

private fun buildRetrofit(gson: Gson, okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()
}

private fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().apply {
        if (BuildConfig.DEBUG) {
            addInterceptor(httpLoggingInterceptor)
        }
    }.build()
}