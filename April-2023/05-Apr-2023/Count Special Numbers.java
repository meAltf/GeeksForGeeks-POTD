/******************************************************************************************************************************************************
----------------------
Level- Medium
-----------------------
You are given an array arr[ ] of size N consisting of only positive integers. Your task is to find the count of special numbers in the array.
A number is said to be a special number if it is divisible by at least 1 other element of the array.

---------------------------------------------------------------------------------------
Example 1:

Input:
N = 3
arr[] = {2, 3, 6}
Output:
1
Explanation:
The number 6 is the only special number in the
array as it is divisible by the array elements 2 
and 3. Hence, the answer is 1 in this case.
Example 2:

Input: 
N = 4
arr[] = {5, 5, 5, 5}
Output:
4
Explanation: 
All the array elements are special. Hence, 
the answer is 4 in this case.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/
Approach-1-- Brute-Force
__________________________

// User function Template for Java

class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        // Code here
        
        int count=0;
        for(int i=0; i<arr.length; i++){
            
            //count = 0;
            for(int j=0; j<arr.length; j++){
                if( arr[i] != arr[j] && arr[i] % arr[j] == 0){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

________________________
Approach-2-- Optimize with Space
________________________

// User function Template for Java

class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        
        int max = Arrays.stream(arr).max().getAsInt();
        int[] hash = new int[max+1];
        
        Arrays.fill(hash,0);
        
        for(int i=0;i<N;i++){
            int start = arr[i];
            if(hash[start]<=1){
                for(int j=start;j<=max;j=j+start){
                    hash[j]++;
                }
            }
        }
        
        int count = 0;
        for(int j=0;j<N;j++){
            if(hash[arr[j]]>1){
                count++;
            }
        }
        return count;
    }
}

____________________________
Approach-3-- Optimize without Space -- I think this was not optimise but accepted !!
________________________________

// User function Template for Java

class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        
        // Code here
        int count = 0;
        int ans = 0;
        
        Arrays.sort(arr);
        
        for (int i = 0; i < N; i++) {
            if (i < N - 1 && arr[i]==arr[i+1]) {
                count++;
            } else {
                for (int j = 0; j < i; j++) {
                    if (arr[i] % arr[j] == 0) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
