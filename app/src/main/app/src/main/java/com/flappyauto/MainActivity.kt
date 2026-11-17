
package com.flappyauto

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private var activo = false
    private lateinit var estado: TextView
    private lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pantalla = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(30, 30, 30, 30)
            setBackgroundColor(Color.rgb(20, 25, 40))
        }

        val titulo = TextView(this).apply {
            text = "🐦 FLAPPY AUTO"
            textSize = 30f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        estado = TextView(this).apply {
            text = "Estado: DETENIDO"
            textSize = 20f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        boton = Button(this).apply {
            text = "ACTIVAR"
            textSize = 20f
            setOnClickListener {
                activo = !activo
                text = if (activo) "DETENER" else "ACTIVAR"
                estado.text = if (activo) {
                    "Estado: ACTIVADO"
                } else {
                    "Estado: DETENIDO"
                }
            }
        }

        pantalla.addView(titulo)
        pantalla.addView(estado)
        pantalla.addView(boton)

        setContentView(pantalla)
    }
}
