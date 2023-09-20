/******************************************************************************************************************************************************
------------------------
Level- Basic
------------------------
Given an integer N and an integer D, rotate the binary representation of the integer N by D digits to the left as well as right and 
return the results in their decimal representation after each of the rotation.
Note: Integer N is stored using 16 bits. i.e. 12 will be stored as 0000000000001100.

___________________________________________________________________________________________________


Example 1:

Input:
N = 28, D = 2
Output:
112
7
Explanation: 
28 in Binary is: 0000000000011100
Rotating left by 2 positions, it becomes 0000000001110000 = 112 (in decimal).
Rotating right by 2 positions, it becomes 0000000000000111 = 7 (in decimal).

Example 2:

Input: 
N = 29, D = 2
Output: 
116
16391
Explanation: 
29 in Binary is: 0000000000011101
Rotating left by 2 positions, it becomes 0000000001110100 = 116 (in decimal).
Rotating right by 2 positions, it becomes 100000000000111 = 16391 (in decimal).

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        // your code here
        
        ArrayList<Integer> list = new ArrayList<>();
        
        D = D%16;
        
        int l = (N<<D | N>>(16-D))&65535;
        int r = (N>>D | N<<(16-D))&65535;
        list.add(l);
        list.add(r);
        return list;
    }
}
