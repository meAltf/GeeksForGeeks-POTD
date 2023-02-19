/******************************************************************************************************************************************************

Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed than the given input will form BST, except for 2 nodes that will be wrong.

---------------------------------------------------------------------------------------

Example 1:
Input:
       10
     /    \
    5      8
   / \
  2   20
Output: 1
Explanation:
 
Example 2:

Input:
         11
       /    \
      3      17
       \    /
        4  10
Output: 1 
Explanation: 
By swapping nodes 11 and 10, the BST 
can be fixed.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

// User function Template for Java


/*
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
*/

class Solution {

    Node misPlacedNode1=null,misPlacedNode2=null,prevNode=null;

    public Node correctBST(Node root) {

        // code here.

        inorder(root);

        int temp=misPlacedNode1.data;

        misPlacedNode1.data=misPlacedNode2.data;

        misPlacedNode2.data=temp;

        return root;
    }

    private void inorder(Node root){

        if(root==null) return;

        inorder(root.left);

        if(prevNode!=null){

            if(prevNode.data>root.data){

                if(misPlacedNode1==null) misPlacedNode1=prevNode;

                misPlacedNode2=root;
            }
        }
        prevNode=root;
        inorder(root.right);
    }
}
