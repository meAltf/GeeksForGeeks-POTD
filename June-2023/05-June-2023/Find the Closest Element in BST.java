/******************************************************************************************************************************************************
------------------------
Level- Medium
-------------------------
Given a BST and an integer. Find the least absolute difference between any node value of the BST and the given integer.

___________________________________________________________________________________________________

Example 1:

Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
K = 13
Output: 
2
Explanation: K=13. The node that has
value nearest to K is 11. so the answer
is 2
Example 2:

Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
K = 9
Output: 
0
Explanation: K=9. The node that has
value nearest to K is 9. so the answer
is 0.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


//User function Template for Java

/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
*/

class Solution
{
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    static int minDiff;

    static int minDiff(Node  root, int K) 
    { 
        // Initialize the minimum difference to a large value
        minDiff = Integer.MAX_VALUE;
        
        // Start the recursive traversal
        findMinDiff(root, K);
        
        return minDiff;
    }
    
    static void findMinDiff(Node root, int K) {
        if (root == null)
            return;
        
        // Update the minimum difference if the current node is closer to K
        if (Math.abs(root.data - K) < minDiff)
            minDiff = Math.abs(root.data - K);
        
        // Recursively traverse the left and right subtrees
        if (root.data > K)
            findMinDiff(root.left, K);
        else
            findMinDiff(root.right, K);
    }
}
