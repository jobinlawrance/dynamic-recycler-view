package com.jobinlawrance.dynamicrecyclerview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jobinlawrance.dynamicrecyclerview.data.models.ResponseType
import com.jobinlawrance.dynamicrecyclerview.ui.models.*
import com.jobinlawrance.dynamicrecyclerview.ui.viewholders.*
import layout.BannerViewHolder


/**
 * Created by Jobin Lawrance on 17/11/21
 */
interface TypeFactory {
    fun type(bannerUI: BannerUI): Int
    fun type(quoteUI: QuoteUI): Int
    fun type(carouselUI: CarouselUI): Int
    fun type(contactListUI: ContactListUI): Int
    fun type(gridUI: GridUI): Int

    fun holder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*>
}

class TypeFactoryImpl : TypeFactory {
    override fun type(bannerUI: BannerUI): Int = ResponseType.BANNER.ordinal
    override fun type(quoteUI: QuoteUI): Int = ResponseType.QUOTE.ordinal
    override fun type(carouselUI: CarouselUI): Int = ResponseType.CAROUSEL.ordinal
    override fun type(contactListUI: ContactListUI): Int = ResponseType.CONTACT.ordinal
    override fun type(gridUI: GridUI): Int = ResponseType.GRID.ordinal

    override fun holder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*> {
        return when (viewType) {
            ResponseType.BANNER.ordinal -> BannerViewHolder.createViewHolder(inflater, parent)
            ResponseType.QUOTE.ordinal -> QuoteViewHolder.createViewHolder(inflater, parent)
            ResponseType.CAROUSEL.ordinal -> CarouselViewHolder.createViewHolder(inflater, parent)
            ResponseType.CONTACT.ordinal -> ContactsViewHolder.createViewHolder(inflater, parent)
            ResponseType.GRID.ordinal -> GridViewHolder.createViewHolder(inflater, parent)
            else -> throw IllegalArgumentException("The viewtype value of $viewType is not supported")
        }
    }
}