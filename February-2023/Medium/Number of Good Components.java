/******************************************************************************************************************************************************

Given an undirected graph with V vertices(numbered from 1 to V) and E edges. Find the number of good components in the graph.
A component of the graph is good if and only if the component is a fully connected component.
Note: A fully connected component is a subgraph of a given graph such that there's an edge between every pair of vertices in a component, 
the given graph can be a disconnected graph. Consider the adjacency list from index 1.

---------------------------------------------------------------------------------------

Example 1:

Input: 

Output: 1
Explanation: We can see that there is only one 
component in the graph and in this component 
there is a edge between any two vertces.
Example 2:

Input:

Output: 2
Explanation: We can see that there are 3 components
in the graph. For 1-2-7 there is no edge between
1 to 7, so it is not a fully connected component.
Rest 2 are individually fully connected component.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

// User function Template for Java
class Solution {
    
    static int vertices;
    static int edges;
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean v[] = new boolean[V + 1];
        int ans = 0;
        for (int i = 1; i <= V; i++) {
            if (!v[i]) {
                vertices = 0;
                edges = 0;
                dfs(adj, i, v);
                edges /= 2;
                if (edges == ((long)vertices * (vertices - 1)) / 2) ans++;
            }
        }
        return ans;
    }
    
    private static void dfs(ArrayList<ArrayList<Integer>> A, int i, boolean v[]) {
        v[i] = true;
        vertices++;
        edges += A.get(i).size();
        for (int child : A.get(i)) {
            if (!v[child]) {
                dfs(A, child, v);
            }
        }
    }
}
