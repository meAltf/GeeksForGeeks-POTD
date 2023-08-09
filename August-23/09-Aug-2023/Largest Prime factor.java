/**************************************************
------------------
Level- Medium
-------------------
Given a number N, the task is to find the largest prime factor of that number.
_________________________________

 Example 1:

Input:
N = 5
Output:
5
Explanation:
5 has 1 prime factor i.e 5 only.

Example 2:

Input:
N = 24
Output:
3
Explanation:
24 has 2 prime factors 2 and 3 in which 3 is greater.

_________________________________

***************************************************/

//User function Template for Java

class Solution{
    
    private static int checkPrime(int num){
        int divide=2;
        for(int i=divide; i<num; i++){
            
            if(num%divide != 0){
                
                return divide;
            }
            
            divide++;
        }
    }
    static long largestPrimeFactor(int N) {
        // code here
        
        for(int i=2; i*i<=N; i++){
            
            if(N%i==0){
                
                N=N/i;
                
                i--;
            }
        }
        long ans = N;
        
        return ans;
        
    }
}
