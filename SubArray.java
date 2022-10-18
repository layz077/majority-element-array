package com.jdbc;

import java.util.HashMap;
import java.util.Map;

public class SubArray {
    public static void main(String[] args) {
        int[] array = {10,15,-5,15,-10,5};
        int sum = 10;
        // for(int i:solution(array, sum)) System.out.print(i+",");
        for(int i:effSolution(array, sum)) System.out.print(i+",");
    }

    public static int[] solution(int[] array,int sum){

        int[] returnValue  = new int[2];
        loop:
        for (int i = 0; i < array.length-1; i++) {
           // if(i==array.length-2) continue;
             int sum1=array[i];
                for (int j = i+1; j < array.length-1; j++) {
                    sum1 = sum1 + array[j];
                    if(sum1==sum) {
                        returnValue[0] = i;
                        returnValue[1] = j;
                        break loop;
                    }
                }
        }
        return returnValue;
    }

    public static int[] effSolution(int[] array,int sum){
        int currSum = 0;
        int start = 0;
        int end = -1;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            currSum += array[i];

            // If we get current sum directly equal to sum than we got the solution here only

            if(currSum - sum == 0 && i!=0){
                start = 0;
                end = i;
                break;
            }

            // Current Sum - Sum = Any of the previously saved sum (key in map) than we have the answer
            if(map.containsKey(currSum - sum)){
                start = map.get(currSum - sum) +1;
                end = i;
                break;
            }
            map.put(currSum, i);
        }
        return new int[] {start,end};
    }
}
