/******************************************************************************************************************************************************
-----------------
Level- Easy
You are given an array A of size N. Let us denote S as the sum of all integers present in the array. Among all integers present in the array, 
find the minimum integer X such that S ≤ N*X.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 3,
A = { 1, 3, 2}
Output:
2
Explanation:
Sum of integers in the array is 6.
since 6 ≤ 3*2, therefore 2 is the answer.
Example 2:

Input:
N = 1,
A = { 3 }
Output:
3
Explanation:
3 is the only possible answer

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

--------------------------
Approach-1
--------------------------
  
  

class Solution {
    public static int minimumInteger(int N, int[] A) {
        // code here
        
        long sum = 0;
        for(int i=0; i<N; i++) sum += A[i];
        
        Arrays.sort(A);
        
        for(int i=0; i<A.length; i++){
            if(sum <(long)N*A[i] || sum == (long)N*A[i] )
                return A[i];
        }
        return 0;
    }
}


---------------------------------
Approach-2
--------------------------------
  
class Solution {
    public static int minimumInteger(int N, int[] A) {
        // code here
        
        long sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) sum += A[i];
        
        for(int i=0; i<A.length; i++){
            if(sum <=(long)N*A[i])
                ans = Math.min(ans,A[i]);
        }
        return ans;
    }
}
