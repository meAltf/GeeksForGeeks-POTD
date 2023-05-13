/******************************************************************************************************************************************************
----------------------
Level- Easy
----------------------
Given an integer array arr[] of size n which contains only 1 and 0. Your task is to make the array perfect. 
An array is said to be perfect if for each i from 0 to n-1 arr[i]==arr[n-1-i] is satisfied. 

To Make the array perfect you are allowed to do the following operation  :

In one operation you can choose two different indexes i and j and set value of both arr[i] and arr[j] to arr[i]^arr[j].

Your task is to make the array perfect in minimum possible number of operations and return the number of operations.

Note: 0-based indexing is used.

___________________________________________________________________________________________________

Example 1:

Input:
n = 4
arr = {1,0,0,0}
Output:
1
Explanation:
We can take index 0 and 3 and apply the operation.
Array becomes {1,0,0,1}.Now the condition is satisfied 
Example 2:

Input:
n = 3
arr = {1,0,1}
Output:
0
Explanation:
condition is satisfied intially. So no operation is required
in this case.
___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



class Solution {
    public static int bitMagic(int n, int[] arr) {
        int ans = 0;
        
        for(int i = 0;i<n/2;i++){
            if(arr[i]!=arr[n-1-i])
                ans++;
        }
        
        return (ans+1)/2;
    }
}
        
