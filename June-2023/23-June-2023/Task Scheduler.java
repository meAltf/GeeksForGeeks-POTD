/******************************************************************************************************************************************************
----------------
Level- Medium
----------------

Given a character array tasks of size N, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. 
Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
CPU has a cooldown period for each task. CPU can repeat a task only after atleast K units of time has passed after it did same task last time. 
It can perform other tasks in that time, can stay idle to wait for repeating that task.

Return the least number of units of times that the CPU will take to finish all the given tasks.

___________________________________________________________________________________________________

Example 1:
Input:
N = 6
K = 2
task[ ] = {'A', 'A', 'A', 'B', 'B', 'B'}
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is atleast 2 units of time between any two same tasks.
 

Example 2:
Input:
N = 12
K = 2
task[ ] = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}
Output: 16
Explanation:  
One possible solution is 
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



// User function Template for Java

class Solution {
    static int leastInterval(int N, int K, char tasks[]) {
        // code here
        int temp[]=new int[26];
        for(int i : tasks)
            temp[i-'A']++;
            
        int max=-1, count=0;
        
        for(int i = 0 ; i<26 ; i++){
            if(temp[i]==max)
                count++;
            else if(temp[i]>max){
                max=temp[i];
                count=1;
            }
        }
        int ans = Math.max(N, max+(max-1)*K+count-1);
        return ans;
    }
}
    
