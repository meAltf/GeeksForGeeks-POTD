/******************************************************************************************************************************************************

Given a linked list and a number k. You have to reverse first part of linked list with k nodes and the second part with n-k nodes.

---------------------------------------------------------------------------------------

Example 1:

Input: 1 -> 2 -> 3 -> 4 -> 5
k = 2
Output: 2 -> 1 -> 5 -> 4 -> 3
Explanation: As k = 2 , so the first part 2
nodes: 1 -> 2 and the second part with 3 nodes:
3 -> 4 -> 5. Now after reversing the first part: 
2 -> 1 and the second part: 5 -> 4 -> 3.
So the output is: 2 -> 1 -> 5 -> 4 -> 3
Example 2:

Input: 1 -> 2 -> 4 -> 3
k = 3
Output: 4 -> 2 -> 1 -> 3
Explanation: As k = 3 , so the first part 
3 nodes: 4 -> 2 -> 1 and the second part
with 1 nodes: 3. Now after reversing the 
first part: 1 -> 2 -> 4 and the 
second part: 3. So the output is: 1 -> 2 -> 4 -> 3

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static Node reverse(Node head) {
        // code here
        
       Node curr=head;
            Node prev=null;
            Node temp;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
	}
    public static Node reverse(Node head, int k) {
        // code here
        Node temp=head;
        for(int i=0;i<k-1;i++){
            temp=temp.next;
        }
        Node nxt=temp.next;
        temp.next=null;
        Node rev1=reverse(head);
        Node rev2=reverse(nxt);
        temp=rev1;
        while(temp.next!=null)
        temp=temp.next;
        temp.next=rev2;
        return rev1;
    }
}
