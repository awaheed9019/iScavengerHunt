package com.example.computer.hackny;

import java.math.BigInteger;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Computer on 10/9/2016.
 */
public class Utils_awaheed {

    public static String intToString(int integer){
        return Integer.toString(integer);
    }

    public static int stringToInt(String str){
        return Integer.getInteger(str);
    }

    public static ArrayList<String> stringTo1DArraySpace(String str){

        ArrayList<String> result = new ArrayList<String>();

        Collections.addAll(result, str.split("\\s+"));
        return result;
    }

    public static ArrayList<String> stringTo1DArrayNewLine(String str){

        ArrayList<String> result = new ArrayList<String>();

        Collections.addAll(result, str.split("\\n"));
        return result;
    }

    public static ArrayList<String> stringTo1DArrayTab(String str){

        ArrayList<String> result = new ArrayList<String>();

        Collections.addAll(result, str.split("\\t"));
        return result;
    }

    public static Map<String, Integer> strToMapStrIntWithTabNewline(String str){

        ArrayList<String> sepByNewline = stringTo1DArrayNewLine(str);
        ArrayList<String> temp;
        Map<String, Integer> result = new HashMap<String, Integer>();

        for(int i = 0; i < sepByNewline.size(); i++){
            temp = stringTo1DArrayTab(sepByNewline.get(i));
            result.put(temp.get(1), Integer.parseInt(temp.get(0))); //reverses order
        }
        return result;
    }

    public static String gen_md5(String input){
        MessageDigest md;

        try {
            md = java.security.MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            System.err.println("NoSuchAlgorithmException for MD5 implementation");
            return null;
        }

        md.update(input.getBytes());

        return new BigInteger(1, md.digest()).toString(16);
    }

}
