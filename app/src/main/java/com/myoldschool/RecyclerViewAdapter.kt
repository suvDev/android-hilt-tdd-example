package com.myoldschool

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myoldschool.network.StudentModel
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class RecyclerViewAdapter(private val studentList: List<StudentModel>,
                          private val onStudentRowClick: onStudentClick): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = holder.itemView

        item.name.text = studentList[position].name
        item.sid.text = studentList[position].id.toString()
        item.marks.text = studentList[position].marks.toString()
        item.rollnum.text = studentList[position].rollno.toString()

        holder.itemView.setOnClickListener {
            onStudentRowClick.onStudentRowClick(studentList[position])
        }
    }

    override fun getItemCount() = studentList.size

    interface onStudentClick{
        fun onStudentRowClick(studentInfo: StudentModel)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}