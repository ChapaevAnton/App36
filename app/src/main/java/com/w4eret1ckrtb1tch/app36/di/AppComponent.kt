package com.w4eret1ckrtb1tch.app36.di

import android.content.Context
import com.w4eret1ckrtb1tch.app36.di.modules.AppModule
import com.w4eret1ckrtb1tch.app36.multibindings.FormatExporter
import com.w4eret1ckrtb1tch.app36.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : FeatureComponentInjector {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun context(context: Context): Builder
    }

    fun getFormatExporterSet(): Set<FormatExporter>

    fun getFormatExporterMap(): Map<String, FormatExporter>

}