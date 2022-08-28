package com.jdbc;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {-2,-1};
        System.out.println(kadanesAlgo(arr));
    }

    static int kadanesAlgo(int[] array){

        int curSum = 0;
        int maxSum =0;
        int neg = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            curSum = curSum + array[i];

            if(curSum > maxSum){
                maxSum = curSum;
            }
            if(curSum < 0){
                if(curSum > neg){
                    neg = curSum;
                }
                curSum = 0;
            }
        }

        if(maxSum == 0){
            return neg;
        }
        return maxSum;
    }

}
