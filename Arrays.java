package com.jdbc;

import java.sql.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Arrays {

    public static void main(String[] args) {
        int[] a = {6,5,5};
        System.out.println(majorityElement(a));
//        System.out.println(majorityElement2(a));
        System.out.println(majorityElement3(a));
        System.out.println(morreVotingAlgo(a));
    }

    static int majorityElement(int[] array) {   // O(n^2)
        int a = 0;
        int b = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) continue;
                if (array[i] == array[j]) a++;
            }
            if (a > count) {
                count = a;
                b = array[i];
            }
        }
        if (array.length / 2 < count) return b;
        return -1;
    }

//    static int majorityElement2(int[] array) {    //O(nlogn)
//        java.util.Arrays.sort(array);
//        int pointer = 0;
//        int count = 0;
//        int count1=0;
//        int res = 0;
//
//        for (int i = 1; i < array.length; i++) {
//            if (array[pointer] == array[i]) count++;
//            if (array[pointer] != array[i] || (count>0 && i==array.length-1)){
//                if(count > count1){
//                    count1 = count;
//                    res = array[pointer];
//                }
//                pointer = i;
//                count=0;
//            }
//        }
//        if(array.length/2 < count1+1) return res;
//        return -1;
//    }

    static int majorityElement3(int[] array){
        Map<Integer,Integer> map = new HashMap<>();

        for (int j : array) {
            if (map.containsKey(j)) {
                map.replace(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        var a = 0;
        for(int i: map.keySet()){
            if(map.get(i)>a) a=i;
        }
        if(array.length/2 < map.get(a)) return a;
        return -1;
    }

    static int morreVotingAlgo(int[] array){

        int point=0;
        int count=0;

        for (int i = 1; i < array.length; i++) {
            if(array[point]==array[i]){
                count++;
            }else {
                if(count!=0){
                    count--;
                }
                else {
                    point = i;
                }
            }
        }
//        if(count>0) {
            int x=0;
            for (int j : array) {
                if (j == array[point]) x++;
            }
            if(x > array.length/2) return array[point];
//        }

        return -1;
    }
}