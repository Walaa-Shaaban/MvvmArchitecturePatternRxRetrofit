package com.walaa.shaaban.mvvmarchitecturepattern.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.walaa.shaaban.mvvmarchitecturepattern.data.model.FlowerResponse

@Dao
interface FlowerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFlower(flowerResponse: FlowerResponse)

    @Query("SELECT * FROM FlowerResponse")
    fun getAllFlower():LiveData<List<FlowerResponse>>

    @Query("SELECT * FROM FlowerResponse WHERE productId IN (:product_id)")
    fun getOneFlower(product_id: Int) : LiveData<FlowerResponse>


}