/******************************************************************************************************************************************************
---------------------
Level- Easy
----------------------
Given a string S, check if it is palindrome or not.

___________________________________________________________________________________________________

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // code here
        int d = S.length();
        // code here
        for(int i=0; i<d/2; i++){
            if(S.charAt(i)!= S.charAt(d-i-1)){
                return 0;
            }
        }
        return 1;
    }
};
