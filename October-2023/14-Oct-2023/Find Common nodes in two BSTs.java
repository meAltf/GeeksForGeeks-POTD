/******************************************************************************************************************************************************
------------------------
Level- Easy
------------------------
Given two Binary Search Trees. Find the nodes that are common in both of them, ie- find the intersection of the two BSTs.

Note: Return the common nodes in sorted order.

___________________________________________________________________________________________________

Example 1:

Input:
BST1:
                  5
               /     \
             1        10
           /   \      /
          0     4    7
                      \
                       9
BST2:
                10 
              /    \
             7     20
           /   \ 
          4     9
Output: 4 7 9 10

Example 2:

Input:
BST1:
     10
    /  \
   2   11
  /  \
 1   3
BST2:
       2
     /  \
    1    3
Output: 1 2 3

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution
{
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        //code here
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        inorder(root1,hm);
        res(root2,hm,list);
        return list;
    }
    static void inorder(Node node,HashMap<Integer,Integer> hm){
        if(node==null) return;
        inorder(node.left,hm);
        hm.put(node.data,1);
        inorder(node.right,hm);
    }
    
    static void res(Node node, HashMap<Integer,Integer> hm, ArrayList<Integer> list){
        if(node==null) return;
        res(node.left,hm,list);
        if(hm.containsKey(node.data)) list.add(node.data);
        res(node.right,hm,list);
    }
}
