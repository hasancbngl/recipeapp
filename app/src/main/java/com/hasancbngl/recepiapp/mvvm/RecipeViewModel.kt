package com.hasancbngl.recepiapp.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasancbngl.recepiapp.model.Recipe
import com.hasancbngl.recepiapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {
    val list = MutableLiveData<List<Recipe>>()
    private val disposable = CompositeDisposable()
    var recipe = MutableLiveData<Recipe>()

    fun getClickedRecipe() = recipe

    fun getRecipes() {
        disposable.add(
            repository.allRecipes().subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread()).subscribe(this::onRecipeLoaded, this::onError)
        )
    }

    fun updateChosenRecipe(recipe: Recipe) {
        this.recipe.postValue(recipe)
    }

    private fun onRecipeLoaded(recipe: List<Recipe>) {
        list.postValue(recipe)
    }

    private fun onError(t: Throwable) {
        t.printStackTrace()
    }
}