package com.myoldschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myoldschool.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_student_info.*

@AndroidEntryPoint
class StudentInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)

        initViews()
    }

    private fun initViews(){
        val bundle = intent.extras
        sid.text = bundle?.getString(Constants.ID)
        name.text = bundle?.getString(Constants.NAME)
        rollnum.text = bundle?.getString(Constants.RollNum)
        marks.text = bundle?.getString(Constants.MARKS)

    }
}