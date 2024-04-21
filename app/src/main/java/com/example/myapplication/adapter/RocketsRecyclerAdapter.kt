package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.entity.Rocket

class RocketsRecyclerAdapter() : RecyclerView.Adapter<RocketsRecyclerAdapter.RocketsViewHolder>()  {

    private lateinit var inflater : LayoutInflater
    private lateinit var rockets: List<Rocket>

    constructor(context: Context, rockets: List<Rocket>) : this() {
        this.inflater = LayoutInflater.from(context)
        this.rockets = rockets
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketsViewHolder {
        val view = inflater.inflate(R.layout.rocket_item,parent,false)
        return RocketsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rockets.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: RocketsViewHolder, position: Int) {
        val rocket = rockets[position]
        holder.rocketImage.setImageResource(rocket.imageResourceId)
        holder.rocketType.setText(rocket.type)
        holder.rocketName.setText(rocket.name)
        holder.rocketStatus.setBackgroundResource(R.drawable.round_red_drawable)
        holder.rocketStatus.setText(R.string.inactive)

        if(rocket.status){
            holder.rocketStatus.setBackgroundResource(R.drawable.round_green_drawable)
            holder.rocketStatus.setText(R.string.active)
        }
    }

    class RocketsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rocketImage: ImageView = itemView.findViewById(R.id.rocket_item_image)
        val rocketType : TextView = itemView.findViewById(R.id.rocket_item_type)
        val rocketName : TextView = itemView.findViewById(R.id.rocket_item_name)
        val rocketStatus : TextView = itemView.findViewById(R.id.rocket_item_status_indicator)
    }
}