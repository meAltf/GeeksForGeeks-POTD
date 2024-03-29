/******************************************************************************************************************************************************
------------------------
Medium
------------------------
Given string str, find the length of the longest repeating subsequence such that it can be found twice in the given string.

The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B. 
For example, A = "xax" and B = "xax" then the index of first "x" must be different in the original string for A and B.
___________________________________________________________________________________________________

Example 1:

Input:
str = "axxzxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x z x y 
0 1 2 3 4 5

The longest subsequence is "xx". 
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str 


subsequence B
x x
0 1  <-- index of subsequence B
------
2 4  <-- index of str 

We are able to use character 'x' 
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A 
and index 0 in subsequence B.
Example 2:

Input:
str = "axxxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x x y 
0 1 2 3 4

The longest subsequence is "xx". 
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str 


subsequence B
x x
0 1  <-- index of subsequence B
------
2 3  <-- index of str 

We are able to use character 'x' 
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A 
and index 0 in subsequence B.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        
        int n=str.length();
		    int nichli[]=new int[n+1];
		    int cur[]=new int[n+1];
		    for(int i=n;i>=0;i--){
		        for(int j=n;j>=0;j--){
		            if(i==n || j==n)cur[j]=0;
		            else if(str.charAt(i)==str.charAt(j) && i!=j){
		                cur[j]=1+nichli[j+1];
		            }
		            else cur[j]=Math.max(nichli[j],cur[j+1]);
		        }
		        nichli=cur.clone();
		    }
		    return nichli[0];
    }
}
