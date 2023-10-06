/******************************************************************************************************************************************************
-------------------------
Level- Medium
--------------------------
Given a linked list, you have to perform the following task:

Extract the alternative nodes starting from second node.
Reverse the extracted list.
Append the extracted list at the end of the original list.
Note: Try to solve the problem without using any extra memory.

___________________________________________________________________________________________________


Example 1:

Input:
LinkedList = 10->4->9->1->3->5->9->4
Output: 
10 9 3 9 4 5 1 4
Explanation: 
Alternative nodes in the given linked list are 4,1,5,4. Reversing the alternative nodes from the given list, and 
then appending them to the end of the list results in a list 10->9->3->9->4->5->1->4.

Example 2:

Input:
LinkedList = 1->2->3->4->5
Output: 
1 3 5 4 2 
Explanation:
Alternative nodes in the given linked list are 2 and 4. Reversing the alternative nodes from the given list, 
and then appending them to the end of the list results in a list 1->3->5->4->2.

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
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        // add your code here
        
        if(odd.next==null || odd.next.next==null) return;
        
        Node pre = null;
        while(odd.next!=null && odd.next.next!=null){
            Node curr = odd.next;
            odd.next = curr.next;
            curr.next = pre;
            pre = curr;
            odd = odd.next;
        }
        if(odd.next==null) odd.next = pre;
        else odd.next.next = pre;
    }
}
