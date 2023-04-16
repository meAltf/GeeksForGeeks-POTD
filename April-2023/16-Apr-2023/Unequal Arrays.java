/******************************************************************************************************************************************************
---------------------------
Level- Medium
----------------------------
You are given two arrays A and B each of length N. You can perform the following operation on array A zero or more times. 

Select any two indices i and j, 1 <= i , j <= N and i != j
Set A[i] = A[i] + 2 and A[j] = A[j]-2
Find the minimum number of operations required to make A and B equal.

Note :

Two arrays are said to be equal if the frequency of each element is equal in both of them.
Arrays may contain duplicate elements.
___________________________________________________________________________________________________

Example 1:

Input:
N = 3
A[] = {2, 5, 6}
B[] = {1, 2, 10}
Output: 2
Explanation: 
Select i = 3, j = 2, A[3] = 6 + 2 = 8 and A[2] = 5 - 2 = 3
Select i = 3, j = 2, A[3] = 10 - 2 = 8 and A[2] = 3 - 2 = 1
Now A = {2, 1, 10} and B = {1, 2, 10}
Example 2:

Input:
N = 2
A[] = {3, 3}
B[] = {9, 8}
Output: -1
Explanation: 
It can be shown that A cannot be made equal to B.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



class Solution {
    public static long solve(int N, int[] A, int[] B) {
        // code here
        long operations=0;
        Arrays.sort(A);
        Arrays.sort(B);
         int sumA=0;
        int sumB=0;
        for(int i=0;i<N;i++)
        {
           sumA += A[i];
           sumB += B[i];
        }
        if(sumA != sumB)
            return -1;
       
        ArrayList<Integer> Aodd = new ArrayList<Integer>();
        ArrayList<Integer> Bodd = new ArrayList<Integer>();
        ArrayList<Integer> Aeven = new ArrayList<Integer>();
        ArrayList<Integer> Beven = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            if(A[i]%2==0)
            Aeven.add(A[i]);
            else
            Aodd.add(A[i]);
            if(B[i]%2==0)
            Beven.add(B[i]);
            else
            Bodd.add(B[i]);
            
        }
        if(Aodd.size() != Bodd.size() || Aeven.size() != Beven.size())
            return -1;
        for(int i=0;i<Aodd.size();i++)
        {
            operations=operations+Math.abs(Aodd.get(i)-Bodd.get(i));
        }
        for(int i=0;i<Aeven.size();i++)
        {
            operations=operations+Math.abs(Aeven.get(i)-Beven.get(i));
        }
        return operations/4;
    }
}       
