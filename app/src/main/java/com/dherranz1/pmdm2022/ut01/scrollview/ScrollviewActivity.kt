package com.dherranz1.pmdm2022.ut01.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.dherranz1.pmdm2022.R

class ScrollviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrollview)


        val contenido = findViewById<LinearLayout>(R.id.contenido)


        var i = 0
        while (i < 50) {
            var texto: TextView = TextView(contenido.context)
            texto.text = "El contador vale : $i"
            contenido.addView(texto)
            Log.d("@dev", "texto $i " + contenido.childCount)

            i++
        }

    }
}