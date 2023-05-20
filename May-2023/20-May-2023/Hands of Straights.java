/******************************************************************************************************************************************************
-------------------
Level- Medium
-------------------

Alice has some cards, each card has one number written on it. She wants to rearrange the cards into groups so that each group is of size groupSize, 
and consists of groupSize consecutive cards.
Given an integer array hand of size N where hand [ i ] is the value written on the ith card and an integer groupSize, 
return true if she can rearrange the cards, or false otherwise.
___________________________________________________________________________________________________

Example 1:

Input:
N = 9
groupSize = 3
hand[ ] = {1, 2, 3, 6, 2, 3, 4, 7, 8}
Output: true
Explanation: 
Alice's hand can be rearranged as {1, 2, 3} , {2, 3, 4}, {6, 7, 8}. There are three groups with size 3. Each group has 3 consecutive cards.

Example 2:

Input:
N = 5
groupSize = 2
hand[ ] = {1, 2, 3, 4, 5}
Output: false
Explanation: 
Alice's hand cannot be rearranged into groups of 2. Since there are 5 cards and 5 cards cannot be divided into groups of 2.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        // code here
        
        TreeMap<Integer,Integer> mm = new TreeMap<>();
        
        for(int x:hand){
            mm.putIfAbsent(x,0);
            mm.put(x,mm.get(x)+1);
        }
        
        int num=-1,c=0;
        while(true){
            num=mm.firstKey();
            c=0;
            while(c<groupSize){
                
                if(mm.get(num)==null)return false;
                mm.put(num,mm.get(num)-1);
                if(mm.get(num)==0)mm.remove(num);
                num++;
                c++;
            }
            
            if(mm.size()==0)break;
        }
        return true;
        
    }
}
