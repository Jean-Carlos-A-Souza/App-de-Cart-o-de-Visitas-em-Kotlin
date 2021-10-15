package com.apolo.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepositoy(private val dao: BusinessCardDao) {

    fun insert(businessCard: BusinessCard)= runBlocking {
        launch(Dispatchers.IO){
            dao.insert(businessCard)
        }
    }

    fun getAll() = dao.getAll()

}