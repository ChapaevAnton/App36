package com.w4eret1ckrtb1tch.app36.di.modules

import android.content.Context
import com.w4eret1ckrtb1tch.app36.data.AppDataBase
import com.w4eret1ckrtb1tch.app36.data.BaseDataBase
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDataBase(): BaseDataBase = AppDataBase()

    @Singleton
    @Provides
    fun provideViewModel(dataBase: BaseDataBase, context: Context): MainViewModel =
        MainViewModel(dataBase, context)

}