/******************************************************************************************************************************************************
---------------------------
Level- Easy
---------------------------
Given a singly linked list and an integer x.Delete xth node from the singly linked list.

___________________________________________________________________________________________________

Example 1:

Input: 1 -> 3 -> 4 
       x = 3
Output: 1 -> 3
Explanation:
After deleting the node at 3rd
position (1-base indexing), the
linked list is as 1 -> 3. 
Example 2:

Input: 1 -> 5 -> 2 -> 9 
x = 2
Output: 1 -> 2 -> 9
Explanation: 
After deleting the node at 2nd
position (1-based indexing), the
linked list is as 1 -> 2 -> 9.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


/* Linklist node structure
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
/*You are required to complete below method*/
class GfG
{
    Node deleteNode(Node head, int x)
    {
	// Your code here
	if(x==1) return head.next;
	    
	    Node ptr=head;
	    Node prev=null;
	    
	    while(x>1)
	    {
	        prev=ptr;
	        ptr=ptr.next;
	        x-=1;
	    }
	    
	    prev.next=ptr.next;
	    
	        return head;
    }
}
