/******************************************************************************************************************************************************
-----------------
Level- Easy
------------------

Given two linked lists, your task is to complete the function makeUnion(), that returns the union list of two linked lists. 
This union list should include all the distinct elements only and it should be sorted in ascending order.

___________________________________________________________________________________________________

Example 1:

Input:
L1 = 9->6->4->2->3->8
L2 = 1->2->8->6->2
Output: 
1 2 3 4 6 8 9
Explaination: 
All the distinct numbers from two lists, when sorted forms the list in the output. 
Example 2:

Input:
L1 = 1->5->1->2->2->5
L2 = 4->5->6->7->1
Output: 
1 2 4 5 6 7
Explaination: 
All the distinct numbers from two lists, when sorted forms the list in the output.

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
class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
        Node cur=null,start=null;
        
        TreeSet<Integer> s = new TreeSet<Integer>();        
        // using tree set to store numbers in sorted order
        
        while(head1!=null)
        {
            // adding all numbers in list1 to set
            s.add(head1.data);
            head1=head1.next;
        }
        while(head2!=null)
        {
            // adding all numbers in list2 to set
            // duplicates will be ignored in set
            s.add(head2.data);
            head2=head2.next;
        }
        for(Integer i : s)
        { 
            Node ptr=new Node(i);
            if(start==null)
            {
                // creating new head
                start=ptr;
                cur=ptr;
            }
            else
            {
                // appending node at the end
                cur.next=ptr;
                cur=ptr;
            }
        }
        return start;
	}
}
