/******************************************************************************************************************************************************
---------------
Level - Medium
---------------
Given a string str consisting of only two characters 'a' and 'b'. You need to find the minimum steps required to make the string empty 
by removing consecutive a's and b's.

---------------------------------------------------------------------------------------


Example 1:

Input:
str = "bbaaabb"
Output:
2
Explanation:
Operation 1: Removal of all a's modifies str to "bbbb".
Operation 2: Removal of all remaining b's makes str
empty.
Therefore, the minimum number of operations required
is 2.
Example 2:

Input:
str = "aababaa"
Output:
3
Explanation:
Operation 1: Removal of b's modifies str to "aaabaa".
Operation 2: Removal of b's modifies str = "aaaaa".
Operation 3: Removal of all remaining a's makes str 
empty.
Therefore, the minimum number of operations required 
is 3.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution{
	int minSteps(String str) {
		//Write your code here
		
		int aNum = 0;
		int bNum = 0;
		
		if(str.charAt(0) == 'a'){
		    aNum++;
		}else{
		    bNum++;
		}
		
		for(int i=1; i<str.length(); i++){
		    
		    if(str.charAt(i) =='b' && str.charAt(i-1) == 'a') bNum++;
		    
		    if(str.charAt(i) =='a' && str.charAt(i-1) == 'b') aNum++;
		}
		
		return Math.min(aNum, bNum) + 1;
	}
}
