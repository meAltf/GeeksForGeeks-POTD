/******************************************************************************************************************************************************
---------------------
Level- Easy
---------------------
Given a binary tree and the task is to find the spiral order traversal of the tree.

Spiral order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and for all the odd levels
we print the node's value from left to right. 

For below tree, function should return 1, 2, 3, 4, 5, 6, 7.
___________________________________________________________________________________________________

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 

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

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean b = true;
        while(q.size()!=0){
            int s = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0;i<s;i++){
                Node temp = q.remove();
                level.add(temp.data);
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            if(b==true)Collections.reverse(level);
            for(int i=0;i<s;i++)ans.add(level.get(i));
            b=!b;
        }
        return ans;
    }
}
