package com.grg.adep.persistent.entity;

import javafx.util.Builder;

import java.util.*;

/**
 * 2 * @Author: Run Man
 * 3 * @Date: 2020/5/9 15:22
 * 4
 */
public class Test {
    public static void main(String[] args) {

    }

    public String reformat(String s) {
        StringBuilder ss = new StringBuilder(s);
        StringBuilder num = new StringBuilder();
        StringBuilder zimu = new StringBuilder();
        for (int i = 0; i < ss.length(); i++) {
            Boolean digit = Character.isDigit(ss.charAt(i));
            if(digit){
                num.append(ss.charAt(i));
            }else {
                zimu.append(ss.charAt(i));
            }

        }

        if(Math.abs(num.length()-zimu.length())>1){
            return "";
        }else {
            if(num.length()>zimu.length()){
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < num.length(); i++) {
                    temp.append(num.charAt(i));
                    if(i<zimu.length()) temp.append(zimu.charAt(i));
                }
                return temp.toString();
            }else {
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < zimu.length(); i++) {
                    temp.append(zimu.charAt(i));
                    if(i<num.length()) temp.append(num.charAt(i));
                }
                return temp.toString();
            }

        }

    }
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            IdentityHashMap<String, String> temp = new IdentityHashMap<String, String>();
            HashMap<String, List<String>> tableList = new HashMap<String, List<String>>();
            TreeSet <Integer> table = new TreeSet <Integer>();

            TreeSet<String> uniqueKey = new TreeSet<String>();
            for (List<String> order : orders) {
                temp.put(order.get(2),order.get(1));
                table.add(Integer.parseInt(order.get(1)));

                List<String> l;
                if(tableList.containsKey(order.get(1))){
                    l.
                }
            }

            for (String s : temp.keySet()) {
                uniqueKey.add(s);
            }

            List<String> header = new LinkedList<String>();
            header.add("Table");
            for (String s : uniqueKey) {
                header.add(s);
            }
            List<List<String>> re = new LinkedList<List<String>>();
            re.add(header);
            List<String> body = new LinkedList<String>();
            for (Integer t : table) {
temp.get(t.toString())
            }


        }
    }
}
