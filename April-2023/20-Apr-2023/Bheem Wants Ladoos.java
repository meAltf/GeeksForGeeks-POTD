/******************************************************************************************************************************************************
------------------
Level- Medium
------------------
Chhota Bheem wants to eat the maximum number of ladoos in Dholakpur on Independence Day. 
The houses in Dholakpur are arranged in the form of a binary tree
and have ladoos the same as their house number. Chhota Bheem is standing at his home initially. 
Find the maximum ladoos he can eat if he can go to houses within a maximum distance k from his house.
The number of ladoos at his home should also be included in the sum.

Note: Every house has distinct ladoos in it. 

___________________________________________________________________________________________________

Example 1:

Input:
                   1
                 /    \
                2      9
               /      /  \
              4      5     7
            /   \         /  \
           8     19     20    11
          /     /  \
         30   40   50
home = 9, K = 1
Output:
22
Explanation:
Initially Bheem at 9, so sum = 9
In 2nd move he went to 5, sum=9+5=14
In 3rd move he went to 7, sum=14+7=21
In 4th move he went to 1, sum=21+1=22
So within K distance bheem can get 22 ladoos.  
Example 2:

Input:
                   1
                 /    \
                2      9
               /      /  \
              4      5     7
            /   \         /  \
           8     19     20    11
          /     /  \
         30   40   50
home = 40, K = 2
Output:
113
Explanation:
Initially Bheem at 40, so sum = 40
In 2nd move he went to 19, sum=40+19=59
In 3rd move he went to 4, sum=59+4=63
In 4th move he went to 50, sum=63+50=113
So within K distance bheem can get 113 ladoos.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class Solution{
    static int ans;
    static int findForSubtree(Node root,int dis)
    {
        if(root==null || dis<0) return 0;
        if(dis==0) return root.data;
        
        return root.data + findForSubtree(root.left,dis-1) + findForSubtree(root.right,dis-1);
    }
    static int solve(Node root, int home, int k)
    {
        if(root==null) return -1;
        if(root.data==home){
           ans+=findForSubtree(root,k);
           return 0;
        }
        
        int leftDistance=solve(root.left,home,k);
        int rightDistance=solve(root.right,home,k);
        
        if(leftDistance!=-1)
        {
            if(leftDistance+1<=k)
                ans+=root.data + findForSubtree(root.right, k-leftDistance-2);
            
            return leftDistance+1;
        }
        
        if(rightDistance!=-1)
        {
            if(rightDistance+1<=k)
                ans+=root.data + findForSubtree(root.left, k-rightDistance-2);
            
            return rightDistance+1;
        }
        
            return -1;
    }
    static int ladoos(Node root, int home, int k){
        
        ans=0;
        solve(root,home,k);
        
            return ans;
    }
}
