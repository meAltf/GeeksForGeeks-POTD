/******************************************************************************************************************************************************
-------------------------
level- Easy
-------------------------
Given an array A of n positive numbers. The task is to find the first index in the array such that the sum of elements before it is equal to the
sum of elements after it.
Note:  Array is 1-based indexed.

---------------------------------------------------------------------------------------

Example 1:

Input: 
n = 5 
A[] = {1,3,5,2,2} 
Output: 3 
Explanation: For second test case 
at position 3 elements before it 
(1+3) = elements after it (2+2). 
 

Example 2:

Input:
n = 1
A[] = {1}
Output: 1
Explanation:
Since its the only element hence
it is the only point.


----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution{
	int equalSum(int [] A, int N) {
		//Write your code here
		int totalSum = 0;
		int leftSum = 0;
		
		for(int num : A) totalSum += num;
		
		for(int i=0;i<N;i++){
		    
		    totalSum -= A[i];
		    
		    if(totalSum == leftSum) return i+1;
		    leftSum += A[i];
		}
		return -1;
	}
}
