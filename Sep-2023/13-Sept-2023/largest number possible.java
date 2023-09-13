/******************************************************************************************************************************************************
------------------------
Level- Easy
-------------------------
Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'. Return -1 if it is not possible.

___________________________________________________________________________________________________

Example 1:

Input: N = 2, S = 9
Output: 90
Explaination: It is the biggest number 
with sum of digits equals to 9.

Example 2:

Input: N = 3, S = 20
Output: 992
Explaination: It is the biggest number 
with sum of digits equals to 20.
___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
        
        String ans ="";
        if((S==0 && N>1) || (S!=0 && N==0))
            return "-1";
        if(S>9*N)
            return "-1";
        if(N==1){
            return Integer.toString(S);
        }
        int dig = 9;
        while(N>0){
            while(S-dig<0)
                dig--;
            ans+= Integer.toString(dig);
            S-=dig;
            N--;
        }
        if(S==0 && N==0)
            return ans;
        else
            return "-1";
    }
}
