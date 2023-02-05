/******************************************************************************************************************************************************

Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

---------------------------------------------------------------------------------------

Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15
Explanation:
Y ShapedLinked List

Example 2:

Input: 
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8
Explanation: 

4              5
|              |
1              6
 \             /
  8   -----  1 
   |
   4
   |
  5
  |
  NULL       

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

-----------------
  APPROACH-1
--------------------
  
  
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
        Node curr = head1;
         
        int len1 = 0;
        while(curr != null){
            curr = curr.next;
            len1++;
        }
         
        curr = head2;
        int len2 = 0;
        while(curr != null){
            curr = curr.next;
            len2++;
        }
         
        if(len1>len2){
            while(len1 != len2){
                 len1--;
                 head1 = head1.next;
            }
        }else{
            while(len1 != len2){
                len2--;
                head2 = head2.next;
            }
        }
        
        while(head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return head1.data;
        
	}
}

---------------------
APPROACH-2
--------------------
  


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
        HashSet<Node> set = new HashSet<>();
        Node temp = head1;
        while(temp != null) {
            set.add(temp);
            temp = temp.next;
        }        
        temp = head2;
        while(temp != null) {
            if(set.contains(temp)) break;
            temp = temp.next;
        }
        
        if(temp != null) return temp.data;
        return -1;
        
	}
}
