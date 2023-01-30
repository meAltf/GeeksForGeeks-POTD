/************************************************************************************************************************************************

Given N nodes of a tree and a list of edges. Find the minimum number of nodes to be selected to light up all the edges of the tree.
An edge lights up when at least one node at the end of the edge is selected.


---------------------------------------------------------------------

Example 1:

Input:
N = 6
edges[] = {(1,2), (1,3), (2,4), (3,5), (3,6)}
Output: 2
Explanation: Selecting nodes 2 and 3 lights
up all the edges.

Example 2:

Input:
N = 3
arr[] = {(1,2), (1,3)}
Output: 1
Explanation: Selecting Node 1 
lights up all the edges.

-------------------------------------------------------------------


*************************************************************************************************************************************************/

//User function Template for Java

class Solution{
    public int countVertex(int N, int[][] edges){
        // code here
        
        ArrayList<Integer> adj[]=new ArrayList[N+1];
        for(int i=0;i<=N;i++)
        adj[i]=new ArrayList<>();
        for(int i=0;i<N-1;i++)
        {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        //s2
        int[][]val=new int[N+1][2];
        for(int i=1;i<=N;i++)
            val[i][1]=1;
            
        //s3
        dfs(adj, 1,1, val);
        return Math.min(val[1][0], val[1][1]);
    }
    // we do not process the leaf node
    public void dfs(ArrayList<Integer> adj[] , int src, int par, int val[][])
    {
        for(Integer v: adj[src])
       { if(v!=par)  //do not process the leaf node
        {
         dfs(adj, v, src, val);   
        }
       }
        for(Integer v: adj[src])
        {
            if(v!=par)
            {
                val[src][0]  += val[v][1];  // camera++;
                val[src][1] += Math.min(val[v][1], val[v][0]);
            }
        }
    }
}
