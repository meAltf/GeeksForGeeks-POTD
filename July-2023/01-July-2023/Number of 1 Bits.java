/******************************************************************************************************************************************************
------------------------
Level- Easy
--------------------------
Given a positive integer N, print count of set bits in it. 
___________________________________________________________________________________________________

Example 1:

Input:\
N = 6
Output:
2
Explanation:
Binary representation is '110' 
So the count of the set bit is 2.

Example 2:

Input:
8
Output:
1
Explanation:
Binary representation is '1000' 
So the count of the set bit is 1.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

// User function Template for Java
class Solution {
    static int setBits(int N) {
        // code here
        
        //base case
        if(N == 0) return 0;
        
        int count = 0;
        
        while(N != 0){
            
            if ((N & 1) == 1) {
                count++;
            }
            
            N >>= 1;
        }
        return count;
    }
}
