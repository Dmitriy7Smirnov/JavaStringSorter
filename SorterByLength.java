package com.nicedev;

import java.util.Comparator;

public class SorterByLength implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        if (str1.length() < str2.length()){
            return 1;
        }else if (str1.length() > str2.length()){
            return -1;
        }
        return str1.toLowerCase().compareTo(str2.toLowerCase());
    }
}
