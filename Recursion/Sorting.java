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

    static int [] mergeSort(int[] arr){
        if(arr.length==1) return arr;
        int mid = arr.length/2;
        int [] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int [] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static void inplaceMergeSort(int[] arr, int start, int end){
        if(end-start == 1) return;
        int mid = (start+end)/2;
        inplaceMergeSort(arr, start, mid);
        inplaceMergeSort(arr, mid, end);
        inplaceMerge(arr, start, mid, end);
    }

    private static void inplaceMerge(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end-start];
        int i=start, j=mid, k=0;
        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                mix[k] =arr[i];
                i++;}
            else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while(j<end){
            mix[k] = arr[j];
            j++;
            k++;
        }
        for(int l = 0; l<mix.length; l++){
            arr[start+l] = mix[l];
        }

    }

    private static int[] merge(int[]first, int[] second) {

        int[] arr = new int[first.length + second.length];
        int i=0, j=0, k=0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                arr[k] =first[i];
                i++;}
            else {
                arr[k] = second[j];
                j++;
            }
            k++;
        }
        while(i<first.length){
            arr[k] = first[i];
            i++;
            k++;
        }
        while(j<second.length){
            arr[k] = second[j];
            j++;
            k++;
        }
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end){
        if(start>=end) return;
        int low = start;
        int high = end;
        int mid = low+ (high-low)/2;
        int pivot = arr[mid];

        while(low<=high){

            while (arr[low]<pivot) low++;
            while (arr[high]>pivot) high--;
            if(low<=high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        quickSort(arr, start, high);
        quickSort(arr, low, end);
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 23,1,2,3,4,5,6,7};
//        ArrayList<Integer> ans = new ArrayList<>();
//        System.out.println(rotatedBinarySearch(arr, 5, 0, arr.length-1));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
