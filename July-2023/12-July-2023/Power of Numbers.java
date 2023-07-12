/******************************************************************************************************************************************************
---------------------
Level- Medium
---------------------
Given a number and its reverse. Find that number raised to the power of its own reverse.
Note: As answers can be very large, print the result modulo 109 + 7.
___________________________________________________________________________________________________

Example 1:

Input:
N = 2, R = 2
Output: 4
Explanation: The reverse of 2 is 2 and after raising power of 2 by 2 we get 4 which gives remainder as 4 when divided by 1000000007.

Example 2:

Input:
N = 12, R = 21
Output: 864354781
Explanation: The reverse of 12 is 21and 1221 when divided by 1000000007 gives remainder as 864354781.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution
{
      
    static int mod = 1000000007;  
    long power(int N,int R)
    {
        //Your code here
        
       if(R==1)return N%mod;
       
       long half = power(N,R/2);
       
       half = (half*half)%mod;
       
       if(R%2==1)half = (half*N)%mod;
       
       return half;
        
    }

}
