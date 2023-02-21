/******************************************************************************************************************************************************

Given a matrix with dimensions N x M, entirely filled with zeroes except for one position at co-ordinates X and Y containing '1'. 
Find the minimum number of iterations in which the whole matrix can be filled with ones.
Note: In one iteration, '1' can be filled in the 4 neighbouring elements of a cell containing '1'.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 2, M = 3
X = 2, Y = 3
Output: 3 

Explanation: 3 is the minimum possible 
number of iterations in which the
matrix can be filled.
Example 2:

Input:
N = 1, M = 1
X = 1, Y = 1 
Output: 0

Explanation: The whole matrix is 
already filled with ones.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

Approach-1
--------------------------------
  
  //User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		
		Queue<int[]> q=new LinkedList<>();
    	boolean[][] visited=new boolean[N][M];
	           	
	    q.add(new int[]{x-1,y-1});
	    visited[x-1][y-1]=true;
	    
	    int itr=0;
	    while(!q.isEmpty())
	    {
	        int size=q.size();
	        
	        for(int i=0;i<size;i++)
	        {
	               int[] coor=q.poll();
	               int Xcor=coor[0],Ycor=coor[1];
	               
	               if(Xcor+1<N && !visited[Xcor+1][Ycor]) //downward direction
	               {
	                   visited[Xcor+1][Ycor]=true;
	                   q.add(new int[]{Xcor+1,Ycor});
	               }
	               if(Xcor-1>=0 && !visited[Xcor-1][Ycor]) //upward direction
	               {
	                   visited[Xcor-1][Ycor]=true;
	                   q.add(new int[]{Xcor-1,Ycor});
	               }
	               if(Ycor+1<M && !visited[Xcor][Ycor+1]) //right direction
	               {
	                   visited[Xcor][Ycor+1]=true;
	                   q.add(new int[]{Xcor,Ycor+1});
	               }
	               if(Ycor-1>=0 && !visited[Xcor][Ycor-1]) //left direction
	               {
	                   visited[Xcor][Ycor-1]=true;
	                   q.add(new int[]{Xcor,Ycor-1});
	               }
	        }
	        itr++;
	    }
	   return itr-1;
	}
}

-------------------------------
Approach-2
----------------------------------
  
  class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		
		int d1=x-1+y-1;
		int d2=N-x+y-1;
		int d3=N-x+M-y;
		int d4=M-y+x-1;
		
		
		return Arrays.stream(new int[]{d1,d2,d3,d4}).max().getAsInt();
	}
}
