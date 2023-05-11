/******************************************************************************************************************************************************
-------------------
Level- Medium
-------------------

Given a string, S.The string can contain small case English letters or '?'. You can replace '?' with any small English letter. 
Now if it is possible to make the string S a palindrome after replacing all '?'
then find the palindromic string with a minimum ascii sum of the absolute difference of adjacent characters. Otherwise, return -1.

___________________________________________________________________________________________________

Example 1:

Input: S = a???c??c????
Output: 4
Explanation:
We can see that we can make the string
palindrome. Now to get minimum ascii sum we should
replace all the '?' between 'a' and 'c' with
'b' and all the '?' between two 'c' with 'c'.
So after replacing all the '?' the string: 
abbbccccbbba.
The sum of differences of adjacent characters is 4.

Example 2:

Input: S = a???c??c???c
Output: -1
Explanation:
It is not possible to make the string palindrome.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



class Solution {
    public static int minimumSum(String s) {
        int ans = 0;
        int l =0 ,r = s.length() -1 ;
        StringBuilder sb = new StringBuilder(s);
        while(l<r){
            if(s.charAt(l)!='?' && s.charAt(r)!='?' && s.charAt(l)!=s.charAt(r)){
                return -1;
            }
            else if(s.charAt(l)=='?'){
                if(s.charAt(r)!='?')sb.setCharAt(l,s.charAt(r));
            }
            else if(s.charAt(r)=='?'){
                if(s.charAt(l)!='?')sb.setCharAt(r,s.charAt(l));
            }
            l++;
            r--;
        }
        
        char prev = '$' ;
        for(char ch : sb.toString().toCharArray()){
            if(ch == '?')continue;
            if(prev == '$'){
                prev = ch;
            }
            else{
                ans += Math.abs(prev - ch);
                prev = ch;
            }
        }
        return ans;
    }
}
