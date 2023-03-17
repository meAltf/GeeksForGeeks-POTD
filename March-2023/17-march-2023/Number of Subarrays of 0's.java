/******************************************************************************************************************************************************
--------------------------
Level-EAsy
----------------------
You are given an array arr  of length N of 0's and 1's. Find the total number of subarrays of 0's

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 4
arr[] = {0, 0, 1, 0}
Output:
4
Explanation:
Following are the subarrays of
length 1: {0}, {0}, {0} - 3
length 2: {0, 0} - 1
Total Subarrays: 3 + 1 = 4
Example 2:

Input:
N = 4
arr[] = {0, 0, 0, 0}
Output:
10
Explanation:
Following are the subarrays of
length 1: {0}, {0}, {0}, {0} - 4
length 2: {0, 0}, {0, 0}, {0, 0} - 3
length 3: {0, 0, 0}, {0, 0, 0} - 2
length 4: {0, 0, 0, 0} - 1
Total Subarrays: 4 + 3 + 2 + 1 = 10

----------------------------------------------------------------------------------------
*******************************************************************************************************************************************************/


//User function Template for Java


class Solution{
	long no_of_subarrays(int N, int [] arr) {
	    long cnt=0, ans=0;
	    for(int num: arr){
	        if(num==0) {
	            cnt++;
	            ans+=cnt;
	        } else {
	            cnt=0;
	        }
	    }
	    return ans;
	}
}
