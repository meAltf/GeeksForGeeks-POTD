/******************************************************************************************************************************************************
-------------------------
level- Medium
--------------------------
Given an array Arr of N positive integers and an integer K, find K largest elements from the array.  The output elements should be printed in decreasing order.

___________________________________________________________________________________________________


Example 1:

Input:
N = 5, K = 2
Arr[] = {12, 5, 787, 1, 23}
Output: 787 23
Explanation: 1st largest element in the
array is 787 and second largest is 23.
Example 2:

Input:
N = 7, K = 3
Arr[] = {1, 23, 12, 9, 30, 2, 50}
Output: 50 30 23
Explanation: 3 Largest element in the
array are 50, 30 and 23.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        
        Arrays.sort(arr);
        
        int ans[] = new int[k];
        
        for(int i=0; i<k; i++){
            ans[i] = arr[n-1-i];
        }
        
        return ans;
    }
}
