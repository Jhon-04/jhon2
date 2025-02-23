package com.example.jhon2


import android.widget.Button
import android.os.Bundle
import android.widget.ListView
import android.widget.ArrayAdapter
import android.content.Intent
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var hasSelectedProduct = false
    private lateinit var products: List<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDetalles = findViewById<Button>(R.id.btnDetalles)
        btnDetalles.setOnClickListener {
            hasSelectedProduct = true
            mostrarMensaje("Producto seleccionado", "¡Has seleccionado un producto!")
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!hasSelectedProduct) {
                    mostrarConfirmacionSalida()
                } else {
                    finish()
                }
            }
        })
    }

    private fun mostrarMensaje(titulo: String, mensaje: String) {
        AlertDialog.Builder(this)
            .setTitle(titulo)
            .setMessage(mensaje)
            .setPositiveButton("Ok", null)
            .show()
    }

    private fun mostrarConfirmacionSalida() {
        AlertDialog.Builder(this)
            .setTitle("Confirmación")
            .setMessage("¿Seguro que quieres salir sin seleccionar un producto?")
            .setPositiveButton("Sí") { _, _ -> finish() }
            .setNegativeButton("No", null)
            .show()
    }
}