package com.yisusdracon.firebasedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private val useCase = UseCase()
    fun storeTicket(email:String, nombre:String, direccion:String, precio:Double): LiveData<Boolean> {
        val data = MutableLiveData<Boolean>()
        useCase.saveTicket(email, nombre, direccion, precio).observeForever{
            data.postValue(it)
        }
        return data
    }
}