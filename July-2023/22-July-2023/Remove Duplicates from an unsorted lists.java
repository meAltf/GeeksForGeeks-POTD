/******************************************************************************************************************************************************
-----------------------
Level- Easy
------------------------
Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, 
the node which appeared first should be kept, all others duplicates are to be removed.

___________________________________________________________________________________________________

Example 1:

Input:
N = 4
value[] = {5,2,2,4}
Output: 5 2 4
Explanation:Given linked list elements are
5->2->2->4, in which 2 is repeated only.
So, we will delete the extra repeated
elements 2 from the linked list and the
resultant linked list will contain 5->2->4
Example 2:

Input:
N = 5
value[] = {2,2,2,2,2}
Output: 2
Explanation:Given linked list elements are
2->2->2->2->2, in which 2 is repeated. So,
we will delete the extra repeated elements
2 from the linked list and the resultant
linked list will contain only 2.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         // Your code here
         
       HashSet<Integer> hashChoose = new HashSet<>();
       
       Node current = head;
	   Node prev = null;
	   
	   while (current != null) {
	       
			int curval = current.data;
			
			if (hashChoose.contains(curval)) {
				prev.next = current.next;
				
			} else {
				hashChoose.add(curval);
				prev = current;
			}
			
			current = current.next;
		}
		
		return head;
    }
}
