/******************************************************************************************************************************************************
----------------------------
Level- Easy
-----------------------------
Given a binary tree, find its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

___________________________________________________________________________________________________

Example 1:

Input:
 root  -->     1
             /   \
            3     2
           /
          4           
Output: 3
Explanation:
Maximum depth is between nodes 1 and 4, which is 3.
Example 2:

Input:
 root -->    10
           /    \
          20    30
           \      \  
           40     60
                  /
                 2 
Output: 4
Explanation:
Maximum depth is between nodes 10 and 2, which is 4

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


//User function Template for Java

/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    
    private static int height(Node root){
        
        int count = 0;
        
        if(root == null) return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
        
        
    }
    
  public static int maxDepth(Node root) {
    // code here
    
    int depthCount = 0;
    
    if(root == null) return 0;
    
    int count1 = height(root.left);
    int count2 = height(root.right);
    
    if(count1 > count2) return 1+ maxDepth(root.left);
    
    else return 1+ maxDepth(root.right);
    
  }
}
     
