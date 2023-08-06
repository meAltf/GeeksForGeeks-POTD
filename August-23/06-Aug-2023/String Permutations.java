/**************************************************
-------------------
Level- Easy
-------------------
Given a string S. The task is to find all permutations (need not be different) of a given string.

_________________________________

Example 1:

Input:
S = AAA
Output: AAA AAA AAA AAA AAA AAA
Explanation: There are total 6 permutations, as given in the output.

Example 2:

Input:
S = ABSG
Output: ABGS ABSG AGBS AGSB ASBG ASGB
BAGS BASG BGAS BGSA BSAG BSGA GABS
GASB GBAS GBSA GSAB GSBA SABG SAGB
SBAG SBGA SGAB SGBA
Explanation: There are total 24 permutations, as given in the output.

_________________________________

***************************************************/



//Back-end complete function Template for Java


class Solution
{
    ArrayList<String> arr=new ArrayList<>();
    private void permute(String str, int l, int r) 
    { 
        //base condition
        if (l == r) 
            arr.add(str); 
        else
        { //process each character of the remaining string
            for (int i = l; i <= r; i++) 
            { // swap character at index i with current character
                str = swap(str,l,i); 
                permute(str, l+1, r); // recurse for string [i+1, n-1]
                str = swap(str,l,i); // backtrack (restore the string to its original state)
            } 
        } 
    } 
  
    
    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
    
    
    public ArrayList<String> permutation(String S)
    {
    	permute(S,0,S.length()-1);
    	Collections.sort(arr); 
    	return arr;
    }
	   
}
