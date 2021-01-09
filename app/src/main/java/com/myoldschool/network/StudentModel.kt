package com.myoldschool.network

import com.google.gson.annotations.SerializedName

data class StudentModel(
    @SerializedName("sid")
    val id: Int,
    @SerializedName("marks")
    val marks: Double,
    @SerializedName("sname")
    val name: String,
    @SerializedName("rollno")
    val rollno: Int
)