/******************************************************************************************************************************************************
--------------------------
Level- Medium
---------------------------
Given two Lists of strings s1 and s2, you have to count the number of strings in s2 which is either a suffix or prefix of at least one string of s1.

___________________________________________________________________________________________________

Example 1:

Input:
s1 = ["cat", "catanddog", "lion"]
s2 = ["cat", "dog", "rat"]
Output: 
2
Explanation: 
String "cat" of s2 is prefix of "catanddog"
& string "dog" of s2 is suffix of "catanddog" 
Example 2:

Input: 
s1 = ["jrjiml", "tchetn", "ucrhye", "ynayhy", 
       "cuhffd", "cvgpoiu", "znyadv"]
s2 = ["jr", "ml", "cvgpoi", "gpoiu", "wnmkmluc", 
      "geheqe", "uglxagyl", "uyxdroj"] 
Output: 
4
Explanation: 
String "jr" of s2 is prefix of "jrjiml", 
"ml" of s2 is suffix of "jrjiml", 
"cvgpoi" of s2 is prefix of "cvgpoiu" &
"gpoiu" of s2 is suffix of "cvgpoiu"

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java
class Solution
{
    public int prefixSuffixString(String s1[],String s2[])
    {
        trie root=new trie();
        build(s1,root);
        for(int i=0;i<s1.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<s1[i].length();j++){
                sb.append(s1[i].charAt(j));
            }
            sb.reverse();
            s1[i]=sb.toString();
        }
        build(s1,root);
        int ans=0;
        for(int i=0;i<s2.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<s2[i].length();j++){
                sb.append(s2[i].charAt(j));
            }
            sb.reverse();
            if(find(s2[i],root)==1 || find(sb.toString(),root)==1){
                ans++;
            }
        }
        return ans;
    }
    public void build(String a[], trie root){
        trie temp=null;
        for(int i = 0;i < a.length;i++){
            temp = root;
            for(int j = 0;j < a[i].length();j++){
                if(temp.ch[a[i].charAt(j)-'a'] == null)
                    temp.ch[a[i].charAt(j)-'a'] = new trie();
                temp = temp.ch[a[i].charAt(j)-'a'];
            }
        }
    }
    public int find(String s, trie root){
        for(int i = 0;i < s.length();i++){
            if(root.ch[s.charAt(i)-'a'] == null)
            return 0;
            root = root.ch[s.charAt(i)-'a'];
        }
        return 1;
    }
    public class trie
    {
        trie ch[];
        public trie()
        {
            ch=new trie[26];
            for(int i=0;i<26;i++){
                ch[i]=null;
            }
        }
    }
}
