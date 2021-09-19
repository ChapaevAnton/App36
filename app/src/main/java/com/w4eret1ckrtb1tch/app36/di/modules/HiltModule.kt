package com.w4eret1ckrtb1tch.app36.di.modules

import com.w4eret1ckrtb1tch.app36.data.AppDataBase
import com.w4eret1ckrtb1tch.app36.data.BaseDataBase
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object HiltModule {

    @Provides
    fun provideDataBase(): BaseDataBase = AppDataBase()

    @Provides
    fun provideViewModel(dataBase: BaseDataBase): MainViewModel = MainViewModel(dataBase)
}