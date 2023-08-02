/**************************************************
---------------------
Level-Medium
---------------------
Given a 2D binary matrix A(0-based index) of dimensions NxM. Find the minimum number of steps required to reach from (0,0) to (X, Y).
Note: You can only move left, right, up and down, and only through cells that contain 1.
_____________________________________________________________________

Example 1:

Input:
N=3, M=4
A=[[1,0,0,0], 
   [1,1,0,1],
   [0,1,1,1]]
X=2, Y=3 
Output:
5
Explanation:
The shortest path is as follows:
(0,0)->(1,0)->(1,1)->(2,1)->(2,2)->(2,3).
Example 2:

Input:
N=3, M=4
A=[[1,1,1,1],
   [0,0,0,1],
   [0,0,0,1]]
X=0, Y=3
Output:
3
Explanation:
The shortest path is as follows:
(0,0)->(0,1)->(0,2)->(0,3).

________________________________________________________________________

***************************************************/



// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        
        if(A[0][0]==0) return -1;
        
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[N][M];
        int path=0;
        
        q.add(new int[]{0,0});
        visited[0][0]=true;
        
        while(!q.isEmpty())
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                int[] cur=q.poll();
                
                if(cur[0]==X && cur[1]==Y) return path;
                
                if(cur[0]+1<N && !visited[cur[0]+1][cur[1]] && A[cur[0]+1][cur[1]]==1)
                {
                    q.add(new int[]{cur[0]+1,cur[1]});
                    visited[cur[0]+1][cur[1]]=true;
                }
                if(cur[0]-1>=0 && !visited[cur[0]-1][cur[1]] && A[cur[0]-1][cur[1]]==1)
                {
                    q.add(new int[]{cur[0]-1,cur[1]});
                    visited[cur[0]-1][cur[1]]=true;
                }
                if(cur[1]+1<M && !visited[cur[0]][cur[1]+1] && A[cur[0]][cur[1]+1]==1)
                {
                    q.add(new int[]{cur[0],cur[1]+1});
                    visited[cur[0]][cur[1]+1]=true;
                }
                if(cur[1]-1>=0 && !visited[cur[0]][cur[1]-1] && A[cur[0]][cur[1]-1]==1)
                {
                    q.add(new int[]{cur[0],cur[1]-1});
                    visited[cur[0]][cur[1]-1]=true;
                }
            }
            
            path++;
        }
        
            return -1;
    }
};
