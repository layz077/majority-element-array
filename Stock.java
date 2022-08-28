package com.jdbc;

import java.util.Arrays;

public class Stock {

    public static void main(String[] args) {
        int[] arr = {3,2,6,1,0,2};
        //System.out.println(sell(arr));
        //System.out.println(sell2(arr));
        System.out.println(sell3(arr));
        System.out.println(sellMultiple(arr));
    }

    static int sell(int[] array){

        int min=Integer.MAX_VALUE;
        int minIndex=0;
        int max=Integer.MIN_VALUE;
        int maxIndex=1;
        int point=0;

        for (int i = 0; i < array.length; i++) {

            if((maxIndex - minIndex) <= 1){
               break;
            }
//            point++;
//            if((array.length & 1 )==1){
//                if(point > (array.length / 2)+1) break;
//            }
//            else{
//                if(point > (array.length / 2)) break;
//            }

            if(array[i] < min){
                //if(i < maxIndex && minIndex < maxIndex){
                    min = array[i];
                    minIndex = i;
                //}
            }
            if(array[array.length-i-1] > max){
                //if(i > minIndex && minIndex < maxIndex) {
                    max = array[array.length-1-i];
                    maxIndex = array.length-1-i;
               // }
            }
        }
        System.out.println(array[minIndex]);
        System.out.println(array[maxIndex]);

        return Math.max((max - min), 0);
    }

    static int sell2(int[] array){

        int max = Integer.MIN_VALUE;
        int[] aux = new int[array.length];
        int count=0;
        int ans = 0;

        for (int i = array.length-1; i > 0; i--) {
            if(array[i] > max){
                max = array[i];
                aux[count++] = array[i];
            }
        }
       count = 0;

        for (int i = 0; i < array.length; i++) {
            if((max - array[i]) == 0)
            {
                if(ans > 0) return ans;
            }
            if((max - array[i]) > ans ) ans = max - array[i];
        }
        return ans;
    }

    static int sell3(int[] array){

        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < array.length; i++) {
            minSoFar = Math.min(minSoFar, array[i]);
            int profit = array[i] - minSoFar;
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    static int sellMultiple(int [] array){
        int profit = 0;

        /*for (int i = 1; i < array.length; i++) {
            if(array[i-1] > array[i]){
                profit += (array[i-1] - array[i]);
            }
        }*/

        int pointer =0;
        for (int i = 1; i < array.length; i++) {
            if(array[i-1] > array[i]){
                profit += (array[i-1] - array[pointer]);
                pointer = i;
            }
            if(i == array.length-1){
                if(array[i] > array[pointer]){
                    profit += (array[i] - array[pointer]);
                }
            }
        }

        return profit;
    }
}

class sum{

    public static void main(String[] args) {
        int[] array = {5,4,37,4,32,5,3};
        // 12
        //target - sumof2 = 2    // 3,4,4,5,5,32,37
        Arrays.sort(array);
        int pointer = array.length-1;
        int target = 12;

        for (int i = 0; i < array.length; i++) {
            if(array[pointer] >= target){
                pointer--;
                continue;
            }
            if((target - (array[i] + array[pointer])) ==2){
                System.out.println(i);
                System.out.println(pointer);
            }
        }

    }
}
