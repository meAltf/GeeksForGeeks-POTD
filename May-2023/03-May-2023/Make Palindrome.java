/******************************************************************************************************************************************************
----------------------------
Level- Easy
----------------------------
You are given an array of strings arr of size n. You have to find out if it is possible to make a palindromic string by concatenating the strings 
in any order. Provided that all the strings given in the array are of equal length.
___________________________________________________________________________________________________

Example 1:

Input:
n = 4
arr = {"djfh", "gadt", "hfjd", "tdag"}
Output:
YES
Explanation:
You can make the string "djfhgadttdaghfjd", by concatenating the given strings which is a palindrome.
Example 2:

Input:
n = 3
arr = {"jhjdf", "sftas", "fgsdf"}
Output:
NO
Explanation:
You can't make a palindromic string with this strings.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



class Solution {
   // public static boolean makePalindrome(int n, String[] arr) {
        // code here
   // }
public static boolean makePalindrome(int n, String[] arr) {
        // code here
        Map<String,Integer> mm = new HashMap<>();
        int odd=0;
        for(String x:arr){
            mm.putIfAbsent(x,0);
            mm.put(x,mm.get(x)+1);
        }
        for(Map.Entry<String,Integer> x : mm.entrySet()){
            StringBuilder t = new StringBuilder(x.getKey());
            t.reverse();
            String temp = t.toString();
            if(temp.equals(x.getKey())){
                if((x.getValue()%2)==1)odd++;
                if(odd>1)return false;
            }
            else if(mm.get(temp)!=x.getValue())return false;
        }
        return true;
    }
}
        
