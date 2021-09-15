package com.w4eret1ckrtb1tch.app36.di

import com.w4eret1ckrtb1tch.app36.di.modules.ViewModelProviderModule
import com.w4eret1ckrtb1tch.app36.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelProviderModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}