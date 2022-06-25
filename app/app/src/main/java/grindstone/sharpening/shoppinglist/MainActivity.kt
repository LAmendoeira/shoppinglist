package grindstone.sharpening.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import grindstone.sharpening.shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productsList: List<String> = listOf("Apples", "Bananas", "Rice", "Pasta", "Mama mia")

        populateProductsList(productsList)
    }

    fun populateProductsList(productsList: List<String>) {

        val iterator = productsList.listIterator()

        while (iterator.hasNext()) {
            val product = iterator.next()
            Log.v(TAG, product)
            binding.linearLayoutProductsList.addView(createTextViewProduct(product))

        }
    }

    fun createTextViewProduct(product: String): TextView {

        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val txtView = TextView(this)
        txtView.layoutParams = layoutParams
        txtView.text = product

        return txtView
    }
}