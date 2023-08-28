/******************************************************************************************************************************************************
-----------------------
Level- Easy
-------------------------
Given a singly linked list consisting of N nodes. The task is to remove duplicates (nodes with duplicate values) from the given list (if exists).
Note: Try not to use extra space. The nodes are arranged in a sorted way.

___________________________________________________________________________________________________

Example 1:

Input:
LinkedList: 2->2->4->5
Output: 2 4 5
Explanation: In the given linked list 
2 ->2 -> 4-> 5, only 2 occurs more 
than 1 time. So we need to remove it once.
Example 2:

Input:
LinkedList: 2->2->2->2->2
Output: 2
Explanation: In the given linked list 
2 ->2 ->2 ->2 ->2, 2 is the only element
and is repeated 5 times. So we need to remove
any four 2.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
	// Your code here
	
	//base case
	
	    if(head == null || head.next == null){
	        return head;
	    }
	    
	    Node temp1 = head;
	    Node temp2 = head.next;
	   
	    
	    while(temp2!=null){
	        
	        if(temp1.data == temp2.data){
	            
	            temp2 = temp2.next;
	            temp1.next=temp2;
	            
	        } else{
	            
	            temp1 = temp2;
	            temp2 = temp2.next;
	        }
	    }
        
	    return head;
	
    }
}
