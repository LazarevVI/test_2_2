package com.example.test_2_2

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView


class CustomAdapter(private val context: Context, private val dataSource: ArrayList<visitor>)
    : BaseAdapter() {

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var timeTextView: TextView

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_list, parent, false)

        nameTextView = convertView.findViewById(R.id.name) as TextView
        emailTextView = convertView.findViewById(R.id.email) as TextView
        ageTextView = convertView.findViewById(R.id.age) as TextView
        timeTextView = convertView.findViewById(R.id.time) as TextView

        val currentvisitor = getItem(position) as visitor

        nameTextView.text = currentvisitor.visitor_name
        emailTextView.text = currentvisitor.email
        ageTextView.text = currentvisitor.age.toString()
        timeTextView.text = currentvisitor.arrival_time


        return convertView
    }

}