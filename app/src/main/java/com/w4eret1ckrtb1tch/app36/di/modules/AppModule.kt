package com.w4eret1ckrtb1tch.app36.di.modules

import android.content.Context
import com.w4eret1ckrtb1tch.app36.data.AppDataBase
import com.w4eret1ckrtb1tch.app36.data.BaseDataBase
import com.w4eret1ckrtb1tch.app36.multibindings.*
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey
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


    // TODO: 03.10.2021 MultiBindings 
    @Provides
    @IntoSet
    fun provideXmlFormatExporterSet(): FormatExporter = XmlFormatExporter()

    @Provides
    @IntoSet
    fun provideCsvFormatExporterSet(): FormatExporter = CsvFormatExporter()

    @Provides
    @IntoMap
    @StringKey("xml")
    fun provideXmlFormatExporterMap(): FormatExporter = XmlFormatExporter()

    @Provides
    @IntoMap
    @StringKey("csv")
    fun provideCsvFormatExporterMap(): FormatExporter = CsvFormatExporter()

    // TODO: 03.10.2021 Lazy and Provides

    @Provides
    @One
    fun provideFeatureOne(): Feature = FeatureImplOne()

    @Provides
    @Two
    fun provideFeatureTwo(): Feature = FeatureImplTwo()

}