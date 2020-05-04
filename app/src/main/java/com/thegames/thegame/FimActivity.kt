package com.thegames.thegame

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_fim.*

class FimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fim)
        val extras: String = intent.getStringExtra("Result");
        lblWinOrLos.text = extras;
        if (extras == getString(R.string.loser)) {
            btnShare.setVisibility(View.INVISIBLE);
            lblMoney2.setVisibility(View.INVISIBLE);
            lblIconMoney.setVisibility(View.INVISIBLE);
        } else {
            lblMoney2.text = "$ " + intent.getStringExtra("Money");
        }
    }

    fun share(v: View) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}
