/******************************************************************************************************************************************************
-------------------------
Level- Hard
---------------------------
Geek is organizing a birthday party, so his friends brought a cake for him. The cake consists of N chunks, 
whose individual sweetness is represented by the sweetness array. Now at the time of distribution,
Geek cuts the cake into K + 1 pieces to distribute among his K friends. One piece he took for himself. 
Each piece consists of some consecutive chunks. He is very kind, so he left the piece with minimum sweetness for him.

You need to find the maximum sweetness that the Geek can get if he distributes the cake optimally.
___________________________________________________________________________________________________

Example 1:

Input:
N  = 6, K = 2
sweetness[] = {6, 3, 2, 8, 7, 5}
Output:
9
Explanation:
Geek can divide the cake to [6, 3], [2, 8], [7, 5] 
with sweetness level 9, 10 and 12 respectively.
Example 2:

Input:
N  = 7, K = 3
sweetness[] = {1, 2, 4, 7, 3, 6, 9}
Output:
7
Explanation:
Geek can divide the cake to [1, 2, 4], [7], [3, 6], [9] 
with sweetness level 7, 7, 9 and 9 respectively.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution{
	//int maxSweetness(int [] sweetness, int N, int K) {
	    // Write your code here.
static boolean ispossible(int mid,int arr[],int K){
        int person=0,sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>=mid){
                person++;
                sum=0;
            }
        }
        return person>=K+1;
    }
	int maxSweetness(int [] sweetness, int N, int K) {
	    // Write your code here.
        int low=Integer.MAX_VALUE,high=0,mid=0;
	    for(int i=0;i<N;i++){
	        high+=sweetness[i];
	        low=Math.min(low,sweetness[i]);
	    }
	    int ans = 0;
        while(low<=high){
            mid=(low+high)/2;
            if(ispossible(mid,sweetness,K)==true){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
	}
	
}
