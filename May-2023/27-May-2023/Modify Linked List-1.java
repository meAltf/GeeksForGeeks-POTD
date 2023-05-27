/******************************************************************************************************************************************************
------------------
Level- MEdium
-----------------
Given a singly linked list containing N nodes. Modify the Linked list as follows:

1. Modify the value of the first half nodes such that 1st node's new value is equal to the value of the last node minus the first node's current value, 
2nd node's new value is equal to the second last nodes value minus 2nd nodes current value, likewise for first half nodes.
2. Replace the second half of nodes with the initial values of the first half nodes(values before modifying the nodes).
3. If N is odd then the value of the middle node remains unchanged.
___________________________________________________________________________________________________

Example 1:

Input:
N = 5
linked list = 10 -> 4 -> 5 -> 3 -> 6
Output:
-4 -1 5 4 10
Explanation:
For first half nodes modified list will be:
-4 -> -1 -> 5 -> 3 -> 6
For second half nodes modified list will be:
-4 -> -1 -> 5 -> 4 -> 10

Example 2:

Input:
N = 6
linked list = 2 -> 9 -> 8 -> 12 -> 7 -> 10
Output:
8 -2 4 8 9 2
Explanation:
After modifying the linked list as required,
we have a new linked list containing the elements as
8 -> -2 -> 4 -> 8 -> 9 -> 2.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
        ArrayList<Integer>list = new ArrayList<Integer>();
        if(head==null || head.next==null){
            return head;
        }
        Node temp=head;
        while(temp!=null){
            list.add(temp.data);
            temp=temp.next;
        }
        temp=head;
        int n=list.size();
        // System.out.println(n);
        int i=0;
        int j=n-1;
        int m=(n%2==1)?n/2:n/2-1;
        
        while(j>m){
            int temp1=list.get(i);
            list.set(i,list.get(j)-list.get(i));
            list.set(j,temp1);
            i++;
            j--;
        }
        i=0;
        while(temp!=null){
            temp.data=list.get(i);
            temp=temp.next;
            i++;
        }
        // System.out.println(list);

        return head;
    }
}
