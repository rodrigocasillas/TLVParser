package com.rodrigo.tlvparser

import java.io.UnsupportedEncodingException
import java.nio.charset.StandardCharsets.UTF_8
import java.util.ArrayList


object Tags {
    // Constant Strings for tag and element description
    const val BLANK = "---"
    const val TAG = "Tag: "
    const val EQUALS = " = "
    const val TAG_MEANING = "Tag Meaning: "
    const val VALUE = "Value: "
    const val HEX_VALUE = "HexValue: "
    const val UNKNOWN = "00"
    const val UNKNOWN_TAG = "Unknown tag"
    const val NOT_FOUND = "Did not find last byte of tag "

    // Tags Meaning Array

    internal var tags = arrayOf(arrayOf("9F01", "Acquirer Identifier"), arrayOf("9F40", "Additional Terminal Capabilities"), arrayOf("81", "Amount, Authorised (Binary)"), arrayOf("9F02", "Amount, Authorised (Numeric)"), arrayOf("9F04", "Amount, Other (Binary)"), arrayOf("9F03", "Amount, Other (Numeric)"), arrayOf("9F3A", "Amount, Reference Currency"), arrayOf("9F26", "Application Cryptogram"), arrayOf("9F42", "Application Currency Code"), arrayOf("9F44", "Application Currency Exponent"), arrayOf("9F05", "Application Discretionary Data"), arrayOf("5F25", "Application Effective Date"), arrayOf("5F24", "Application Expiration Date"), arrayOf("94", "Application File Locator (AFL)"), arrayOf("4F", "Application Identifier (AID) – card"), arrayOf("9F06", "Application Identifier (AID) – terminal"), arrayOf("82", "Application Interchange Profile"), arrayOf("50", "Application Label"), arrayOf("9F12", "Application Preferred Name"), arrayOf("5A", "Application Primary Account Number (PAN)"), arrayOf("5F34", "Application Primary Account Number (PAN) Sequence Number"), arrayOf("87", "Application Priority Indicator"), arrayOf("9F3B", "Application Reference Currency"), arrayOf("9F43", "Application Reference Currency Exponent"), arrayOf("61", "Application Template"), arrayOf("9F36", "Application Transaction Counter (ATC)"), arrayOf("9F07", "Application Usage Control"), arrayOf("9F08", "Application Version Number"), arrayOf("9F09", "Application Version Number"), arrayOf("89", "Authorisation Code"), arrayOf("8A", "Authorisation Response Code"), arrayOf("5F54", "Bank Identifier Code (BIC)"), arrayOf("8C", "Card Risk Management Data Object List 1 (CDOL1)"), arrayOf("8D", "Card Risk Management Data Object List 2 (CDOL2)"), arrayOf("5F20", "Cardholder Name"), arrayOf("9F0B", "Cardholder Name Extended"), arrayOf("8E", "Cardholder Verification Method (CVM) List"), arrayOf("9F34", "Cardholder Verification Method (CVM) Results"), arrayOf("8F", "Certification Authority Public Key Index"), arrayOf("9F22", "Certification Authority Public Key Index"), arrayOf("83", "Command Template"), arrayOf("9F27", "Cryptogram Information Data"), arrayOf("9F45", "Data Authentication Code"), arrayOf("84", "Dedicated File (DF) Name"), arrayOf("9D", "Directory Definition File (DDF) Name"), arrayOf("73", "Directory Discretionary Template"), arrayOf("9F49", "Dynamic Data Authentication Data Object List (DDOL)"), arrayOf("70", "EMV Proprietary Template"), arrayOf("BF0C", "File Control Information (FCI) Issuer Discretionary Data"), arrayOf("A5", "File Control Information (FCI) Proprietary Template"), arrayOf("6F", "File Control Information (FCI) Template"), arrayOf("9F4C", "ICC Dynamic Number"), arrayOf("9F2D", "Integrated Circuit Card (ICC) PIN Encipherment Public Key Certificate"), arrayOf("9F2E", "Integrated Circuit Card (ICC) PIN Encipherment Public Key Exponent"), arrayOf("9F2F", "Integrated Circuit Card (ICC) PIN Encipherment Public Key Remainder"), arrayOf("9F46", "Integrated Circuit Card (ICC) Public Key Certificate"), arrayOf("9F47", "Integrated Circuit Card (ICC) Public Key Exponent"), arrayOf("9F48", "Integrated Circuit Card (ICC) Public Key Remainder"), arrayOf("9F1E", "Interface Device (IFD) Serial Number"), arrayOf("5F53", "International Bank Account Number (IBAN)"), arrayOf("9F0D", "Issuer Action Code – Default"), arrayOf("9F0E", "Issuer Action Code – Denial"), arrayOf("9F0F", "Issuer Action Code – Online"), arrayOf("9F10", "Issuer Application Data"), arrayOf("91", "Issuer Authentication Data"), arrayOf("9F11", "Issuer Code Table Index"), arrayOf("5F28", "Issuer Country Code"), arrayOf("5F55", "	Issuer Country Code (alpha2 format)"), arrayOf("5F56", "Issuer Country Code (alpha3 format)"), arrayOf("42", "	Issuer Identification Number (IIN)"), arrayOf("90", "Issuer Public Key Certificate"), arrayOf("9F32", "	Issuer Public Key Exponent"), arrayOf("92", "Issuer Public Key Remainder"), arrayOf("86", "Issuer Script Command"), arrayOf("9F18", "Issuer Script Identifier"), arrayOf("71", "Issuer Script Template 1"), arrayOf("72", "Issuer Script Template 2"), arrayOf("5F50", "Issuer URL"), arrayOf("5F2D", "Language Preference"), arrayOf("9F13", "Last Online Application Transaction Counter (ATC) Register"), arrayOf("9F4D", "Log Entry"), arrayOf("9F4F", "Log Format"), arrayOf("9F14", "Lower Consecutive Offline Limit"), arrayOf("9F15", "Merchant Category Code"), arrayOf("9F16", "Merchant Identifier"), arrayOf("9F4E", "Merchant Name and Location"), arrayOf("9F17", "Personal Identification Number (PIN) Try Counter"), arrayOf("9F39", "Point-of-Service (POS) Entry Mode"), arrayOf("9F38", "Processing Options Data Object List (PDOL)"), arrayOf("80", "Response Message Template Format 1"), arrayOf("77", "Response Message Template Format 2"), arrayOf("5F30", "Service Code"), arrayOf("88", "Short File Identifier (SFI)"), arrayOf("9F4B", "Signed Dynamic Application Data"), arrayOf("93", "Signed Static Application Data"), arrayOf("9F4A", "Static Data Authentication Tag List"), arrayOf("9F33", "Terminal Capabilities"), arrayOf("9F1A", "Terminal Country Code"), arrayOf("9F1B", "Terminal Floor Limit"), arrayOf("9F1C", "Terminal Identification"), arrayOf("9F1D", "Terminal Risk Management Data"), arrayOf("9F35", "Terminal Type"), arrayOf("95", "Terminal Verification Results"), arrayOf("9F1F", "Track 1 Discretionary Data"), arrayOf("9F20", "Track 2 Discretionary Data"), arrayOf("57", "Track 2 Equivalent Data"), arrayOf("98", "Transaction Certificate (TC) Hash Value"), arrayOf("97", "Transaction Certificate Data Object List (TDOL)"), arrayOf("5F2A", "Transaction Currency Code"), arrayOf("5F36", "Transaction Currency Exponent"), arrayOf("9A", "Transaction Date"), arrayOf("99", "Transaction Personal Identification Number (PIN) Data"), arrayOf("9F3C", "Transaction Reference Currency Code"), arrayOf("9F3D", "Transaction Reference Currency Exponent"), arrayOf("9F41", "Transaction Sequence Counter"), arrayOf("9B", "Transaction Status Information"), arrayOf("9F21", "Transaction Time"), arrayOf("9C", "Transaction Type"), arrayOf("9F37", "Unpredictable Number"), arrayOf("9F23", "Upper Consecutive Offline Limit"))

    fun getTagMeaning(tag: String): String {

        var meaning = UNKNOWN_TAG

        for (i in tags.indices) {
            for (y in 0 until tags[i].size) {
                if (tags[i][y] == tag) {
                    meaning = tags[i][y + 1]
                    return meaning
                }
            }
        }
        return meaning
    }

    // Converts from hexadecimal to String

    fun hexToString(value: String): String {

        if (value == BLANK) {
            return value
        }

        try {
            val bytes = hexStringToByteArray(value) // Gets ByteArray from hexadecimal

            val result = String(bytes, UTF_8) // Gets String from ByteArray

            // Checks for a non hex-value existence
            if (result.length > 2) {
                if (!Character.isLetterOrDigit(result[0]) || !Character.isLetterOrDigit(result[1])) {
                    return BLANK
                }
            } else if(result.length < 2 || !Character.isLetterOrDigit(result[0])) {
                return BLANK
            }
            return result
        } catch (e: UnsupportedEncodingException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            return "Could not convert Hexadecimal to String"
        }
    }

    // Converts from hexadecimal String to ByteArray

    fun hexStringToByteArray(hex: String): ByteArray {
        val l = hex.length
        val data = ByteArray(l / 2)
        var i = 0
        while (i < l) {
            data[i / 2] = ((Character.digit(hex[i], 16) shl 4) + Character.digit(hex[i + 1], 16)).toByte()
            i += 2
        }
        return data
    }
}
