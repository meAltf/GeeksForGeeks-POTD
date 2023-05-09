/******************************************************************************************************************************************************
-------------------
Level- Hard
--------------------
Finding a high paying job is easier than today's problem! Attend Job Fair 2023
 

Given an integer N. Your task is to find the number of binary strings of length N having no consecutive 1s.
As the number can be large, return the answer modulo 10^9+7.

___________________________________________________________________________________________________

Example 1:

Input:
N = 3
Output:
5
Explanation:
All the binary strings of length 3 having
no consecutive 1s are "000", "001", "101",
"100" and "010".
Example 2:

Input: 
N = 2
Output:
3
Explanation: 
All the binary strings of length 2 having no 
consecutive 1s are "10", "00" and "01".

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



// User function Template for Java

class Solution {
    public int countStrings(long N) {
        // Code here
              int Mod = 1000000007;
        return power(new int[][]{{1, 1}, {1, 0}}, N+1, Mod)[0][0];
    }
    public int[][] multiply(int[][] A, int[][] B, int Mod) {
        int[][] arr = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    arr[i][j] = (arr[i][j] + (int)((long)A[i][k] * B[k][j] % Mod)) % Mod;
                }
            }
        }
        return arr;
    }
    public int[][] power(int[][] A, long n, int Mod) {
        if (n == 1)  return A;
        int[][] ans = power(A, n/2, Mod);
        int[][] res = multiply(ans, ans, Mod);
        if (n%2 == 1) {
            res = multiply(res, A, Mod);
        }
        return res;
    }
}
