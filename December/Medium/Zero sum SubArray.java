/******************************************************************************************************************************************************

You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0.

---------------------------------------------------------------------------------------

Example 1:

Input:
n = 6
arr[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 subarrays are 
[0], [0], [0], [0], [0,0], and [0,0].

Example 2:

Input:
n = 10
arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
Output: 4
Explanation: The 4 subarrays are [-1 -3 4]
[-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        Map<Long,Long> map=new HashMap<>();
        map.put(0L,1L);
        long sum=0;
        long ans=0;
        for(long i:arr){
            sum+=i;
            if(map.containsKey(sum)){
                ans+=map.get(sum);
            }
            map.put(sum,map.getOrDefault(sum,0L)+1);
        }
        return ans;
    }
}
