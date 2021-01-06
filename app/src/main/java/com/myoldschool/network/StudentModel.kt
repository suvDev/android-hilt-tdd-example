package com.myoldschool.network

import com.google.gson.annotations.SerializedName

data class StudentModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("marks")
    val marks: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("rollno")
    val rollno: Int
)