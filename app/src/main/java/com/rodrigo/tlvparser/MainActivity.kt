package com.rodrigo.tlvparser

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import java.util.*



class MainActivity : AppCompatActivity() {

    internal lateinit var tlvParseEditText: EditText
    internal lateinit var tlvString: String

    internal lateinit var parse: TLVParser
    internal lateinit var result: ArrayList<Values>
    internal lateinit var valuesArrayList: ArrayList<String>
    internal lateinit var itemsListView: ListView
    internal lateinit var arrayAdapter: ArrayAdapter<*>

    fun parseButton(view: View) {

        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        parse = TLVParser
        tlvString = tlvParseEditText.text.toString()
        result = parse.parseTLV(tlvString)

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

        tlvParseEditText =  findViewById<EditText>(R.id.tlv_parse_edit_text) as EditText
        tlvString = tlvParseEditText.text.toString()

        itemsListView = findViewById<ListView>(R.id.item_list_view) as ListView
        valuesArrayList = ArrayList()

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, valuesArrayList)
        itemsListView.adapter = arrayAdapter
    }
}

