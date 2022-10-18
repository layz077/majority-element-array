package com.jdbc;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {4,3,7,1,5,0,-1,10,45};
        //bubbleSort(arr);
        mergeSort(arr, 0, arr.length-1);
    }

    static void bubbleSort(int[] array){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[j] > array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i: array) System.out.print(i+"  ");
    }

    static void mergeSort(int[] array,int left, int right){
       if(left < right){
           int mid = (left+right)/2;
           mergeSort(array, left, mid);
           mergeSort(array, mid+1, right);

//         [4,6,7,9] , [1,3,5] -> Now we have these two arrays.No in merge method we will compare
//         elements of these two one by one and do accordingly;

           merge(array,left,(left+right)/2,right);

           System.out.println("Sorted Array");
           for (int i: array) System.out.print(i);
       }
    }

    static void merge(int[] array, int left, int mid,int right){
         int i = left;
         int j = mid+1;
         int k=0;
         int[] temp = new int[array.length];

         while(i <= mid && j <= right){
             if(array[i] < array[j]){
                 temp[k++] = array[i++];
             }
             else{
                 temp[k++] = array[j++];
             }
         }

             while(j <= right){
                 temp[k++] = array[j++];
             }

             while(i <= mid){
                 temp[k++] = array[i++];
             }

         int y = 0;
         for(int x: temp) {
             array[y++] = x;
         }
    }
}

// Selection sort -> Take the minimum element and put it in respective index

// Quick sort -> O(nlogn) , worst-> n^2

// Merge sort -> both o(nlogn)


