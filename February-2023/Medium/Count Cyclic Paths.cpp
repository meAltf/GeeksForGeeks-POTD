/******************************************************************************************************************************************************

Given a triangular pyramid with its vertices marked as O, A, B and C and a number N, the task is to find the number of ways such that a person starting
from the origin O initially, reaches back to the origin in N steps. In a single step, a person can go to any of its adjacent vertices.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 1
Output: 0
Explanation: The minimum length of
a cyclic path is 2.
Example 2:

Input:
N = 2
Output: 3
Explanation: The three paths are :
O-A-O, O-B-O, O-C-O

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution{   
public:
    int countPaths(int N){
        // code here 
        
        //try to find logic with the help of Brute-force
		//if n=0, then we reached 'O'- 1 times, and a-0, b-0, c-0 times from 'O' vertices
		//then sum of previous steps of a,b,c is equal to next steps of 'O'
		//like n=0, then 'O'-1, a-0,b-0,c-0
		//n=1, then "O" = a+b+c, from previous steps, a=o+b+c. b=o+a+c, c=o+a+b;
		//n=2, then "O"= a+b+c, from previous steps ans so on..
		
		long mod = 1e9+7;
		
		long o=1, a=0, b=0, c=0;
		
		for(int i=0; i<N; i++){
		    
		    long temp1 = (a+b+c)%mod;
		    long temp2 = (o+b+c)%mod;
		    long temp3 = (o+a+c)%mod;
		    long temp4 = (o+a+b)%mod;
		    
		    o=temp1;
		    a=temp2;
		    b=temp3;
		    c=temp4;
		    
		}
		return o;
    }
};
