/******************************************************************************************************************************************************
-----------------------
Level-Easy
------------------------
Given two numbers X and Y, and a range [L, R] where 1 <= L <= R <= 31. You have to copy the set bits of 'Y' in the range L to R in 'X'. Return this modified X.

Note: Range count will be from Right to Left & start from 1.

___________________________________________________________________________________________________

Example 1:

Input: 
X = 44, Y = 3 
L = 1,  R = 5
Output: 
47
Explaination: 
Binary represenation of 44 and 3 is 101100 and 000011. So in the range 1 to 5 there are two set bits of 3 (1st & 2nd position). 
If those are set in 44 it will become 101111 which is 47.

Example 2:

Input: 
X = 16, Y = 2
L = 1,  R = 3
Output: 18
Explaination: Binary represenation of 16 and 2 is 10000 and 10. If the mentioned conditions are applied then 16 will become 10010 which is 18.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        // code here
        
         // l and r must be between 1 to 32
    if (l < 1 || r > 32)
        return x;
 
    // get the length of the mask
    int maskLength = (int)((1L<<(r-l+1)) - 1);
 
    // Shift the mask to the required position
    // "&" with y to get the set bits at between
    // l ad r in y
    int mask = ((maskLength)<<(l-1)) & y ;
    x = x | mask;
    return x;
    }
}
