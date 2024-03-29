/**************************************************
--------------------
  Level- Easy
---------------------
Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum
_________________________________

Example 1:

Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :{3, 4, 9, 7, 9}.
Example 2:

Input:
N = 7, M = 3
A = {7, 3, 2, 4, 9, 12, 56}
Output: 2
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 4 - 2 = 2 by choosing following M packets :{3, 2, 4}.


_________________________________
//User function Template for Java

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        if(m>n)
            return -1;
        if(n==0 || m==0){
            return 0;
        }
        
        Collections.sort(a);
        long min_diff=Integer.MAX_VALUE;
        
        for(int i=0;i+m-1<n;i++){
            long diff=a.get(i+m-1)-a.get(i);
            if(diff<min_diff){
                min_diff=diff;
            }
        }
        
        return min_diff;
    }
}
***************************************************/
