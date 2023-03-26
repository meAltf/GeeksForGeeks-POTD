/******************************************************************************************************************************************************
---------------------
Level- Easy
---------------------
N frogs are positioned at one end of the pond. All frogs want to reach the other end of the pond as soon as possible. 
The pond has some leaves arranged in a straight line. Each frog has the strength to jump exactly K leaves. For example,
a  frog having strength 2 will visit the leaves 2, 4, 6, ...  etc. while crossing the pond.

Given the strength of each frog and the number of leaves, your task is to find the number of leaves that not be visited by any of the frogs 
when all frogs have reached the other end of the pond. 

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 3
leaves = 4
frogs[] = {3, 2, 4} 
Output: 1
Explanation:
Leaf 1 will not be visited by any frog.
Example 2:

Input: 
N = 3
leaves = 6
frogs[] = {1, 3, 5} 
Output: 0
Explanation: 
First frog will visit all the leaves so no 
leaf is left unvisited.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        
        boolean visited[] = new boolean[leaves+1];
        
        for(int i=0; i< frogs.length; i++){
            
            int j = frogs[i];
            if(j <= leaves && visited[j] == false){
                
                while(j<= leaves){
                    visited[j] = true;
                    j += frogs[i];
                }
            }
        }
        
        int ans = 0;
        for(int i=1; i<= leaves; i++){
            
            if(visited[i] == false) ans++;
        }
        
        return ans;
    }
}
