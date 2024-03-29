/**************************************************
--------------------------
Level- EAsy
--------------------------

You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use a recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.

_________________________________

Example 1:

Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]

Output: 0 2 4 3 1
Explanation: 
0 is connected to 2, 3, 1.
1 is connected to 0.
2 is connected to 0 and 4.
3 is connected to 0.
4 is connected to 2.
so starting from 0, it will go to 2 then 4,
and then 3 and 1.
Thus dfs will be 0 2 4 3 1.

Example 2:

Input: V = 4, adj = [[1,3], [2,0], [1], [0]]

Output: 0 1 2 3
Explanation:
0 is connected to 1 , 3.
1 is connected to 0, 2. 
2 is connected to 1.
3 is connected to 0. 
so starting from 0, it will go to 1 then 2
then back to 0 then 0 to 3
thus dfs will be 0 1 2 3. 

_________________________________

***************************************************/

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        
        //ArrayList arr to store the visited nodes and return the result
        ArrayList<Integer> arr = new ArrayList<>();
        
        //adding the source node
        arr.add(0);
        
        //calling the recursive function which will successively visit the other nodes in the graph
        recursiveDFS(adj,arr,0);
        
        
        //returning the ArrayList
        return arr;
        
    }
    
    
    //recursive function to find the DFS traversal
    public static void recursiveDFS(ArrayList<ArrayList<Integer>> adj, ArrayList arr, int row){
        //len to store the length of the ArrayList.
        //shows the degree of the node i.e. number of adjacent nodes
        int len = adj.get(row).size();
        
        //traversing each node in the order
        for(int i=0; i<len; i++){
            int num = adj.get(row).get(i);
            
            //if the value is not present in arr, then add it and call DFS function for that node.
            //this will ensure that the function is of type recursive
            if(!arr.contains(num)){
                arr.add(num);
                recursiveDFS(adj,arr,num);
            }
        }
    }
}
