package com.hasancbngl.recepiapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.hasancbngl.recepiapp.R
import com.hasancbngl.recepiapp.adapter.IngredientsAdapter
import com.hasancbngl.recepiapp.adapter.InstructionsAdapter
import com.hasancbngl.recepiapp.model.Recipe
import com.hasancbngl.recepiapp.mvvm.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipe_detail.*

@AndroidEntryPoint
class RecipeDetailFragment : Fragment() {

    private val recipeViewModel: RecipeViewModel by activityViewModels()
    private lateinit var ingredientsAdapter: IngredientsAdapter
    private lateinit var instructionsAdapter: InstructionsAdapter
    private val TAG = "RecipeDetailFragment"
    private var mContext : Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeViewModel.getClickedRecipe().observe(requireActivity(), { recipe ->
            run {
                Glide.with(view).load(recipe.imageURL).into(imageView)
                initRecyclers(recipe)
                ingredientsTitle.text = getString(R.string.ingredients, recipe.ingredients.size)
            }
        })
    }

    private fun initRecyclers(recipe: Recipe) {
        ingredientsRecycler.apply {
            ingredientsAdapter = IngredientsAdapter()
            val manager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
            layoutManager = manager
            adapter = ingredientsAdapter
        }
        ingredientsAdapter.updateList(recipe.ingredients)

        instrucitonsRecycler.apply {
            instructionsAdapter = InstructionsAdapter()
            val manager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
            layoutManager = manager
            adapter = instructionsAdapter
        }
        instructionsAdapter.updateInstructions(recipe.steps)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context.applicationContext
    }

    override fun onDetach() {
        super.onDetach()
        mContext = null
    }
}