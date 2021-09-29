package com.w4eret1ckrtb1tch.app36.di.modules

import android.app.Application
import android.content.Context
import com.w4eret1ckrtb1tch.app36.data.AppDataBase
import com.w4eret1ckrtb1tch.app36.data.BaseDataBase
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideDataBase(): BaseDataBase = AppDataBase()

    @Singleton
    @Provides
    fun provideViewModel(dataBase: BaseDataBase): MainViewModel = MainViewModel(dataBase)

    @Singleton
    @Provides
    fun provideContext(): Context = application.applicationContext
}