/******************************************************************************************************************************************************
-------------------
Level- Easy
--------------------
Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.

___________________________________________________________________________________________________
Example 1:

Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
Explanation: In the first example, there
are 9 nodes in linked list and we need
to find 2nd node from end. 2nd node
from end is 8.  

Example 2:

Input:
N = 5
LinkedList: 10->5->100->5
Output: -1
Explanation: In the second example, there
are 4 nodes in the linked list and we
need to find 5th from the end. Since 'n'
is more than the number of nodes in the
linked list, the output is -1.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



/* Structure of node

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution
{
    //Function to find the data of nth node from the end of a linked list.
int getNthFromLast(Node head, int n)
    {
    	// Your code here	
    	Node first=head,second=head;
    	int c=0;
    	while(first!=null){
    	    first=first.next;
    	    c++;
    	    if(c>n)second=second.next;
    	}
    	if(c<n)return -1;
    	return second.data;
    }
}
