package com.thegames.thegame

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_jogo.*

class JogoActivity : AppCompatActivity() {

    val gameObjects = listOf<String>(
        "Dinheiro10",
        "Dinheiro10",
        "Dinheiro25",
        "Dinheiro25",
        "Dinheiro50",
        "Armadilha",
        "Armadilha",
        "Armadilha",
        "Armadilha",
        "Armadilha",
        "Monstro",
        "Saida"
    ).shuffled();
    val button1 = gameObjects.get(0);
    val button2 = gameObjects.get(1);
    val button3 = gameObjects.get(2);
    val button4 = gameObjects.get(3);
    val button5 = gameObjects.get(4);
    val button6 = gameObjects.get(5);
    val button7 = gameObjects.get(6);
    val button8 = gameObjects.get(7);
    val button9 = gameObjects.get(8);
    val button10 = gameObjects.get(9);
    val button11 = gameObjects.get(10);
    val button12 = gameObjects.get(11);
    var life = 3;
    var saldo = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)
    }

    fun buttonClick(v: View) {
        v.isClickable = false;
        val btn = findViewById<Button>(v.id);
        val action: String = when (btn) {
            btn1 -> button1;
            btn2 -> button2;
            btn3 -> button3;
            btn4 -> button4;
            btn5 -> button5;
            btn6 -> button6;
            btn7 -> button7;
            btn8 -> button8;
            btn9 -> button9;
            btn10 -> button10;
            btn11 -> button11;
            btn12 -> button12;

            else -> "Error!"
        }


        if (action == "Monstro") {
            btn.text = "\uD83D\uDC79";
            val toast = Toast.makeText(
                applicationContext,
                "Você encontrou um monstro e perdeu!",
                Toast.LENGTH_SHORT
            );
            toast.setGravity(Gravity.LEFT, 150, -400);
            toast.show();
            val fim = Intent(this, FimActivity::class.java).apply {
                putExtra("Result", getString(R.string.loser));
            };
            startActivity(fim);
        } else if (action == "Saida") {
            btn.text = "✔";
            val toast = Toast.makeText(applicationContext, "Você venceu", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.LEFT, 150, -400);
            toast.show();
            val fim = Intent(this, FimActivity::class.java).apply {
                putExtra("Result", getString(R.string.winner));
                putExtra("Money", saldo.toString());
            }
            startActivity(fim);
        } else if (action.contains("Dinheiro")) {
            val valor: Int = action.replace("Dinheiro", "").toInt();
            saldo += valor;
            val toast =
                Toast.makeText(applicationContext, "Você ganhou $" + valor, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.LEFT, 150, -400);
            toast.show();
            lblMoney.text = "$ " + saldo;
            btn.text = "\uD83D\uDCB0 " + valor;
        } else {
            btn.text = "❌";
            val toast =
                Toast.makeText(applicationContext, "Você perdeu uma vida", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.LEFT, 150, -400);
            toast.show();
            life--;
            lblVidas.text = "x " + life;
            if (life == 0) {
                val toast = Toast.makeText(
                    applicationContext,
                    "Você perdeu o jogo por perder todas suas vidas",
                    Toast.LENGTH_SHORT
                );
                toast.setGravity(Gravity.LEFT, 150, -400);
                toast.show();
                val fim = Intent(this, FimActivity::class.java).apply {
                    putExtra("Result", getString(R.string.loser));
                };
                startActivity(fim);
            }
        }

    }

}
