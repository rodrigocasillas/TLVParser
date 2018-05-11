package com.rodrigo.tlvparser

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import java.util.*

class MainActivity : AppCompatActivity() {

    internal lateinit var tlvParseEditText: EditText
    internal lateinit var tlv_string: String

    internal lateinit var parse: TLVParser
    internal lateinit var result: ArrayList<Values>
    internal lateinit var valuesArrayList: ArrayList<String>
    internal lateinit var itemsListView: ListView
    internal lateinit var arrayAdapter: ArrayAdapter<*>




    fun parseButton(view: View) {

        parse = TLVParser
        tlv_string = tlvParseEditText.text.toString()
        result = parse.parseTLV(tlv_string)

        for (entry in result) {
            valuesArrayList.add(Tags.TAG + entry.tag + Tags.EQUALS +
                    entry.tagMeaning + "\n" +
                    Tags.HEX_VALUE + entry.hexValue + "\n" + Tags.VALUE +
                    entry.value)
        }
        arrayAdapter.notifyDataSetChanged()
    }

    fun clearButton(view: View) {
        tlvParseEditText.setText("")
        valuesArrayList.clear()
        arrayAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        tlvParseEditText =  findViewById<EditText>(R.id.tlv_parse_edit_text) as EditText
        tlv_string = tlvParseEditText.text.toString()


        itemsListView = findViewById<ListView>(R.id.item_list_view) as ListView
        valuesArrayList = ArrayList()

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, valuesArrayList)
        itemsListView.adapter = arrayAdapter
    }
}

