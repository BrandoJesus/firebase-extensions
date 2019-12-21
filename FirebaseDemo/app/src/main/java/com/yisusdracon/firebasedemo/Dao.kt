package com.yisusdracon.firebasedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class Dao {
    fun saveTicketFirebase(email: String,
                           nombre: String,
                           direccion: String,
                           precio: Double): LiveData<Boolean> {

        val data = MutableLiveData<Boolean>()
        val ticket = Ticket(email, nombre, direccion, precio)
        FirebaseFirestore.getInstance()
            .collection("compras")
            .add(ticket)
            .addOnSuccessListener {
                data.value = true
            }.addOnFailureListener{
                data.value = false
            }
        return data
    }
}