/******************************************************************************************************************************************************
----------------
Level- Easy
----------------
Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.

___________________________________________________________________________________________________

Example 1:

Input: 

Output: 0
Explanation: According to the given edges, all 
nodes can be reached from nodes from 0, 1 and 2. 
But, since 0 is minimum among 0,1 and 2, so 0 
is the output.
Example 2:

Input: 

Output: -1
Explanation: According to the given edges, 
no vertices are there from where we can 
reach all vertices. So, output is -1.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/




class Solution {
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int motherVertex = -1;

        // Step 1: Perform a DFS traversal from each vertex to find the last visited vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
                motherVertex = i;
            }
        }

        // Step 2: Reset visited array and perform DFS from the last visited vertex
        Arrays.fill(visited, false);
        dfs(adj, motherVertex, visited);

        // Step 3: Check if all vertices are visited from the last visited vertex
        for (boolean val : visited) {
            if (!val) return -1; // Not all vertices can be reached from the mother vertex
        }

        return motherVertex;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }
}
