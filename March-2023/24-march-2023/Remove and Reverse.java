/******************************************************************************************************************************************************
-------------------------
Level- Medium
-------------------------
Given a string S which consists of only lowercase English alphabets, you have to perform the below operations:
If the string S contains any repeating character, remove the first repeating character and reverse the string and
again perform the above operation on the modified string, otherwise, you stop.
You have to find the final string.

---------------------------------------------------------------------------------------

Example 1:

Input: S = "abab"
Output: ba
Explanation:
In 1st operation: The first repeating 
character is a. After Removing the first 
character, S = "bab". After Reversing the 
string, S = "bab".
In 2nd operation: The first repeating 
character is b. After Removing the first 
character, S = "ab". After Reversing the 
string, S = "ba".
Now the string S does not contain any 
repeating character.
Example 2:

Input: S = "dddd"
Output: d

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution { 
    String removeReverse(String S) { 
        // code here
        
        HashMap<Character,Integer> map= new HashMap<>();
        StringBuilder sb= new StringBuilder(S);
        
        for(int i=0; i<S.length(); i++)
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
            
        boolean turn= true;
        int start= 0;
        int end= sb.length()-1;
        
        while(start<=end){
            if(turn){
                if(map.get(sb.charAt(start))>1){
                    map.put(sb.charAt(start),map.get(sb.charAt(start))-1);
                    sb.deleteCharAt(start);
                    end--;
                    turn= !turn;
                } else {
                    start++;
                }
            } else {
                if(map.get(sb.charAt(end))>1){
                    map.put(sb.charAt(end),map.get(sb.charAt(end))-1);
                    sb.deleteCharAt(end);
                    turn= !turn;
                } 
                end--;
            }
        }
        return turn?sb.toString():sb.reverse().toString();
    }
}
