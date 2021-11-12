package com.jobinlawrance.dynamicrecyclerview.data.api

import com.jobinlawrance.dynamicrecyclerview.data.models.DynamicApiResponse
import io.reactivex.Single
import retrofit2.http.GET


/**
 * Created by Jobin Lawrance on 27/10/21
 */
interface ApiService {
    @GET("dynamic-recycler-view/dynamic-list")
    fun getDynamicList(): Single<DynamicApiResponse>
}