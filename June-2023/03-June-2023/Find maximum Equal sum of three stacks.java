/******************************************************************************************************************************************************
-------------------------
Level- Medium
-------------------------
Given three stacks S1, S2 & S3 of size N1, N2 & N3 respectively, having only Positive Integers. 
The task is to find the possible equal maximum sum of the stacks with the removal of top elements allowed. 
Stacks are represented as an array, and the first index of the array represents the top element of the stack.

___________________________________________________________________________________________________

Example 1:

Input:
N1 = 3, N2 = 4, N3 = 2
S1 = {4,2,3}
S2 = {1,1,2,3}
S3= {1,4}
Output:
5
Explanation:
We can pop 1 element from the 1st stack, and 2
elements from the 2nd stack. Now remaining elements
yield the equal sum of the three stacks, that is 5.
Example 2:

Input:
N1 =2, N2 = 1, N3 = 3
S1 = {4,7}
S2 = {10}
S3 = {1,2,3}
Output:
0
Explanation:
We will never get an equal sum after popping
some elements, so the answer will be 0.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // code here
        int a =0;
        int b =0;
        int c =0;
        
        for(int i: S1) a+=i;
        for(int i: S2) b+=i;
        for(int i: S3) c+=i;
        
        int i=0;
        int j=0;
        int k=0;
        
        while(a>0 && b>0 && c>0)
        {
            if(a==b && b==c) return a;
            else if(a>=b && a>=c) a -=S1[i++];
            else if(b>=a && b>=c) b -=S2[j++];
            else if(c>=b && c>=a) c -=S3[k++];
        }
        
        return 0;
    }
}
        
