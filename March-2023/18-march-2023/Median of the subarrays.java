/******************************************************************************************************************************************************
--------------------------
Level-Hard
--------------------------
Given an array A[] of N integers and an integer M. The task is to count the number of subarrays which have median M.
Median of an array is defined as below:

1. If N is odd, the median value is the number that is in the middle after sorting the array.
2. if N is even, the median value is the left of the two middle numbers after sorting the array. 

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 5, M = 2
A[] = {2, 1, 3, 5, 4}
Output: 
3
Explanation: 
The subarrays which has median equal to M
are [2], [2,1,3] and [2,1,3,5]

Example 2:

Input:
N = 1, M = 1
A[] = {1}
Output: 
1
Explanation: 
The subarrays which has median equal to M
is [1].


----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************

//User function Template for Java
class Solution 
{ 
    
    private long helpFunction(int n,int arr[],int m){
        int mm[] = new int[2*n+1];
        Arrays.fill(mm,0);
        long ans=0,currElement=0;
        int sum=n;
        mm[n]++;
        for(int i=0;i<n;i++){
            if(arr[i]<m){
                sum--;
                currElement-=mm[sum];
            }
            else{
                currElement+=mm[sum];
                sum++;
            }
            ans+=currElement;
            mm[sum]++;
        }
        return ans;
    }
    
    long countSubarray(int N, int A[], int M) 
    { 
       long a = helpFunction(N,A,M);
        long b = helpFunction(N,A,M+1);
        return a-b;
    }
} 
