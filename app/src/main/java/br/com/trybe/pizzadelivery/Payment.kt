package br.com.trybe.pizzadelivery

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.trybe.pizzadelivery.databinding.ActivityPaymentBinding
import java.text.DecimalFormat

class Payment : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //color StatusBar
        window.statusBarColor = Color.parseColor("WHITE")

        val name = intent.extras!!.getString("name")
        val amount = intent.extras!!.getInt("amount")
        val total = intent.extras!!.getDouble("total")
        val sauces = intent.extras!!.getString("sauces")
        val decimalFormat = DecimalFormat.getCurrencyInstance()

        binding.txtTotal.text = "$name \n Quantidade: $amount \n Molho: $sauces \n Total: ${decimalFormat.format(total)}"

        binding.btPay.setOnClickListener {
            if (binding.btCreditCard.isChecked) {
                val intent = Intent(this, ThankYouScreen::class.java)
                startActivity(intent)
                Toast.makeText(this, "Pagamento com cartão", Toast.LENGTH_SHORT).show()
            } else if (binding.btPix.isChecked) {

                binding.editPix.visibility = View.VISIBLE
                val pix = binding.editPix.text.toString()

                if (pix.isNotEmpty()) {
                    val intent = Intent(this, ThankYouScreen::class.java)
                    intent.putExtra("userPix", pix)
                    startActivity(intent)
                    Toast.makeText(this, "Pagamento com PIX", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this, "Preencha com seu celular ou email", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}