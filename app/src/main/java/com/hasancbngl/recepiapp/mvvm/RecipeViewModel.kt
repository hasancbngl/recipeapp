package com.hasancbngl.recepiapp.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasancbngl.recepiapp.model.Recipe
import com.hasancbngl.recepiapp.network.RecipeClient
import com.hasancbngl.recepiapp.repository.RecipeRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RecipeViewModel : ViewModel() {
    val list = MutableLiveData<ArrayList<Recipe>>()
    private val client = RecipeClient
    private val repository = RecipeRepository(client)
    private val disposable = CompositeDisposable()

    fun getRecipes() {
        disposable.add(
            repository.getRecipes().allRecipes().subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread()).subscribe(this::onRecipeLoaded, this::onError)
        )
    }

    private fun onRecipeLoaded(recipe: ArrayList<Recipe>) {
        list.postValue(recipe)
    }

    private fun onError(t: Throwable) {
        t.printStackTrace()
    }
}