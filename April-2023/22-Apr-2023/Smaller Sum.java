/******************************************************************************************************************************************************
--------------------------
Level- Medium
--------------------------
You are given an array arr of n integers. For each index i, you have to find the sum of all integers present in the array with a value less than arr[i].

___________________________________________________________________________________________________

Example 1:

Input:
n = 3
arr = {1, 2, 3}
Output:
0 1 3
Explanation:
For 1, there are no elements lesser than itself.
For 2, only 1 is lesser than 2.
And for 3, 1 and 2 are lesser than 3, so the sum is 3.
Example 2:

Input:
n = 2
arr = {4, 4}
Output:
0 0
Explanation:
For 4, there are no elements lesser than itself. 
For 4, there are no elements lesser than itself.
There are no smaller elements than 4.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java
class Solution
{
    public long[] smallerSum(int n, int a[]) {
        long prefixSum = 0;
		int[] b = Arrays.copyOf(a, n);
		Arrays.sort(b);
		Map<Integer, Long> sumArray = new HashMap<>();
		for (int i = 0; i < n; i++) {
		    if(!sumArray.containsKey(b[i])) {
    		    sumArray.put(b[i], prefixSum);
		    }
		    prefixSum += b[i];
		}
// 		sumArray.put(b[n-1], prefixSum);
		long[] sum = new long[n];
		for (int i = 0; i < n; i++) {
			sum[i] = sumArray.get(a[i]);
		}
		return sum;
    }
}
