/******************************************************************************************************************************************************

Given an integer N. Find maximum LCM (Least Common Multiple) that can be obtained from four numbers less than or equal to N.
Note: Duplicate numbers can be used.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 4
Output: 12
Explanation:
The four numbers can be [4,4,3,2] or
[4,4,4,3], etc. It can be shown that 12 is
the maximum LCM of four numbers that can
be obtained from numbers less than or equal 
to 4.
Example 2:

Input:
N = 5
Output: 60
Explanation:
The four numbers can be [5,5,4,3] or
[5,4,3,2], etc. 60 is the maximum that can
be obtained.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


// User function Template for Java

class Solution {
    long solve(int n) {
        long a1 = n*(n-1);
        int include=0;
        for(long i=n-2;i>=1;i--) {
            long g = gcd(a1,i);
            if(g==1) {
                a1*=i;
                include++;
            }
            if(include==2) return a1;
        }
        return a1;
    }
    
    long maxGcd(int N) {
        return Math.max(solve(N),solve(N-1));
    }
    
    long gcd(long a,long b) {
        if(a==0) return b;
        return gcd(b%a,a);
    }
}
