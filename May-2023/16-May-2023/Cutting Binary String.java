/******************************************************************************************************************************************************
----------------------
Level- MEdium
----------------------
Given a string s containing 0's and 1's. You have to return the smallest positive integer C, 
such that the binary string can be cut into C pieces and each piece should be of the power of 5  with no leading zeros.
Note: The string s is a binary string. And if no such cuts are possible, then return -1.
___________________________________________________________________________________________________

Example 1:

Input:
s = "101101101"
Output: 
3
Explanation: 
We can split the given string into 
three 101s, where 101 is the binary 
representation of 5.
Example 2:

Input:
s = "00000"
Output: 
-1
Explanation: 
0 is not a power of 5.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution{
    static int cuts(String s)
    {
        int n=s.length();

        Set<Long>set=new HashSet<>();

        long in=1;

        for(int i=1;i<51 && in>0;i++)

        {

            set.add(in);

            in*=5;

        }

        int[]arr=new int[n+1];

        for(int i=n-1;i>=0;i--)

        {

            int min=Integer.MAX_VALUE;

            if(s.charAt(i)=='0')

            {

                arr[i]=-1;

                continue;

            }

            long curr=0;

            for(int j=i;j<n;j++)

            {

                curr=(curr<<1)+(s.charAt(j)-'0');

                if(!set.contains(curr) || arr[j+1]==-1) continue;

                min=Math.min(min,1+arr[j+1]);

            }

            arr[i]=min==Integer.MAX_VALUE?-1:min;

        }

        return arr[0];
    }
}
