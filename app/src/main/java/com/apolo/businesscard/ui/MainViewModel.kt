package com.apolo.businesscard.ui

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.apolo.businesscard.data.BusinessCard
import com.apolo.businesscard.data.BusinessCardRepositoy

class MainViewModel(private val  businessCardRepositoy: BusinessCardRepositoy) : ViewModel() {

    fun insert(businessCard: BusinessCard) {
        businessCardRepositoy.insert(businessCard)
    }

    fun getAll() : LiveData<List<BusinessCard>>{
        return businessCardRepositoy.getAll()
    }

}

class MainViewModelFactory(private val repositoy: BusinessCardRepositoy):
        ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repositoy) as T
        }
        throw  IllegalArgumentException(" Unknow ViewModel Class")
    }
}