/******************************************************************************************************************************************************

Given a Binary Search Tree and a target value. You have to find the node whose data is equal to target and return the sum of all descendant node's data 
which are vertically below the target node. Initially you are at the root node.
Note: If target node is not present in bst then return -1.

---------------------------------------------------------------------------------------

Example 1:

Input:


Target = 35
Output: 32
Explanation: Vertically below 35 is 32.

Example 2:

Input:

Target = 25
Output: 52
Explanation: Vertically below 25 is 22, 30 and their sum is 52.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution
{
    
    Node findTarget(Node root, int target) {
        
        if(root == null) return null;
        
        if(root.data == target) return root;
        if(root.data > target) return findTarget(root.left, target);
        return findTarget(root.right, target);
    }
    
    long traverseVertically(Node root, int position) {
        
        if(root == null) return 0;
        
        long left = traverseVertically(root.left, position+1);
        long right = traverseVertically(root.right, position-1);
        
        return (position == 0 ? root.data : 0) + left + right;
    }
    
    long verticallyDownBST(Node root,int target) {
        
        Node result = findTarget(root, target);
        
        if(result == null) return -1;
        
        return traverseVertically(result, 0) - result.data;
    }
}
