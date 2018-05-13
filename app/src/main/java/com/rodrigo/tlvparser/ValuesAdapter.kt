package com.rodrigo.tlvparser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList

/**
 * Created by Rodrigo on 13/05/2018.
 */

class ValuesAdapter(context: Context, layoutId: Int, valuesArrayList: ArrayList<Values>) : ArrayAdapter<Values>(context, layoutId, valuesArrayList) {
    var layoutId : Int
    var valuesArrayList: ArrayList<Values>
    var context : LayoutInflater

    init {
        this.valuesArrayList = valuesArrayList
        this.layoutId = layoutId
        this.context = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var holder: ViewHolder
        var retView: View

        if(convertView == null){
            retView = context.inflate(layoutId, null)
            holder = ViewHolder()

            holder.tagAndMeaningTextView = retView.findViewById<TextView>(R.id.tag_and_meaning_text_view)
            holder.valueTextView = retView.findViewById<TextView>(R.id.value_text_view)
            holder.hexadecimalValue = retView.findViewById<TextView>(R.id.hexadecimal_value_text_view)

            retView.tag = holder

        } else {
            holder = convertView.tag as ViewHolder
            retView = convertView
        }

        val values = valuesArrayList[position]

        holder.tagAndMeaningTextView!!.text = (Tags.TAG + values.tag + Tags.EQUALS + values.tagMeaning)
        holder.valueTextView!!.text = Tags.VALUE + values.value!!
        holder.hexadecimalValue!!.text = Tags.HEX_VALUE + values.hexValue!!

        return retView
    }

    internal class ViewHolder {
        var tagAndMeaningTextView: TextView? = null
        var valueTextView: TextView? = null
        var hexadecimalValue: TextView? = null
    }
}
