package Recursion;

import java.util.*;

public class Recursion2 {

    private static String removeACharacter(String str, char ch, int i, StringBuilder ans){
        if(i==str.length()) return ans.toString();
        if(str.charAt(i)!=ch) ans.append(str.charAt(i));
        return removeACharacter(str, ch, i+1, ans);

    }

    private static String removeACharacter2(String str, char ch, int i){
        if(i==str.length()) return "";
        char c = str.charAt(i);
        if(c!=ch) return c+removeACharacter2(str, ch, i+1);
        else return removeACharacter2(str, ch, i+1);

    }

    private static String removeAWord(String str, String word){
        if(str.isEmpty()) return "";
        if(str.startsWith(word)) return removeAWord(str.substring(word.length()), word);
        else return str.charAt(0)+removeAWord(str.substring(1), word);
    }

    static void subsetOfString(String pStr, String uStr){
        if(uStr.isEmpty()){
            if(!(pStr.isEmpty()))
                System.out.println(pStr);
            return;
        }
        char ch = uStr.charAt(0);
        subsetOfString(pStr+ch, uStr.substring(1));
        subsetOfString(pStr, uStr.substring(1));
    }

    static ArrayList<String> subsetOfString(String pStr, String uStr, ArrayList<String> ans){
        if(uStr.isEmpty()){
            if(!(pStr.isEmpty()))
                ans.add(pStr);
            return ans;
        }
        char ch = uStr.charAt(0);
        subsetOfString(pStr+ch, uStr.substring(1), ans);
        subsetOfString(pStr, uStr.substring(1), ans);
        return ans;
    }

    private static void subSet(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            subSet(list, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    static ArrayList<String> permutationOfString(String pStr, String uStr, ArrayList<String> ans){
        if(uStr.isEmpty()){
                ans.add(pStr);
            return ans;
        }
        char ch = uStr.charAt(0);
        for(int i = 0; i<=pStr.length(); i++){
            String f = pStr.substring(0,i);
            String s = pStr.substring(i);
            permutationOfString(f+ch+s, uStr.substring(1), ans);
        }
        return ans;
    }

    static void permutationOfArray(List<List<Integer>> list, int index, List<Integer> arr){
        if(index==arr.size()){
            list.add(new ArrayList<>(arr));
            return;
        }
        for(int i = index; i<arr.size(); i++){
            int temp = arr.get(index);
            arr.set(index, arr.get(i));
            arr.set(i, temp);
            permutationOfArray(list, index+1, arr);
            temp = arr.get(index);
            arr.set(index, arr.get(i));
            arr.set(i, temp);
        }
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private void solve(String digits, String p, List<String> ans) {
        if (digits.isEmpty()) {
            ans.add(p);
            return;
        }
        int digit = digits.charAt(0) - '0';
        int start = (digit - 1) * 3;
        int end = digit * 3;
        if (digit > 5) {
            if (digit == 6 || digit ==7) end = (digit * 3)+1;
            start = (digit - 1) * 3;
        }
        for (int i = start; i<end; i++){
            char ch = (char)('a'+i);
            solve(digits.substring(1), p+ch, ans);
        }

    }
    private static void combinationOfTargetSum(int[] candidates, int target, List<List < Integer>> ans, List<Integer> list, int index){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target <0) return;
        for(int i = index ; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            combinationOfTargetSum(candidates, target-candidates[i], ans, list, i+1);
            list.remove(list.size()-1);
        }

    }
    public static List<List<Integer>> removeDuplicates(List<List<Integer>> listOfLists) {
        Set<List<Integer>> uniqueLists = new HashSet<>();

        for (List<Integer> list : listOfLists) {
            // Sort the list to ensure elements with the same frequencies are treated as equal
            list.sort(Integer::compareTo);
            uniqueLists.add(list);
        }

        return new ArrayList<>(uniqueLists);
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int[] num = {8 ,1 ,3 ,7 ,2 ,1, 5};
        Arrays.sort(num);
//        List<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        ArrayList<String> ans = permutationOfString("", "abcc", new ArrayList<>());
//        permutationOfArray(list, 0, nums);
        combinationOfTargetSum(num, 12, list, new ArrayList<>(), 0);
        for(List<Integer> i: list)
            System.out.println(i);

    }
}
