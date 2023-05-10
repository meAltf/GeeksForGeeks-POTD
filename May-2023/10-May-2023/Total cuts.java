/******************************************************************************************************************************************************
----------------------
Level- Easy
----------------------
You are given an array A of N integers and an integer K, and your task is to find the total number of cuts that you can make
such that for each cut these two conditions are satisfied
1. A cut divides an array into two parts equal or unequal length (non-zero).
2. Sum of the largest element in the left part and the smallest element in the right part is greater than or equal to K.
___________________________________________________________________________________________________

Example 1:

Input:
N=3
K=3
A[]={1,2,3}
Output:
2
Explanation:
Two ways in which array is divided to satisfy above conditions are:
{1} and {2,3} -> 1+2>=3(satisfies the condition)
{1,2} and {3} -> 2+3>=3(satisfies the condition)
Example 2:

Input:
N=5
K=5
A[]={1,2,3,4,5}
Output:
3
Explanation:
{1,2} and {3,4,5} -> 2+3>=5
{1,2,3} and {4,5} -> 3+4>=5
{1,2,3,4} and {5} -> 4+5>=5

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public static int totalCuts(int N, int K, int[] A) {
        int[] maxL = new int[N];
        int[] minR = new int[N];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, A[i]);
            maxL[i] = max;
        }

        for (int i = N - 1; i >= 0; i--) {
            min = Math.min(min, A[i]);
            minR[i] = min;
        }

        for (int i = 0; i < N - 1; i++) {
            if ((maxL[i] + minR[i + 1]) >= K) {
                count++;
            }
        }

        return count;
    }
}
   
