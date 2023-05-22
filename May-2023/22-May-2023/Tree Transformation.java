/******************************************************************************************************************************************************
-----------------
Level- MEdium
------------------
You are given a tree containing N nodes in the form of an array P where Pi represents the parent of the i-th node and P0 = -1
as the tree is rooted at node 0. In one move, you can merge any two adjacent nodes. Calculate the minimum number of moves required to turn the 
tree into a star tree.

-> Merging adjacent nodes means deleting the edge between them and considering both the nodes as a single one.
-> A Star tree is a tree with a center node, and all other nodes are connected to the center node only.
___________________________________________________________________________________________________

Example 1:

Input:
N = 5
p[] = {-1, 0, 0, 1, 1}
Output:
1
Explanation: 
Tree looks like:
            
Merge the edge 0 - 2 in one operation

Our Tree will look like:
            
Example 2:

Input: N = 8
p[] = {-1 0 0 0 0 2 2 5}
Output:
2
Explanation:
Tree looks like:

        

Merge node 5 to 2, tree will look like

          

and then 2 to 0, finally the tree will be:

             

thus tree formed will be a star tree.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


class Solution {
    
    public static int solve(int N, int[] p) {
        
        int [] a = new int[N + 1];
        
        for (int i = 1; i < N; i++) {
            a[p[i]]++;
            a[i]++;
        }
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] == 1)
                sum++;
        }
        
        return Math.max(N - sum -1,0);
    }
}
        
