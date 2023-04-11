/******************************************************************************************************************************************************
-----------------------------------
Level- Medium
-----------------------------------
Given the maximum occurrences of a, b, and c in a string. Your task is to make the string containing only a, b, and c such that
no three consecutive characters are the same. If the resultant string equals to a+b+c, return the length (a+b+c) otherwise -1.

___________________________________________________________________________________________________

Example 1:

Input:
a = 3, b = 3, c = 3
Output: 
9
Explanation: 
No three consecutive character of
the string "abcabcabc" is same.
Example 2:

Input:
a = 11, b = 2, c = 2
Output: 
-1
Explanation: 
If we build a string of these character's,
the string will be"aabaacaabaacaaa", here
we can see that there will be three consecutive a. So
there is no solution exist.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution {
    int solve(int a, int b, int c) {
        // code here
        int maxLength=a+b+c;
        int maxCount = Math.max(a, Math.max(b,c));
        int remainingCount = maxLength - maxCount;
        if(maxCount > remainingCount * 2 + 2){
            return -1;
        }else{
            return a+b+c;
        }
    }
};
