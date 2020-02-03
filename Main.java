package com.nicedev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        String str = "сапог сарай арбуз болт бокс биржа";
        String[] arr = str.split("\\s+");
        if (arr.length == 0) {
            System.out.println("no substrings in input string");
            return;
        }
        Arrays.sort(arr, new SorterInLowerCase());
        ArrayList<ArrayList<String>> arrListOfarrList = new ArrayList<>();
        ArrayList<String> nestedArrList = new ArrayList<>();
        char priv_char = arr[0].charAt(0);
        for (int i=0; i<arr.length; i++){
            char curr_char = arr[i].charAt(0);
            if (curr_char != priv_char) {
                priv_char = curr_char;
                nestedArrList.sort(new SorterByLength());
                arrListOfarrList.add(nestedArrList);
                nestedArrList = new ArrayList<>();
            }
            nestedArrList.add(arr[i]);
        }
        nestedArrList.sort(new SorterByLength());
        arrListOfarrList.add(nestedArrList);

        String outputString = "[";
        for (int i=0; i<arrListOfarrList.size(); i++){
            if (arrListOfarrList.get(i).size() != 1){
                outputString += arrListOfarrList.get(i).get(0).charAt(0);
                outputString += "=";
                outputString += "[";
                for (int j=0;j<arrListOfarrList.get(i).size(); j++){
                    outputString += arrListOfarrList.get(i).get(j);
                    outputString += ", ";
                }
                outputString = outputString.substring(0, outputString.length() - 2);
                outputString += "],";
            }
        }
        outputString = outputString.substring(0, outputString.length() - 1);
        outputString += "]";
        System.out.println(outputString);
    }
}