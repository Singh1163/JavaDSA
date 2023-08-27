package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Recursion1 {

    static int sumOfDigit(int num){

        if(num%10 == num) return num;
        else return num%10+sumOfDigit(num/10);
    }

    static int reverseNumber(int num, int rev){

        if(num <= 0) return rev;
        rev = rev*10+num%10;
        return reverseNumber(num/10, rev);
    }

    static boolean checkPalindromeNumber(int num){

        return (num == reverseNumber(num, 0));
    }

    static boolean checkIfArraySorted(int[] arr, int i){
        if(i==arr.length-1) return true;
        if(arr[i]<arr[i+1]) return checkIfArraySorted(arr, i+1);
        else return false;
    }

    static int countZero(int num, int count){

        if(num <= 0) return count;
        if(num%10==0) count+= 1;
        return countZero(num / 10, count);
    }

    static boolean findTargetInArray(int[] arr, int target, int i){
        if(i==arr.length) return false;
        if(arr[i]==target) return true;
        return findTargetInArray(arr, target, i+1);
    }

    static ArrayList<Integer> findAllTargetInArray(int[] arr, int target, int i, ArrayList<Integer> ans){
        if(i==arr.length) return ans;
        if(arr[i]==target) ans.add(i);
        return findAllTargetInArray(arr, target, i+1, ans);
    }

    static ArrayList<Integer> findAllTargetInArrayWithoutPassingArgs(int[] arr, int target, int i){
        ArrayList<Integer> ans = new ArrayList<>();
        if(i==arr.length) return ans;
        if(arr[i]==target) ans.add(i);
        ans.addAll(findAllTargetInArrayWithoutPassingArgs(arr, target, i+1));
         return ans;
    }

    static int rotatedBinarySearch(int[] arr, int target, int start, int end){
        if(start>end) return -1;
        int mid = start + end;
        if(arr[mid]==target) return mid;
        if(arr[start]<arr[mid]){
            if(target>arr[start]&&target<arr[mid]) return rotatedBinarySearch(arr,target,start,mid-1);
            else return rotatedBinarySearch(arr,target,mid+1,end);
        }
        else return rotatedBinarySearch(arr,target,start,mid-1);
    }

    static void printPattern(int row, int col){

        if(row == 0) return;
        if(row>col){
            System.out.print("*");
            printPattern(row, col+1);
        }
        else {
            System.out.println();
            printPattern(row - 1, 0);
        }
    }

    static void printPattern2(int row, int col){

        if(row == 0) return;
        if(row>col){
            printPattern2(row, col+1);
            System.out.print("*");
        }
        else {
            printPattern2(row - 1, 0);
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 23,1,2,3,4,5,6,7};
//        ArrayList<Integer> ans = new ArrayList<>();
//        System.out.println(rotatedBinarySearch(arr, 5, 0, arr.length-1));

        System.out.println(Arrays.toString(arr));
    }


}
