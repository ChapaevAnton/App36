package com.w4eret1ckrtb1tch.app36.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.w4eret1ckrtb1tch.app36.data.BaseDataBase

class MainViewModel(private val dataBase: BaseDataBase) {

    private val db = MutableLiveData<List<String>>()

    fun db(): LiveData<List<String>> = db

    fun getDb() {
        db.value = dataBase.returnBase()
    }

    fun putToDb(string: String) {
        dataBase.add(string)
    }

}
