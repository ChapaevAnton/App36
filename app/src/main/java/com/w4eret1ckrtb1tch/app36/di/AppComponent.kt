package com.w4eret1ckrtb1tch.app36.di

import android.app.Application
import com.w4eret1ckrtb1tch.app36.di.modules.AppModule
import com.w4eret1ckrtb1tch.app36.view.MainActivity
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainViewModel: MainViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}