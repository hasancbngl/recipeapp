package com.hasancbngl.recepiapp.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasancbngl.recepiapp.MainActivity
import com.hasancbngl.recepiapp.R
import com.hasancbngl.recepiapp.adapter.AllRecipesAdapter
import com.hasancbngl.recepiapp.model.Recipe
import com.hasancbngl.recepiapp.mvvm.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipes.*

@AndroidEntryPoint
class RecipesFragment : Fragment(), AllRecipesAdapter.OnRecipeClicked {

    private val recipeViewModel: RecipeViewModel by activityViewModels()
    private val TAG = "RecipesFragment"
    private lateinit var recipeAdapter: AllRecipesAdapter
    private lateinit var mActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView: fragment started")
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeRecipes()
    }


    private fun observeRecipes() {
        recipeViewModel.list.observe(
            requireActivity(),
            { recipes ->
                initRecycler(recipes)
            })
    }

    private fun initRecycler(recipes: ArrayList<Recipe>) {
        allRecipesRecyclerview.apply {
            recipeAdapter = AllRecipesAdapter(this@RecipesFragment)
            val manager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            layoutManager = manager
            adapter = recipeAdapter
        }
        recipeAdapter.updateList(recipes)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = requireActivity()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onRecipeClicked(recipe: Recipe) {
        recipeViewModel.updateChosenRecipe(recipe)
        findNavController().navigate(R.id.action_recipesFragment_to_recipeDetailFragment)
    }
}