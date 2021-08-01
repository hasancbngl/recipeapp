package com.hasancbngl.recepiapp.adapter

import android.provider.Settings.Global.getString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hasancbngl.recepiapp.R
import com.hasancbngl.recepiapp.model.Recipe
import kotlinx.android.synthetic.main.recipe_list_item.view.*

class AllRecipesAdapter(private val listener: OnRecipeClicked) :
    RecyclerView.Adapter<AllRecipesAdapter.ViewHolder>() {

    private var recipeList = ArrayList<Recipe>()
    private val TAG = "AllRecipesAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recipe_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(recipeList[position])
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        fun bindData(recipe: Recipe) {
            with(view) {
                recipeTitleTextview.text = recipe.name
                ingredientsAmountTextView.text =
                    resources.getString(R.string.ingredientsAmount, recipe.ingredients.size)

                Glide.with(this).load(recipe.imageURL)
                    .into(recipeContainerImageView)
                cookingTimeTextview.text =
                    resources.getString(R.string.cooking_time, recipe.timers.sum())
            }
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            listener.onRecipeClicked(recipeList[position])
        }
    }

    fun updateList(list: ArrayList<Recipe>) {
        recipeList = list
    }

    interface OnRecipeClicked {
        fun onRecipeClicked(recipe: Recipe)
    }
}