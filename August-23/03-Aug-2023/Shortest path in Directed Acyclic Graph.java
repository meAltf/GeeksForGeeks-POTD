/**************************************************
----------------
Level- Medium
----------------

Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M,
where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

_________________________________


Example1:

Input:
N = 4, M = 2
edge = [[0,1,2],[0,2,1]
Output:
0 2 1 -1
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->2 with edge weight 1.
There is no way we can reach 3, so it's -1 for 3.
Example2:

Input:
N = 6, M = 7
edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
Output:
0 2 3 6 1 5
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
Shortest path from 0 to 4 is 0->4 with edge weight 1.
Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.

_________________________________

***************************************************/

//User function Template for Java
class Solution {
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<Map<Integer,Integer>> l=new ArrayList<>();
		int vis[]=new int[N];
		for(int i=0;i<N;i++){
		    l.add(new HashMap<>());
		    vis[i]=-1;
		}
		
		Map<Integer,Integer> m;
		for(int i[]:edges){
		    m=l.get(i[0]);
		    m.put(i[1],i[2]);
		}
		dfs(0,l,vis,0);
		return vis;
	}
	
	void dfs(int i,List<Map<Integer,Integer>> g,int vis[],int target){
	    if(vis[i]!=-1){
	        if(target>vis[i])
	            return;
	        else
	            vis[i]=Integer.min(target,vis[i]);
	    }
	    
	    else
	        vis[i]=target;
	    
	    for(Map.Entry<Integer,Integer> mp:g.get(i).entrySet()){
	            dfs(mp.getKey(),g,vis,target+mp.getValue());
	    }
	}
}
