package com.walaa.shaaban.mvvmarchitecturepattern.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "FlowerResponse")
data class FlowerResponse(

    @ColumnInfo(name = "category")
    @SerializedName("category")
    @Expose
    val category: String,

    @ColumnInfo(name = "price")
    @SerializedName("price")
    @Expose
    val price: Double,

    @ColumnInfo(name = "instructions")
    @SerializedName("instructions")
    @Expose
    val instructions: String,

    @ColumnInfo(name = "photo")
    @SerializedName("photo")
    @Expose
    val photo: String,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    val name: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "productId")
    @SerializedName("productId")
    @Expose
    val productId: Integer

)
