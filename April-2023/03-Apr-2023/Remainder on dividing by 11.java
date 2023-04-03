/******************************************************************************************************************************************************
---------------------
Level- Easy
--------------------
Given a big positive number x represented as string, find value of x % 11 or x mod 11. Output is expected as an integer.

---------------------------------------------------------------------------------------

Example 1:

Input: x = 1345
Output: 3
Explanation: 1345 % 11 = 3 
Example 1:

Input: x = 231456786543567898765
Output: 1
Explanation: 231456786543567898765 % 11 = 1

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

Approach -1 
--------------------


//User function Template for Java

class Solution { 
    static int xmod11(String input) { 
        
        int result = 0;
        
        for (int i = 0; i < input.length(); i++) {
            
            char digitChar = input.charAt(i);
            int digitValue = Character.getNumericValue(digitChar);
            result = (result * 10 + digitValue) % 11;
        }
        return result;
    }
}

____________________
Approach-2
-----------------------
  
//User function Template for Java

class Solution { 
    static int xmod11(String x) { 
        
        int ans = 0;
        
	    for(int i = 0; i<x.length();i++){
	        ans = (ans * 10 +(x.charAt(i)- '0')) % 11;
	    }
	    
        return ans;
    }
}
  
