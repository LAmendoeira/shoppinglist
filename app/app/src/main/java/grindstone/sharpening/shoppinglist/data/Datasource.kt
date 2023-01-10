package grindstone.sharpening.shoppinglist.data

import grindstone.sharpening.shoppinglist.R
import grindstone.sharpening.shoppinglist.model.Product

class Datasource {

    fun loadProducts(): MutableList<Product> {
        return mutableListOf<Product>(
            Product("Bananas", null, false),
            Product("Peras", null, false),
            Product("Maças", null, false),
            Product("Cereais", null, false),
            Product("Arroz", null, false),
            Product("Agua", null, false),
            Product("Massa", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false),
            Product("Bacalhau", null, false)
        )
    }

}