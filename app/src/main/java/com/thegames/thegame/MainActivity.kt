package com.thegames.thegame

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun IniciarJogo(view: View) {
        val jogo = Intent(this, JogoActivity::class.java);
        startActivity(jogo);
    }

}
