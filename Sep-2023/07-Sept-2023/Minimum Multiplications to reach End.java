/******************************************************************************************************************************************************
------------------
Level- Medium
-----------------'

Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.

Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

___________________________________________________________________________________________________

Example 1:

Input:
arr[] = {2, 5, 7}
start = 3, end = 30
Output:
2
Explanation:
Step 1: 3*2 = 6 % 100000 = 6 
Step 2: 6*5 = 30 % 100000 = 30
Example 2:

Input:
arr[] = {3, 4, 65}
start = 7, end = 66175
Output:
4
Explanation:
Step 1: 7*3 = 21 % 100000 = 21 
Step 2: 21*3 = 63 % 100000 = 63 
Step 3: 63*65 = 4095 % 100000 = 4095 
Step 4: 4095*65 = 266175 % 100000 = 66175

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        
        int n=arr.length;
        int m=100000;
        int dp[]=new int[100001];
        Arrays.fill(dp,-1);
        dp[start]=0;
        
        Queue<Integer> q=new LinkedList<>();
        q.add(start%m);
        
        while(!q.isEmpty())
        {
            int t=q.poll();
            if(t==end) return dp[end];
            
            for(int i=0;i<n;i++)
            {
                int p=((t%m)*(arr[i]%m))%m;
                if(dp[p]==-1)
                {
                    dp[p]=dp[t]+1;
                    q.add(p);
                }
            }
        }
        
        return -1;
    }
}
