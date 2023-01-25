/**************************************************************************************************************************************

Geek is extremely punctual but today even he is not feeling like doing his homework assignment. He must start doing it immediately in order to meet the deadline. 
For the assignment, Geek needs to type a string s.
To reduce his workload, he has decided to perform one of the following two operations till he gets the string.

Append a character at the end of the string.
Append the string formed thus far to the end of the string. (This can not be done more than once.)
Help Geek find the minimum operations required to type the given string.

------------------------------------------------------------------------------------


Example 1:

Input:
s = abcabca
Output: 5
Explanation: a -> ab -> abc -> abcabc 
-> abcabca

Example 2:

Input:
s = abcdefgh
Output: 8
Explanation: a -> ab -> abc -> abcd 
-> abcde -> abcdef -> abcdefg -> abcdefgh
-------------------------------------------------------------------------------------


****************************************************************************************************************************************/

// User function Template for Java

class Solution {
    int minOperation(String s) {
        // code here
        
        int ans=s.length();

        for(int i=0;i<s.length()/2;i++) {

            boolean isSame =true;

            for(int j=0;j<=i && isSame;j++){
                
                if(s.charAt(j)!=s.charAt(j+i+1)){
                    
                    isSame = false;
                }    
            }
            

            if(isSame){
                
                ans = s.length()-i;
            } 
        }

        return ans;
    }
}
