package com.yisusdracon.firebasedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        obtenerDatos()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        btnEnviar.isEnabled = false//To/To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        btnEnviar.isEnabled = true//To change body of created functions use File | Settings | File Templates.
    }

    fun obtenerDatos() {
        btnEnviar.setOnClickListener {
            val nombre = nombre_etx.text.toString().trim();
            val email = email_etx.text.toString().trim();
            val direccion = direccion_etx.text.toString().trim();
            showProgress()
            

            if (nombre.isNotEmpty() && email.isNotEmpty() && direccion.isNotEmpty()) {
                viewModel.storeTicket(email, nombre, direccion,30.0)
                    .observe(this, Observer{
                        if (it) {
                            hideProgress()
                            Toast.makeText(this, "ticket guardado con exito", Toast.LENGTH_SHORT).show()
                        } else {
                            hideProgress()
                            Toast.makeText(this, "Hubo un problema al guardar los datos", Toast.LENGTH_SHORT).show()
                        }
                    })
            } else {
                hideProgress()
                Toast.makeText(this, "Los campos estan vacios", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
