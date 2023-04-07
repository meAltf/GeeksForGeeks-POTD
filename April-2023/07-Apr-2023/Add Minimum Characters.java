/******************************************************************************************************************************************************
-----------------------------
Level- Medium
----------------------------
Given a string str, find the minimum characters to be added at front of the string to make it a palindrome.

---------------------------------------------------------------------------------------

Example 1:

Input:
str = ABCD
Output: 3
Explanation: The resultant string 
after adding 3 characters is DCBABCD.
The minimum possible answer is 3.
Example 2:

Input:
str = ABA
Output: 0
Explanation: The given string
is already a palindrome.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution

{
	public static int addMinChar(String str){

		int len = str.length();

        int start = 0, end = len - 1;

        int res = 0;

        while(start < end) {

            if(str.charAt(start)== str.charAt(end)) {
                
                start++;
                end--;
                
            } else {

                res++;
                start = 0;
                end = len - res - 1;
            }
        }
        return res;
	}
}

