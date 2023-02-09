/******************************************************************************************************************************************************

There are M job applicants and N jobs.  Each applicant has a subset of jobs that he/she is interested in. Each job opening can only accept one applicant and
a job applicant can be appointed for only one job. Given a matrix G with M rows and N columns where G(i,j) denotes ith applicant is interested in the jth job. 
Find the maximum number of applicants who can get the job.

---------------------------------------------------------------------------------------

Example 1:

Input: 
M = 3, N = 5
G = {{1,1,0,1,1},{0,1,0,0,1},
{1,1,0,1,1}}
Output: 3
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.
Third applicant gets the 4th job.

Example 2:

Input:
M = 6, N = 2
G = {{1,1},{0,1},{0,1},{0,1},
{0,1},{1,0}}
Output: 2
Explanation: There is one of the possible
assignment-
First applicant gets the 1st job.
Second applicant gets the 2nd job.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] G) {
        int m = G.length;
        int n = G[0].length;
        int[] match = new int[n];
        int result = 0;
        
        Arrays.fill(match, -1);

        for (int u = 0; u < m; u++) {
          boolean[] vis = new boolean[n];
          if (bfs(u, G, match, vis)) result++;
        }
        return result;
    }

    private static boolean bfs(int u, int[][] g, int[] match, boolean[] vis) {
        for (int v = 0; v < g[0].length; v++) {
            if (g[u][v] == 1 && !vis[v]) {
                vis[v] = true;
                if (match[v] == -1 || bfs(match[v], g, match, vis)) {
                  match[v] = u;
                  return true;
                }
            }
        }
        return false;
    }

}
