/******************************************************************************************************************************************************
----------------------
Level-Easy
-----------------------
There are N bags with diamonds in them. The i'th of these bags contains A[i] diamonds. If you drop a bag with A[i] diamonds,
it changes to A[i]/2 diamonds and you gain A[i] diamonds. Dropping a bag takes 1 minute. Find the maximum number of diamonds that you can take if you are given K minutes.

___________________________________________________________________________________________________

Example 1:

Input:
N = 5, K = 3
A[] = {2, 1, 7, 4, 2}
Output:
14
Explanation:
The state of bags is:
2 1 7 4 2
You take all diamonds from Third bag (7).
The state of bags becomes: 2 1 3 4 2 
Take all diamonds from Fourth bag (4).
The state of bags becomes: 2 1 3 2 2
Take all diamonds from Third bag (3).
The state of bags becomes: 2 1 1 2 2 
Hence, number of Diamonds = 7+4+3 = 14.
Example 2:

Input:
N = 3, K = 2
A[] = {7, 1, 2}
Output:
10
Explanation:
You take all diamonds from First bag (7).
The state of bags becomes: 3 1 2 
Take all diamonds from again First bag (3).
The state of bags becomes: 1 1 2
You can take a maximum of 10 diamonds.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution {
    static long maxDiamonds(int[] A, int N, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long ans = 0L; int time = K;
        
        for(int num: A) pq.add(num);
        
        while(!pq.isEmpty() && time>0) {
            int curr = pq.poll();
            ans = ans + curr;
            pq.add(curr/2);
            time--;
        }
        return ans;
    }
};
