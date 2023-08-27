/******************************************************************************************************************************************************
-----------------------
Level- Basic
------------------------
You are given a string s. You need to reverse the string.
___________________________________________________________________________________________________

Example 1:

Input:
s = Geeks
Output: skeeG

Example 2:

Input:
s = for
Output: rof

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        
        String s ="";
        
        for(int i=str.length()-1;i>-1;i--){
            s+=str.charAt(i);
        }
        return s;
    }
}
