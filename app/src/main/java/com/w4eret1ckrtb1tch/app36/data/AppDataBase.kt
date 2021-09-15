package com.w4eret1ckrtb1tch.app36.data

class AppDataBase : BaseDataBase {

    private val db = mutableListOf("one", "two", "three", "four")

    override fun returnBase(): List<String> {
        return db
    }

    override fun add(string: String) {
        db.add(string)
    }
}