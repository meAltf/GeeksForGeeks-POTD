/******************************************************************************************************************************************************

Alex is very fond of traveling. There are n cities, labeled from 1 to n.  You are also given flights, a list of travel flights as directed weighted edges
flights[i] = (ui,vi,wi) where ui is the source node, vi is the target node, and wi is the price it takes for a person to travel from source to target.
Currently, Alex is in k'th city and wants to visit one city of his choice. Return the minimum money Alex should have so that he can visit any city of his choice 
from k'th city. If there is a city that has no path from k'th city, which means Alex can't visit that city, return -1. 
Alex always takes the optimal path. He can any city via another city by taking multiple flights.

---------------------------------------------------------------------------------------

Example 1:

Input:
n: 4
k: 2
flights size: 3
flights: [[2,1,1],[2,3,1],[3,4,1]]
Output:
2
Explanation:
to visit 1 from 2 takes cost 1
to visit 2 from 2 takes cost 0
to visit 3 from 2 takes cost 1
to visit 4 from 2 takes cost 2,
2->3->4
So if Alex wants to visit city 4
from 2, he needs 2 units of money


Example 2:

Input:
n: 4 
k: 3 
flights size: 3 
flights: [[2,1,1],[2,3,1],[3,4,1]] 
Output: -1
Explanation:
There is no direct or indirect path 
to visit city 2 and 1 from city 3


----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        
        int[] BellMan = new int[n+1];
        
        
        Arrays.fill(BellMan,Integer.MAX_VALUE);
        BellMan[k] = 0;
        
        for(int idx=1; idx<n; idx++){
            
            for(int i = 0; i < flights.length; i++){
                
                if(BellMan[flights[i][0]] != Integer.MAX_VALUE)
                if(BellMan[flights[i][0]] + flights[i][2] < BellMan[flights[i][1]]){
                
                BellMan[flights[i][1]] = BellMan[flights[i][0]] + flights[i][2];
                
                    
                }
            }
            
        }
        int ans = -1;
        boolean flag = false;
        
        for(int i=1; i<n+1; i++){
            if(i == k)
            continue;
            
            //System.out.print(BellMan[i]+" ");
            if(BellMan[i] == Integer.MAX_VALUE)
            flag = true;
            
            ans = Math.max(BellMan[i],ans);
        }
        
        if(flag)
        return -1;
        return ans;
        
    }
}
