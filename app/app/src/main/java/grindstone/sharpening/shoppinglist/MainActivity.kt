package grindstone.sharpening.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import grindstone.sharpening.shoppinglist.adapters.ListViewAdapter
import grindstone.sharpening.shoppinglist.data.Product
import grindstone.sharpening.shoppinglist.databinding.ActivityMainBinding
import grindstone.sharpening.shoppinglist.dialogFragments.AddProductDialogFragment

class MainActivity : AppCompatActivity(), AddProductDialogFragment.DialogListener {

    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapterProducts: ListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize buttons event listners
        initButtons()

        //Just a testing list with products
        val productsList: List<String> = listOf(
            "Arroz",
            "Bananas",
            "Massa",
            "Diogo",
            "Hamburguer",
            "Arroz",
            "Bananas",
            "Massa",
            "Diogo"
        )

        setupListView(initProducts(productsList.sorted()))
    }

    /**
     * Setup the ListView with the current list of products
     * @param productsList ArrayList with Product objects
     */
    private fun setupListView(productsList: ArrayList<Product>) {

        listAdapterProducts = ListViewAdapter(this, productsList)

        binding.listViewProductsList.adapter = listAdapterProducts

        binding.listViewProductsList.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            val linearLayout = view as LinearLayout

            val txtView = linearLayout.getChildAt(0) as TextView

            if (itemAtPos is Product) {
                if (!itemAtPos.done) {
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

    /**
     * Setup event listeners in the buttons for this activity
     */
    private fun initButtons() {
        //FAB add product
        binding.fabAddProduct.setOnClickListener { view ->
            val newFragment = AddProductDialogFragment()
            newFragment.show(supportFragmentManager, "addProduct")
        }
    }

    /**
     * Receives the positive event from the Add Product Dialog
     */
    override fun onDialogPositiveClick(dialog: DialogFragment) {
        val dialogView = dialog.dialog
        if (dialogView != null) {
            val editTextProduct: EditText = dialogView.findViewById(R.id.editTextAddProduct)
            addProduct(editTextProduct.text.toString())
        }
    }

    /**
     * Receives the negative event from the Add Product Dialog
     */
    override fun onDialogNegativeClick(dialog: DialogFragment) {
        dialog.dialog?.cancel()
    }

    /**
     * Adds a new product to the ListView
     */
    private fun addProduct(name: String) {
        listAdapterProducts.add(Product(name, "", false))
    }
}