/******************************************************************************************************************************************************
---------------------------
Level- Medium
---------------------------
Given an array of strings arr[] of size n, a string str and an integer k. 
The task is to find the count of strings in arr[] whose prefix of length k matches with the k-length prefix of str.

___________________________________________________________________________________________________

Example 1:

Input:
n = 6
arr[] = {“abba”, “abbb”, “abbc”, “abbd”, 
“abaa”, “abca”}
str = “abbg”
k = 3
Output: 
4 
Explanation:
“abba”, “abbb”, “abbc” and “abbd” have their prefix of length 3 equal to 3-length prefix of str i.e., "abb".

Example 2:

Input:
n = 3
arr[] = {“geeks”, “geeksforgeeks”, “forgeeks”}
str = “geeks”
k = 2
Output: 
2
Explanation:
“geeks” and “geeksforgeeks” have their prefix of length 2 equal to 2-length prefix of str i.e., "ge".

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java


class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        // code here
        if(k>str.length())return 0;
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            if(k<=arr[i].length()){
                int j=0;
                while(j<k){
                    if(arr[i].charAt(j)!=str.charAt(j))break;
                    j++;
                }
                if(j==k)ans++;
            }
        }
        return ans;
    }
}
