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

class DetailActivityViewModel(
    house: House
) : ViewModel() {

    val headerUrl = MutableLiveData<String>().apply { value = "https://www.sky.at/static/img/serienhighlights/sky_16-03_gameofthrones-uebersicht_sub_s.jpg" }
    val url = MutableLiveData<String>().apply { value = house.url }
    val activityTitle = MutableLiveData<String>().apply { value = house.name }
    val region = MutableLiveData<String>().apply { value = house.region }
    val coatOfArms = MutableLiveData<String>().apply { value = house.coatOfArms }
    val words = MutableLiveData<String>().apply { value = house.words }
    val titles = MutableLiveData<String>().apply { value = buildStringFromList(house.titles) }
    val seats = MutableLiveData<String>().apply { value = buildStringFromList(house.seats) }
    val currentLord = MutableLiveData<String>().apply { value = house.currentLord }
    val heir = MutableLiveData<String>().apply { value = house.heir }
    val overlord = MutableLiveData<String>().apply { value = house.overlord }
    val founded = MutableLiveData<String>().apply { value = house.founded }
    val founder = MutableLiveData<String>().apply { value = house.founder }
    val diedOut = MutableLiveData<String>().apply { value = house.diedOut }
    val ancestralWeapons = MutableLiveData<String>().apply { value = buildStringFromList(house.ancestralWeapons) }
    val cadetBranches = MutableLiveData<String>().apply { value = buildStringFromList(house.cadetBranches) }
    val swornMembers = MutableLiveData<String>().apply { value = buildStringFromList(house.swornMembers) }

    private fun buildStringFromList(list: List<String>) : String {
        var string = ""

        list.forEach {
            string += "$it\t"
        }
        return string
    }
}