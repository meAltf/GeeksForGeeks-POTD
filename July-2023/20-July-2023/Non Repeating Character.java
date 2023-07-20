/******************************************************************************************************************************************************
---------------------------
Level- EAsy
--------------------------
Given a string S consisting of lowercase Latin Letters. Return the first non-repeating character in S. If there is no non-repeating character, return '$'.

___________________________________________________________________________________________________


Example 1:

Input:
S = hello
Output: h
Explanation: In the given string, the
first character which is non-repeating
is h, as it appears first and there is
no other 'h' in the string.

Example 2:

Input:
S = zxvczbtxyzvy
Output: c
Explanation: In the given string, 'c' is
the character which is non-repeating. 

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

  HashMap<Character,Integer> mm = new HashMap<>();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            mm.putIfAbsent(c,0);
            mm.put(c,mm.get(c)+1);
        }
        for(int i=0;i<S.length();i++){
            if(mm.get(S.charAt(i))==1)return S.charAt(i);
        }
        return '$';
