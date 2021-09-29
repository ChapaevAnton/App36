package com.w4eret1ckrtb1tch.app36.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.w4eret1ckrtb1tch.app36.R
import com.w4eret1ckrtb1tch.app36.data.BaseDataBase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val dataBase: BaseDataBase,
    private val context: Context

) {

    private val db = MutableLiveData<List<String>>()

    fun db(): LiveData<List<String>> = db

    fun getDb() {
        db.value = dataBase.returnBase()
    }

    fun putToDb(string: String) {

        dataBase.add("$string ${context.getString(R.string.context_text)}")
    }

}
