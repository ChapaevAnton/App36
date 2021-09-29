package com.w4eret1ckrtb1tch.app36

import android.app.Application
import android.content.Context
import com.w4eret1ckrtb1tch.app36.di.AppComponent
import com.w4eret1ckrtb1tch.app36.di.DaggerAppComponent
import com.w4eret1ckrtb1tch.app36.di.modules.AppModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        private set
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

}