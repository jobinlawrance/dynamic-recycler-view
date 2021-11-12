package com.jobinlawrance.dynamicrecyclerview

import com.jobinlawrance.dynamicrecyclerview.data.models.*
import com.jobinlawrance.dynamicrecyclerview.ui.models.*


/**
 * Created by Jobin Lawrance on 12/11/21
 */

fun Banner.toBannerUI() = BannerUI(imageUrl = bannerUrl)

fun Quote.toQuoteUI() = QuoteUI(quote, author)

fun Carousel.toCarouselUI() = CarouselUI(imageUrls)

fun Contact.toContactUI() = ContactUI(name, avatar, city, id)

fun Contacts.toContactListUI() =
    ContactListUI(contacts = contactList.map { it.toContactUI() })

fun Grid.toGridUI() = GridUI(imageUrls = gridUrls)

fun Response.toBaseUI(): BaseUI =
    when (this) {
        is Banner -> this.toBannerUI()
        is Carousel -> this.toCarouselUI()
        is Contacts -> this.toContactListUI()
        is Grid -> this.toGridUI()
        is Quote -> this.toQuoteUI()
    }

fun List<Response>.toBaseUIList(): List<BaseUI> {
    return this.map { it.toBaseUI() }
}