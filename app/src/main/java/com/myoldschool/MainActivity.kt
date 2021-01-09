package com.myoldschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myoldschool.network.CustomAnnotationModule
import com.myoldschool.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {

     val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.testInit()
        viewModel.getAllRecords()
        viewModel.observeGetAllRecordsAPI.observe({this.lifecycle},{
            for(student in it){
                System.out.println("Student name: ${student.name}")
                progressbar.visibility = View.GONE
                val adapter = RecyclerViewAdapter(it)
                student_rv.layoutManager = LinearLayoutManager(this)
                student_rv.adapter = adapter
            }
        })
    }
}