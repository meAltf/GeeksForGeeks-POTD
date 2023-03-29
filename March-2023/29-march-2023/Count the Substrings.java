/******************************************************************************************************************************************************
----------------
Level- Easy
------------------
Given a string S. The task is to count the number of substrings which contains equal number of lowercase and uppercase letters. 

---------------------------------------------------------------------------------------
Example 1:

Input:
S = "gEEk"
Output: 3
Explanation: There are 3 substrings of
the given string which satisfy the
condition. They are "gE", "gEEk" and "Ek".
Example 2:

Input:
S = "WomensDAY"
Output: 4
Explanation: There are 4 substrings of 
the given string which satisfy the
condition. They are "Wo", "ensDAY", 
"nsDA" and "sD"

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        
        int upper=0;
        int lower=0;
        int ans=0;
        
        for(int i=0;i<S.length();i++)
        {
            upper=0;
            lower=0;
            for(int j=i;j<S.length();j++)
            {
                if(Character.isUpperCase(S.charAt(j)))
                {
                    upper++;
                }
                if(Character.isLowerCase(S.charAt(j)))
                {
                    lower++;
                }
                if(upper==lower)
                {
                    ans++;
                }
               
            }
             
        }
        
        return ans;
        
    }
} 
