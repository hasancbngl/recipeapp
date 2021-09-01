package com.hasancbngl.recepiapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.hasancbngl.recepiapp.model.Recipe
import com.hasancbngl.recepiapp.mvvm.RecipeViewModel
import com.hasancbngl.recepiapp.repository.RecipeRepository
import io.reactivex.rxjava3.core.Observable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class RecipeViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val repository: RecipeRepository = mock()

    //view model instanciate for every test case
    private lateinit var viewModel: RecipeViewModel
    private val mockObserver: Observer<List<Recipe>> = mock()

    //function will run before every test
    @Before
    fun `set up`() {
        viewModel = RecipeViewModel(repository)
    }

    @Test
    fun `getRecipes-given list of three items, live data should return three items`() {
        val list = listOf(
            Recipe(
                "chickenpie", emptyList(), emptyList(),
                emptyList(), "url", "originalUrl"
            ),
            Recipe(
                "chickenpie", emptyList(), emptyList(),
                emptyList(), "url", "originalUrl"
            ),
            Recipe(
                "chickenpie", emptyList(), emptyList(),
                emptyList(), "url", "originalUrl"
            ),
        )

        whenever(repository.allRecipes()).thenReturn(Observable.just(list))
        viewModel.list.observeForever(mockObserver)
        viewModel.getRecipes()
        verify(mockObserver).onChanged(list)
    }
}