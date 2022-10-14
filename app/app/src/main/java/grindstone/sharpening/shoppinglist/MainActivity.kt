package grindstone.sharpening.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import grindstone.sharpening.shoppinglist.adapters.ListViewAdapter
import grindstone.sharpening.shoppinglist.data.Product
import grindstone.sharpening.shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Just a testing list with products
        val productsList: List<String> = listOf("Arroz", "Bananas", "Massa", "Diogo", "Hamburguer", "Arroz", "Bananas", "Massa", "Diogo", "Hamburguer","Arroz", "Bananas", "Massa", "Diogo", "Hamburguer","Arroz", "Bananas", "Massa", "Diogo", "Hamburguer","Arroz", "Bananas", "Massa", "Diogo", "Hamburguer","Arroz", "Bananas", "Massa", "Diogo", "Hamburguer","Arroz", "Bananas", "Massa", "Diogo", "Hamburguer","Arroz", "Bananas", "Massa", "Diogo", "Hamburguer")

        setupListView(initProducts(productsList.sorted()))

    }

    /**
     * Setup the ListView with the current list of products
     * @param productsList ArrayList with Product objects
     */
    private fun setupListView(productsList: ArrayList<Product>) {

        val listAdapterProducts = ListViewAdapter(this, productsList)

        binding.listViewProductsList.adapter = listAdapterProducts

        binding.listViewProductsList.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            val linearLayout = view as LinearLayout

            val txtView = linearLayout.getChildAt(0) as TextView
//            txtView.setTextAppearance(R.style.doneText)

//            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_SHORT).show()

            if (itemAtPos is Product) {
                if(!itemAtPos.done) {
                    itemAtPos.done = true
                    txtView.setTextAppearance(R.style.doneText)
                } else {
                    itemAtPos.done = false
                    txtView.setTextAppearance(R.style.todoText)
                }
            }
        }
    }

    /**
     * Setup the ArrayList with Product objects based on a list of strings
     * @param productsList String List with the products
     */
    private fun initProducts(productsList: List<String>): ArrayList<Product> {

        var products: ArrayList<Product> = ArrayList()

        for (product in productsList) {
            products.add(Product(product, "", false))
        }

        return products

    }
}