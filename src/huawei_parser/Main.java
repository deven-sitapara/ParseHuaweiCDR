package huawei_parser;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String fromFile = args[0];
        String toFile = args[1];

        try {

            readText(fromFile,toFile);

        } catch ( Exception ex ) {

              //  throw EOFException("Here");
        }

        //readText("FLHE2018040311464300252754.dat");

    }



    public static void readText(String fromFile,String toFile){


        try {

            String file_name1 = fromFile;


            String fromPath = fromFile;
            String toPath = toFile;

            FileInputStream fis = new FileInputStream(fromPath);
            DataInputStream dis = new DataInputStream(fis);

            FileWriter outFile = new FileWriter(toPath);
            PrintWriter out = new PrintWriter(outFile);

            //FileWriter outFile1 = new FileWriter(toPath2);
           // PrintWriter out1 = new PrintWriter(outFile1);


            /*
            OLD Code
            FileInputStream fis = new FileInputStream("D:\\Parser\\Huawei\\IN\\parse.dat");
            DataInputStream dis = new DataInputStream(fis);

            FileWriter outFile = new FileWriter("D:\\Parser\\Huawei\\IN\\parse.csv");
            PrintWriter out = new PrintWriter(outFile);

            FileWriter outFile1 = new FileWriter("D:\\Parser\\Huawei\\IN\\parse2.csv");
            PrintWriter out1 = new PrintWriter(outFile1);
            */

            String bin,answer_flag,charge_flag,cdr_flag,charge_party_indicator,calling_party_no,end_date_time,end_date_time_m,called_party_no,connection_id,switch_id,spn,gcr_call_ref,sent_called_party,owner_dn,outgoing_pa_id,received_cac,file_id,dialed_No,gcr_flag1_str;

            int count, temp, x= dis.available();
            int cdr_flag1,charge_flag1,charge_party_indicator1,calling_party_nadi1,called_party_nadi1,tgno_inc1,cid_inc1,tgno_og1,cid_og2,spn_na1,tqd_cause,tqd_coding_std1,tqd_loc1,gcr_flag1,sent_called_party_nadi1,nocd1,calling_category1,end_date_time_hh1,end_date_time_mi1,end_date_time_ss1,end_date_time_yy1,end_date_time_mm1,end_date_time_dd1;
            double in_srv_key1,duration1,duration2;
            int bit,i,length1,Audio_codec_type_1;
            double exp =0, num1 = 0;
            String end_date_time_hh,end_date_time_mi,end_date_time_ss,end_date_time_yy,end_date_time_mm,end_date_time_dd,switch_id_1,caller_call_id,called_call_id,switch_id_2;

            String end_date_time_call,end_date_time_hh_call,end_date_time_mi_call,end_date_time_ss_call,end_date_time_yy_call,end_date_time_mm_call,end_date_time_dd_call,wbl_called_no,wbl_calling_no;
            int end_date_time_hh_call_1,end_date_time_mi_call_1,end_date_time_ss_call_1,end_date_time_yy_call_1,end_date_time_mm_call_1,end_date_time_dd_call_1;

            String end_date_time_alert,end_date_time_hh_alert,end_date_time_mi_alert,end_date_time_ss_alert,end_date_time_yy_alert,end_date_time_mm_alert,end_date_time_dd_alert;
            int end_date_time_hh_alert_1,end_date_time_mi_alert_1,end_date_time_ss_alert_1,end_date_time_yy_alert_1,end_date_time_mm_alert_1,end_date_time_dd_alert_1;

//------------------------------------------------------------------------------

//WORLD CALL COLUMNS NAMES

            out.println("Flag1,Flag2,Flag3,Calling_Party,Calling_Party_Nadi,End_Date_Time,Duration,Called_Party,Called_Party_Nadi,TGNO_INC,CID_INC,TGNO_OG,CID_OG,Connection_Id,Switch_Id,SPN,SPN_Nadi,TQD_Cause,TQD_Coding_Std,TQD_Loc,Global_Call_Ref,GCR_Flag,Sent_Called_Party,Sent_Called_Party_Nadi,IN_Srv_Key,New_Destination,New_Destination_Nadi,Owner_DN,Outgoing_PA_Id,NOCD,Received_CAC,File_ID,Calling_Category,caller_call_id,called_call_id,Start_Date_and_Time_of_Call_Setup,Alert_Time,Audio_Codec_Type");

            //out1.println("Calling_Party,Called_Party,End_Date_Time,Duration");


//    out.println("Answer_flag,Charge_flag,CDR_flag,Calling_Party_No,Calling_Party_Nadi,End_Date_Time,Duration,Called_Party_No,called_Party_Nadi,TGNO_INC,CID_INC,TGNO_OG,CID_OG,Connection_Id,Switch_Id,SPN,SPN_Nadi,TQD_Cause,TQD_Coding_Std,TQD_Loc,Global_Call_Ref,GCR_Flag,Sent_Called_Party,Sent_Called_Party_Nadi,IN_Srv_Key,New_Destination,New_Destination_Nadi,Owner_DN,Outgoing_PA_Id,NOCD,Received_CAC,File_ID,Calling_Category");

//-----------------------------------------------------------------------------
            while (dis.available() != 0)
            {

                answer_flag="";
                charge_flag = "";
                cdr_flag = "";
                charge_party_indicator = "";
                calling_party_no = "";
                end_date_time = "";
                end_date_time_m="";
                called_party_no = "";
                connection_id="";
                switch_id = "";
                switch_id_1="";
                spn="";
                gcr_call_ref="H'";
                sent_called_party = "";
                owner_dn="";
                outgoing_pa_id="";
                received_cac = "";
                gcr_flag1_str="";
                caller_call_id="";
                called_call_id="";
                file_id=file_name1;
                called_party_nadi1=0;
                spn_na1=0;
                tqd_coding_std1=0;
                tqd_loc1=0;
                gcr_flag1=0;
                nocd1=0;
                in_srv_key1=0;
                tgno_inc1=0;
                tgno_og1=0;
                end_date_time_hh1=0;
                dialed_No="";
                end_date_time_call="";
                end_date_time_alert="";
                end_date_time_yy_call_1=0;
                end_date_time_yy_alert_1=0;
                end_date_time_dd_call_1=0;
                Audio_codec_type_1=0;
                switch_id_1 =file_name1.substring(1,4);
                switch_id_1=switch_id_1.trim();
                switch_id_1=switch_id_1.toUpperCase();

                //switch_id_2 =file_name1.substring(1,3);
                //switch_id_2=switch_id_1.trim();
                //switch_id_2=switch_id_1.toUpperCase();

                if (switch_id_1.equals("LHE"))
                    switch_id="LHR";

                if (switch_id_1.equals("FRA"))
                    switch_id="FRA";

                temp = dis.skipBytes(9);


//---------------------------------------------------------------------------
//WORLD CALL, HUAWEI
//CDR_FLAG,PARTIAL RECORD INDICATOR
//OFFSET=9, LENGTH=0.5
//Reading 10th Byte
//FORMAT: RECEIVING VALUE IN DECIMAL
//---------------------------------------------------------------------------
                bin = decimalToBinary(dis.readByte());
                cdr_flag1=binaryToDecimal(bin.substring(4));
                if(cdr_flag1 == 0)
                    cdr_flag ="SINGLE";
                else if(cdr_flag1 == 1)
                    cdr_flag ="FIRST";
                else if(cdr_flag1 == 2)
                    cdr_flag ="INTERM";
                else if(cdr_flag1 == 3)
                    cdr_flag ="LAST";
                else if(cdr_flag1 == 4)
                    cdr_flag ="SUMMARY";

//-------------------------------------------------------------------------
//WORLD CALL, HUAWEI
//CHARGE_FLAG,Free Indicator
//offset=9.75, length=0.125
//FORMAT: RECEIVING VALUE IN DECIMAL
//------------------------------------------------------------------------
                charge_flag1 = binaryToDecimal(bin.substring(1,2));
                if(charge_flag1 == 0)
                    charge_flag="NO_CHARGE";
                else if(charge_flag1 == 1)
                    charge_flag="CHARGE";
//-----------------------------------------------------------------------
//WORLD CALL, HUAWEI
//CHARGE_FLAG,CHARGE PARTY INDICATOR
//Reading 11th Byte
//OFFSET=10.5,LENGTH=0.5
//FORMAT: RECEIVING VALUE IN DECIMAL
//-----------------------------------------------------------------------
                bin = decimalToBinary(dis.readByte());
                charge_party_indicator1 =binaryToDecimal(bin.substring(0,4));
                if(charge_party_indicator1 == 0)
                    charge_party_indicator="free of charge";
                else if(charge_party_indicator1 == 1)
                    charge_party_indicator ="Charging the Calling Party";
                else if(charge_party_indicator1 == 2)
                    charge_party_indicator ="Charging the Called Party";
                else if(charge_party_indicator1 == 3)
                    charge_party_indicator ="Charging the destination address number";
                else if(charge_party_indicator1 == 9)
                    charge_party_indicator="Charging incoming trunk";
                else if(charge_party_indicator1 == 10)
                    charge_party_indicator ="Charging outgoing trunk";
                else if(charge_party_indicator1 == 11)
                    charge_party_indicator ="Charging Calling Party (Third Party Charged)";
                else if(charge_party_indicator1 == 12)
                    charge_party_indicator ="Charging Called Party (Third Party Charged)";
                else if(charge_party_indicator1 == 13)
                    charge_party_indicator ="Charging incoming trunk (Third party Charged)";
                else if(charge_party_indicator1== 14)
                    charge_party_indicator="Charging outgoing trunk (Third Party charged)";
                else if(charge_party_indicator1== 15)
                    charge_party_indicator ="No Charging";
//-----------------------------------------------------------------------------
//SKIPPING BYTES 12-17

                temp = dis.skipBytes(6);
//-----------------------------------------------------------------------------
//Reading 18th Byte
//WORLD CALL, HUAWEI
//END_DATE_TIME,END_TIME
//offset=17,length=6
//FORMAT: RECEIVING VALUE IN DECIMAL
//-----------------------------------------------------------------------------

                end_date_time_yy1=(2000 + dis.readByte());
                end_date_time_yy= end_date_time_yy1 + "";
//Reading 19th Byte
                end_date_time_mm1 = dis.readByte();
                end_date_time_mm =end_date_time_mm1 + "";
//Reading 20th Byte
                end_date_time_dd1= dis.readByte();
                end_date_time_dd = end_date_time_dd1 + "";

//Reading 21th Byte

//For hours
                end_date_time_hh1=dis.readByte();
                if ( end_date_time_hh1 == 0)
                    end_date_time_hh="12";
                else
                    end_date_time_hh=end_date_time_hh1 + "";
//Reading 22th Byte

//For minutes
                end_date_time_mi1=dis.readByte();
                if ( end_date_time_mi1 == 0)
                    end_date_time_mi="00";
                else
                    end_date_time_mi=end_date_time_mi1 + "";
//For seconds
                end_date_time_ss1 = dis.readByte();
                if ( end_date_time_ss1 == 0)
                    end_date_time_ss="00";
                else
                    end_date_time_ss=end_date_time_ss1 + "";

                if(end_date_time_hh1<12)
                    end_date_time= end_date_time_mm + "/" + end_date_time_dd + "/" +end_date_time_yy + " " +end_date_time_hh + ":" +end_date_time_mi + ":" +end_date_time_ss + " " + "AM";

                else if(end_date_time_hh1==12)
                    end_date_time= end_date_time_mm + "/" + end_date_time_dd + "/" +end_date_time_yy + " " +end_date_time_hh + ":" +end_date_time_mi + ":" +end_date_time_ss + " " +"PM";

                else if(end_date_time_hh1>12)
                {
                    end_date_time_hh=(end_date_time_hh1-12) + "";
                    end_date_time= end_date_time_mm + "/" + end_date_time_dd + "/" +end_date_time_yy + " " +end_date_time_hh + ":" +end_date_time_mi + ":" +end_date_time_ss + " " +"PM";
                }
//Reading 23th Byte
//------------------------------------------------------------------------------
//WORLD CALL, HUAWEI
//DURATION,CONVERSATION TIME
//offset=23,length=4
//FORMAT: RECEIVING VALUE IN DECIMAL
//------------------------------------------------------------------------------
//Reading 24-27th Byte
                bin = decimalToBinary(dis.readByte());
                bin = decimalToBinary(dis.readByte()) + bin;
                bin = decimalToBinary(dis.readByte()) + bin;
                bin = decimalToBinary(dis.readByte()) + bin;

                exp =0;
                num1 = 0;

                for (i=bin.length(); i >0; i = i - 1 )
                {
                    bit = Integer.parseInt( Character.toString( bin.charAt( i-1 ) ) );

                    num1 = num1 + bit*Math.pow(2.0,exp);

                    exp += 1;

                }

                duration1 =num1;
                duration2=Math.round((duration1/100));

//Skipping 28,29 byte

                temp = dis.skipBytes(2);
//------------------------------------------------------------------------------
//NO BYTE READS CALCULATING THROUGH DURATION
//WORLD CALL, HUAWEI
//ANSWER_FLAG,ANS_TIME
//------------------------------------------------------------------------------
                if(duration1==0)
                    answer_flag="NO_ANSWER";

                else if(duration1>0)
                    answer_flag="ANSWER";
//-----------------------------------------------------------------------------
//Reading 30th Byte
//WORLD CALL, HUAWEI
//CALLING_PARTY_NADI,CALLEER_ADRESS_NATURE
//offset=29,length=1
//FORMAT: RECEIVING VALUE IN DECIMAL
//-----------------------------------------------------------------------------
                calling_party_nadi1 =dis.readByte();

//----------------------------------------------------------------------------
//Reading 31-46 Bytes
//WORLD CALL, HUAWEI
//CALLING_PARTY_NO,CALLER NUMBER
//OFFSET=30,LENGTH=16
//FORMAT: RECEIVING VALUE IN HEX
//---------------------------------------------------------------------------
                count = 0;

                int num, flag = 0, firstfour, lastfour;

                String callerNumber = "", firstfourhex, lastfourhex;


                while(count < 16 && flag != -1)
                {
                    count++;

                    num = dis.readByte();

                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);

                    if( firstfourhex == "F")
                        flag = -1;
                    else
                        callerNumber = callerNumber + firstfourhex;

                    if( lastfourhex == "F")
                        flag = -1;
                    else
                        callerNumber = callerNumber + lastfourhex;


                }

                //System.out.println(callerNumber);
                //System.exit(0);
                //Skipping extra bytes of caller number till 46th

                temp = dis.skipBytes(16-count);
                calling_party_no =callerNumber;

//Skipping bytes 47-48th

                temp = dis.skipBytes(2);
//------------------------------------------------------------------------------
//Reading 49th Byte
//WORLD CALL, HUAWEI
//CALLED_PARTY_NADI,CALLED ADDRESS NATURE
//offset=48,length=1
//FORMAT: RECEIVING VALUE IN DECIMAL
//------------------------------------------------------------------------------
                called_party_nadi1 =dis.readByte();

//-----------------------------------------------------------------------------
//Reading 50-65 Bytes
//WORLD CALL, HUAWEI
//CALLED_PARTY_NO,CALLED NUMBER
//offset=49,length=16
//FORMAT: RECEIVING VALUE IN DECIMAL
//SURPLUS BITS ARE FILLED WITH 0*F
//----------------------------------------------------------------------------
    /*count = 0;
    flag = 0;
    String calledNumber = "";

    while(count < 16 && flag != -1)
    {
        count++;

        num = dis.readByte();

        bin = decimalToBinary(num);

        firstfour = binaryToDecimal(bin.substring(0,4));

        lastfour = binaryToDecimal(bin.substring(4));

        firstfourhex = decimalToHex(firstfour);

        lastfourhex = decimalToHex(lastfour);

        if( firstfourhex == "F")
            flag = -1;
        else
            calledNumber = calledNumber + firstfourhex;

        if( lastfourhex == "F")
            flag = -1;
        else
            calledNumber = calledNumber + lastfourhex;


    }

//Skipping extra bytes of caller number till 46th

    temp = dis.skipBytes(16-count);

    called_party_no =calledNumber;*/

//Skipping bytes of called_party_no
//Skipping bytes till 77

//temp = dis.skipBytes(12);
                temp = dis.skipBytes(28);
//--------------------------------------------------------------------------------
//Reading 78-79th Byte
//WORLD CALL, HUAWEI
//TGNO_INC,TRUNK GROUP IN
//offset=77,length=2
//FORMAT: RECEIVING VALUE IN DECIMAL
//SURPLUS BITS ARE FILLED WITH 0*FFFF
//--------------------------------------------------------------------------------
                bin = decimalToBinary(dis.readByte());

                bin = decimalToBinary(dis.readByte()) + bin;

                tgno_inc1=binaryToDecimal(bin);
//--------------------------------------------------------------------------------
//Reading 80-81th Byte
//WORLD CALL, HUAWEI
//TGNO_OG,TRUNK GROUP OUT
//offset=79,length=2
//FORMAT: RECEIVING VALUE IN DECIMAL
//SURPLUS BITS ARE FILLED WITH 0*00
//--------------------------------------------------------------------------------
                bin = decimalToBinary(dis.readByte());

                bin = decimalToBinary(dis.readByte()) + bin;

                tgno_og1=binaryToDecimal(bin);

//Skipping bytes till 83

                temp = dis.skipBytes(2);
//------------------------------------------------------------------------------
//Skipping bytes till 86

                temp = dis.skipBytes(3);
//------------------------------------------------------------------------------
//Reading 87th Byte
//WORLD CALL, HUAWEI
//CALLING CATEGORY,GSVN
//offset=86,length=1
//FORMAT: RECEIVING VALUE IN DECIMAL
//-----------------------------------------------------------------------------
                calling_category1=dis.readByte();
//-----------------------------------------------------------------------------
//Reading 88th Byte
//WORLD CALL, HUAWEI
//TQD_CAUSE,TERMINATION CODE
//offset=87,length=1
//FORMAT: RECEIVING VALUE IN DECIMAL
//----------------------------------------------------------------------------
                tqd_cause=dis.readByte();
                if (tqd_cause < 0)
                    tqd_cause= tqd_cause + 256;

//Skipping bytes till 102

                temp = dis.skipBytes(14);
//---------------------------------------------------------------------------
//Reading 103rd Byte
//WORLD CALL, HUAWEI
//SENT_CALLED_PARTY_NADI,CONNECTED ADDRESS NATURE
//FORMAT: RECEIVING VALUE IN DECIMAL
//offset = 102,length=1
//----------------------------------------------------------------------------
                sent_called_party_nadi1=dis.readByte();
//----------------------------------------------------------------------------
//The value of sent_called_party_nadi is also used for New_Destination_Nadi
//----------------------------------------------------------------------------
//Reading 104 to 119 Bytes
//WORLD CALL, HUAWEI
//SENT_CALLED_PARTY,CONNECTED NUMBER
//offset=103,length=16
//SURPLUS BITS ARE FILLED WITH 0*F
//----------------------------------------------------------------------------
                count = 0;
                flag = 0;
                String connectedNumber = "";

                while(count < 16 && flag != -1)
                {
                    count++;

                    num = dis.readByte();

                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);

                    if( firstfourhex == "F")
                        flag = -1;
                    else
                        connectedNumber = connectedNumber + firstfourhex;

                    if( lastfourhex == "F")
                        flag = -1;
                    else
                        connectedNumber = connectedNumber + lastfourhex;
                }

//Skipping extra bytes of caller number till 119th

                temp = dis.skipBytes(16-count);

                sent_called_party=connectedNumber;

//Skipping bytes till 122

                temp = dis.skipBytes(3);
//---------------------------------------------------------------------------------
//The value of sent_called_party is also used for New_Destination
//---------------------------------------------------------------------------------
//Reading 123 to 138 Bytes
//WORLD CALL, HUAWEI
//OWNER_DN,CHARGE NUMBER
//FORMAT: RECEIVING VALUE IN DECIMAL
//offset=122,length=16
//---------------------------------------------------------------------------------
                count = 0;
                flag = 0;
                String chargeNumber = "";
                while(count < 16 && flag != -1)
                {
                    count++;

                    num = dis.readByte();

                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);

                    if( firstfourhex == "F")
                        flag = -1;
                    else
                        chargeNumber = chargeNumber + firstfourhex;

                    if( lastfourhex == "F")
                        flag = -1;
                    else
                        chargeNumber = chargeNumber + lastfourhex;

                }

//Skipping extra bytes of caller number till 138th

                temp = dis.skipBytes(16-count);

                owner_dn=chargeNumber;

//Skipping bytes till 139
                temp = dis.skipBytes(1);
//------------------------------------------------------------------------------
//Reading 140 to 155 Bytes
//WORLD CALL, HUAWEI
//DIALED_NO,DIALED_NO
//FORMAT: RECEIVING VALUE IN DECIMAL
//offset=139,length=16
//---------------------------------------------------------------------------------
                count = 0;
                flag = 0;
                String dialed_no1 = "";
                while(count < 16 && flag != -1)
                {
                    count++;

                    num = dis.readByte();

                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);

                    if( firstfourhex == "F")
                        flag = -1;
                    else
                        dialed_no1=dialed_no1 + firstfourhex;

                    if( lastfourhex == "F")
                        flag = -1;
                    else
                        dialed_no1=dialed_no1+lastfourhex;
                }

//Skipping extra bytes of dialed_no till 155th

                temp = dis.skipBytes(16-count);

                dialed_No=dialed_no1;

//Skipping bytes till 161
                temp = dis.skipBytes(6);
//-------------------------------------------------------------------------
//Reading 162 to 165 Bytes
//WORLD CALL, HUAWEI
//IN_SRV_KEY,SERVICE KEY
//FORMAT: RECEIVING VALUE IN DECIMAL
//offset=161,length=4
//-------------------------------------------------------------------------

                bin = decimalToBinary(dis.readByte());

                bin = decimalToBinary(dis.readByte()) + bin;

                bin = decimalToBinary(dis.readByte()) + bin;

                bin = decimalToBinary(dis.readByte()) + bin;


//-------------------------------------
                exp =0;
                num1 = 0;

                for (i=bin.length(); i >0; i = i - 1 )
                {
                    bit = Integer.parseInt( Character.toString( bin.charAt( i-1 ) ) );

                    num1 = num1 + bit*Math.pow(2.0,exp);

                    exp += 1;
                }


//-------------------------------------

//Dummy value

//    in_srv_key1 =0;
                in_srv_key1 =num1;
//    in_srv_key1 =binaryToDecimal(bin);

//Skipping bytes till 167

                temp = dis.skipBytes(2);
//--------------------------------------------------------------------------
//Reading 168-169th Byte
//WORLD CALL, HUAWEI
//CID_INC,CALLER TRUNK CIC
//FORMAT: RECEIVING VALUE IN DECIMAL
//offset=167,length=2
//------------------------------------------------------------------------
                bin = decimalToBinary(dis.readByte());

                bin = decimalToBinary(dis.readByte()) + bin;

                cid_inc1=binaryToDecimal(bin);
//-----------------------------------------------------------------------
//Reading 170-171th Byte
//WORLD CALL, HUAWEI
//CID_OG,CALLED TRUNK CIC
//FORMAT: RECEIVING VALUE IN DECIMAL
//offset=169,length=2
//-----------------------------------------------------------------------
                bin = decimalToBinary(dis.readByte());

                bin = decimalToBinary(dis.readByte()) + bin;

                cid_og2=binaryToDecimal(bin);

///****************************GCR Flag**************************************/
//---------------------------------------------------------------------------
//Reading 172nd Byte
//WORLD CALL, HUAWEI
//GCR_FLAG,GCR FLAG
//OFFSET=171.875, LENGTH=0.125
//FORMAT: RECEIVING VALUE IN DECIMAL (0 or 1)
//---------------------------------------------------------------------------
                bin = decimalToBinary(dis.readByte());
                gcr_flag1 = binaryToDecimal(bin.substring(0,1));
                gcr_flag1_str=""+gcr_flag1;

///********************************************************************************/
//Skipping bytes till 387

                temp = dis.skipBytes(215);
//----------------------------------------------------------------------------------
//Reading 388 to 393 Byte
//WORLD CALL, HUAWEI
//Start Date and Time of Call Setup
//offset=387,length=6
//-----------------------------------------------------------------------------
                if(duration1==0)
                {temp = dis.skipBytes(6);}
                else
                {   end_date_time_yy_call_1=(2000 + dis.readByte());
                    end_date_time_yy_call= end_date_time_yy_call_1 + "";
//Reading 19th Byte
                    end_date_time_mm_call_1 = dis.readByte();
                    end_date_time_mm_call =end_date_time_mm_call_1 + "";
//Reading 20th Byte
                    end_date_time_dd_call_1= dis.readByte();
                    end_date_time_dd_call = end_date_time_dd_call_1 + "";

//Reading 21th Byte

//For hours
                    end_date_time_hh_call_1=dis.readByte();
                    if ( end_date_time_hh_call_1 == 0)
                        end_date_time_hh_call="12";
                    else
                        end_date_time_hh_call=end_date_time_hh_call_1 + "";
//Reading 22th Byte

//For minutes
                    end_date_time_mi_call_1=dis.readByte();
                    if ( end_date_time_mi_call_1 == 0)
                        end_date_time_mi_call="00";
                    else
                        end_date_time_mi_call=end_date_time_mi_call_1 + "";
//For seconds
                    end_date_time_ss_call_1 = dis.readByte();
                    if ( end_date_time_ss_call_1 == 0)
                        end_date_time_ss_call="00";
                    else
                        end_date_time_ss_call=end_date_time_ss_call_1 + "";

                    if(end_date_time_hh_call_1<12)
                        end_date_time_call= end_date_time_mm_call + "/" + end_date_time_dd_call + "/" +end_date_time_yy_call + " " +end_date_time_hh_call + ":" +end_date_time_mi_call + ":" +end_date_time_ss_call + " " + "AM";

                    else if(end_date_time_hh_call_1==12)
                        end_date_time_call= end_date_time_mm_call + "/" + end_date_time_dd_call + "/" +end_date_time_yy_call + " " +end_date_time_hh_call + ":" +end_date_time_mi_call + ":" +end_date_time_ss_call + " " +"PM";

                    else if(end_date_time_hh_call_1>12)
                    {
                        end_date_time_hh_call=(end_date_time_hh_call_1-12) + "";
                        end_date_time_call= end_date_time_mm_call + "/" + end_date_time_dd_call + "/" +end_date_time_yy_call + " " +end_date_time_hh_call + ":" +end_date_time_mi_call + ":" +end_date_time_ss_call + " " +"PM";
                    }
                }
//------------------------------------------------------------------------------
//Skipping bytes till 429

                //temp = dis.skipBytes(257);
                temp = dis.skipBytes(36);

//------------------------------------------------------------------------
//WORLD CALL, HUAWEI
//SWITCH_ID,LOCAL SWITCH NAME
//FORMAT: RECEIVING VALUE IN DECIMAL
//offset=429,length=32
//------------------------------------------------------------------------

                //switch_id =file_id.substring(0,3);

                //file_name=file_name.toUpperCase();

                //if (file_name=="LHE")
                //switch_id="LHE";

//else if (file_name=="KRI")
                //switch_id="KRI";

//else if (file_name=="UK")
                //switch_id="UK";


//Skipping bytes till 462

                temp = dis.skipBytes(33);
//------------------------------------------------------------------------------
//Reading 463 to 465 Bytes
//WORLD CALL, HUAWEI
//RECEIVED_CAC,CAC
//offset=462,length=3
//SURPLUS BITS ARE FILLED WITH 0*F AND INVALIDATE VALUE:0*FF
//------------------------------------------------------------------------------
                count = 0;
                flag = 0;
                String cac = "";

                while(count < 3 && flag != -1)
                {
                    count++;

                    num = dis.readByte();

                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);

                    if( firstfourhex == "F")
                        flag = -1;
                    else
                        cac = cac + firstfourhex;

                    if( lastfourhex == "F")
                        flag = -1;
                    else
                        cac = cac + lastfourhex;

                }

//Skipping extra bytes of caller number till 465th

                temp = dis.skipBytes(3-count);

                received_cac=cac;


//-----------------------------------------------------------------------
//Skipping bytes till 588
                temp = dis.skipBytes(123);
//----------------------------------------------------------------------
//Reading 589 to 608 Bytes
//WORLD CALL, HUAWEI
//CONNECTION_ID,IN CallID
//offset=588,length=20
//----------------------------------------------------------------------
                count = 0;
                flag = 0;


                String incallid = "";

                while(count < 20 && flag != -1)
                {
                    count++;
                    try{

                        num = dis.readByte();

                    } catch ( EOFException ex){
                        break;
                    }


                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);

                    if( firstfour == 0)
                        flag = -1;
                    else
                        incallid = incallid + firstfourhex;

                    if( lastfour == 0)
                        flag = -1;
                    else
                        incallid = incallid + lastfourhex;

                }

//Skipping extra bytes of caller number till 608th

                temp = dis.skipBytes(20-count);

                connection_id=incallid;

//--------------------------------------------------------------------------------
                temp = dis.skipBytes(1);
//-----------------------------------------------------------------------------
//Reading 610 to 615 Byte
//WORLD CALL, HUAWEI
//Alerting Time
//offset=609,length=6
//------------------------------------------------------------------------------
                if(duration1==0)
                {
                    temp = dis.skipBytes(6);
                }
                else {
                    try {

                        end_date_time_yy_alert_1=(2000 + dis.readByte());
                        end_date_time_yy_alert= end_date_time_yy_alert_1 + "";

                    }catch ( EOFException ex ){
                        break;

                    }

//Reading 19th Byte
                    end_date_time_mm_alert_1 = dis.readByte();
                    end_date_time_mm_alert =end_date_time_mm_alert_1 + "";
//Reading 20th Byte
                    end_date_time_dd_alert_1= dis.readByte();
                    end_date_time_dd_alert = end_date_time_dd_call_1 + "";

//Reading 21th Byte

//For hours
                    end_date_time_hh_alert_1=dis.readByte();
                    if ( end_date_time_hh_alert_1 == 0)
                        end_date_time_hh_alert="12";
                    else
                        end_date_time_hh_alert=end_date_time_hh_alert_1 + "";
//Reading 22th Byte

//For minutes
                    end_date_time_mi_alert_1=dis.readByte();
                    if ( end_date_time_mi_alert_1 == 0)
                        end_date_time_mi_alert="00";
                    else
                        end_date_time_mi_alert=end_date_time_mi_alert_1 + "";
//For seconds
                    end_date_time_ss_alert_1 = dis.readByte();
                    if ( end_date_time_ss_alert_1 == 0)
                        end_date_time_ss_alert="00";
                    else
                        end_date_time_ss_alert=end_date_time_ss_alert_1 + "";

                    if(end_date_time_hh_alert_1<12)
                        end_date_time_alert= end_date_time_mm_alert + "/" + end_date_time_dd_alert + "/" +end_date_time_yy_alert + " " +end_date_time_hh_alert + ":" +end_date_time_mi_alert + ":" +end_date_time_ss_alert + " " + "AM";

                    else if(end_date_time_hh_alert_1==12)
                        end_date_time_alert= end_date_time_mm_alert + "/" + end_date_time_dd_alert + "/" +end_date_time_yy_alert + " " +end_date_time_hh_alert + ":" +end_date_time_mi_alert + ":" +end_date_time_ss_alert + " " +"PM";

                    else if(end_date_time_hh_alert_1>12)
                    {
                        end_date_time_hh_alert=(end_date_time_hh_alert_1-12) + "";
                        end_date_time_alert= end_date_time_mm_alert + "/" + end_date_time_dd_alert + "/" +end_date_time_yy_alert + " " +end_date_time_hh_alert + ":" +end_date_time_mi_alert + ":" +end_date_time_ss_alert + " " +"PM";
                    }
                }
///-----------------------------------------------------------------------------
//Skipping bytes till Audio_Codec_Type 718th
//temp = dis.skipBytes(119);
                temp = dis.skipBytes(103);
//------------------------------------Audio Codec Type--------------------------
//WORLD CALL, HUAWEI
// Audio_Codec_Type
//OFFSET=718, LENGTH=1
//Reading 719 Byte
//FORMAT: RECEIVING VALUE IN Number
//---------------------------------------------------------------------------
                Audio_codec_type_1=dis.readByte();
//---------------------------------------------------------------------------
//Skipping bytes till 727th for GCR
//temp = dis.skipBytes(119);
                temp = dis.skipBytes(8);

///**************************** GCR **********************************************/
//---------------------------------------------------------------------------
//WORLD CALL, HUAWEI
//GLOBAL CALL REFERRENCE,GLOBAL CALL REFERRENCE
//OFFSET=727, LENGTH=20
//Reading 728 - 747 Byte
//FORMAT: RECEIVING VALUE IN String
//---------------------------------------------------------------------------

                count = 0;
                flag = 0;

//    while(count < 20 && flag != -1)
//    {
// count++;

                num = dis.readByte();


                bin = decimalToBinary(num);

                firstfour = binaryToDecimal(bin.substring(0,4));

                lastfour = binaryToDecimal(bin.substring(4));


                firstfourhex = decimalToHex(firstfour);

                lastfourhex = decimalToHex(lastfour);

                gcr_call_ref = gcr_call_ref + firstfourhex;

                gcr_call_ref = gcr_call_ref + lastfourhex;

                //Reading network id

                length1 = num;

                count++;
                //count = count + length1;

                while(length1 > 0)
                {

                    num = dis.readByte();

                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);

                    gcr_call_ref = gcr_call_ref + firstfourhex;
                    gcr_call_ref = gcr_call_ref + lastfourhex;

                    length1 = length1 -1;

                    count++;
                }

                num = dis.readByte();

                bin = decimalToBinary(num);

                firstfour = binaryToDecimal(bin.substring(0,4));

                lastfour = binaryToDecimal(bin.substring(4));

                firstfourhex = decimalToHex(firstfour);

                lastfourhex = decimalToHex(lastfour);

                gcr_call_ref = gcr_call_ref + firstfourhex;
                gcr_call_ref = gcr_call_ref + lastfourhex;

                length1 = num;

                count++;
                //count = count + length1;

                while(length1 > 0)
                {

                    num = dis.readByte();

                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);

                    gcr_call_ref = gcr_call_ref + firstfourhex;
                    gcr_call_ref = gcr_call_ref + lastfourhex;

                    count++;
                    length1 = length1 -1;

                }

                num = dis.readByte();

                bin = decimalToBinary(num);

                firstfour = binaryToDecimal(bin.substring(0,4));

                lastfour = binaryToDecimal(bin.substring(4));

                firstfourhex = decimalToHex(firstfour);

                lastfourhex = decimalToHex(lastfour);

                gcr_call_ref = gcr_call_ref + firstfourhex;
                gcr_call_ref = gcr_call_ref + lastfourhex;

                length1 = num;

                count++;
                //count = count + length1;

                while(length1 > 0)
                {

                    num = dis.readByte();

                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);

                    gcr_call_ref = gcr_call_ref + firstfourhex;
                    gcr_call_ref = gcr_call_ref + lastfourhex;

                    count++;
                    length1 = length1 -1;

//        }


/*        if( firstfourhex == "F" && lastfourhex == "F")
            flag = -1;
        else
        {
            gcr_call_ref = gcr_call_ref + firstfourhex;
            gcr_call_ref = gcr_call_ref + lastfourhex;
            }
*/
/*        if( firstfourhex == "F")
            flag = -1;
        else
            gcr_call_ref = gcr_call_ref + firstfourhex;

        if( lastfourhex == "F")
            flag = -1;
        else
            gcr_call_ref = gcr_call_ref + lastfourhex;
*/
                }

                //Skipping extra bytes of GLOBAL CALL REFERENCE till 747th

                temp = dis.skipBytes(20-count);

                //skipping extra bites till 779 caller_call_id
                temp = dis.skipBytes(32);
///********************************************************************************/
//Reading 780 to 843 Bytes
//WORLD CALL, HUAWEI
//caller_call_id,caller_call_id
//offset=779,length=64
//SURPLUS BITS ARE FILLED WITH 0*F AND INVALIDATE VALUE:0*FF
//------------------------------------------------------------------------------
                if(duration1==0)
                {temp = dis.skipBytes(64);
                }

                else
                {
                    count = 0;
                    flag = 0;
                    String caller_call_id1 = "";

                    while(count < 64 && flag != -1)
                    {
                        count++;

                        num = dis.readByte();

                        bin = decimalToBinary(num);

                        firstfour = binaryToDecimal(bin.substring(0,4));

                        lastfour = binaryToDecimal(bin.substring(4));

                        firstfourhex = decimalToHex(firstfour);

                        lastfourhex = decimalToHex(lastfour);

                        if( firstfourhex == "F" && lastfourhex=="F")
                            flag = -1;
                        else
                            caller_call_id1 = caller_call_id1 + firstfourhex + lastfourhex;

/*        if( firstfourhex == "F")
            flag = -1;
        else
            caller_call_id1 = caller_call_id1 + firstfourhex;

        if( lastfourhex == "F")
            flag = -1;
        else
            caller_call_id1 = caller_call_id1 + lastfourhex;
    */
                    }

//Skipping extra bytes of caller_call_id till 843th

                    temp = dis.skipBytes(64-count);

                    caller_call_id=caller_call_id1;

                }
///*********************************************************************************/
//Reading 844 to 907 Bytes
//WORLD CALL, HUAWEI
//called_call_id,called_call_id
//offset=843,length=64
//SURPLUS BITS ARE FILLED WITH 0*F AND INVALIDATE VALUE:0*FF
//------------------------------------------------------------------------------
                //Skipping bytes for called_call_id
                //temp = dis.skipBytes(64);
//------------------------------------------------------------------------------

//code to read called_call_id
                count = 0;
                flag = 0;
                String called_call_id1 = "";

                while(count < 64 && flag != -1)
                {
                    count++;

                    num = dis.readByte();

                    bin = decimalToBinary(num);

                    firstfour = binaryToDecimal(bin.substring(0,4));

                    lastfour = binaryToDecimal(bin.substring(4));

                    firstfourhex = decimalToHex(firstfour);

                    lastfourhex = decimalToHex(lastfour);


                    if( firstfourhex == "F" && lastfourhex=="F")
                        flag = -1;
                    else
                        called_call_id1 = called_call_id1 + firstfourhex + lastfourhex;
                }

//Skipping extra bytes of caller_call_id till 843th

                temp = dis.skipBytes(64-count);

                called_call_id=called_call_id1;


///*********************************************************************************/
//Skipping extra bytes till 907th

                //temp = dis.skipBytes(160);
                //temp = dis.skipBytes(64);

//--------------------------------------------------------------------------------
//WORLDCALL
                out.println(cdr_flag+","+charge_flag+","+answer_flag+","+calling_party_no+","+ calling_party_nadi1+","+end_date_time+","+duration2+","+dialed_No+","+called_party_nadi1+","+tgno_inc1+","+cid_inc1+","+tgno_og1+","+cid_og2+","+connection_id+","+switch_id+","+spn+","+spn_na1+","+tqd_cause+","+tqd_coding_std1+","+tqd_loc1+","+gcr_call_ref+","+gcr_flag1_str+","+sent_called_party+","+sent_called_party_nadi1+","+in_srv_key1+","+sent_called_party+","+sent_called_party_nadi1+","+owner_dn+","+outgoing_pa_id+","+nocd1+","+received_cac+","+file_id+","+calling_category1+","+caller_call_id+","+called_call_id+","+end_date_time_call+","+end_date_time_alert+","+Audio_codec_type_1);

                /*if(tgno_inc1==65535||tgno_inc1==953||tgno_inc1==954)
                {
                    wbl_called_no = getWblCalledNo(dialed_No);
                    wbl_calling_no = getWblCallingNo(calling_party_no);

                    if (wbl_calling_no.length() > 6)
                        if (wbl_calling_no.substring(0,6).equals("021370") && !wbl_called_no.equals("") )
                            out1.println(wbl_calling_no+","+wbl_called_no+","+end_date_time+","+duration2);
                }*/
//--------------------------------------------------------------------------------

                x -= 907;

            }

            fis.close();

            out.close();
            //out1.close();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Usage: java ReadFile filename\n");

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String decimalToBinary(int deci) throws IOException{

        int deci1 = deci;

        if (deci1 < 0)
            deci1 = deci1 + 256;

        String by = Integer.toBinaryString(deci1);

        for (int i=by.length(); i < 8; ++i)
            by = "0" + by;

        return(by);
    }

    public static int binaryToDecimal(String bin) throws IOException{

        int bit;
        double exp =0, num = 0;

        for (int i=bin.length(); i >0; i = i - 1 )
        {
            bit = Integer.parseInt( Character.toString( bin.charAt( i-1 ) ) );

            num = num + bit*Math.pow(2.0,exp);

            exp += 1;

        }

        return((int)num);

    }
    public static String decimalToHex(int deci) throws IOException{

        int deci1 = deci;

        if (deci1 < 0)
            deci1 = deci1 + 256;

        String by = Integer.toString(deci1);


        if (by.equals("10"))
            return("A");
        else if (by.equals("11"))
            by = "B";
        else if (by.equals("12"))
            by = "C";
        else if (by.equals("13"))
            by = "D";
        else if (by.equals("14"))
            by = "E";
        else if (by.equals("15"))
            by = "F";

        return(by);
    }
    public static String getWblCalledNo(String cn) throws IOException{

        if(!cn.equals("") && cn.length() > 2)
        {
            if (cn.substring(0,1).equals("0") || cn.substring(0,2).equals("00"))
                return(cn);
            else if (cn.length() > 8 && !cn.substring(0,1).equals("0"))
                return ("0"+cn);
            else if (cn.length() == 8 && !cn.substring(0,1).equals("0"))
                return ("021"+cn);
            else
                return (cn);

        }
        else
            return (cn);
    }
    public static String getWblCallingNo(String cn) throws IOException{

        if(!cn.equals("") && cn.length() > 2)
        {
            if (cn.length() < 12 &&cn.substring(0,1).equals("0"))
                return(cn);
            else if (cn.length() == 8 && !cn.substring(0,1).equals("0"))
                return ("021"+cn);
            else if (cn.length() > 10 && cn.substring(0,2).equals("92"))
                return ("0"+cn.substring(2));
            else if (cn.length() > 10 && cn.substring(0,3).equals("092"))
                return ("0"+cn.substring(3));
            else if (cn.length() > 10 && cn.substring(0,4).equals("0092"))
                return ("0"+cn.substring(4));
            else
                return ("0"+cn);
        }
        else
            return(cn);
    }
}
