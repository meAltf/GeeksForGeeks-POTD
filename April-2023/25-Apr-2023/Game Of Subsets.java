/******************************************************************************************************************************************************
--------------------
Level- Hard
-------------------
Elena is the topper of the class. Once her teacher asked her a problem. He gave Elena an array of integers of length n. 
He calls a subset of array arr good if its product can be represented as a product of one or more distinct prime numbers. 
He asked her to find the number of different good subsets in arr modulo 109 + 7.

As a good friend of Elena help her to solve the problem.

___________________________________________________________________________________________________

Example 1:

Input:
N: 4
arr: {1,2,3,4}
Output: 6
Explanation: 
The good subsets are:
- [1,2]: product is 2, which is the product of distinct
prime 2.
- [1,2,3]: product is 6, which is the product of 
distinct primes 2 and 3.
- [1,3]: product is 3, which is the product of distinct
prime 3.
- [2]: product is 2, which is the product of distinct
 prime 2.
- [2,3]: product is 6, which is the product of distinct
primes 2 and 3.
- [3]: product is 3, which is the product of distinct
prime 3.
Example 2:

Input:
N : 3
arr : {2, 2, 3}
Output: 5
Explanantion:
The good subsets are : {2}, {2}, {2, 3}, {2, 3}, {3}

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

// User function Template for Java


class Solution {
    static int modulo = (int) 1e9 + 7;
    static int[] maskPrime = new int[31];
    
    public Solution() {
        modulo = (int) 1e9 + 7;
        maskPrime = new int[31];
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int i = 2; i <= 30; ++i) {
            if (i % 4 == 0 || i % 9 == 0 || i == 25) continue;
            int mask = 0;
            for (int j = 0; j < 10; ++j) {
                if (i % primeNumbers[j] == 0) mask |= 1 << j;
            }
            maskPrime[i] = mask;
        }
    }
    
    public static long powerOfTwo(int n) {
        long result = 1, value = 2;
        while (n != 0) {
            if ((n & 1) == 1) result = (result * value) % modulo;
            value = (value * value) % modulo;
            n >>= 1;
        }
        return result;
    }
    
    public static int goodSubsets(int[] arr, int n) {
        
        int[] array = arr;
        int size = n;
        
        int oneCount = 0;
        int[] dp = new int[1024];
        int[] count = new int[31];
        dp[0] = 1;
        for (int element : array) {
            if (element == 1) {
                oneCount++;
            } else if (maskPrime[element] != 0) {
                count[element]++;
            }
        }
        for (int i = 0; i < 31; ++i) {
            if (count[i] == 0) continue;
            for (int j = 0; j < 1024; ++j) {
                if ((j & maskPrime[i]) != 0) continue;
                dp[j | maskPrime[i]] = (int) ((dp[j | maskPrime[i]] + dp[j] * (long) count[i]) % modulo);
            }
        }
        long answer = 0;
        for (int i : dp) {
            answer = (answer + i) % modulo;
        }
        answer--;
        if (oneCount != 0) {
            answer = (answer * powerOfTwo(oneCount)) % modulo;
        }
        return (int) answer;
}
};
