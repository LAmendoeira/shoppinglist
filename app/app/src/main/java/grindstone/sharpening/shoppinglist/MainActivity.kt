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

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        recyclerView.setHasFixedSize(true)




//        //Initialize buttons event listners
//        initButtons()
//
//        //Just a testing list with products
//        val productsList: List<String> = listOf(
//            "Arroz",
//            "Bananas",
//            "Massa",
//            "Diogo",
//            "Hamburguer",
//            "Arroz",
//            "Bananas",
//            "Massa",
//            "Diogo"
//        )
//
//        //Read saved values if applicable
//        if (savedInstanceState != null) {
//            listProducts = savedInstanceState.getParcelableArrayList<Product>(PRODUCTS_KEY) as ArrayList<Product>
//        }

//        setupListView(initProducts(productsList.sorted()))
//    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putParcelableArrayList(PRODUCTS_KEY, listProducts)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        listProducts = savedInstanceState.getParcelableArrayList<Product>(PRODUCTS_KEY) as ArrayList<Product>
//    }

    /**
     * Setup the ListView with the current list of products
     * @param productsList ArrayList with Product objects
     */
//    private fun setupListView(productsList: ArrayList<Product>) {
//
//        listAdapterProducts = ListViewAdapter(this, productsList)
//
//        binding.listViewProductsList.adapter = listAdapterProducts
//
//        binding.listViewProductsList.setOnItemClickListener() { adapterView, view, position, id ->
//            val itemAtPos = adapterView.getItemAtPosition(position)
//            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
//
//            val linearLayout = view as LinearLayout
//
//            val txtView = linearLayout.getChildAt(0) as TextView
//
//            if (itemAtPos is Product) {
//                if (!itemAtPos.done) {
//                    itemAtPos.done = true
//                    txtView.setTextAppearance(R.style.doneText)
//                } else {
//                    itemAtPos.done = false
//                    txtView.setTextAppearance(R.style.todoText)
//                }
//            }
//        }
//
//        binding.listViewProductsList.setOnItemLongClickListener() { adapterView, view, position, id ->
//            val itemAtPos = adapterView.getItemAtPosition(position)
//            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
//
//            val linearLayout = view as LinearLayout
//
//            val txtView = linearLayout.getChildAt(0) as TextView
//
//            if (itemAtPos is Product) {
//                deleteProduct(itemAtPos)
//            }
//            true
//        }
//
    }
//
//    /**
//     * Setup the ArrayList with Product objects based on a list of strings
//     * @param productsList String List with the products
//     */
//    private fun initProducts(productsList: List<String>): ArrayList<Product> {
//
//        if(!this::listProducts.isInitialized) {
//            listProducts = ArrayList()
//
//            for (product in productsList) {
//                listProducts.add(Product(product, "", false))
//            }
//        }
//        return listProducts
//    }
//
//    /**
//     * Setup event listeners in the buttons for this activity
//     */
//    private fun initButtons() {
//        //FAB add product
//        binding.fabAddProduct.setOnClickListener { view ->
//            val newFragment = AddProductDialogFragment()
//            newFragment.show(supportFragmentManager, "addProduct")
//        }
//    }
//
//    /**
//     * Receives the positive event from the Add Product Dialog
//     */
//    override fun onDialogPositiveClick(dialog: DialogFragment) {
//        val dialogView = dialog.dialog
//        if (dialogView != null) {
//            val editTextProduct: EditText = dialogView.findViewById(R.id.editTextAddProduct)
//            addProduct(editTextProduct.text.toString())
//        }
//    }
//
//    /**
//     * Receives the negative event from the Add Product Dialog
//     */
//    override fun onDialogNegativeClick(dialog: DialogFragment) {
//        dialog.dialog?.cancel()
//    }
//
//    /**
//     * Adds a new product to the ListView
//     */
//    private fun addProduct(name: String) {
//        listAdapterProducts.add(Product(name, "", false))
//    }
//
//    /**
//     * Adds a new product to the ListView
//     */
//    private fun deleteProduct(product: Product) {
//        listAdapterProducts.remove(product)
//        listProducts.remove(product)
//    }
}