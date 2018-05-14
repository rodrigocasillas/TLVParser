package com.rodrigo.tlvparser

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import java.util.*



class MainActivity : AppCompatActivity() {

    internal lateinit var tlvParseEditText: EditText
    internal lateinit var tlvString: String

    internal lateinit var parse: TLVParser
    internal lateinit var result: ArrayList<Values>
    internal lateinit var itemsListView: ListView
    internal lateinit var valuesAdapter: ValuesAdapter

    fun parseButton(view: View) {

        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        parse = TLVParser
        tlvString = tlvParseEditText.text.toString()

        try {
            result = parse.parseTLV(tlvString)
        } catch (e: RuntimeException) {
            Toast.makeText(this, "Invalid tlv, null or odd length", Toast.LENGTH_SHORT).show()
        }

        valuesAdapter.clear()
        valuesAdapter.addAll(result)
    }

    fun clearButton(view: View) {
        tlvParseEditText.setText("")
        valuesAdapter.clear()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tlvParseEditText =  findViewById<EditText>(R.id.tlv_parse_edit_text) as EditText
        tlvString = tlvParseEditText.text.toString()
        result = ArrayList()

        itemsListView = findViewById<ListView>(R.id.item_list_view) as ListView

        valuesAdapter = ValuesAdapter(this, R.layout.values_list_item, result)
        itemsListView.adapter = valuesAdapter
    }
}

