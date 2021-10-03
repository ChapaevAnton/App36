package com.w4eret1ckrtb1tch.app36.di

import com.w4eret1ckrtb1tch.app36.di.modules.FeatureModule
import com.w4eret1ckrtb1tch.app36.view.MainActivity
import dagger.Subcomponent
import javax.inject.Scope

@FeatureScope
@Subcomponent(modules = [FeatureModule::class])
interface FeatureComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): FeatureComponent
    }

}

@Scope
annotation class FeatureScope