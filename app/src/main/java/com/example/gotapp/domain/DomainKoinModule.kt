package com.example.gotapp.domain

import com.example.gotapp.domain.usecases.GetAllHousesUseCase
import org.koin.dsl.module.module

val domainModule = module {
    factory {
        GetAllHousesUseCase(get(), get())
    }
}