/******************************************************************************************************************************************************

A special compression mechanism can arbitrarily delete 0 or more characters and replace them with the deleted character count.
Given two strings, S and T where S is a normal string and T is a compressed string, determine if the compressed string  T is valid for the plaintext string S. 

---------------------------------------------------------------------------------------

Example 1:

Input:
S = "GEEKSFORGEEKS"
T = "G7G3S"
Output:
1
Explanation:
We can clearly see that T is a valid 
compressed string for S.

Example 2:

Input:
S = "DFS"
T = "D1D"
Output :
0
Explanation:
T is not a valid compressed string.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution {

    static int checkCompressed(String s, String t) {

        // code here

        int i=0;
        int j=0;

        while(i<s.length() && j<t.length()){

              if(s.charAt(i)==t.charAt(j)){
                 i++;
                 j++;
                 continue;
             }

             if(Character.isDigit(t.charAt(j))==false && s.charAt(i)!=t.charAt(j)) return 0;

             int cnt=0;
             while(j<t.length() &&  Character.isDigit(t.charAt(j))){

                 cnt=cnt*10+(t.charAt(j)-'0');
                 j++;
             }

             i+=cnt;
        }

        if(i==s.length() && j==t.length()){

            return 1;
        }
            return 0;

        }  

    }
