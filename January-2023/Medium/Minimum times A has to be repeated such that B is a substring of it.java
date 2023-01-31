/***************************************************************************************************************************

Given two strings A and B. Find minimum number of times A has to be repeated such that B is a Substring of it. If B can never be a substring then return -1.

-------------------------------------------------------------------------------

Example 1:

Input:
A = "abcd"
B = "cdabcdab"
Output:
3

Explanation:
Repeating A three times (abcdabcdabcd),
B is a substring of it. B is not a substring
of A when it is repeated less than 3 times.

Example 2:
Input:
A = "ab"
B = "cab"
Output :
-1

Explanation:
No matter how many times we repeat A, we can't
get a string such that B is a substring of it.

-----------------------------------------------------------------------------------


****************************************************************************************************************************/

 //User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        
        String c = "";
        int count =0;
        
        while(c.length() <= 2*B.length()){
            
            c= c+A;
            count++;
            
            if(c.contains(B)){
                return count;
            }
        }
        return -1;
        
    }
};
