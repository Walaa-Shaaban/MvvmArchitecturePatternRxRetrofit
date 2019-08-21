package com.walaa.shaaban.mvvmarchitecturepattern.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.walaa.shaaban.mvvmarchitecturepattern.data.model.FlowerResponse
import com.walaa.shaaban.mvvmarchitecturepattern.data.remote.FlowerService
import com.walaa.shaaban.mvvmarchitecturepattern.data.room.FlowerDao
import com.walaa.shaaban.mvvmarchitecturepattern.data.room.FlowerDatabase

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class FlowerRepository(application: Application) {

    var compositeDisposable = CompositeDisposable()
    var listOfFlowers:MutableLiveData<List<FlowerResponse>> = MutableLiveData<List<FlowerResponse>>()
    var getAllFlowers:LiveData<List<FlowerResponse>> = MutableLiveData<List<FlowerResponse>>()
    var databaseDao: FlowerDao

    init {
       var database = FlowerDatabase.invoke(
            application.applicationContext
        )!!
        databaseDao = database.flowerDao()


    }


    fun getFlowerList(){

        compositeDisposable.add(
            FlowerService.getFlowerService()
                .listFlower()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer{
                    listOfFlowers.value = it
                    for (flower in it){
                        databaseDao.insertFlower(flower)
                    }

                }))

    }

    fun getAllFlowers(): LiveData<List<FlowerResponse>>{
        getAllFlowers = databaseDao.getAllFlower()
        return getAllFlowers
    }


    }


