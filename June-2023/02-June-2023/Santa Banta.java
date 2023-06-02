/******************************************************************************************************************************************************
------------------
Level- Medium
-------------------
Santa is still not married. He approaches a marriage bureau and asks them to hurry the process. The bureau checks the list of eligible girls of size N and hands it over to Santa.
Santa being conscious about his marriage is determined to find a girl with maximum connections so that he can gather more information about her. 
Accordingly, he looks to figure out the maximum number of girls (from the list) who know each other to achieve the above purpose.

In order to finalize the girl, he needs to find the Kth prime. Where k = largest group of girls who know each other. Considering Santa's poor knowledge of Maths, 
he seeks Banta's help for the answer. Now you, a fan of Santa Banta Jokes, take this prestigious opportunity to solve the problem.

In case no of connections is zero, print "-1". Here the connection between girls is represented by a 2-D array g of dimension M*2, where M is the number of connections.

Note :
1. Suppose girl "a" knows girl "b" and girl "b" knows girl "c", then girl "a" also knows girl "c". Transitivity holds here.
2. Consider 1 as a composite number.
3. For precompute function given in the template you just have to complete it and use it wherever required, do not call it again and again, 
it is already being called by driver function before executing test cases. 

___________________________________________________________________________________________________

Example 1:

Input : 
N = 10
M = 6
g[] = {{1,2},{2,3},{3,4},{4,5},{6,7},{9,10}}
Output : 
11
Explanation:
Here in this graph there are 4 groups. 
In 1st group: (1 -> 2 -> 3 -> 4 -> 5) are 
there. In 2nd group: (6 -> 7) are there.
In 3rd group: (8) is there.
In 4th group: (10 -> 9) are there.
In these 4 group the maximum number of 
value is 5. So, K = 5 and the 5th prime number 
is 11. Return 11.
Example 2:

Input : 
N = 2
M = 1
g[] = {{1, 2}} 
Output : 
3
Explanation:
In this Example there will only be a 
single group of 2 girls, and hence the 
value of K is 2, The 2nd prime is 3.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


//User function Template for Java


class Complete{
    
   static int cnt;
    static ArrayList<Integer> primes = new ArrayList<>();;
    
    // Function for finding maximum and value pair
    public static int helpSanta (int n, int m, int g[][]) 
    {
       ArrayList<ArrayList<Integer>> adj =new ArrayList<ArrayList<Integer>>();
       
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>()); 
        }
        //add edge
        for(int i=0;i<m;i++)
        {
            int u = g[i][0]; int v = g[i][1];
            adj.get(u).add(v); 
		    adj.get(v).add(u); 
        }

        
        boolean vis[]=new boolean[n+1];
        int max = 0;
        for(int i=1;i<=n;i++)
        {
            if(vis[i]==false){
                cnt=0;  // global variable since i want to access it across the functions
                DFS(adj,i,vis);
                max=Math.max(max,cnt);
            }
        }
        if(max==1) return -1; //In case no of connections is zero, print "-1". 
        return primes.get(max-1);
    }
	static void DFS(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited) 
	{ 
    	visited[s]=true;
        cnt++;
        
        for(int u:adj.get(s)){
            if(visited[u]==false)
                DFS(adj,u,visited);
        } 
	} 
    
     static void precompute () { //sieve 
        //Complete the function
        
        int N=1000000;
        boolean v[]=new boolean[N+1];
        Arrays.fill(v,true);
        for(int i=2;i*i<=N;i++){
            if(v[i]){
                for(int j=i*i;j<=N;j+=i){
                    v[j]=false;
                }
            }
        }
        for(int i=2;i<=N;i++){
            if(v[i]){
                primes.add(i);
            }
        }
    }
}
