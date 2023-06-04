/******************************************************************************************************************************************************
-----------------------
Level- Easy
-----------------------
Given a mathematical equation that contains only numbers and +, -, *, /. Print the equation in reverse, such that the equation is reversed, but the numbers remain the same.
It is guaranteed that the given equation is valid, and there are no leading zeros.

___________________________________________________________________________________________________

Example 1:

Input:
S = "20-3+5*2"
Output: 2*5+3-20
Explanation: The equation is reversed with
numbers remaining the same.

Example 2:

Input: 
S = "5+2*56-2/4"
Output: 4/2-56*2+5
Explanation: The equation is reversed with
numbers remaining the same.


___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java
class Solution
{
    String reverseEqn (String S)
        {
            //code here.
              StringBuilder sb = new StringBuilder();
        for(int i = S.length()-1 ; i >= 0 ; i--){
            char ch = S.charAt(i);
            if(sb.length() == 0) sb.append(ch);
            else if(ch == '*' || ch == '/' || ch == '-' || ch == '+') sb.append(ch);
            else{
                if(sb.length()>0){
                    char c = sb.charAt(sb.length()-1);
                    if(c == '*' || c == '/' || c == '-' || c == '+') sb.append(ch);
                    else sb.insert(sb.length()-1, ch);
                }
            }
        }
        return sb.toString();
        }
}
