/******************************************************************************************************************************************************
-----------------------------
Level- Medium
---------------------------

Given a matrix with n rows and m columns. Your task is to find the kth element which is obtained while traversing the matrix spirally. 
You need to complete the method findK which takes four arguments the first argument is the matrix A and the next two arguments will be n and m 
denoting the size of the matrix A and then the forth argument is an integer k. The function will return the kth element obtained while traversing the matrix spirally.

___________________________________________________________________________________________________

Example 1:

Input:
n = 4, m = 4, k = 10
A[][] = {{1  2  3  4},
         {5  6  7  8},
         {9  10 11 12},
         {13 14 15 16}}
Output:
13
Explanation:

The spiral order of matrix will look like 1->2->3->4->8->12->16->15->14->13->9->5->6->7->11->10. So the 10th element in this order is 13. 

Example 2:

Input:
n = 3, m = 3, k = 4
A[][] = {{1 2 3},
         {4 5 6},
         {7 8 9}}
Output:
6
Explanation:
The spiral order of matrix will look like 1->2->3->6->9->8->7->4->5. So the 4th element in this order is 6.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	       	int left = 0, right = m-1;
	    int top = 0, bottom = n-1;
	    
	    int d = 0; //direction
	    
	    while(left<=right && top<=bottom) {
	        if(d == 0) {
	            for(int i=left; i<=right; i++) {
	                if(--k == 0) {
	                    return A[top][i];
	                }
	            }
	            top++;
	            d = 1;
	        }
	        
	        else if(d == 1) {
	            for(int i=top; i<=bottom; i++) {
	                if(--k == 0) {
	                    return A[i][right];
	                }
	            }
	            right--;
	            d = 2; 
	        }
	        
	        else if(d == 2) {
	            for(int i=right; i>= left; i--) {
	                if(--k == 0) {
	                    return A[bottom][i];
	                }
	            }
	            bottom--;
	            d = 3;
	        }
	        
	        else if(d == 3) {
	            for(int i=bottom; i>=top; i--) {
	                if(--k == 0) {
	                    return A[i][left];
	                }
	            }
	            left++;
	            d = 0; 
	        }
	    }
	    return -1;
    }
}
