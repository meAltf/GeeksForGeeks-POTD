/******************************************************************************************************************************************************
-------------------
Level- Medium
-------------------
Given an input stream A of n characters consisting only of lower case alphabets. While reading characters from the stream, 
you have to tell which character has appeared only once in the stream upto that point. If there are many characters that have appeared only once, 
you have to tell which one of them was the first one to appear. If there is no such character then append '#' to the answer.

___________________________________________________________________________________________________ 

Example 1:

Input: A = "aabc"
Output: "a#bb"
Explanation: For every character first non
repeating character is as follow-
"a" - first non-repeating character is 'a'
"aa" - no non-repeating character so '#'
"aab" - first non-repeating character is 'b'
"aabc" - first non-repeating character is 'b'

Example 2:

Input: A = "zz"
Output: "z#"
Explanation: For every character first non
repeating character is as follow-
"z" - first non-repeating character is 'z'
"zz" - no non-repeating character so '#'

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        
        HashMap<Character,Integer> mm = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<A.length();i++){
            
            mm.putIfAbsent(A.charAt(i),0);
            mm.put(A.charAt(i),mm.get(A.charAt(i))+1);
            
            if(mm.get(A.charAt(i))==1)q.add(A.charAt(i));
            
            while(q.size()!=0 && mm.get(q.peek())>1)q.remove();
            
            if(q.size()==0)ans.append('#');
            else ans.append(q.peek());
        }
        return ans.toString();
    }
}
