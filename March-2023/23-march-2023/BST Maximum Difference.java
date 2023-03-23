/******************************************************************************************************************************************************
-------------------------
Question level- Medium
------------------------
You are given a Binary Search Tree and a target value. You must find the maximum difference between the sum of node data from root to target and
from target to a child leaf node (target exclusive). Initially, you are at the root node.
Note: If the target node is not present in the tree then return -1.

---------------------------------------------------------------------------------------
Example 1:

Input:


Target = 20
Output: 10
Explanation: From root to target the sum of node data is 25 and from target to the children leaf nodes the sums of the node data are 15 and 25. So, the maximum difference will be (25-15) = 10.
Example 2:

Input:

Target = 50
Output: -1
Explanation: The target node is not present in the tree.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution
{
    private static void helper(Node root, int target, int rootToTarget, int targetToLeaf, int ans[], boolean found){
        if(root == null) return;
        
        if(root.data == target) found = true;
        
        if(found == true){
            
            targetToLeaf += root.data;
            helper(root.left, target, rootToTarget, targetToLeaf, ans, found);
            helper(root.right, target, rootToTarget, targetToLeaf, ans, found);
            
            if(root.left == null && root.right == null){
                targetToLeaf -= target;
                ans[0] = Math.max(ans[0], rootToTarget-targetToLeaf);
            }
            
        }else{
           rootToTarget += root.data;
           if(target < root.data) helper(root.left, target, rootToTarget, targetToLeaf, ans, found);
           else helper(root.right, target, rootToTarget, targetToLeaf, ans, found);
        }
    }
    
    
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        int rootToTarget =0, targetToLeaf=0;
        
        int ans[] = new int[1];
        ans[0] = Integer.MIN_VALUE;
        
        boolean found = false;
        
        helper(root, target, rootToTarget,targetToLeaf,ans,found);
        
        if(ans[0] == Integer.MIN_VALUE) return -1;
        return ans[0];
        
    }
}
