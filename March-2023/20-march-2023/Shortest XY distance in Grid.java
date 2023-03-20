/******************************************************************************************************************************************************
-------------------
Level- Medium
---------------------
Give a N*M grid of characters 'O', 'X', and 'Y'. Find the minimum Manhattan distance between a X and a Y.

Manhattan Distance :
| row_index_x - row_index_y | + | column_index_x - column_index_y |

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 4, M = 4
grid  = {{X, O, O, O}
         {O, Y, O, Y}
         {X, X, O, O}
         {O, Y, O, O}}
Output:
1
Explanation:
{{X, O, O, O}
{O, Y, O, Y}
{X, X, O, O}
{O, Y, O, O}}
The shortest X-Y distance in the grid is 1.
One possible such X and Y are marked in bold
in the above grid.
Example 2:

Input:
N = 3, M = 3
grid = {{X, X, O}
        {O, O, Y}
        {Y, O, O}}
Output :
2
Explanation:
{{X, X, O}
 {O, O, Y}
 {Y, O, O}}
The shortest X-Y distance in the grid is 2.
One possible such X and Y are marked in bold
in the above grid.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/



// User function Template for Java

class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        // code here
        ArrayList<int[]>listx=new ArrayList<>();
        ArrayList<int[]>listy=new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid.get(i).get(j)=='X'){
                    listx.add(new int[]{i,j});
                }
                if(grid.get(i).get(j)=='Y'){
                    listy.add(new int[]{i,j});
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int []d1:listx){
            for(int []d2:listy){
                ans=Math.min(ans,Math.abs(d1[0]-d2[0])+Math.abs(d1[1]-d2[1]));
            }
        }
        return ans;
    }
};
