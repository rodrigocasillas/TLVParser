package com.rodrigo.tlvparser

import org.junit.Test

import org.junit.Assert.*
import java.util.ArrayList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun isCorrectTest_1() {

        val arrayList = ArrayList<Values>()

        arrayList.add(Values("5F20", "Cardholder Name", "54444320424C41434B20554E4C494D4954454420564953412020", "TDC BLACK UNLIMITED VISA"))
        arrayList.add(Values("4F", "Application Identifier (AID) – card", "A0000000031010", "---"))
        arrayList.add(Values("5F24", "Application Expiration Date", "230731", "---"))
        arrayList.add(Values("9F16", "Merchant Identifier", "424354455354203132333435363738", "BCTEST 12345678"))
        arrayList.add(Values("9F21", "Transaction Time", "182650", "---"))
        arrayList.add(Values("9A", "Transaction Date", "140617", "---"))
        arrayList.add(Values("9F02", "Amount, Authorised (Numeric)", "000000000001", "---"))
        arrayList.add(Values("9F03", "Amount, Other (Numeric)", "000000000000", "---"))
        arrayList.add(Values("9F34", "Cardholder Verification Method (CVM) Results", "020300", "---"))
        arrayList.add(Values("9F12", "Application Preferred Name", "56495341204352454449544F", "VISA CREDITO"))
        arrayList.add(Values("9F06", "Application Identifier (AID) – terminal", "A0000000031010", "---"))
        arrayList.add(Values("5F30", "Service Code", "0201", "---"))
        arrayList.add(Values("9F4E", "Merchant Name and Location", "616263640000000000000000000000", "abcd"))
        arrayList.add(Values("C4", "Unknown tag", "491573FFFFFF1097", "---"))
        arrayList.add(Values("C0", "Unknown tag", "09117101800165E0000A", "---"))
        arrayList.add(Values("C2", "Unknown tag", "D9DE289AAD770BE408F6B1D4E0A2576CEA7F03CD479CE3A1827375D6C4D4959ACDB5D3B6F84CD83430F4346C35E48A77A0D5F36FBEA444C2D8701C07FFC7AF06C0485D68F7A83FC30840D3C0766EC4EE669BE5A42BAD4C7459680FAAAE9C4EFEFFEB5A590E53B3E91B3CD28A415C2C9484E26DA5A15592BBCD1F45CF49D27A9D480B031957DF8C790C55FF60DB192CCD070FA4F7BCDC99E7F7567C2F991B5536F9336BA66D68115D54BC3642A9CA47FDD162FCDC33E455AAC283975DACC98CBE9A6611E996F0740072CF8E32D3D9F39F4BB25568F5CC3E7F5DE158E4D62BF4E7185CF13BD068C4F062C26A3BBF88E056F249130E89AA29E52A1EBB6BAD98296822F10949F0C825D1449DA7EF4431AB846D0DDB916F2901359DD9A3B3395BAC9F9BE4D24657F65B030DDADA53577A14D9F5F776B6FF7EAB99D8C4BB08BEF2016C72D94B1DB91BCF0238405B7857646DCE5F79871D96B6A6652090FD8CFCC59973433919A6D0533DFE", "---"))


        val tlvString = "5F201A54444320424C41434B20554E4C494D49544544205649534120204F07A00000000310105F24032307319F160F4243544553542031323334353637389F21031826509A031406179F02060000000000019F03060000000000009F34030203009F120C56495341204352454449544F9F0607A00000000310105F300202019F4E0F616263640000000000000000000000C408491573FFFFFF1097C00A09117101800165E0000AC2820168D9DE289AAD770BE408F6B1D4E0A2576CEA7F03CD479CE3A1827375D6C4D4959ACDB5D3B6F84CD83430F4346C35E48A77A0D5F36FBEA444C2D8701C07FFC7AF06C0485D68F7A83FC30840D3C0766EC4EE669BE5A42BAD4C7459680FAAAE9C4EFEFFEB5A590E53B3E91B3CD28A415C2C9484E26DA5A15592BBCD1F45CF49D27A9D480B031957DF8C790C55FF60DB192CCD070FA4F7BCDC99E7F7567C2F991B5536F9336BA66D68115D54BC3642A9CA47FDD162FCDC33E455AAC283975DACC98CBE9A6611E996F0740072CF8E32D3D9F39F4BB25568F5CC3E7F5DE158E4D62BF4E7185CF13BD068C4F062C26A3BBF88E056F249130E89AA29E52A1EBB6BAD98296822F10949F0C825D1449DA7EF4431AB846D0DDB916F2901359DD9A3B3395BAC9F9BE4D24657F65B030DDADA53577A14D9F5F776B6FF7EAB99D8C4BB08BEF2016C72D94B1DB91BCF0238405B7857646DCE5F79871D96B6A6652090FD8CFCC59973433919A6D0533DFE"


        val result = Tags.checkEquality(arrayList, TLVParser.parseTLV(tlvString))
        val expected = true


        assertEquals(expected, result)
    }


    @Test
    @Throws(Exception::class)
    fun isCorrectTest_2() {

        val arrayList = ArrayList<Values>()

        arrayList.add(Values("9F06", "Application Identifier (AID) – terminal", "A0000000041010", "---"))
        arrayList.add(Values("5F30", "Service Code", "0201", "---"))
        arrayList.add(Values("9F02", "Amount, Authorised (Numeric)", "000000000001", "---"))
        arrayList.add(Values("9F16", "Merchant Identifier", "424354455354203132333435363738", "BCTEST 12345678"))
        arrayList.add(Values("5F24", "Application Expiration Date", "230731", "---"))
        arrayList.add(Values("4F", "Application Identifier (AID) – card", "A0000000041010", "---"))
        arrayList.add(Values("9F34", "Cardholder Verification Method (CVM) Results", "020300", "---"))
        arrayList.add(Values("9A", "Transaction Date", "140617", "---"))
        arrayList.add(Values("9F03", "Amount, Other (Numeric)", "000000000000", "---"))
        arrayList.add(Values("5A", "Application Primary Account Number (PAN)", "6214672500000000056F", "---"))
        arrayList.add(Values("57", "Track 2 Equivalent Data", "2223000010025499D19122010000000004180F", "---"))
        arrayList.add(Values("9F10", "Issuer Application Data", "00146000002C0000000000000000000000FF", "---"))
        arrayList.add(Values("9F4E", "Merchant Name and Location", "616263640000000000000000000000", "abcd"))
        arrayList.add(Values("82", "Application Interchange Profile", "7C00", "---"))
        arrayList.add(Values("8E", "Cardholder Verification Method (CVM) List", "000000000000000002031F00", "---"))
        arrayList.add(Values("5F25", "Application Effective Date", "130708", "---"))
        arrayList.add(Values("9F07", "Application Usage Control", "AB00", "---"))
        arrayList.add(Values("9F0D", "Issuer Action Code – Default", "D86004A800", "---"))
        arrayList.add(Values("9F0E", "Issuer Action Code – Denial", "0010980000", "---"))
        arrayList.add(Values("9F0F", "Issuer Action Code – Online", "D86804F800", "---"))
        arrayList.add(Values("9F26", "Application Cryptogram", "45CFE577DD2B762B", "---"))
        arrayList.add(Values("9F27", "Cryptogram Information Data", "40", "---"))
        arrayList.add(Values("9F36", "Application Transaction Counter (ATC)", "0268", "---"))
        arrayList.add(Values("9C", "Transaction Type", "00", "---"))
        arrayList.add(Values("9F33", "Terminal Capabilities", "E0F8C8", ""))
        arrayList.add(Values("9F37", "Unpredictable Number", "2120A718", "---"))
        arrayList.add(Values("9F39", "Point-of-Service (POS) Entry Mode", "05", "---"))
        arrayList.add(Values("9F40", "Additional Terminal Capabilities", "F000F0A001", "---"))
        arrayList.add(Values("95", "Terminal Verification Results", "088004E000", "---"))
        arrayList.add(Values("9B", "Transaction Status Information", "E800", "---"))
        arrayList.add(Values("84", "Dedicated File (DF) Name", "A0000003330101", "---"))
        arrayList.add(Values("5F2A", "Transaction Currency Code", "0156", "---"))
        arrayList.add(Values("5F34", "Application Primary Account Number (PAN) Sequence Number", "01", "---"))
        arrayList.add(Values("9F09", "Application Version Number", "008C", "---"))
        arrayList.add(Values("9F1A", "Terminal Country Code", "0156", "---"))
        arrayList.add(Values("9F1E", "Interface Device (IFD) Serial Number", "3833323031494343", "83201ICC"))
        arrayList.add(Values("9F35", "Terminal Type", "22", "---"))
        arrayList.add(Values("9F41", "Transaction Sequence Counter", "00000001", "---"))
        arrayList.add(Values("9F53", "Unknown tag", "52", "---"))
        arrayList.add(Values("5F20", "Cardholder Name", "5445535420434152442F454D562042494E2D32", "TEST CARD/EMV BIN-2"))
        arrayList.add(Values("8A", "Authorisation Response Code", "0 0", "---"))
        arrayList.add(Values("50", "Application Label", "4D415354455243415244", "MASTERCARD"))
        arrayList.add(Values("9F08", "Application Version Number", "0020", "---"))
        arrayList.add(Values("00", "Unknown tag", "---", "---"))
        arrayList.add(Values("00", "Unknown tag", "---", "---"))

        val tlvString = "9F0607A00000000410105F300202019F02060000000000019F160F4243544553542031323334353637385F24032307314F07A00000000410109F34030203009A031406179F03060000000000005A0A6214672500000000056F57132223000010025499D19122010000000004180F9F101200146000002C0000000000000000000000FF9F4E0F61626364000000000000000000000082027C008E0C000000000000000002031F005F25031307089F0702AB009F0D05D86004A8009F0E0500109800009F0F05D86804F8009F260845CFE577DD2B762B9F2701409F360202689C01009F3303E0F8C89F37042120A7189F3901059F4005F000F0A0019505088004E0009B02E8008407A00000033301015F2A0201565F3401019F0902008C9F1A0201569F1E0838333230314943439F3501229F4104000000019F5301525F20135445535420434152442F454D562042494E2D325F280208408A023030500A4D4153544552434152449F080200200000000000"

        val result = Tags.checkEquality(arrayList, TLVParser.parseTLV(tlvString))
        val expected = true


        assertEquals(expected, result)
    }
}
