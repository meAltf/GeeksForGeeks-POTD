/******************************************************************************************************************************************************
------------------------
Level- Easy
------------------------
Given a non-negative integer N. The task is to check if N is a power of 2. More formally, check if N can be expressed as 2x for some integer x.
___________________________________________________________________________________________________

Example 1:

Input: 
N = 8
Output: 
YES
Explanation:
8 is equal to 2 raised to 3 (23 = 8).

Example 2:

Input: 
N = 98
Output: 
NO
Explanation: 
98 cannot be obtained by any power of 2.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution{
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        
        // Your code here
        
        // while(n>1){
        //     if(n%2 == 0){
        //         n=n/2;
        //     }
        // }
        
        // if(n==1) return true;
        // return false;
        
        
        if(n==0) return false;
        
        //return (n & (n-1)) == 0;
        
        if((n&(n-1)) == 0) return true;
        
        return false;
        
    }
    
}
