package com.example.gotapp

import android.app.Application
import com.example.gotapp.domain.domainModule
import com.example.gotapp.service.httpModule
import com.example.gotapp.ui.uiModule
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

import kotlin.coroutines.CoroutineContext

internal val coreModule = module {
    single {
        CoroutineDispatchers(
            ui = Dispatchers.Main,
            computation = Dispatchers.Default,
            io = Dispatchers.IO
        )
    }
}

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin(this, moduleSet.toList())
    }
}

internal val moduleSet = setOf(coreModule, uiModule, httpModule, domainModule)

data class CoroutineDispatchers(
    val ui: CoroutineContext,
    val computation: CoroutineContext,
    val io: CoroutineContext
)