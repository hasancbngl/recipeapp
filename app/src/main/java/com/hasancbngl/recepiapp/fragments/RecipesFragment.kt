package com.hasancbngl.recepiapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasancbngl.recepiapp.R
import com.hasancbngl.recepiapp.adapter.AllRecipesAdapter
import com.hasancbngl.recepiapp.model.Recipe
import com.hasancbngl.recepiapp.mvvm.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipes.*

class RecipesFragment : Fragment() {

    private val recipeViewModel: RecipeViewModel by activityViewModels()
    private val TAG = "RecipesFragment"
    private lateinit var recipeAdapter: AllRecipesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView: fragment started")
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeViewModel.list.observe(
            requireActivity(),
            { recipes ->
                initRecycler(recipes)
            })
    }

    private fun initRecycler(recipes: ArrayList<Recipe>) {
        allRecipesRecyclerview.apply {
            recipeAdapter = AllRecipesAdapter()
            val manager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            layoutManager = manager
            adapter = recipeAdapter
        }
        recipeAdapter.updateList(recipes)
    }
}