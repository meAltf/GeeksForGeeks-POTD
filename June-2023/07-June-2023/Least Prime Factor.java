/******************************************************************************************************************************************************
---------------------
Level- Easy
======================
Given a number N, find the least prime factors for all numbers from 1 to N.  The least prime factor of an integer X is the smallest prime number that divides it.
Note :

1 needs to be printed for 1.
You need to return an array/vector/list of size N+1 and need to use 1-based indexing to store the answer for each number.

___________________________________________________________________________________________________

Example 1:

Input: N = 6
Output: [0, 1, 2, 3, 2, 5, 2] 
Explanation: least prime factor of 1 = 1,
least prime factor of 2 = 2,
least prime factor of 3 = 3,
least prime factor of 4 = 2,
least prime factor of 5 = 5,
least prime factor of 6 = 2.
So answer is[1, 2, 3, 2, 5, 2]. 
Example 2:

Input: N = 4
Output: [0, 1, 2, 3, 2]
Explanation: least prime factor of 1 = 1,
least prime factor of 2 = 2,
least prime factor of 3 = 3,
least prime factor of 4 = 2.
So answer is[1, 2, 3, 2]. 
___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int []arr = new int [n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        if(n==1 || n==2 ||n==3)
        return arr;
        for(int i=4;i<n+1;i++)
        {
            arr[i] = findLPF(i);
        }
        return arr;
    }
    
    public int findLPF(int x)
    {
        if(x%2==0)
        return 2;
        for(int i=3;i<=Math.sqrt(x);i++)
        {
            if(x%i==0)
              return i;
        }
        return x;
    }
}
