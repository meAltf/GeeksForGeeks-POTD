/******************************************************************************************************************************************************
------------------------
Level- Medium
------------------------
Given an array arr of size n, the task is to find the maximum triplet product in the array.

---------------------------------------------------------------------------------------

Example 1:

Input:
n = 4
arr[] = {1, 2, 3, 5}
Output:
30
Explanation:
5*3*2 gives 30. This is the maximum possible
triplet product in the array.
Example 2:

Input:
n = 7
arr[] = {-3, -5, 1, 0, 8, 3, -2} 
Output:
120
Explanation: 
-3*-5*8 gives 120. This is the maximum possible triplet product in the array.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/



class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        // Complete the function
        Arrays.sort(arr);
        
        long ans = Math.max(arr[n-1]*arr[n-2]*arr[n-3],arr[0]*arr[n-1]*arr[1]);
        
        return ans;
    }
}
