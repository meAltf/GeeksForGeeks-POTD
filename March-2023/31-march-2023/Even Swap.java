/******************************************************************************************************************************************************
-----------------
Level- Medium
-------------------
You are given an array a and you need to generate an array b. You are allowed to apply only one type of operation on the array a, any number of times. 
In one operation you can swap ai, ai+1 if ai+ai+1 is even.
Array b should be generated after applying the above operation any number of times on array a and array b should be 
lexicographically the largest among all arrays that can be generated from array a, after applying the above operation any number of times.

---------------------------------------------------------------------------------------

Example 1:

Input:
N=3
a[]={1,3,5}
Output:
5,3,1
Explanation: [1,3,5],[1,5,3],[3,1,5],[3,5,1],
[5,1,3] and [5,3,1] are all possible
values of array b while the last one is 
lexicographically largest.
 

Example 2:

Input:
N=4
a[]={1,3,4,2}
Output:
b[]={3,1,4,2}
Explanation: [1,3,4,2],[1,3,2,4],[3,1,2,4] and 
[3,1,4,2] are all possible values of b among 
which the last one is lexicographically largest one.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution{
    
    private static void reverse(int[] a,int i,int j){
        
        while(i<j){
            
            j--;

            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            
            i++;
        }
    }
    
	int [] lexicographicallyLargest(int [] arr, int n) {
		//Write your code here
		int i=0;

        while(i<n){
            
            int j=i+1;

            while(j<n && arr[j]%2 == arr[j-1]%2){
                j++;
            }
            
            Arrays.sort(arr,i,j);
            
            reverse(arr,i,j);

            i=j;
        }
        return arr;
	}
	
}
