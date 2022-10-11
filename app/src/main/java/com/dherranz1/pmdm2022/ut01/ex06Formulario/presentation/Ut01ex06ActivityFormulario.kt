package com.dherranz1.pmdm2022.ut01.ex06Formulario.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.dherranz1.pmdm2022.R
import com.dherranz1.pmdm2022.ut01.ex06Formulario.domain.Cat

class Ut01ex06ActivityFormulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex06_formulario)

        setupView()
    }

    private fun setupView(){
        val inputName = findViewById<EditText>(R.id.inputName)
        val inputSurname = findViewById<EditText>(R.id.inputSurname)
        val actionSave = findViewById<Button>(R.id.actionSave)

        actionSave.setOnClickListener{
            Log.d("@dev", "Click")

            val value = inputName.text.toString()

            log("dev", "$value")

            val cat = Cat(
                inputName.text.toString(),
                inputSurname.text.toString()
            )

            log("dev","$cat")
        }


        actionSave.setOnLongClickListener {
            Log.d("@dev", "Long Click")

            true
        }

    }

    private fun log(tag : String, message: String){
        Log.d("@$tag", "$message")
    }
}