package com.hasancbngl.recepiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasancbngl.recepiapp.R
import kotlinx.android.synthetic.main.instructions_list_item.view.*

class InstructionsAdapter : RecyclerView.Adapter<InstructionsAdapter.ViewHolder>() {

    private val TAG = "InstructionsAdapter"
    private var instructions = ArrayList<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InstructionsAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.instructions_list_item, parent, false)
    )

    override fun onBindViewHolder(holder: InstructionsAdapter.ViewHolder, position: Int) {
        holder.bindData(instructions[position])
    }

    override fun getItemCount(): Int = instructions.size

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(instruction: String) {
            view.instructionTextview.text = instruction
        }
    }

    fun updateInstructions(data: ArrayList<String>) {
        instructions = data
    }
}