/*****************************************************************************************************************************************

Given an array Arr of size N containing positive integers. Find the maximum sum of a subsequence such that no two numbers in the sequence should be adjacent in the array.

----------------------------------------------------------------------------------------------------------

Example 1:

Input:
N = 6
Arr[] = {5, 5, 10, 100, 10, 5}
Output: 110
Explanation: If you take indices 0, 3
and 5, then Arr[0]+Arr[3]+Arr[5] =
5+100+5 = 110.
 

Example 2:

Input:
N = 4
Arr[] = {3, 2, 7, 10}
Output: 13
Explanation: 3 and 10 forms a non
continuous  subsequence with maximum
sum.

----------------------------------------------------------------------------------------------------------


*****************************************************************************************************************************************/


//User function Template for Java

class Solution {

    int findMaxSum(int arr[], int n) {

        // code here

        if(n==1)

            return arr[0];         // if n==1 then there is nothing to compare

        if(n>2)                    // the last third element can be added to last element only 

            arr[n-3]+=arr[n-1];   // jumping three index from this point will cost it ArrayIndexOutOfBound

        

        for(int i=n-4;i>=0;i--)

        {

            arr[i]+=Math.max(arr[i+2],arr[i+3]); //Checking at each step for the more optimized jump

        }                                        //and storing it on the current array

        

        return Math.max(arr[0],arr[1]);    //The answer can be available on any of the index 0th or 1st so return the maximum one.

    }

}
