/*
---------
  Level - hard
  ---------
Given two integers N and K, the task is to find the string S of minimum length such that it contains all possible strings of size N as a substring. The characters of the string should be from integers ranging from 0 to K-1.  

Example 1:

Input:
N = 2, K = 2
Output: 
00110
Explanation: 
Allowed characters are from 0 to k-1 (i.e., 0 and 1).
There are 4 string possible of size N=2 
(i.e "00", "01","10","11")
"00110" contains all possible string as a 
substring. It also has the minimum length.
  
Example 2:

Input:
N = 2, K = 3
Output: 
0010211220
Explanation: 
Allowed characters are from 0 to k-1 (i.e., 0, 1 and 2).
There are total 9 strings possible
of size N, given output string has the minimum
length that contains all those strings as substring.

  */

// Here is the solution in cpp

class Solution
{
public:
    string findString(int n, int k) {
        // code here
        
         set<string> vis;
        
        string start = "";
        for(int i = 0; i < n; i++)
            start += '0';
        
        string ans = start;
        
        function<void(string &)> dfs = [&](string &node) {
            vis.insert(node);
            string nextS = node.substr(1);
            
            for(int i = k - 1; i > -1; i--){
                string child = nextS + to_string(i);
                
                if(!vis.count(child)){
                    ans += to_string(i);
                    dfs(child);
                }
            }
        };
        
        dfs(start);
        
        return ans;
    }
};
