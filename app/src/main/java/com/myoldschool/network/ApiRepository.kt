package com.myoldschool.network

import androidx.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiRepository {

    @GET("/getRecords")
    fun getAllRecords(): Single<List<StudentModel>>

}