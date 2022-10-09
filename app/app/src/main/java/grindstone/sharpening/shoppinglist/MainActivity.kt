package grindstone.sharpening.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import grindstone.sharpening.shoppinglist.adapters.ListViewAdapter
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

        setupListView(productsList)
    }

    /**
     * Setup the ListView with the current list of products
     * @param productsList String List with the products
     */
    private fun setupListView(productsList: List<String>) {

        val listAdapterProducts = ListViewAdapter(this, productsList)

        binding.listViewProductsList.adapter = listAdapterProducts

        binding.listViewProductsList.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            val linearLayout = view as LinearLayout

            val txtView = linearLayout.getChildAt(0) as TextView

            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_SHORT).show()
        }

    }
}