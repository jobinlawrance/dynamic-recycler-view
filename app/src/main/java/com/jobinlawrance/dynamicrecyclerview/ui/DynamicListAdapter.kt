package com.jobinlawrance.dynamicrecyclerview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jobinlawrance.dynamicrecyclerview.data.models.ResponseType.*
import com.jobinlawrance.dynamicrecyclerview.ui.models.*
import com.jobinlawrance.dynamicrecyclerview.ui.viewholders.*
import layout.BannerViewHolder


/**
 * Created by Jobin Lawrance on 12/11/21
 */
class DynamicListAdapter(private val typeFactory: TypeFactory) : RecyclerView.Adapter<BaseViewHolder<BaseUI>>() {

    private var uiList = emptyList<BaseUI>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseUI> {
        val inflater = LayoutInflater.from(parent.context)
        return typeFactory.holder(inflater, parent, viewType) as BaseViewHolder<BaseUI>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseUI>, position: Int) {
        holder.bind(uiList[position])
    }

    override fun getItemCount(): Int = uiList.size

    override fun getItemViewType(position: Int): Int {
        return uiList[position].type(typeFactory)
    }

    fun setUIList(uiList: List<BaseUI>) {
        this.uiList = uiList
        notifyDataSetChanged()
    }

}