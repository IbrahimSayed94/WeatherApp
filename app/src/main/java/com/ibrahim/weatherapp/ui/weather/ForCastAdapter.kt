package com.ibrahim.weatherapp.ui.weather

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ibrahim.weatherapp.data.response.ForeCastDay
import com.ibrahim.weatherapp.databinding.ItemWeatherBinding

class ForCastAdapter(private var forecastList : List<ForeCastDay> ?= arrayListOf(), private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(playerList : List<ForeCastDay>)
    {
        this.forecastList  = playerList
        notifyDataSetChanged()
    } // fun of submitList

    override fun getItemCount(): Int {
        return forecastList?.size ?: 0
    } // fun of getItemCount

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderForecast(
            ItemWeatherBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    } // fun of onCreateViewHolder

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        forecastList?.get(position)
            ?.let { (holder as ViewHolderForecast).bind(context = context,forecast = it) }
    } // fun of onBindViewHolder

    private class ViewHolderForecast  (val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(context: Context, forecast : ForeCastDay)
        {
            binding.txtDay.text = "${forecast.date}"
            binding.txtTemp.text = "${forecast.day?.maxtemp_c} °C / ${forecast.day?.mintemp_c} °C"

            Glide.with(context)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load("https:${forecast.day?.condition?.icon}")
                .into(binding.imgCondition)
        } // fun of bind
    } // class of ViewHolderForecast
}