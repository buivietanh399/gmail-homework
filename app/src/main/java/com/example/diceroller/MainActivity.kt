package com.example.diceroller

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity



class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val label = arrayOf<String>("A","B","C","D","E","F","G","H","I","K","L","M","N")
        val subtitle = arrayOf<String>(
            "Boring 1",
            "Boring 2",
            "Boring 3",
            "Boring 4",
            "Boring 5",
            "Boring 6",
            "Boring 7",
            "Boring 8",
            "Boring 10",
            "Boring 11",
            "Boring 12",
            "Boring 13",
            "Boring 14"
        )
        val time = arrayOf<String>("15:00 AM","15:00 AM","15:00 AM","15:00 AM","15:00 AM","15:00 AM","15:00 AM","15:00 AM","15:00 AM","15:00 AM","15:00 AM","15:00 AM","15:00 AM")


        val myListAdapter = MyListAdapter(this,label,time,subtitle)
        val listView:ListView = findViewById(R.id.listview_1)
        listView.adapter=myListAdapter
    }

    class MyListAdapter(private val context: Activity, private val lable: Array<String>, private val time: Array<String>, private val subtitle: Array<String>)
        : ArrayAdapter<String>(context, R.layout.listview_item, lable) {

        override fun getView(position: Int, view: View?, parent: ViewGroup): View {
            val inflater = context.layoutInflater
            val rowView = inflater.inflate(R.layout.listview_item, null, true)

            val titleText = rowView.findViewById(R.id.label) as TextView
            val avatar = rowView.findViewById(R.id.avatar) as TextView
            val timeText = rowView.findViewById(R.id.time) as TextView
            val subtitleText = rowView.findViewById(R.id.subtitle) as TextView

            avatar.text = lable[position].first().uppercase()
            titleText.text = lable[position]
            timeText.text = time[position]
            subtitleText.text = subtitle[position]

            return rowView
        }
    }
}
