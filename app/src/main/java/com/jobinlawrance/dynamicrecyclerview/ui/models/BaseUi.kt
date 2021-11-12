package com.jobinlawrance.dynamicrecyclerview.ui.models


/**
 * Created by Jobin Lawrance on 12/11/21
 *
 * This is a marker interface that we will use as a base for all our different types of ui class
 */
interface BaseUI

data class BannerUI(val imageUrl: String): BaseUI

data class QuoteUI(val quote: String, val author: String): BaseUI

data class CarouselUI(val imageUrls: List<String>): BaseUI

data class ContactListUI(val contacts: List<ContactUI>): BaseUI

data class GridUI(val imageUrls: List<String>): BaseUI

data class ContactUI(
    val name: String,
    val avatar: String,
    val city: String,
    val id: String
)

