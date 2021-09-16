package com.w4eret1ckrtb1tch.app36

import android.app.Application
import com.w4eret1ckrtb1tch.app36.data.AppDataBase
import com.w4eret1ckrtb1tch.app36.data.BaseDataBase
import com.w4eret1ckrtb1tch.app36.di.koin.KoinModule
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

//    lateinit var mainViewModel: MainViewModel
//    lateinit var dataBase:BaseDataBase

    override fun onCreate() {
        super.onCreate()
//        instance = this
//        dataBase = AppDataBase()
//        mainViewModel = MainViewModel(dataBase)
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(listOf(KoinModule.mainModule))
        }

    }

//    companion object {
//        lateinit var instance:App
//        private set
//    }
}