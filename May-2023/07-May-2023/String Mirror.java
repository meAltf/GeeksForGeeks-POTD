/******************************************************************************************************************************************************
-------------------
Level- Easy
------------------
You are given a string str of length n. You want to choose a non-zero integer k (k<=n), such that you can perform the following operation:
Take the prefix of the string of length k and append the reverse of it to itself.
Your task is to find the lexicographically smallest string you can get.

___________________________________________________________________________________________________

Example 1:

Input:
str = "bvdfndkn"
Output:
bb
Explanation:
If we choose k=1, prefix of length k will be "b", reverse of
this prefix will be "b" itself, when we append both we get "bb",
"bb" is the lexicographically smallest string you can get.
If you choose k>1, the resulting string will not be 
lexicographically smaller than "bb".
Example 2:

Input:
str = "casd"
Output:
caac
Explanation:
If we choose k=2, prefix of length k will be "ca", reverse of
this prefix will be "ac", when we append both we get "caac",
"caac" is the lexicographically smallest string you can get.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



class Solution {
    public static String stringMirror(String str) {
        // code here
        
        StringBuilder s=new StringBuilder();
        int k=0;
        
        s.append(str.charAt(0));
        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i-1)>str.charAt(i))
            {
                s.append(str.charAt(i));
            }
            else if(str.charAt(i-1)==str.charAt(i)  && s.length()>1)
            {
                s.append(str.charAt(i));
            }
            else
                break;
        }
        
        //s=s.append(str.substring(0,k+1));
        StringBuilder ans=new StringBuilder();
        ans=ans.append(s);
        ans=ans.append(s.reverse());
        return ans.toString();
    }
}
        
