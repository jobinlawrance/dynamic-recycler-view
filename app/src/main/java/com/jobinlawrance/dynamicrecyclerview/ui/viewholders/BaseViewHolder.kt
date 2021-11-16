package com.jobinlawrance.dynamicrecyclerview.ui.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


/**
 * Created by Jobin Lawrance on 12/11/21
 */
abstract class BaseViewHolder<in T>(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
    val context: Context = binding.root.context
    abstract fun bind(item: T)
}