package com.walaa.shaaban.mvvmarchitecturepattern.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.walaa.shaaban.mvvmarchitecturepattern.data.model.FlowerResponse
import com.walaa.shaaban.mvvmarchitecturepattern.data.repository.FlowerRepository

class FlowerResponseViweMOdel(application: Application) : AndroidViewModel(application) {

    var listOfFlowers: MutableLiveData<List<FlowerResponse>> = MutableLiveData<List<FlowerResponse>>()
    var flowerRepository: FlowerRepository
    var getAllFlower: LiveData<List<FlowerResponse>> = MutableLiveData<List<FlowerResponse>>()


    init {
        flowerRepository = FlowerRepository(application)
        flowerRepository.getFlowerList()
        listOfFlowers = flowerRepository.listOfFlowers
        getAllFlower = flowerRepository.getAllFlowers()
    }
}