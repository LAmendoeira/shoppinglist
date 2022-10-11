package grindstone.sharpening.shoppinglist.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import grindstone.sharpening.shoppinglist.R

class ListViewAdapter(private val context: Activity, private val products: List<String>) :
    ArrayAdapter<String>(context, R.layout.list_view_item, products) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_view_item, null, true)

        val titleText = rowView.findViewById(R.id.textView) as TextView
        //val imageView = rowView.findViewById(R.id.icon) as ImageView
        //val subtitleText = rowView.findViewById(R.id.description) as TextView

        titleText.text = products[position]
        titleText.setTextAppearance(R.style.todoText)
        //imageView.setImageResource(imgid[position])
        //subtitleText.text = description[position]

        return rowView
    }
}