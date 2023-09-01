/******************************************************************************************************************************************************
------------------------------
Level- MEdium
--------------------------------
Given a Binary Tree of size N, Print the corner nodes ie- the node at the leftmost and rightmost of each level.
___________________________________________________________________________________________________

Example 1:

Input :
         1
       /  \
     2      3
    / \    / \
   4   5  6   7    
Output: 1 2 3 4 7
Explanation:
Corners at level 0: 1
Corners at level 1: 2 3
Corners at level 2: 4 7
Example 2:

Input:

        10
      /    \
     20     30
    / \  
   40  60
Output: 10 20 30 40 60

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

/* Node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Tree
{
    public static void printCorner(Node node)
    {
        
        // add your code here
        
        
        if (node == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            int n = queue.size();


            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
                if (i == 1 || i == n) {
                    System.out.print(temp.data + " ");
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }


            }


        }
    }
    
}
