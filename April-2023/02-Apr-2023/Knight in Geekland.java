/******************************************************************************************************************************************************
-----------------------
Level- Medium
-----------------------
Knight is at (start_x,start_y) in Geekland which is represented by an NxM 2D matrix.
Each cell in the matrix contains some points. In the ith step, the knight can collect all the points from all the cells that can be visited in exactly
i steps without revisiting any cell.
Also, the knight has some magical powers that enable him to fetch coins from the future i.e. If the knight can collect y coins in the xth step 
he can fetch all the coins that he will collect in the (x + y)th step and if the knight can collect z coins in the yth step 
he can fetch all the coins that he will collect in the (y + z)th step and so on without increasing the step count i.e. knight will stay on xth step 
and will get all the coins of the future steps mentioned above((x + y)th step coins + (y+z)th steps + ...).
Find the minimum number of steps required to collect the maximum points.
Note: The knight moves exactly the same as the knight on a chess board. Please follow 0 indexing.


---------------------------------------------------------------------------------------

Example 1:

Input:
n = 9
m = 10
start_x = 4, start_y = 5
arr =
0 0 0 2 0 2 0 2 0 0
0 0 2 0 2 0 2 0 2 0
0 2 0 0 1 2 0 0 0 2
0 0 2 0 2 0 2 0 2 0
0 2 0 2 0 0 0 2 0 2
0 0 2 0 2 0 2 0 2 0
0 2 0 0 0 2 0 0 0 2
0 0 2 0 2 0 2 0 2 0
0 0 0 2 0 2 0 2 0 0
Output: 1
Explanation: minimum knight have to take 1 steps to gain maximum points.
Initially, the knight has 0 coins, he will take 1 step to collect 1 point (sum of cells denoted in red color).
Now in the second step, he can collect points from all the cells colored green i.e. 64 points.
But with his magical power, at the 1st step, he can fetch points from the (1 + 1)th step. Therefore he can collect 1 + 64 coins at step 1 only. Hence answer is 1.
Example 2:

Input:
n = 3 
m = 3
start_x = 2, start_y = 1
arr =
7 6 8
9 1 4
6 2 8
Output:0
Explanation:
Initially, the knight has 2 points, or more formally we can say that at the 0th step knight has 2 points.
In the first step, he can collect points from cells (0, 0) and (0, 2) i.e. 15 points.
In the second step, he can collect points from cells (1, 0) and (1, 2) i.e. 13 coins.
In the third step, he can collect points from cells (2, 0) and (2, 2) i.e. 14 points.
In the fourth step, he can collect points from the cell (0, 1) i.e. 6 points.
So in each step, he can collect coins like -You can see in the below image  Knight can collect 15 coins in the 0th step only

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution{
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        // Code Here.
        int[][] steps = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};
        int n = arr.length,m=arr[0].length;
        byte[][] visit = new byte[n][m];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start_x,start_y});
        ArrayList<Integer> points = new ArrayList<>();
        while(dq.size()>0) {
            int s = dq.size();
            int point=0;
            while(s-->0) {
                int[] idx = dq.pop();
                int i=idx[0],j=idx[1];
                if(visit[i][j]==1) continue;
                visit[i][j]=1;
                point+=arr[i][j];
                for(int[] step : steps) {
                    if(i+step[0]>=0 && i+step[0]<n && j+step[1]>=0 && j+step[1]<m) {
                        if(visit[i+step[0]][j+step[1]]==0) dq.add(new int[]{i+step[0],j+step[1]});
                    }
                }
            }
            points.add(point);
        }
        int ans=0,max_point=0;
        for(int i=0;i<points.size();i++) {
            int idx=i;
            int score=0;
            while(idx<points.size()) {
                score+=points.get(idx);
                if(points.get(idx)==0) break;
                idx+=points.get(idx);
            }
            if(max_point<score) {
                max_point=score;
                ans=i;
            }
        }
        return ans;
    
    }
}   
