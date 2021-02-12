package com.example.gotapp.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gotapp.domain.model.House
import com.example.gotapp.domain.model.HouseResponse
import com.example.gotapp.domain.usecases.GetAllHousesUseCase

class MainActivityViewModel(
    private val getAllHousesUseCase: GetAllHousesUseCase
) : ViewModel() {

    val allHouses = MutableLiveData<List<House>>()
    val headerUrl = MutableLiveData<String>().apply {
        value = "https://www.sky.at/static/img/serienhighlights/sky_16-03_gameofthrones-uebersicht_sub_s.jpg"
    }

    init {
        getAllHouses()
    }

    private fun getAllHouses() {
        getAllHousesUseCase.execute {
            allHouses.value = it.response
        }
    }

    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context).load(url).into(view);
        }

        @BindingAdapter("setAdapter")
        @JvmStatic
        fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
            this.run {
                this.adapter = adapter
            }
        }
    }
}