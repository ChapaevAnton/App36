package com.w4eret1ckrtb1tch.app36.data

class AppDataBase1 : BaseDataBase {

    private val db = mutableListOf("1", "2", "3", "4")

    override fun returnBase(): List<String> {
        return db
    }

    override fun add(string: String) {
        db.add(string)
    }
}