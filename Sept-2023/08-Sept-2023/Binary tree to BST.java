/******************************************************************************************************************************************************
-----------------
Level- Easy
---------------------

Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.
___________________________________________________________________________________________________


 Example 1:

Input:
      1
    /   \
   2     3
Output: 
1 2 3
Explanation:
The converted BST will be 
      2
    /   \
   1     3

Example 2:

Input:
          1
       /    \
     2       3
   /        
 4       
Output: 
1 2 3 4
Explanation:
The converted BST will be

        3
      /   \
    2     4
  /
 1

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */


class Solution
{
    int i =0;
    Node binaryTreeToBST(Node root)
    {
       ArrayList<Integer> list = new ArrayList<>();
       getNodes(root,list);
       Collections.sort(list);
       inorder(root,list);
       return root;
       
    }
    
    void getNodes(Node root, ArrayList<Integer> list){
        if(root==null) return;
        list.add(root.data);
        getNodes(root.left,list);
        getNodes(root.right,list);
    }
    
    void inorder(Node root, ArrayList<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        root.data = list.get(i++);
        inorder(root.right,list);
    }
}
 
