package br.com.trybe.pizzadelivery.listItems

import br.com.trybe.pizzadelivery.R
import br.com.trybe.pizzadelivery.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {

    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productList

    fun getProducts(): Flow<MutableList<Product>>{
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = R.drawable.cheese_pizza,
                name = "Pizza de Queijo",
                price = "10.50"
            ),
            Product(
                imgProduct = R.drawable.mixed_pizza,
                name = "Pizza Vegetariana",
                price = "15.00"
            ),
            Product(
                imgProduct = R.drawable.salmon_pizza,
                name = "Pizza de Salmão",
                price = "23.50"
            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                name = "Pizza de Milho",
                price = "12.50"
            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                name = "Pizza de Bacon",
                price = "12.50"
            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                name = "Pizza de Camarão",
                price = "25.00"
            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                name = "Pizza de Atum",
                price = "18.00"
            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                name = "Pizza de Presunto",
                price = "15.50"
            )
        )
        _productList.value = productList
        return productListFlow
    }
}