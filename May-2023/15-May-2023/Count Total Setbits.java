/******************************************************************************************************************************************************
----------------
Level-Medium
----------------
You are given a number N. Find the total number of setbits in the numbers from 1 to N.
___________________________________________________________________________________________________

Example 1:

Input: N = 3
Output: 4
Explaination: 
1 -> 01, 2 -> 10 and 3 -> 11. 
So total 4 setbits.
Example 2:

Input: N = 4
Output: 5
Explaination: 1 -> 01, 2 -> 10, 3 -> 11 
and 4 -> 100. So total 5 setbits.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



class Solution {
    public static long countBits(long N) {
        // code here
        long count = 0;

    for (int i = 1; i <= N; i++) {

        // Count the number of set bits in each number using Integer.bitCount()

        count += Integer.bitCount(i);

    }

    return count;
    }
}
        
