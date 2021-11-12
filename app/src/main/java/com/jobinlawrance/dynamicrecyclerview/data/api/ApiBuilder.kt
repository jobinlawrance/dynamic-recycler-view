package com.jobinlawrance.dynamicrecyclerview.data.api

import com.jobinlawrance.dynamicrecyclerview.data.models.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Jobin Lawrance on 27/10/21
 *
 * NOTE - Do not create and use builders like this in a production app, create a singleton or inject one
 * using DI libraries like Dagger, Koin etc.
 */

val polymorphicAdapter = 
    PolymorphicJsonAdapterFactory.of(Response::class.java, "type")
            .withSubtype(Banner::class.java, "banner")
            .withSubtype(Quote::class.java, "quote")
            .withSubtype(Carousel::class.java, "carousel")
            .withSubtype(Contacts::class.java, "contact")
            .withSubtype(Grid::class.java, "grid")

val moshi: Moshi = Moshi.Builder()
    .add(polymorphicAdapter)
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://my-json-server.typicode.com/jobinlawrance/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

val apiService = retrofit.create(ApiService::class.java)



