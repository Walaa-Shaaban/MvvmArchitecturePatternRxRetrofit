package com.walaa.shaaban.mvvmarchitecturepattern.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.walaa.shaaban.mvvmarchitecturepattern.data.utils.ApiUtils
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class FlowerRetrofit {


    companion object {

        val TAG = FlowerRetrofit::class.java.simpleName
        var retrofit: Retrofit? = null
        val REQUEST_TIMEOUT = 60
        var okHttpClient: OkHttpClient? = null

        fun getClient(): Retrofit? {


            if (okHttpClient == null)
                initOkHttp()

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(ApiUtils.BASE_URL)
                    .client(okHttpClient!!)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


            }
            return retrofit
        }


        private fun initOkHttp() {
            val httpClient = OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            httpClient.addInterceptor(interceptor)

            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Request-Type", "Android")
                    .addHeader("Content-Type", "application/json")

                val request = requestBuilder.build()
                chain.proceed(request)
            }

            okHttpClient = httpClient.build()
        }

        fun resetApiClient() {
            retrofit = null
            okHttpClient = null
        }

    }
}
