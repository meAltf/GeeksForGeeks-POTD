/******************************************************************************************************************************************************

Geek is in a geekland which have a river and some stones in it. Initially geek can step on any stone. Each stone has a number on it representing the value of exact step
geek can move. If the number is +ve then geeks can move right and if the number is -ve then geeks can move left. Bad Stones are defined as the stones in which if geeks
steps, will reach a never ending loop whereas good stones are the stones which are safe from never ending loops. Return the number of good stones in river.

---------------------------------------------------------------------------------------

Example 1:

Input: [2, 3, -1, 2, -2, 4, 1]
Output: 3
Explanation: Index 3, 5 and 6 are safe only. As index 1, 4, 2 forms a cycle and from index 0 you can go to index 2 which is part of cycle.

Example 2:

Input: [1, 0, -3, 0, -5, 0]
Output: 2
Explanation: Index 2 and 4 are safe only. As index 0, 1, 3, 5 form cycle.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


class Solution {
    public static int goodStones(int n, int[] arr) {
        // code here
        
        int vis[]=new int[n];
        for(int i=0; i<n; i++){
            if(vis[i]==0) good(i, arr, vis);
        }
        
        int ans=0;
        for(int i: vis){
            if(i==2) ans++;
        }
        return ans;
    }
    
    private static int good(int i, int arr[], int[] vis){
        
        int n=arr.length;
        if(i<0 || i>=n) return 2; // safe
        if(arr[i]==0) return 1; // self loop
        if(vis[i]!=0) return vis[i]; // already visited, either safe or unsafe
        
        vis[i]=1;
        return vis[i]=good(i+arr[i], arr, vis);
    }
}
  
