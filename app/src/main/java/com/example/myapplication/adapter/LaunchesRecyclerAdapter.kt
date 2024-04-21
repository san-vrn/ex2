package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.entity.LaunchRocket
import com.example.myapplication.R

class LaunchesRecyclerAdapter() : RecyclerView.Adapter<LaunchesRecyclerAdapter.LaunchViewHolder>() {

    private lateinit var inflater : LayoutInflater
    private lateinit var rockets: List<LaunchRocket>

    constructor(context: Context, rockets: List<LaunchRocket>) : this() {
        this.inflater = LayoutInflater.from(context)
        this.rockets = rockets
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LaunchViewHolder {
        val view = inflater.inflate(R.layout.launches_item,parent,false)
        return LaunchViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val launchRocket = rockets[position]
        holder.rocketImage.setImageResource(launchRocket.rocketImage)
        holder.stateProgramm.text = launchRocket.stateProgramm
        holder.launchesMission.text = launchRocket.launchesMission
        holder.rocketIndex.text = launchRocket.rocketIndex
        holder.launchDate.text = launchRocket.launchDate
    }

    override fun getItemCount(): Int {
        return rockets.size
    }


    class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rocketImage: ImageView = itemView.findViewById(R.id.launches_image_item)
        val stateProgramm : TextView = itemView.findViewById(R.id.launches_launch_text_view)
        val launchesMission: TextView = itemView.findViewById(R.id.launches_mission_text_view)
        val rocketIndex: TextView = itemView.findViewById(R.id.launches_rocket_index_text_view)
        val launchDate: TextView = itemView.findViewById(R.id.launches_launch_date_text_view)
    }

}