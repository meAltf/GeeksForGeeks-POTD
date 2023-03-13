/******************************************************************************************************************************************************
Given two arrays A[] and B[] of same length N. There are N types of sticks of lengths specified. Each stick of length A[i] is present in B[i] units (i=1 to N).
You have to construct the squares and rectangles using these sticks. Each unit of a stick can be used as length or breadth of a rectangle or as a side of square. 
A single unit of a stick can be used only once.

Let S be the sum of lengths of all sticks that are used in constructing squares and rectangles. The task is to calulate the maximum possible value of S.

Note: The element in array A[] is always unique.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 4
A[] = {3,4,6,5}
B[] = {2,3,1,6}
Output: 
38
Explanation: 
There are 2 sticks of length 3.
There are 3 sticks of length 4.
There is a 1 stick of length 6.
There are 6 sticks of length 5.
One square can be made using 4 sticks of
4th kind (5*4=20)
A rectangle can be made using 2 sticks of 
4th kind and 2 sticks of 2nd kind (5*2+4*2=18)
S = 20 + 18 = 38

Example 2:

Input:
N = 1
A[] = {3}
B[] = {2}
Output: 
0
Explanation: 
There are only 2 sticks of length 3 which are 
not enough to make the square or rectangle.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java
class Solution 
{ 
    long maxPossibleValue(int N, int A[] ,int B[]) { 
        // code here
        
        long min_len = Integer.MAX_VALUE; long tot_stick=0; long tot_peri=0;
        for(int i=0; i<N; i++)
        {
            if(B[i]%2==1) B[i]--;
            if(B[i]>=2) min_len = Math.min(min_len, A[i]);
            
            tot_stick += B[i];
            tot_peri += B[i]*A[i];
        }
        
        if(tot_stick%4!=0) // even number not div by 4 also results rem==2
        tot_peri -= 2*min_len;
        
        return tot_peri;
        
    }
} 
