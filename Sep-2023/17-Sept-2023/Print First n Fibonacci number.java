/******************************************************************************************************************************************************
----------------
Level- Basic
----------------
Given a number N, find the first N Fibonacci numbers. The first two number of the series are 1 and 1.

___________________________________________________________________________________________________

Example 1:

Input:
N = 5
Output: 1 1 2 3 5

Example 2:

Input:
N = 7
Output: 1 1 2 3 5 8 13

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


//User function Template for Java


class Solution
{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //Your code here
        long []arr = new long[n];
        
        if(n==1){
            arr[0] = 1;
            return arr;
        }
        
        arr[0] = 1;
        arr[1] = 1;
        
        for(int i=2; i<n; i++){
            
            arr[i] = arr[i-1]+arr[i-2];
        }
        
        return arr;
    }
}
