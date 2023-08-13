/******************************************************************************************************************************************************
-------------------
Level -Easy
-------------------
Given a positive integer n, find the nth fibonacci number. Since the answer can be very large, return the answer modulo 1000000007.

___________________________________________________________________________________________________


Example 1:

Input: 
n = 2
Output: 
1 
Explanation: 
1 is the 2nd number of fibonacci series.

Example 2:

Input: 
n = 5
Output: 
5
Explanation: 
5 is the 5th number of fibonacci series.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution {
    static int nthFibonacci(int n){
        // code here
        
        if(n==0 || n==1) return n;
        
        long a = 0;
        long b = 1;
        
        long ans = 0;
        
        for(int i=2; i<=n; i++){
            
            ans = (a+b)%1000000007;
            a = b;
            b = ans;
        }
        
        return (int)(ans%1000000007);
    
    }
}
