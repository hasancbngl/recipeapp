package com.hasancbngl.recepiapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.hasancbngl.recepiapp.R
import com.hasancbngl.recepiapp.mvvm.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipe_detail.*

class RecipeDetailFragment : Fragment() {

    private val recipeViewModel: RecipeViewModel by activityViewModels()
    private val TAG = "RecipeDetailFragment"

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
                Glide.with(this).load(recipe.imageURL).into(imageView)
            }
        })
    }
}