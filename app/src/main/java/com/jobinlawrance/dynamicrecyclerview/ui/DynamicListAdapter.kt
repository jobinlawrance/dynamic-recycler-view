package com.jobinlawrance.dynamicrecyclerview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jobinlawrance.dynamicrecyclerview.data.models.ResponseType.*
import com.jobinlawrance.dynamicrecyclerview.databinding.*
import com.jobinlawrance.dynamicrecyclerview.ui.models.*
import com.jobinlawrance.dynamicrecyclerview.ui.viewholders.*
import layout.BannerViewHolder


/**
 * Created by Jobin Lawrance on 12/11/21
 */
class DynamicListAdapter : RecyclerView.Adapter<BaseViewHolder<BaseUI>>() {

    private var uiList = emptyList<BaseUI>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseUI> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            BANNER.ordinal -> {
                val binding = ViewholderBannerBinding.inflate(inflater, parent, false)
                BannerViewHolder(binding)
            }
            QUOTE.ordinal -> {
                val binding = ViewholderQuoteBinding.inflate(inflater, parent, false)
                QuoteViewHolder(binding)
            }
            CAROUSEL.ordinal -> {
                val binding = ViewholderCarouselBinding.inflate(inflater, parent, false)
                CarouselViewHolder(binding)
            }
            CONTACT.ordinal -> {
                val binding = ViewholderContactsBinding.inflate(inflater, parent, false)
                ContactsViewHolder(binding)
            }
            GRID.ordinal -> {
                val binding = ViewholderGridBinding.inflate(inflater, parent, false)
                GridViewHolder(binding)
            }
            else -> throw IllegalArgumentException("The viewtype value of $viewType is not supported")
        } as BaseViewHolder<BaseUI>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseUI>, position: Int) {
        holder.bind(uiList[position])
    }

    override fun getItemCount(): Int = uiList.size

    override fun getItemViewType(position: Int): Int {
        return when (uiList[position]) {
            is BannerUI -> BANNER.ordinal
            is QuoteUI -> QUOTE.ordinal
            is CarouselUI -> CAROUSEL.ordinal
            is ContactListUI -> CONTACT.ordinal
            is GridUI -> GRID.ordinal
            else -> -1
        }
    }

    fun setUIList(uiList: List<BaseUI>) {
        this.uiList = uiList
        notifyDataSetChanged()
    }

}