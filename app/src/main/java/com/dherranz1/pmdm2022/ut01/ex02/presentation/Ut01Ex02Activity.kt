package com.dherranz1.pmdm2022.ut01.ex02.presentation

import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import com.dherranz1.pmdm2022.R
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.iterator

class Ut01Ex02Activity : AppCompatActivity() {
    var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex02)

        Thread{
            Thread.sleep(1000)
            runOnUiThread{
                initComponents()
            }
        }.start()

    }

    private fun initStarGroup(){

        val starGroup : LinearLayout = findViewById<LinearLayout>(R.id.star_group)

        Log.d("@dev","Estrellas: "+starGroup.childCount)

        var iterador = starGroup.iterator()

        while(iterador.hasNext()){
            Log.d("@dev","Hay elementos "+iterador.hasNext())
            var star = iterador.next() as AppCompatImageView


            star.setOnClickListener {
                val score = calcScore(star)
                setScore(score)
            }
        }

    }

    private fun initComponents(){
        findViewById<AppCompatImageView>(R.id.favorite).setOnClickListener {
            toggleFavorite()
        }
        initStarGroup()
    }

    fun calcScore(appCompatImageView : AppCompatImageView) : Int{
        val starGroup : LinearLayout = findViewById<LinearLayout>(R.id.star_group)
        var contador = 0

        var iterador = starGroup.iterator()
        var flag = false

        while(iterador.hasNext() && !flag){
            Log.d("@dev","Hay elementos "+iterador.hasNext())
            var star = iterador.next() as AppCompatImageView

            if (star == appCompatImageView) flag = true

            contador++
        }

        return contador
    }

    private fun setScore( score : Int){
        val starGroup : LinearLayout = findViewById<LinearLayout>(R.id.star_group)
        var contador = 0
        var iterador = starGroup.iterator()

        while(iterador.hasNext()){
            var star = iterador.next() as AppCompatImageView

            if (contador < score)
                tintView(star, R.color.yellow)
            else
                tintView(star, R.color.gray)

            contador++
        }
    }

    private fun toggleFavorite(){

        val favorite = findViewById<AppCompatImageView>(R.id.favorite)

        if (isFavorite) {
            tintView(favorite, R.color.gray)
            isFavorite = false
        }
        else {
            tintView(favorite, R.color.red)
            isFavorite = true

        }

    }

    private fun tintView(imageView : ImageView, color : Int){
        imageView.setColorFilter(ContextCompat.getColor(this,color))
    }
}




















