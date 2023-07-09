/******************************************************************************************************************************************************
---------------------------
Level- Medium
---------------------------
You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.

___________________________________________________________________________________________________

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.

Example 2:

Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing 
number is 2.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        boolean flag= false;
        int ans=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<size;i++){
            set.add(arr[i]);
        }
        for(int i=0;i<size;i++){
            if(set.contains(i+1))continue;
            else{
                return i+1;
            }
        }
        return size+1;
    }
}
