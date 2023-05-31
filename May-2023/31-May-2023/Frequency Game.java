/******************************************************************************************************************************************************
-------------------------
Level- Easy
-------------------------
Given an array A of size N. The elements of the array consist of positive integers. You have to find the largest element with minimum frequency.

___________________________________________________________________________________________________


Example 1:

Input: 
5
2 2 5 50 1
Output:
50
Explanation :
All elements are having frequency 1 except 2.
50 is the maximum element with minimum frequency.

Example 2:

Input:
4
3 3 5 5
Output:
5
Explanation:
Both 3 and 5 have the same frequency, so 5 should be returned.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

// User function Template for Java

// Helper class to find largest number with minimum frequency
class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
        
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int x=arr[i];
            if(mp.containsKey(x)){
                mp.put(x,mp.get(x)+1);
            }
            else{
                mp.put(x,1);
            }
        }
        
        int max=Integer.MAX_VALUE;
        int ans=0;
        for(Integer e:mp.keySet()){
            if(max>=mp.get(e)){
                if(e>ans){
                    ans=e;
                    max=mp.get(e);
                }
              
            }
        }
        return ans;
    }
}
