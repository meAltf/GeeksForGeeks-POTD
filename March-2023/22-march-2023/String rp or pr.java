/******************************************************************************************************************************************************
------------------------
Level- Medium
---------------------
Given a string S. In one operation, you can remove the substring "pr" from the string S and get amount X or you can remove the substring "rp" and 
get the amount Y. 
Find the maximum amount you can get if you perform zero or more such operations optimally. 
NOTE-
Substring of a string S is defined as a continuous sequence of characters in S.
After removing pr or rp, the order of remaining letters should remain the same.

---------------------------------------------------------------------------------------

Example 1:

Input:
X = 5, Y = 4
S = "abppprrr"
Output: 15
Explanation: 
Here, S = "abppprrr" 
X= 5, Y=4.
Remove "pr", new string S = "abpprr".
Remove "pr", new string S = "abpr".
Remove "pr", new string S = "ab".
In total, we removed "pr" 3 times, 
so total score is 3*X + 0*Y = 3*5 =15.
 

 

Example 2:

Input:
X = 7, Y = 7
S = "prpptppr"
Output: 14
Explanation: 
Here, S = "prpptppr" 
X= 7, Y=7.
As both have the same amount we can first 
remove either pr or rp. Here we start with pr
Remove "pr", new string S = "pptppr".
Remove "pr", new string S = "pptp".
In total, we removed "pr" 2 times, 
so total score is 2*X + 0*Y = 2*7 =14.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution 
{ 
static long solve(int X,int Y, String S) {

    // get the length of input string S
    int l = S.length();
    // substrings that can be removed to earn amounts X and Y
    String str1 = "pr", str2 = "rp";
    // if Y is greater than X, we swap the substrings str1 and str2 and the amounts X and Y
    if (Y > X) {
        str1 = "rp";
        str2 = "pr";
        int temp = X;
        X = Y;
        Y = temp;
    }
    // While substring str1 is found in S, remove it using replaceAll() method
    while (S.indexOf(str1) != -1) {
        S = S.replaceAll(str1, "");
    }
    
    /*Calculate the number of times str1 was removed by subtracting the length of S 
    after removal of str1 from the original length of S, and divide by 2*/
    long x = (l - S.length()) / 2;
    // Update length of S after removal of str1
    l = S.length();
    // While substring str2 is found in S, remove it using replaceAll() method
    while (S.indexOf(str2) != -1) {
        S = S.replaceAll(str2, "");
    }
    /*Calculate the number of times str1 was removed by subtracting the length of S 
    after removal of str1 from the original length of S, and divide by 2*/
    long y = (l - S.length()) / 2;
    // return the total amount earned by removing str1 and str2 substrings respectively
    return x * X + y * Y;
    
}
} 
