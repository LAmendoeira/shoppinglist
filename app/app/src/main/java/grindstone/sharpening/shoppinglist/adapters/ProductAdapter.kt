package grindstone.sharpening.shoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import grindstone.sharpening.shoppinglist.R
import grindstone.sharpening.shoppinglist.model.Product

class ProductAdapter(private val dataset: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_view_item, parent, false)

        return ProductViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var item = dataset[position]
        holder.textView.text = item.name

        //Invoked on first call to set the correct text appearence from the start
        toggleProductDone(item, holder.textView)

        holder.textView.setOnClickListener {
            item.done = !item.done
            toggleProductDone(item, holder.textView)
        }
    }

    override fun getItemCount() = dataset.size

    fun toggleProductDone(item: Product, txtView: TextView) {

        if (!item.done) {
            txtView.setTextAppearance(R.style.todoText)
        } else {
            txtView.setTextAppearance(R.style.doneText)
        }

    }

}