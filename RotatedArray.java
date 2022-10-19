package com.jdbc;

public class RotatedArray {
    public static void main(String[] args) {
        //int[] array = {120,130,40,50,90,100,110};
        int[] array = {50,60,90,100,20,30,40};
        int target = 40;
        System.out.println(solution(array, target));
    }

    public static int solution(int[] array, int target){

        int start = 0;
        int end = array.length-1;
        int returnValue = -1;

        for (int i = start; i <= end; i++) {

            int mid = start + (end - start)/2;

            if(start == end){
                returnValue = start;
                break;
            }
            if(target == array[mid]){
                returnValue =  mid;
                break;
            }

            if(array[start] < array[mid]){      // Left Sorted
                if(array[mid-1] > target && array[start] <= target){ // If element present in left array
                    start = start;
                    end = mid;
                }
                else {                                                // Else shift position to right array
                    start = mid+1;
                    end =end;
                }
            }
            else if(array[end] > array[mid]){      // Right Sorted
                if(array[mid+1] < target && array[end] >= target){
                    start = mid+1;
                    end = end;
                }
                else {
                    start = start;
                    end = mid;
                }
            }
        }
        return returnValue;
    }
}
