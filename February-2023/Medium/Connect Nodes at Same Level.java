/******************************************************************************************************************************************************

Given a binary tree, connect the nodes that are at the same level. The structure of the tree Node contains an addition nextRight pointer for this purpose.

Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.

       10                       10 ------> NULL
      / \                       /      \
     3   5       =>     3 ------> 5 --------> NULL
    / \     \               /  \           \
   4   1   2          4 --> 1 -----> 2 -------> NULL

---------------------------------------------------------------------------------------

Example 1:

Input:
     3
   /  \
  1    2
Output:
3 1 2
1 3 2
Explanation:The connected tree is
       3 ------> NULL
     /   \
    1---> 2 -----> NULL
Example 2:

Input:
      10
    /   \
   20   30
  /  \
 40  60
Output:
10 20 30 40 60
40 20 60 10 30
Explanation:The connected tree is
        10 ---> NULL
       /   \
     20---> 30 ---> NULL
   /   \
 40---> 60 ---> NULL

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        nextRight = null;
    }
} */
class Solution {
    public void connect(Node root) {
        // code here
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
          
            int sz = q.size();
            Node prev = null;
          
            for(int i = 0 ; i < sz ; i++){
              
                Node curr = q.remove();
                if(prev != null) prev.nextRight = curr;
                    
                if(curr.left != null) q.add(curr.left);
                
                if(curr.right != null)q.add(curr.right);
                    
                prev = curr;
            }
        }
    }
}
