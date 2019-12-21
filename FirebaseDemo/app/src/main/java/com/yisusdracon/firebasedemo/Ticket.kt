package com.yisusdracon.firebasedemo

data class Ticket(val email: String = "DEFAULT",
                  val nombre: String = "DEFAULT",
                  val direccion: String = "DEFAULT_ADRESS",
                  val precio: Double = 0.0)