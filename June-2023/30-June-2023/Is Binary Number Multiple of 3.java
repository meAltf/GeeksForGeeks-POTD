/******************************************************************************************************************************************************
----------------------
Level- Medium
---------------------
Given a number in its binary form find if the given binary number is a multiple of 3. It is recommended to finish the task using one traversal of input binary number.
___________________________________________________________________________________________________

Example 1:

Input: S = "0011"
Output: 1
Explanation: "0011" is 3, which is divisible by 3.

Example 2:

Input: S = "100"
Output: 0
Explanation: "100"'s decimal equivalent is 4, which is not divisible by 3.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution {
    int isDivisible(String s) {
        // code here
        
      int odd=0;
      int even=0;
      
      for(int i=0;i<s.length();i++)
      {
          int bit=s.charAt(i)-'0';
          if(i%2==0)
          {
              even+=bit;
          }
          else
          {
              odd+=bit;
          }
      }
      
      int delta=Math.abs(even-odd);
      
      if(delta%3==0)
      {
          return 1;
      }
      else
      {
          return 0;
      }
    }
}
