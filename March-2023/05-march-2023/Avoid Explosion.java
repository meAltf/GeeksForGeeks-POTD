/******************************************************************************************************************************************************

Geek is a chemical scientist who is performing an experiment to find an antidote to a poison. The experiment involves mixing some solutions in a flask. 
Based on the theoretical research Geek has done, he came up with an n * 2 array 'mix', where mix[i] = {X, Y} denotes solutions X and Y that needs to be mixed.

Also, from his past experience, it has been known that mixing some solutions leads to an explosion and thereby completely ruining the experiment. 
The explosive solutions are also provided as a m * 2 array 'danger' where danger[i] = {P, Q} denotes that if somehow solutions P and Q get into the 
same flask it will result in an explosion.

Help the Geek by returning an array 'answer' of size n, where answer[i] = "Yes" if it is safe to mix solutions in 'mix[i]' or else answer[i] = "No".

Note: Geek should follow the order of mixing of solutions as it is in 'mix' otherwise the antidote will be ineffective. Also, Geek will not mix the 
solutions in 'mix[i]' once he gets to know that mixing them will result in an explosion. Mixing a solution will effect the other solutions
which will appear after it. 

---------------------------------------------------------------------------------------

Example 1:

Input:
n = 5, m = 2
mix = {{1, 2}, {2, 3}, {4, 5}, {3, 5}, {2, 4}}
danger = {{1, 3}, {4, 2}}

Output:
answer = {"Yes", "No", "Yes", "Yes", "No"}

Explanation:
Mixing the first solution(1 and 2) of 'mix' do not result in any kind of explosion hence answer[0] is "Yes", while mixing(2nd solution) 2 and 3
is not allowed because it will result in an explosion as 1 and 3 would be in same solution hence we have returned "No" as the answer for 2nd solution. 
Mixing the third solution(4 and 5) and 4th solution(3 and 5) of 'mix' do not result in any kind of explosion hence answer[2] and answer[3] is "Yes".
While mixing 2 and 4 is not allowed because it will result in an explosion hence we have returned "No" as the answer for it.
Example 2:

Input:
n = 3, m = 2
mix = {{1, 2}, {2, 3}, {1, 3}}
danger = {{1, 2}, {1, 3}}

Output:
answer = {"No", "Yes", "No"}

Explanation:
Mixing solutions 1 and 2 is dangerous hence 
answer[0] = "No", but solutions 2 and 3 can 
be mixed without any problem therefore answer[1] 
= "Yes". Again, mixing solutions 1 and 3 is 
dangerous due to which answer[2] = "No".

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

// User function Template for Java

class Solution {

   class DisjointSet{

        int []parent,rank;

        int n;

        DisjointSet(int n){

            parent=new int[n];

            rank=new int[n];

            this.n=n;

            for(int i=0;i<n;i++)

            parent[i]=i;

        }

        int find(int x){

            if(parent[x]!=x)

            parent[x]=find(parent[x]);

            return parent[x];

        }

        void union(int x,int y){

            int xroot=find(x),yroot=find(y);

            if(xroot==yroot)

            return;

            if(rank[xroot]<rank[yroot]){

                parent[xroot]=yroot;

            }

            else if(rank[yroot]<rank[xroot]){

                parent[yroot]=xroot;

            }

            else{

                parent[yroot]=xroot;

                rank[xroot]+=1;

            }

        }

    }

    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {

    ArrayList<String> arr=new ArrayList<>();

    DisjointSet dsu=new DisjointSet(n);

    

    for(int i=0;i<n;i++){

        int m1=dsu.find(mix[i][0]-1),m2=dsu.find(mix[i][1]-1);

        boolean dang=false;

        for(int j=0;j<m;j++){

            int d1=dsu.find(danger[j][0]-1),d2=dsu.find(danger[j][1]-1);

            if((m1==d1&&m2==d2)||(m1==d2&&m2==d1)){

            dang=true;

            break;

        }

    }

    if(!dang){

    dsu.union(m1,m2);

    arr.add("Yes");

    }

    else arr.add("No");

}

return arr;}

}
