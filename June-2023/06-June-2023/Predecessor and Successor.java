/******************************************************************************************************************************************************
-------------------
Level- Medium
--------------------
There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key.
If either predecessor or successor is not found, then set it to NULL.

Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 
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
key = 8
Output: 
6 10
Explanation: 
In the given BST the inorder predecessor of 8 is 6 and inorder successor of 8 is 10.
Example 2:

Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
key = 11
Output: 
10 -1
Explanation: 
In given BST, the inorder predecessor of 11 is 10 whereas it does not have any inorder successor.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/




//Function to check whether a Binary Tree is BST or not.
public static void findPreSuc(Node root, int key)
{ 
    if(root == null){
        return;
    }
    
    if(root.data < key){
        pre = root;
        findPreSuc(root.right, key);
    } else if (root.data > key){
        suc = root;
        findPreSuc(root.left, key);
    } else {
        findPreSuc(root.right, key);
        findPreSuc(root.left, key);
    }
  
}
}
