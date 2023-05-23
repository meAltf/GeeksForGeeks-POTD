/******************************************************************************************************************************************************
--------------------------
Level- Medium
--------------------------
Given two arrays that represent Preorder traversals of a Full binary tree preOrder[] and its mirror tree preOrderMirror[], 
your task is to complete the function constructBinaryTree(), that constructs the full binary tree using these two Preorder traversals.

Note: It is not possible to construct a general binary tree using these two traversal. 
But it is possible to create a full binary tree using the above traversals without any ambiguity.
___________________________________________________________________________________________________

Example 1:

Input :
preOrder[] = {0,1,2}
preOrderMirror[] = {0,2,1} 

Output :
                0
              /   \
             1     2
Explanation :
Tree in the output and it's mirror tree matches the preOrder and preOrderMirror.

Example 2:

Input :  
preOrder[] = {1,2,4,5,3,6,7}
preOrderMirror[] = {1,3,7,6,2,5,4}

Output :          
                 1
               /    \
              2      3
            /   \   /  \
           4     5 6    7
Explanation :
Tree in the output and it's mirror tree matches the preOrder and preOrderMirror.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution
{
    static int index=0;
    private static Node help(int start,int end,int pre[],int preMirror[],int n){
        if(index>=n || start>end)return null;
        if(index==n-1 || start==end){
            Node temp = new Node(pre[index]);
            index++;
            return temp;
        }
        
        Node temp = new Node(pre[index]);
        index++;
        for(int i=start;i<=end;i++){
            if(pre[index]==preMirror[i]){
                temp.left = help(i,end,pre,preMirror,n);
                temp.right = help(start+1,i-1,pre,preMirror,n);
                break;
            }
        }
        return temp;
    }
    
    
    public Node constructBTree(int pre[], int preM[], int size)
    {
        // your code here
        index=0;
        return help(0,size-1,pre,preM,size);
    }
    
}
