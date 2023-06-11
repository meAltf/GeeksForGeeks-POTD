/******************************************************************************************************************************************************
--------------------------
Level- Easy
-----------------------------
You start with an array A of size N. Initially all elements of the array A are zero. You will be given K positive integers.
Let j be one of these integers, you have to add 1 to all A[i], where i ≥ j. Your task is to print the array A after all these K updates are done.

Note: 1-based indexing is followed for updates.

___________________________________________________________________________________________________

Example 1:

Input:
N = 3, K = 4
1 1 2 3
Output:
2 3 4
Explanation:
Initially the array is {0, 0, 0}. After the
first 1, it becomes {1, 1, 1}. After the
second 1 it becomes {2, 2, 2}. After 2, 
it becomes {2, 3, 3} and 
After 3 it becomes, {2, 3, 4}. 
Example 2:

Input:
N = 2, K = 3
1 1 1
Output:
3 3 
Explanation:
Initially the array is {0, 0}. After the
first 1, it becomes {1, 1}. After the
second 1 it becomes {2, 2}. After the
third 1, it becomes {3, 3}.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java


class Solution {

    public static void update(int a[], int n, int updates[], int k)
    {
        for (int i=0;i<k;i++)
        {
            for (int j=updates[i]-1;j<n;j++)
            {
                a[j]++;
            }
        }
    }
    
}
