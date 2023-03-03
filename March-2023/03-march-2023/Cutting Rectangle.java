/******************************************************************************************************************************************************
-----------------
level-EASY
------------------

Given a rectangle of dimensions L x B find the minimum number (N) of identical squares of maximum side that can be cut out from that rectangle so that no 
residue remains in the rectangle. Also find the dimension K of that square.

---------------------------------------------------------------------------------------

Example 1:

Input: L = 2, B = 4
Output: N = 2, K = 2
Explaination: 2 squares of 2x2 dimension.

Example 2:

Input: L = 6, B = 3
Output: N = 2, K = 3
Explaintion: 2 squares of 3x3 dimension. 


----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution{
    static List<Long> minimumSquares(long L, long B)
    {
  
        // Code here
        List<Long> arr = new ArrayList<>();
        long k = gcd(L, B);
        long n = (L * B) / (k * k);
        arr.add(n);
        arr.add(k);
  
        return arr;
    }
  
  private static long gcd(long a,long b)
    {
       if(b==0) return a;
      return gcd(b,a%b);
    }
}
