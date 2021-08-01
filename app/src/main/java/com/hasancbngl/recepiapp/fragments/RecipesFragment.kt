package com.hasancbngl.recepiapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.hasancbngl.recepiapp.R
import com.hasancbngl.recepiapp.mvvm.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipes.*

class RecipesFragment : Fragment() {

    private val recipeViewModel: RecipeViewModel by activityViewModels()
    private val TAG = "RecipesFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeViewModel.list.observe(
            requireActivity(),
            { recipes -> Log.i(TAG, "onViewCreated: $recipes") })

        initRecycler()
    }

    private fun initRecycler() {
        allRecipesRecyclerview.apply {

        }
    }
}