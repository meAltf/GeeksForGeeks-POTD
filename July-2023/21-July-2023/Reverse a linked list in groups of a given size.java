/******************************************************************************************************************************************************
-----------------------------
Level- MEdium
----------------------------
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed (See Example 2 for clarification).

___________________________________________________________________________________________________

Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5 
Explanation: 
The first 4 elements 1,2,2,4 are reversed first 
and then the next 4 elements 5,6,7,8. Hence, the 
resultant linked list is 4->2->2->1->8->7->6->5.

Example 2:

Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4 
Explanation: 
The first 3 elements are 1,2,3 are reversed 
first and then elements 4,5 are reversed.Hence, 
the resultant linked list is 3->2->1->5->4.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        Node pichli=null,curr=node,agli=null,fhead=null,temp=null;
        
        int c=0;
        
        while(node!=null){
            
            while(curr!=null && c<k){
                
                agli=curr.next;
                curr.next=pichli;
                pichli=curr;
                curr=agli;
                c++;
            }
            
            if(fhead==null)fhead=pichli;
            
            if(temp!=null)temp.next=pichli;
            
            temp=node;
            pichli=null;
            node=curr;
            c=0;
        }
        
        return fhead;
    }
}
