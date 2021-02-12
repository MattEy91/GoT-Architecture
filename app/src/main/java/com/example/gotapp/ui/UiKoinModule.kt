package com.example.gotapp.ui

import com.example.gotapp.domain.model.House
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val uiModule = module {

    viewModel {
        MainActivityViewModel(get())
    }

    viewModel { (house: House) ->  DetailActivityViewModel(house) }
}