package com.kangtian.string;

import java.util.ArrayList;

public class Permutation {

    public ArrayList<String> Permutation(String str) {
    str=removeRepeatChar(str);
        String[] arr = str.split(str);
     for ()

    return null;
    }



    public String removeRepeatChar(String s) {
        if (s == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            sb.append(c);
            i++;
            while (i < len && s.charAt(i) == c) {//这个是如果这两个值相等，就让i+1取下一个元素
                i++;
            }
        }
        return sb.toString();
    }
    }
