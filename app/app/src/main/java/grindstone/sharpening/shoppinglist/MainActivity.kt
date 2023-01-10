package grindstone.sharpening.shoppinglist

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import grindstone.sharpening.shoppinglist.adapters.ProductAdapter
import grindstone.sharpening.shoppinglist.data.Datasource
import grindstone.sharpening.shoppinglist.model.Product
import grindstone.sharpening.shoppinglist.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val PRODUCTS_KEY = "PRODUCTS"

    private lateinit var binding: ActivityMainBinding
    private lateinit var dataSet: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize data
        dataSet = arrayListOf<Product>()
        dataSet.addAll(Datasource().loadProducts())
        Log.d(TAG, "Dataset #: " + dataSet.count())

        val recyclerView = findViewById<RecyclerView>(R.id.listViewProductsList)
        recyclerView.adapter = ProductAdapter(dataSet)
    }
}