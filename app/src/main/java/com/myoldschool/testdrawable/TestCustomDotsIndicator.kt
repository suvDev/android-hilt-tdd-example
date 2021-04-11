package com.myoldschool.testdrawable

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.myoldschool.R
import com.myoldschool.RecyclerViewAdapter
import com.myoldschool.network.StudentModel
import kotlinx.android.synthetic.main.activity_test_custom_dots_indicator.*


class TestCustomDotsIndicator : AppCompatActivity(), RecyclerViewAdapter.onStudentClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_custom_dots_indicator_motionlayout)

        val adapter = RecyclerViewAdapter(arrayListOf(
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3),
                StudentModel(1, 99.98, "dddd", 3)
        ), this)
        test_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        test_rv.adapter = adapter
//        ar_indicator.attachTo(test_rv, true)
//        ar_indicator.numberOfIndicators = 4
//        appbar.addOnOffsetChangedListener(OnOffsetChangedListener { appBarLayout, verticalOffset ->
//            if (Math.abs(verticalOffset) == appBarLayout.totalScrollRange) {
//                // If collapsed, then do this
//                btn_toolbar.setVisibility(View.GONE)
//                btn_bjj.setVisibility(View.VISIBLE)
//            } else if (verticalOffset == 0) {
//                // If expanded, then do this
//                btn_toolbar.setVisibility(View.VISIBLE)
//                btn_bjj.setVisibility(View.GONE)
//            } else {
//                // Somewhere in between
//                // Do according to your requirement
//            }
//        })
    }

    override fun onStudentRowClick(studentInfo: StudentModel) {

    }
}