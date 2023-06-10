/******************************************************************************************************************************************************
----------------------
Level- Medium
---------------------
You are given an array of size N. Rearrange the given array in-place such that all the negative numbers occur before all non-negative numbers.
(Maintain the order of all -ve and non-negative numbers as given in the original array).
___________________________________________________________________________________________________

Example 1:

Input:
N = 4
Arr[] = {-3, 3, -2, 2}
Output:
-3 -2 3 2
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 3, 2. 
Example 2:

Input:
N = 4
Arr[] = {-3, 1, 0, -2}
Output:
-3 -2 1 0
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 1, 0.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution {
    
    public void Rearrange(int arr[], int n)
    {
        // Your code goes here
        int temp[] = new int[n];
        // store -ves
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] < 0) {
                temp[k++] = arr[i];
            }
        }
        // store +ves
        for(int i = 0; i < n; i++) {
            if(arr[i] >= 0) {
                temp[k++] = arr[i];
            }
        }
        // store elements back in original array
        for(int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
