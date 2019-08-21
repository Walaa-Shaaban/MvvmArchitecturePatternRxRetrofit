package com.walaa.shaaban.mvvmarchitecturepattern.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walaa.shaaban.mvvmarchitecturepattern.R
import com.walaa.shaaban.mvvmarchitecturepattern.data.model.FlowerResponse
import com.walaa.shaaban.mvvmarchitecturepattern.data.utils.ApiUtils
import de.hdodenhof.circleimageview.CircleImageView


class FlowerAdapter : RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder> {

    private var context: Context
    private var flowerList: List<FlowerResponse>

    constructor(context: Context, flowerList: List<FlowerResponse>) : super() {
        this.context = context
        this.flowerList = flowerList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_flower, parent, false)
        return FlowerViewHolder(inflater)

    }

    override fun getItemCount(): Int {

        return flowerList.size
    }


    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        var flowerResponse: FlowerResponse = flowerList.get(position)
        holder.flowerName.text = flowerResponse.name.toString()
        holder.flowerPrice.text = flowerResponse.price.toString()

        Glide
            .with(context)
            .load("${ApiUtils.PHOTO_URL}photos/${flowerResponse.photo}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.flowerImg)
    }


    class FlowerViewHolder: RecyclerView.ViewHolder{

        var flowerImg: CircleImageView
        var flowerName: TextView
        var flowerPrice: TextView

        constructor(itemView: View) : super(itemView){
            flowerImg = itemView.findViewById(R.id.image)
            flowerPrice = itemView.findViewById(R.id.price)
            flowerName = itemView.findViewById(R.id.name)
        }



    }
}