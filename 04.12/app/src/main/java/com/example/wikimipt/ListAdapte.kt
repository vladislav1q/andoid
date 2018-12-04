package com.example.wikimipt
import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ListAdapte(val context: Context, val list: ArrayList<Teacher>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false)

        //val facultyText = view.findViewById(R.id.faculty_text) as AppCompatTextView
        val teacherName = view.findViewById(R.id.teacher_name) as AppCompatTextView
        val teacherUrl = view.findViewById(R.id.teacher_url) as AppCompatTextView
        teacherName.text = list[position].name
        teacherUrl.text = list[position].url

        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}