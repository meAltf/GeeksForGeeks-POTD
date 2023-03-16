/******************************************************************************************************************************************************
-------------------
Level- Medium
-------------------

The task is to find the second smallest number with a given sum of digits as S and the number of digits as D.

---------------------------------------------------------------------------------------
Example 1:

Input:
S = 9 
D = 2
Output:
27
Explanation:
18 is the smallest number possible with sum = 9
and total digits = 2, Whereas the second
smallest is 27.
Example 2:

Input:
S = 16
D = 3
Output:
178
Explanation:
169 is the smallest number possible with sum is
16 and total digits = 3, Whereas the second
smallest is 178.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
        // code here
        
        int[] ans = new int[D];
        
        for(int i = D - 1; i >= 1; i--) {
            int d = Math.min(S - 1, 9);
            ans[i] = d;
            S -= d;
        }
        
        if(S > 9) {
            return "-1";
        }
        
        ans[0] = S;
        
        for(int i = D - 1; i >= 1; i--) {
            
            if(ans[i] != 0 && ans[i - 1] != 9) {
                ans[i] -= 1;
                ans[i-1] += 1;
                
                StringBuilder num = new StringBuilder();
                for(int a : ans) {
                    num.append(a);
                }
                
                return num.toString();
            }
        }
        
        return "-1";
    }
}
