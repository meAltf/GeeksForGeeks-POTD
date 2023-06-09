/******************************************************************************************************************************************************
------------------------
Level- Medium
----------------------
Given a string S. The task is to print all unique permutations of the given string in lexicographically sorted order.

___________________________________________________________________________________________________

Example 1:

Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6 
forms as ABC, ACB, BAC, BCA, CAB and CBA .
Example 2:

Input: ABSG
Output:
ABGS ABSG AGBS AGSB ASBG ASGB BAGS 
BASG BGAS BGSA BSAG BSGA GABS GASB 
GBAS GBSA GSAB GSBA SABG SAGB SBAG 
SBGA SGAB SGBA
Explanation:
Given string ABSG has 24 permutations.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



class Solution {
    public List<String> find_permutation(String S) 
    {
        Set<String> list=new HashSet<String>();
        char letters[]=S.toCharArray();
        Arrays.sort(letters);
        S=new String(letters);
        permutations(S, "", list);
        List<String> res=new ArrayList<String>(list);
        Collections.sort(res);
        return res;
    }
    public void permutations(String S, String curr, Set<String> l)
    {
        if(S.length()==0)
        {
            l.add(curr);
            return;
        }
        for(int i=0;i<S.length();i++)
        {
            permutations(S.substring(0,i)+S.substring(i+1),curr+S.charAt(i),l);
        }
    }
}
