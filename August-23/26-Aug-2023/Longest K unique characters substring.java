/******************************************************************************************************************************************************
-----------------------
Level- Medium
-----------------------
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

___________________________________________________________________________________________________

Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 
7
Explanation: 
"cbebebe" is the longest substring with 3 distinct characters.
Example 2:

Input: 
S = "aaaa", K = 2
Output: -1
Explanation: 
There's no substring with 2 distinct characters.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        
        int ans = -1, i = 0, j = 0;
        
        while (j < s.length()) {
            if (map.size() < k) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            else if (map.size() == k) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                    j++;
                } else {
                    if (ans < j - i) ans = j - i;
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
            }
        }
        if (map.size() == k && ans < j - i) ans = j - i;
        return ans;
    }
}
