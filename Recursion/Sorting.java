package Recursion;

import java.util.Arrays;

public class Sorting {
    static void bubbleSort(int[] arr, int i, int n){
        if(n==0) return;
        if(arr[i]>arr[i+1]){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }

        if(i<n-2)bubbleSort(arr, i+1, n);
        else bubbleSort(arr, 0, n-1);
    }

    static void selectionSort(int[] arr, int i, int n, int max){
        if(n==0) return;
        if(arr[i]>arr[max]) max = i;
        if(i<n-1)selectionSort(arr, i+1, n, max);
        else {
            int temp = arr[max];
            arr[max] = arr[n-1];
            arr[n-1] = temp;
            selectionSort(arr, 0, n-1, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 23,1,2,3,4,5,6,7};
//        ArrayList<Integer> ans = new ArrayList<>();
//        System.out.println(rotatedBinarySearch(arr, 5, 0, arr.length-1));
        selectionSort(arr, 0, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }
}
