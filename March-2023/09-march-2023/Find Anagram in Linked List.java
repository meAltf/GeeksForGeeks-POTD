/******************************************************************************************************************************************************
-------------------------
Level- Medium
-------------------------
Given a linked list of characters and a string S.Return all the anagrams of the string present in the given linked list.In case of overlapping anagrams 
choose the first anagram from left.

---------------------------------------------------------------------------------------

Example 1:

Input: a -> b -> c -> a -> d -> b -> c -> a
S = bac
Output: [a -> b -> c, b -> c -> a]
Explanation: In the given linked list,
there are three anagrams: 
1. a -> b -> c -> a -> d -> b -> c -> a
2. a -> b -> c -> a -> d -> b -> c -> a
3. a -> b -> c -> a -> d -> b -> c -> a
But in 1 and 2, a -> b -> c and b -> c-> a
are ovelapping.So we take a -> b -> c as it
comes first from left.So the output is:
[a->b->c,b->c->a]
Example 2:

Input: a -> b -> d -> c -> a
S = bac
Output: -1 
Explanation: There is no anagrams, so output is -1

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/


class Solution {
    
    private static boolean checkAnagram(int arr1[], int arr2[]){
        for(int i=0; i<26; i++){
            
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            arr1[ch - 'a']++;
        }
        
        int n = s.length();

        int count = 0;
        Node ptr = head;
        Node curr = head;
        while(ptr!=null){
            count++;
            char c = ptr.data;
            arr2[c - 'a']++;
           
            if(count == n){
                
                if(checkAnagram(arr1,arr2)){
                    
                    Node next = ptr.next; 
                    ptr.next = null; 
                    ans.add(curr); 
                    ptr = next; 
                    curr = ptr; 
                    count = 0;
                    Arrays.fill(arr2,0);
                }else{
                
                    char ch1 = curr.data;
                    arr2[ch1 - 'a']--;
                    ptr = ptr.next;
                    curr = curr.next;
                    count--;
                }
            }else{
                ptr = ptr.next;
            }
        }
        return ans;
    }
}
