package com.w4eret1ckrtb1tch.app36

import android.app.Application
import android.content.Context
import com.w4eret1ckrtb1tch.app36.di.AppComponent
import com.w4eret1ckrtb1tch.app36.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().context(this).build()
    }

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }
