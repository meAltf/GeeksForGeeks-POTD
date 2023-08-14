/******************************************************************************************************************************************************
----------------------
Level- MEdium
-----------------------
Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. 
Find the other two numbers. Return in increasing order.

___________________________________________________________________________________________________

Example 1:

Input: 
N = 2
arr[] = {1, 2, 3, 2, 1, 4}
Output:
3 4 
Explanation:
3 and 4 occur exactly once.
Example 2:

Input:
N = 1
arr[] = {2, 1, 3, 2}
Output:
1 3
Explanation:
1 3 occur exactly once.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int j=0;
        int []arr = new int[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i + 1 < nums.length && nums[i]==nums[i+1]){
                i++;
            }
            else{
                arr[j]=nums[i];
                j++;
            }
        }
        return arr;
    }
}
