package br.com.trybe.pizzadelivery

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.trybe.pizzadelivery.databinding.ActivityProductDetailsBinding
import java.text.DecimalFormat

class ProductDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    var amount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("WHITE")

        val imgProduct = intent.extras!!.getInt("imgProduct")
        val name = intent.extras!!.getString("name")
        val price = intent.extras!!.getString("price")!!.toDouble()
        var newPrice = price
        val decimalFormat = DecimalFormat.getCurrencyInstance()

        binding.imgProduct.setBackgroundResource(imgProduct)
        binding.txtProductName.text = "$name"
        binding.txtPrice.text = decimalFormat.format(price)

        binding.btBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btIncrease.setOnClickListener {
            var newAmount = amount + 1
            if (amount == 1){
                binding.txtAmount.text = "$newAmount"
                newPrice += price
                amount = newAmount
            } else {
                binding.txtAmount.text = "$newAmount"
                newPrice += price
                amount = newAmount
            }
            binding.txtPrice.text = decimalFormat.format(newPrice)
        }

        binding.btToDecrease.setOnClickListener {
            var newAmount = amount - 1
            if (amount > 1){
                binding.txtAmount.text = "$newAmount"
                newPrice -= price
                amount = newAmount
            }

            binding.txtPrice.text = decimalFormat.format(newPrice)
        }

        binding.btConfirm.setOnClickListener {
            val mustard = binding.btMustard
            val ketchup = binding.btKetchup
            val maio = binding.btMaio
            val bacon = binding.btBacon

            val sauces = when{
                mustard.isChecked -> {
                    "Mostarda"
                }
                ketchup.isChecked -> {
                    "Ketchup"
                }
                maio.isChecked -> {
                    "Maionese"
                }
                bacon.isChecked -> {
                    "Bacon"
                }
                else -> {
                    ""
                }
            }

            val intent = Intent(this, Payment::class.java)
            intent.putExtra("name", name)
            intent.putExtra("amount", amount)
            intent.putExtra("total", newPrice)
            intent.putExtra("sauces", sauces)
            startActivity(intent)
        }

    }
}