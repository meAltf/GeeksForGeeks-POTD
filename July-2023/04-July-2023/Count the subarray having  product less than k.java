/******************************************************************************************************************************************************
-----------------------------
Level- Medium
------------------------------
Given an array of positive numbers, the task is to find the number of possible contiguous subarrays having product less than a given number k.

___________________________________________________________________________________________________

Example 1:

Input : 
n = 4, k = 10
a[] = {1, 2, 3, 4}
Output : 
7
Explanation:
The contiguous subarrays are {1}, {2}, {3}, {4} 
{1, 2}, {1, 2, 3} and {2, 3} whose count is 7.
Example 2:

Input:
n = 7 , k = 100
a[] = {1, 9, 2, 8, 6, 4, 3}
Output:
16
Your Task:  


___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java


class Solution {
    
    public int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        int i=0, j=0, ans= 0;
        
        long prod = 1;
        
        while(i < n && j< n){
            
            prod = prod * a[j];
            
            while(prod >= k && i<= j){
                
                prod = prod/a[i++];
            }
            
            ans += (j-i+1);
            j++;
        }
        
        return ans;
    }
}
