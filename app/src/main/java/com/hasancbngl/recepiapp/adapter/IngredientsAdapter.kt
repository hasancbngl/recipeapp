package com.hasancbngl.recepiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasancbngl.recepiapp.R
import com.hasancbngl.recepiapp.model.Ingredient
import com.hasancbngl.recepiapp.model.Recipe
import kotlinx.android.synthetic.main.ingredient_list_item.view.*

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    private val TAG = "IngredientsAdapter"
    private var list = emptyList<Ingredient>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientsAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.ingredient_list_item, parent, false)
    )

    override fun onBindViewHolder(holder: IngredientsAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(ingredient: Ingredient) {
            with(view) {
                ingridientName.text = ingredient.name
                ingridientQeantity.text = ingredient.quantity
            }
        }
    }

    fun updateList(data: List<Ingredient>) {
        list = data
    }
}