package com.w4eret1ckrtb1tch.app36

import android.app.Application
import com.w4eret1ckrtb1tch.app36.di.AppComponent
import com.w4eret1ckrtb1tch.app36.di.DaggerAppComponent

class App : Application() {


    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this).build()
    }

}