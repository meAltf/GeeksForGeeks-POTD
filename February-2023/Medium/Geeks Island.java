/******************************************************************************************************************************************************

Geeks Island is represented by an N * M matrix mat. The island is touched by the Indian Ocean from the top and left edges and the Arabian Sea from the right and bottom 
edges. Each element of the matrix represents the height of the cell.

Due to the rainy season, the island receives a lot of rainfall, and the water can flow in four directions(up, down, left, or right) from one cell to another one
with height equal or lower.

You need to find the number of cells from where water can flow to both the Indian Ocean and the Arabian Sea.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 5, M = 5
mat[][] =    {{1, 3, 3, 2, 4},
               {4, 5, 6, 4, 4},
               {2, 4, 5, 3, 1},
               {6, 7, 1, 4, 5},
               {6, 1, 1, 3, 4}}
Output:
8
Explanation:
Indian    ~   ~   ~   ~   ~
Ocean  ~  1   3   3   2  (4) *
        ~  4   5  (6) (4) (4) *
        ~  2   4  (5)  3   1  *
        ~ (6) (7)  1   4   5  *
        ~ (6)  1   1   3   4  *           
           *   *   *   *   * Arabian Sea
Water can flow to both ocean and sea from the cells
denoted by parantheses().For example at index(1,2), the height of that island is 6. If a water drop falls on that island, water can flow to up direction(as 3<=6) and reach to Indian Ocean. ALso, water can flow to right direction(as 6>=4>=4) and reach to Arabian Sea.
Example 2:

Input:
N = 2, M = 3
mat[][] =    {{1, 1, 1},
               {1, 1, 1}}
Output:
6 
Explanation:
Water can flow from all cells to both Indian Ocean and Arabian Sea as the height of all islands are same.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution{
    
    // BFS to Check the Neighbour Cells
    void bfs(Queue<int[]> q, boolean[][] visited, int [][] mat, int N, int M) {
        
        while(!q.isEmpty()) {
            
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            // Marking the Visited True
            visited[x][y] = true;
            
            // For Right
            if(x+1 < N && !visited[x+1][y] && mat[x+1][y] >= mat[x][y]) {
                q.add(new int[]{x+1, y});
            }
            // For Left
            if(x-1 >= 0 && !visited[x-1][y] && mat[x-1][y] >= mat[x][y]) {
                q.add(new int[]{x-1, y});
            }
            // For Down
            if(y+1 < M && !visited[x][y+1] && mat[x][y+1] >= mat[x][y]) {
                q.add(new int[]{x, y+1});
            }
            // For Up
            if(y-1 >= 0 && !visited[x][y-1] && mat[x][y-1] >= mat[x][y]) {
                q.add(new int[]{x, y-1});
            }
        }
    }
    
	int water_flow(int [][] mat, int N, int M) {
	    
	    // For Indian Ocean
	    // Visited Matrix to Track the Cells from which Water can flow to the Indian Ocean
	    boolean[][] visitedIO = new boolean[N][M];
	    // Creating Queue and Adding the Top and Right Cells in it
	    // they will definitely flow water to Indian Ocean
	    // int[] will have the Coordinates of Cell (i, j);
	    Queue<int[]> qIO = new LinkedList<>();
	    // Adding Top Cells
	    for(int j = 0; j < M; j++) {
	        qIO.offer(new int[]{0, j});
	    }
	    // Adding Left Cells
	    for(int i = 0; i < N; i++) {
	        qIO.offer(new int[]{i, 0});
	    }
	    // Storing the Cells from which water can flow to the Indian Ocean using BFS
	    bfs(qIO, visitedIO, mat, N, M);
	    
	    // For Arabic Sea
	    // Visited Matrix to Track the Cells from which Water can flow to the Arabic Sea
	    boolean[][] visitedAS = new boolean[N][M];
	    // Creating Queue and Adding the Top and Right Cells in it
	    // they will definitely flow water to Arabic Sea
	    // int[] will have the Coordinates of Cell (i, j);
	    Queue<int[]> qAS = new LinkedList<>();
	    // Adding Bottom Cells
	    for(int j = 0; j < M; j++) {
	        qAS.offer(new int[]{N-1, j});
	    }
	    // Adding Right Cells
	    for(int i = 0; i < N; i++) {
	        qAS.offer(new int[]{i, M-1});
	    }
	    // Storing the Cells from which water can flow to the Arabic Sea using BFS
	    bfs(qAS, visitedAS, mat, N, M);
	    
	    // Counting the Cells from Visited Matrices
	    // Both Indian Ocean & Arabic Sea
	    int numOfCells = 0;
	    for(int i = 0; i < N; i++) {
	        for(int j = 0; j < M; j++) {
	            if(visitedIO[i][j] && visitedAS[i][j]) {
	                numOfCells++;
	            }
	        }
	    }
	    return numOfCells;
	}
}
