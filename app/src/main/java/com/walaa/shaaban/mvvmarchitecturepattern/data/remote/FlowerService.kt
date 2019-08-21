package com.walaa.shaaban.mvvmarchitecturepattern.data.remote

import com.walaa.shaaban.mvvmarchitecturepattern.data.model.FlowerResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface FlowerService {

    companion object {
        fun getFlowerService(): FlowerService {
            return FlowerRetrofit.getClient()!!.create(FlowerService::class.java)
        }
    }

    @GET("flowers.json")
    fun listFlower(): Observable<List<FlowerResponse>>

}