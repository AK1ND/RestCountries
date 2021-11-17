package com.example.countryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapp.model.ModelItem

class RecyclerAdapter(private val listAllCountries: List<ModelItem>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName: TextView? = null
        var countryCapital: TextView? = null
        var countPeoples: TextView? = null
        var flag: ImageView? = null   //how to upload images?

        init {
            countryName = itemView.findViewById(R.id.countryName)
            countryCapital = itemView.findViewById(R.id.countryCapital)
            countPeoples = itemView.findViewById(R.id.countPeoplesInCountry)
            flag = itemView.findViewById(R.id.imageFlag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerviev, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.countryName?.text = "Country: " + listAllCountries[position].name
        holder.countryCapital?.text ="Capital: " + listAllCountries[position].capital
        holder.countPeoples?.text ="Population: " + listAllCountries[position].population.toString()
        holder.flag?.visibility = View.GONE //for not to take up space
    }

    override fun getItemCount() = listAllCountries.size

}