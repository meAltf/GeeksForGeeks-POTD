/******************************************************************************************************************************************************
-----------------------
Level- Medium
------------------------
Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

___________________________________________________________________________________________________

Example 1:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.

Example 2:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 5, 4, 2, 1, 3, 0.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] isVisited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]){
                dfs(i, isVisited, stack, adj);
            }
        }
        int[] ans = new int[V];
        for (int i = 0; i < V; i++) {
            ans[i]= stack.pop();
        }
        return ans;
        
    }
    
    public static void dfs(int start, boolean[] isVisited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        isVisited[start] = true;
        for (int neighbour : adj.get(start)) {
            if (!isVisited[neighbour]) {
                dfs(neighbour, isVisited, stack, adj);
            }
        }
        stack.push(start);
    }
}
