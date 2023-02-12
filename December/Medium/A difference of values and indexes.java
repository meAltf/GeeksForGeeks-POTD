/******************************************************************************************************************************************************

Given an unsorted array arr[ ] of size n, you need to find the maximum difference of absolute values of elements and indexes, 
i.e., for i <= j, calculate maximum of | arr[ i ] - arr[ j ] | + | i - j |. 

---------------------------------------------------------------------------------------

Example 1:

Input : 
n = 3
arr[ ] = {1, 3, -1}
Output: 5
Explanation:
Maximum difference comes from indexes 
1, 2 i.e | 3 - (-1) | + | 1 - 2 | = 5

Example 2:

Input : 
n = 4
arr[ ] = {5, 9, 2, 6} 
Output:  8
Explanation: 
Maximum difference comes from indexes 
1, 2 i.e | 9 - 2 | + | 1 - 2 | = 8

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for java

class Solution{
    public static int maxDistance (int arr[], int n) {
        //Complete the function
        int a1 = Integer.MAX_VALUE;
        int a2 = Integer.MIN_VALUE;
        int a3 = Integer.MIN_VALUE;
        int a4 = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            
            a1 = Math.min(a1,(arr[i]+i));
            a2 = Math.max(a2,(arr[i]+i));
            a3 = Math.max(a3,(arr[i]-i));
            a4 = Math.min(a4,(arr[i]-i));
        }
        return Math.max(a3-a4, a2-a1);
    }
    
    
}
