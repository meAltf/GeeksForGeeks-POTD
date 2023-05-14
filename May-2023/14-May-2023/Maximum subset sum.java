/******************************************************************************************************************************************************
---------------------------
Level- MEdium
----------------------------

Given an array A of size N. Find the maximum subset-sum of elements that you can make from the given array such that for every two consecutive elements
in the array, at least one of the elements is present in our subset. 

___________________________________________________________________________________________________

Example 1:

Input: 
N = 4
A[] = {1, -1, 3, 4}
Output: 8
Explanation: 
We can choose 0th,2nd & 3rd index(0 based 
Index),so that it can satisfy the 
condition & can make maximum sum 8. 

Example 2:

Input: 
N = 3
A[] =  {0, 2, 0};
Output: 2
Explanation: 
We can choose 1st index. Here the 
maximum possible sum is 2.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    
    private static long maxSum(int[] arr,int index,long[] dp){
        
        if(index>=arr.length){
            return 0;
        }
        
        if(dp[index]!=-1) return dp[index];
        long notTake=arr[index]+maxSum(arr,index+1,dp);
        long take=0;
        if((index+1)<arr.length){
            take=arr[index+1]+maxSum(arr,index+2,dp);
        }
        return dp[index]=Math.max(notTake,take);
    }
    
    public static long findMaxSubsetSum(int n, int[] arr) {
        //code here
        
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        return maxSum(arr,0,dp);
    }
    
    
}
