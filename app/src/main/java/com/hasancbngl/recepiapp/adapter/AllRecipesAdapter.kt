package com.hasancbngl.recepiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasancbngl.recepiapp.R
import com.hasancbngl.recepiapp.model.Recipe

class AllRecipesAdapter() : RecyclerView.Adapter<AllRecipesAdapter.ViewHolder>() {

    private var recipeList = ArrayList<Recipe>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllRecipesAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recipe_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AllRecipesAdapter.ViewHolder, position: Int) {
        holder.bindData(recipeList[position])
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(recipe: Recipe) {

        }
    }

    fun updateList(list: ArrayList<Recipe>) {
        recipeList = list
    }
}