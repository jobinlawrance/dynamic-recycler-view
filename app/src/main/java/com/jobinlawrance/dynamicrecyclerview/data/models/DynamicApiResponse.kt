package com.jobinlawrance.dynamicrecyclerview.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DynamicApiResponse(val data: List<Response>)