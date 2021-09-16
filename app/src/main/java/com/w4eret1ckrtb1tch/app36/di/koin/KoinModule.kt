package com.w4eret1ckrtb1tch.app36.di.koin

import com.w4eret1ckrtb1tch.app36.data.AppDataBase
import com.w4eret1ckrtb1tch.app36.data.AppDataBase1
import com.w4eret1ckrtb1tch.app36.data.BaseDataBase
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object KoinModule {

    val mainModule = module {
        single<BaseDataBase>(qualifier = named("base1")) { AppDataBase() }
        single<BaseDataBase>(qualifier = named("base2")) { AppDataBase1() }
        single<MainViewModel> { MainViewModel(dataBase = get(qualifier = named("base2"))) }
    }

}