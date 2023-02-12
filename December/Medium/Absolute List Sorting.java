/******************************************************************************************************************************************************

Given a linked list of N nodes, sorted in ascending order based on the absolute values of its data,i.e. negative values are considered as positive ones. 
Sort the linked list in ascending order according to the actual values, and consider negative numbers as negative and positive numbers as positive.

---------------------------------------------------------------------------------------

Example 1:

Input: 
List: 1, -2, -3, 4, -5
Output: 
List: -5, -3, -2, 1, 4
Explanation: 
Actual sorted order of {1, -2, -3, 4, -5}
is {-5, -3, -2, 1, 4}
 

Example 2:

Input: 
List: 5, -10
Output: 
List: -10, 5
Explanation:
Actual sorted order of {5, -10}
is {-10, 5}

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

/* The structure of the node of the Linked List is
class Node
{
   int data;
   Node next;
   Node(int d) {data = d; next = null; }
 }
*/

class Solution
{
	Node sortList(Node head) {
		// Your code here
		Node prev=head,temp=head.next;
        while(temp!=null)
        {
           
            if(temp.data<0){
                    Node t=temp;
                    prev.next=temp.next;
                   
                    t.next=head;
                    head=t;
                    temp=prev.next;
            }
            else
            {
                prev=temp;
                temp=temp.next;
            }
           
           
        }
        return head;
	}
}
