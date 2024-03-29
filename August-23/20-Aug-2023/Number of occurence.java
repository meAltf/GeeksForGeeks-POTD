/******************************************************************************************************************************************************
------------------------
Level- Medium
-----------------------
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

___________________________________________________________________________________________________

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
Example 2:

Input:
N = 7, X = 4
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 0
Explanation: 4 is not present in the
given array.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int count = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == x) count++;
        }
        return count;
    }
}
