package com.rodrigo.tlvparser

object TLVParser {

    fun parseTLV(tlv:String):ArrayList<Values> {

        if (tlv == null || tlv.length % 2 != 0) {
            throw RuntimeException("Invalid tlv, null or odd length")
        }

        val valuesArrayList = ArrayList<Values>()
        var i = 0

        while (i < tlv.length - 2) {
            try {
                var key = tlv.substring(i, i + 2)
                i = i + 2
                if ((Integer.parseInt(key, 16) and 0x1F) == 0x1F) {
                    // extra byte for TAG field
                    key += tlv.substring(i, i + 2)
                    i = i + 2
                }
                var len = tlv.substring(i, i + 2)
                i = i + 2
                var length = Integer.parseInt(len, 16)
                if (length > 127) {
                    // more than 1 byte for length
                    val bytesLength = length - 128
                    len = tlv.substring(i, i + (bytesLength * 2))
                    i = i + (bytesLength * 2)
                    length = Integer.parseInt(len, 16)
                }
                length *= 2
                var value = tlv.substring(i, i + length)
                i = i + length
                if (key == Tags.TAG8A) {
                    value = Tags.TAG8A_VALUE
                }
                if (key == Tags.UNKNOWN) {
                    value = Tags.BLANK
                }
                valuesArrayList.add(Values(key, Tags.getTagMeaning(key), value, Tags.hexToString(value)))
            }
            catch (e:NumberFormatException) {
                throw RuntimeException("Error parsing number", e)
            }
            catch (e:IndexOutOfBoundsException) {
                throw RuntimeException("Error processing field", e)
            }
        }
        return valuesArrayList
    }
}

