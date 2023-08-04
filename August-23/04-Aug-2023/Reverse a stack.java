/**************************************************
-----------------
Level-Medium
-----------------

_________________________________

Example 1:

Input:
St = {3,2,1,7,6}
Output:
{6,7,1,2,3}
Explanation:
Input stack after reversing will look like the stack in the output.

Example 2:

Input:
St = {4,3,9,6}
Output:
{6,9,3,4}
Explanation:
Input stack after reversing will look like the stack in the output

_________________________________

***************************************************/

//User function Template for Java

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        Queue<Integer> q = new LinkedList<>();
        while(!s.isEmpty())
        {
            q.add(s.pop());
        }
        while(!q.isEmpty())
        {
            s.push(q.remove());
        }
    }
}
