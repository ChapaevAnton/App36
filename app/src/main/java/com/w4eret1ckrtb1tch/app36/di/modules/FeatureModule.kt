package com.w4eret1ckrtb1tch.app36.di.modules

import com.w4eret1ckrtb1tch.app36.di.FeatureScope
import com.w4eret1ckrtb1tch.app36.multibindings.*
import dagger.Module
import dagger.Provides

@Module
class FeatureModule {

    // TODO: 03.10.2021 Lazy and Provides
    @Provides
    @One
    @FeatureScope
    fun provideFeatureOne(): Feature = FeatureImplOne()

    @Provides
    @Two
    @FeatureScope
    fun provideFeatureTwo(): Feature = FeatureImplTwo()

}