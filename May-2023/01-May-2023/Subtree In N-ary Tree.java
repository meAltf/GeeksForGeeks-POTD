/******************************************************************************************************************************************************
-------------------------
Level- Medium
--------------------------
Given the root of a n-ary tree find the number of duplicate subtrees in the n-ary tree. 
Two trees are duplicates if they have the same structure with the same node values.
___________________________________________________________________________________________________

Example 1:

Input:
1 N 2 2 3 N 4 N 4 4 3 N N N N N

Output: 
2
Explanation: 
[4], [3] are duplicate subtree.
Example 2:

Input:
1 N 2 3 N 4 5 6 N N N N

Output: 
0
Explanation: 
No duplicate subtree found.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java


class Solution{
    
Map<String,Integer> mm = new HashMap<>();
    String help(Node root){
        String temp = String.valueOf(root.data);
        for(Node x:root.children){
            String t = help(x);
            temp=temp+t+"*";
        }
        mm.putIfAbsent(temp,0);
        mm.put(temp,mm.get(temp)+1);
        return temp;
    }
    public int duplicateSubtreeNaryTree(Node root){
       // Code here
        help(root);
        int ans=0;
        for(Map.Entry<String,Integer> x:mm.entrySet()){
            if(x.getValue()>1)ans++;
        }
        return ans;
    }
}
