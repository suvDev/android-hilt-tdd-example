package com.myoldschool.testdrawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.myoldschool.R
import com.myoldschool.RecyclerViewAdapter
import com.myoldschool.network.StudentModel
import kotlinx.android.synthetic.main.activity_test_custom_dots_indicator.*

class TestCustomDotsIndicator : AppCompatActivity(), RecyclerViewAdapter.onStudentClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_custom_dots_indicator)

        val adapter = RecyclerViewAdapter(arrayListOf(
            StudentModel(1,99.98,"dddd",3),
            StudentModel(1,99.98,"dddd",3),
            StudentModel(1,99.98,"dddd",3),
            StudentModel(1,99.98,"dddd",3)
        ), this)
        test_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        test_rv.adapter = adapter
        ar_indicator.attachTo(test_rv, true)
        ar_indicator.numberOfIndicators = 4
    }

    override fun onStudentRowClick(studentInfo: StudentModel) {

    }
}