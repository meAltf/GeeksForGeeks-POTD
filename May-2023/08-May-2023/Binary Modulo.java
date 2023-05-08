/******************************************************************************************************************************************************
-------------------
Level- Easy
--------------------
You are given a binary string s and an integer m. You need to return an integer r. Where r = k%m, k is the binary equivalent of string s.

___________________________________________________________________________________________________

Example 1:

Input:
s = "101" 
m = 2
Output:
1
Explanation: Here k=5 because (101)2 = (5)10.
Hence 5 mod 2 = 1.
Example 2:

Input:
s = "1000"
m = 4
Output:
0
Explanation: Here k=8 and m=4 hence 
r = k mod m = 8 mod 4 = 0.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution{
int modulo(String s, int m) {
		//Write your code here
		int ans=0,temp=1;
		for(int i=s.length()-1;i>=0;i--){
		    if(s.charAt(i)=='1'){
		        ans+=temp;
		        ans%=m;
		    }
		    temp*=2;
		    temp%=m;
		}
		return ans;
	}
}
