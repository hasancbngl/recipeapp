package com.hasancbngl.recepiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.hasancbngl.recepiapp.model.Recipe
import com.hasancbngl.recepiapp.mvvm.RecipeViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val viewModel : RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.list.observe(this, { recipes -> Log.i(TAG, "onCreate: $recipes") })
        viewModel.getRecipes()

        //todo add hilt dependency injection
        //recyclerview and update UI
    }
}