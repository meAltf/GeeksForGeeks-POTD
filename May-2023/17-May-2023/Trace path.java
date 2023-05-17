/******************************************************************************************************************************************************
-------------------------
Level- Easy
-------------------------
There is a rectangular path for a Train to travel consisting of n rows and m columns. 
The train will start from one of the grid's cells and it will be given a command in the form of string s consisting of characters L, R, D, U. 
Find if it is possible to travel the train inside the grid only.
Note:
If the train is at position (i,j)
on taking 'L' it goes to (i,j-1),
on taking 'R' it goes to (i,j+1),
on taking 'D' it goes to (i-1,j),
on taking 'U' it goes to (i+1,j).
___________________________________________________________________________________________________

Example 1:

Input: 
n = 1, m = 1
s = "R"
Output: 0
Explaination: There is only one cell(1,1). So train can only start from (1,1). On taking right(R) train moves to (1,2), which is out of grid.
Therefore there is no cell from where train can start and remain inside the grid after tracing the route. 
Example 2:

Input: 
n = 2, m = 3
s = "LLRU"
Output: 1
Explaination: One possible cell is (1,3)
(1,3) --> (1,2) --> (1,1) --> (1,2) --> (2,2). Thus there is a cell from where if train starts, it remains inside the grid throughout tracing the route.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
        // code here
        int minx=Integer.MAX_VALUE,miny=Integer.MAX_VALUE,maxx=Integer.MIN_VALUE,maxy=Integer.MIN_VALUE,x=0,y=0;
            for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L')y-=1;
            if(s.charAt(i)=='R')y+=1;
            if(s.charAt(i)=='D')x-=1;
            if(s.charAt(i)=='U')x+=1;
            
             minx=Math.min(x,minx);
             maxx=Math.max(maxx,x);
             miny=Math.min(y,miny);
             maxy=Math.max(y,maxy);
             if(Math.abs(maxx-minx)>=n || (maxy-miny)>=m || Math.abs(x)>=n || Math.abs(y)>=m)return 0;
        }
       return 1;
    }
}
