--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------
Level- Easy
-----------------
---------------------------------------------

Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph starting from the 0th vertex, 
from left to right according to the input graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.

--------------------------------------------

Example 1:

Input:

Output: 0 1 2 3 4
Explanation: 
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3. After this 2 to 4, thus bfs will be
0 1 2 3 4.
  
Example 2:

Input:

Output: 0 1 2
Explanation:
0 is connected to 1 , 2.
so starting from 0, it will go to 1 then 2,
thus bfs will be 0 1 2. 

--------------------------------------------------------------------------------------------------------------------------------------------------------------------



class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        
        boolean[] visit = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        visit[0] = true;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            bfs.add(curr);
            
            for(int n: adj.get(curr)){
                if(!visit[n]){
                    q.add(n);
                    visit[n] = true;
                }
            }
        }
        return bfs;
    }
}
