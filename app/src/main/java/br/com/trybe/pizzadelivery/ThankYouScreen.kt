package br.com.trybe.pizzadelivery

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ThankYouScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you_screen)

        window.statusBarColor = Color.parseColor("WHITE")
    }
}