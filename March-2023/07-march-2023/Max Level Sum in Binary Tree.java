/******************************************************************************************************************************************************
------------------
LEVEL- EASY
------------------
Given a Binary Tree having positive and negative nodes. Find the maximum sum of a level in the given Binary Tree.

---------------------------------------------------------------------------------------

Example 1:

Input :               
             4
          /    \
         2     -5
        / \    / \
      -1   3  -2  6

Output: 6

Explanation :
Sum of all nodes of 0'th level is 4
Sum of all nodes of 1'th level is -3
Sum of all nodes of 2'th level is 6
Hence maximum sum is 6

Example 2:

Input :          
            1
          /   \
         2     3
        / \     \
       4   5     8
                / \
               6   7  

Output :  17

Explanation: Maximum sum is at level 2.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

/*Complete the fUnction below
Node is as follows
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/
class Solution {
    public int maxLevelSum(Node root) {
        // add code here
        
        if(root == null) return 0;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int maxSum = Integer.MIN_VALUE;
        
        
        while(!queue.isEmpty()){
            int sum = 0;
            int queueSize = queue.size();
            
            for(int i=0; i<queueSize; i++){
                
                Node front = queue.poll();
                sum += front.data;
            
                if(front.left != null){
                    queue.add(front.left);
                }
                
                if(front.right != null){
                    queue.add(front.right);
                }
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
