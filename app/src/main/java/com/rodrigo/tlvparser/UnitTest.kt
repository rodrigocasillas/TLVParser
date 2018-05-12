package com.rodrigo.tlvparser

import java.util.ArrayList

/**
 * Created by Rodrigo on 12/05/2018.
 */

object UnitTest {

    fun checkEquality(arrayList1: ArrayList<Values>, arrayList2: ArrayList<Values>): Boolean {

        var matchCounts = 0
        var i: Int
        var y: Int

        i = 0
        while (i < arrayList1.size) {
            y = 0
            while (y < arrayList2.size) {
                if (arrayList1[i].tag == arrayList2[y].tag && arrayList1[i].hexValue == arrayList2[y].hexValue) {

                    println(Tags.TAG + arrayList1[i].tag + Tags.EQUALS + arrayList2[y].tag)
                    println(Tags.TAG_MEANING + arrayList1[i].tagMeaning + " = " + arrayList2[y].tagMeaning)
                    println(Tags.VALUE + arrayList1[i].value + " = " + arrayList2[y].value)
                    println(Tags.HEX_VALUE + arrayList1[i].hexValue + " = " + arrayList2[y].hexValue + "\n")
                    matchCounts++
                    break
                }
                y++
            }
            i++
        }

        println(matchCounts.toString() + " of " + arrayList1.size + " matches.")

        return arrayList1.size == matchCounts
    }
}
