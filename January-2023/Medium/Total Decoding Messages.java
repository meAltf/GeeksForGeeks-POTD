/*********************************************************************************************************************************

A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded, as the answer can be large return the answer modulo 109 + 7.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0s, extra trailing 0s and two or more consecutive 0s then it is an invalid string.



----------------------------------------------------------------------

Example 1:
Input: str = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(123),
"LC"(12 3) and "AW"(1 23).

Example 2:
Input: str = "90"
Output: 0
Explanation: "90" cannot be decoded as it's an invalid string and we cannot decode '0'.

-------------------------------------------------------------------------


**********************************************************************************************************************************/


//User function Template for Java
class Solution
{
    public int CountWays(String str)
    {
        // code here
        int n = str.length();
        
        if(n==0 || str.charAt(0)=='0')
        return 0;
        
        if(n==1)
        return 1;
        
        int count1 = 1;
        int count2 = 1;
        for(int i=1;i<n;i++)
        {
            int curr = str.charAt(i)-'0';
            int prev = (str.charAt(i-1)-'0')*10 + curr;
            
            int count = 0;
            if(curr>0)
            count = count + count2;
            
            if(prev>=10 && prev<=26)
            count = count + count1;
            
            count1 = count2%1000000007;
            count2 = count%1000000007;
        }
        
        return count2%1000000007;
    }
}
