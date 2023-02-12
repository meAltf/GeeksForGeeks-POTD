/******************************************************************************************************************************************************

You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number. If more than one prime number exists
at an equal distance, choose the smallest one.

---------------------------------------------------------------------------------------

Example 1:

Input:
2 → 6 → 10
Output:
2 → 5 → 11
Explanation:
The nearest prime of 2 is 2 itself.
The nearest primes of 6 are 5 and 7,
since 5 is smaller so, 5 will be chosen.
The nearest prime of 10 is 11.
 

Example 2:

Input:
1 → 15 → 20
Output:
2 → 13 → 19
Explanation:
The nearest prime of 1 is 2.
The nearest primes of 15 are 13 and 17,
since 13 is smaller so, 13 will be chosen.
The nearest prime of 20 is 19.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/
//import java.lang.Math;
class Solution
{
    
    private static boolean isPrime(int num){
        
        if(num==1) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++){
            
            if(num%i == 0) return false;
        }
        return true;
    }
    
    
    Node primeList(Node head){
        //code here
        
        Node temp = head;
        
        while(temp != null){
            
            int num = temp.val;
            
            if(num==1){
                temp.val = 2;
                temp= temp.next;
                continue;
            }
            int prev = num;
            int ahead = num;
            while(!isPrime(prev)){
                prev--;
            }
            
            while(!isPrime(ahead)){
                ahead++;
            }
            
            int distance1 = ahead-num;
            int distance2 = num-prev;
            
            if(distance1 < distance2){
                temp.val = ahead;
                
            } else if(distance2 < distance1){
                temp.val = prev;
                
            }else{
                temp.val = prev;
            }
            temp = temp.next;
        }
        
        return head;
        
    }
}
