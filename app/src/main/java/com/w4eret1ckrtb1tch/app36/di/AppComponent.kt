package com.w4eret1ckrtb1tch.app36.di

import com.w4eret1ckrtb1tch.app36.di.modules.AppModule
import com.w4eret1ckrtb1tch.app36.view.MainActivity
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainViewModel: MainViewModel)

}