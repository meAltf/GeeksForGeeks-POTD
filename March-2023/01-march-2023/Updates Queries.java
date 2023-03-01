/******************************************************************************************************************************************************

You are given an array of n elements, initially all a[i] = 0. Q queries need to be performed. Each query contains three integers l, r, and x  and
you need to change all a[i] to (a[i] | x) for all l ≤ i ≤ r.

Return the array after executing Q queries.

---------------------------------------------------------------------------------------

Example 1:

Input:
N=3, Q=2
U=[[1, 3, 1],
   [1, 3, 2]]

Output:
a[]={3,3,3}

Explanation: 
Initially, all elements of the array are 0. After execution of the
first query, all elements become 1 and after execution of the 
second query all elements become 3.
Example 2:

Input:
N=3, Q=2
U=[[1, 2, 1],
   [3, 3, 2]]

Output:
a[]={1,1,2}

Explanantion:
[0,0,0] => [1,1,0] => [1,1,2]

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution{
	int [] updateQuery(int N, int q, int [][]u){
        //Write your code here
          int[] res = new int[N];

        for(int j=0; j<q; j++){

            int l = u[j][0];

            int r = u[j][1];

            int x = u[j][2];

            for(int i=l-1; i<r; i++) 
                res[i]|=x;

        }
        return res;
    }
}
