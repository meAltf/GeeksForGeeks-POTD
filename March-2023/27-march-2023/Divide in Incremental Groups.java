/******************************************************************************************************************************************************
---------------------
Level- Hard
---------------------
You can earn more Geekbits by participating in GFG Weekly Coding Contest  

Given two integers N and K, the task is to count the number of ways to divide N into K groups of positive integers such that their sum is N 
and the number of elements in groups follows a non-decreasing order (i.e. group[i] <= group[i+1]).

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 8
K = 4
Output:
5
Explanation:
There are 5 groups such that their sum is 8 
and the number of positive integers in each 
group is 4. The 5 groups are [1, 1, 1, 5], 
[1, 1, 2, 4], [1, 1, 3, 3], [1, 2, 2, 3] and 
[2, 2, 2, 2].
Example 2:

Input: 
N = 4
K = 3
Output:
1
Explanation: 
The only possible grouping is {1, 1, 2}. Hence,
the answer is 1 in this case.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

// User function Template for Java

class Solution {
    public int countWaystoDivide(int N, int K) {
        return getCount(K, 1, N);
    }
    
    int getCount(int idx, int prev, int total){
        if (total < 0) return 0;
        if (idx == 1) 
            if (total >= prev) return 1;
            else return 0;
        
        int ans = 0;
        
        for (int i = prev; i <= total/idx; i++){
            ans += getCount(idx - 1, i, total - i);
        }
        
        return ans;
    }
}
