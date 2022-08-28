package com.jdbc;

import java.util.ArrayList;
import java.util.List;

public class RainWater {

    public static void main(String[] args) {
        int[] arr = {3,1,2,4,0,1,3,2};
        System.out.println(rain(arr));
    }

    static int rain(int[] array){

        int result = 0;
        int[] left = new int[array.length];
        int countLeft = 0;
        int[] right = new int[array.length];
        int countRight = right.length-1;

        // Saving left right max values for particular indexes
        for (int i = 1; i < array.length; i++) {
            if(i==1){
                left[countLeft++] = array[0];
                right[countRight--] = array[array.length-1];
            }
            left[countLeft] = Math.max(left[countLeft - 1], array[i]);
            countLeft++;

            right[countRight] = Math.max(right[countRight+1],array[array.length-i-1]);
            countRight--;
        }

        for (int i = 0; i < array.length; i++) {
            result += Math.min(left[i],right[i]) - array[i];
        }

        return result;
    }
}
