package com.jobinlawrance.dynamicrecyclerview.ui.models

import com.jobinlawrance.dynamicrecyclerview.ui.TypeFactory
import com.jobinlawrance.dynamicrecyclerview.ui.Visitable


/**
 * Created by Jobin Lawrance on 12/11/21
 *
 * This is a marker interface that we will use as a base for all our different types of ui class
 */
interface BaseUI: Visitable

data class BannerUI(val imageUrl: String): BaseUI {
    override fun type(typeFactory: TypeFactory): Int {
        return typeFactory.type(this)
    }
}

data class QuoteUI(val quote: String, val author: String): BaseUI {
    override fun type(typeFactory: TypeFactory): Int {
        return typeFactory.type(this)
    }
}

data class CarouselUI(val imageUrls: List<String>): BaseUI {
    override fun type(typeFactory: TypeFactory): Int {
        return typeFactory.type(this)
    }
}

data class ContactListUI(val contacts: List<ContactUI>): BaseUI {
    override fun type(typeFactory: TypeFactory): Int {
        return typeFactory.type(this)
    }
}

data class GridUI(val imageUrls: List<String>): BaseUI {
    override fun type(typeFactory: TypeFactory): Int {
        return typeFactory.type(this)
    }
}

data class ContactUI(
    val name: String,
    val avatar: String,
    val city: String,
    val id: String
)