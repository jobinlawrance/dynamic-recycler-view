package com.jobinlawrance.dynamicrecyclerview.data.models

import com.squareup.moshi.Json


/**
 * Created by Jobin Lawrance on 27/10/21
 */

sealed class Response(@Json(name = "type") val type: ResponseType)

data class Banner(@Json(name = "banner-url") val bannerUrl: String) : Response(ResponseType.BANNER)

data class Quote(val quote: String, val author: String) : Response(ResponseType.QUOTE)

data class Carousel(@Json(name = "image-urls") val imageUrls: List<String>) :
    Response(ResponseType.CAROUSEL)

data class Contacts(@Json(name = "contacts") val contactList: List<Contact>) :
    Response(ResponseType.CONTACT)

data class Grid(@Json(name = "grid-urls") val gridUrls: List<String>) : Response(ResponseType.GRID)

data class Contact(
    val name: String,
    val avatar: String,
    val city: String,
    val id: String
)

enum class ResponseType {
    @Json(name = "banner") BANNER,
    @Json(name = "quote") QUOTE,
    @Json(name = "carousel") CAROUSEL,
    @Json(name = "contact") CONTACT,
    @Json(name = "grid") GRID
}