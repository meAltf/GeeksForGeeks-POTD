/*********************************************************************************************************************************

Given two numbers a and b. In one operation you can pick any non negative integer x and either of a or b. Now if you picked a then replace a with a&x 
else if you picked b then replace b with b&x.

Return the minimum number of operation required to make a and b equal.

Note: Here & represents bitwise AND operation.

-------------------------------------------------------------

Example 1:

Input:
a = 5, b = 12
Output:
2

Explanantion:
In first operation replace 
a = a&4 = 4
after that replace 
b = b&6 = 4
Hence both are same after applying two
operations.

Example 2:

Input: 
a = 100, b = 100
Output: 
0

Explanation: 
Already same.

-------------------------------------------------------------------------

**********************************************************************************************************************************/

class Solution {
    public static int solve(int a, int b) {
        // code here
        
        if(a==b) return 0;
        
        if((a&b) == a || (a&b) ==b) return 1;
        
        return 2;
        
    }
}
   
