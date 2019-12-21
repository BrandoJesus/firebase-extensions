package com.yisusdracon.firebasedemo

import androidx.lifecycle.LiveData

class UseCase {

    private val dao = Dao()
    fun saveTicket(email: String,
                   nombre: String,
                   direccion: String,
                   precio: Double): LiveData<Boolean> = dao.saveTicketFirebase(email, nombre, direccion, precio)
}