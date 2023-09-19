/******************************************************************************************************************************************************
-------------------
Level-Easy
-----------------------
Given an integer N. The task is to return the position of first set bit found from the right side in the binary representation of the number.
Note: If there is no set bit in the integer N, then return 0 from the function.  

___________________________________________________________________________________________________

Example 1:

Input: 
N = 18
Output: 
2
Explanation: 
Binary representation of 18 is 010010,the first set bit from the right side is at position 2.

Example 2:

Input: 
N = 12 
Output: 
3 
Explanation: 
Binary representation of  12 is 1100, the first set bit from the right side is at position 3.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
            
        // Your code here
        int count = 0;
        
        while(n > 0){
            
            count++;
            
            if((n & 1) == 1 ){
                
                break;
            }
            n=n/2;
        }
        
        return count;
            
    }
}


// 18- 010010
//12- 1100


