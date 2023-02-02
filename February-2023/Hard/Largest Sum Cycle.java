/*****************************************************************************************************************************************

Given a maze with N cells. Each cell may have multiple entry points but not more than one exit(i.e entry/exit points are unidirectional doors like valves).
You are given an array Edge[] of N integers, where Edge[i] contains the cell number that can be reached from of cell i in one step. 
Edge[i] is -1 if the ith cell doesn't have an exit. 
The task is to find the largest sum of a cycle in the maze(Sum of a cycle is the sum of the cell indexes of all cells present in that cycle).

Note:The cells are named with an integer value from 0 to N-1. If there is no cycle in the graph then return -1.


----------------------------------------------------------------------------------------------------------

Example 1:

Input:
N = 4
Edge[] = {1, 2, 0, -1}
Output: 3

Explanation: 
There is only one cycle in the graph.
(i.e 0->1->2->0)
Sum of the cell index in that cycle 
= 0 + 1 + 2 = 3.

Example 2:

Input:
N = 4 
Edge[] = {2, 0, -1, 2}
Output: -1

Explanation:
1 -> 0 -> 2 <- 3
There is no cycle in the graph.

----------------------------------------------------------------------------------------------------------


*****************************************************************************************************************************************/


//User function Template for Java

class Solution{
    long ans = -1;
    public long largesSumCycle(int N, int Edge[]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i < N;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i < N;i++){
            if(Edge[i] != -1){
                adj.get(i).add(Edge[i]);
            }
        }
        
        long sum[] = new long[N+1];
        long vis[] = new long[N];
        long pathvis[] = new long[N];
        
        for(int i = 0;i < N;i++){
            if(vis[i] == 0){
                dfs(i , N , adj , sum , vis , pathvis);
            }
        }
        
        return ans;
    }
    private void dfs(int node , int prevNode , ArrayList<ArrayList<Integer>> adj , long sum[] , long vis[] , long pathvis[]){
        sum[node] = sum[prevNode] + node;
        vis[node] = 1;
        pathvis[node] = 1;
        
        for(Integer nbr : adj.get(node)){
            if(pathvis[nbr] == 1){
                ans = Math.max(ans , sum[node] - sum[nbr] + nbr);
            }
            else if(vis[nbr] == 0){
                dfs(nbr , node , adj ,sum , vis , pathvis);
            }
        }
        pathvis[node] = 0;
    }
}
