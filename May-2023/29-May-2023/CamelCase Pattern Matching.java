/******************************************************************************************************************************************************
----------------------
Level- Medium
----------------------

Given a dictionary of words where each word follows CamelCase notation, print all words (in lexicographical order) in the dictionary 
that match with a given pattern consisting of uppercase characters only.

Example: GeeksForGeeks matches the pattern "GFG", because if we combine all the capital letters in GeeksForGeeks they become GFG.

CamelCase is the practice of writing compound words or phrases such that each word or abbreviation begins with a capital letter. 
Common examples include PowerPoint and Wikipedia, GeeksForGeeks, CodeBlocks, etc.  
    
___________________________________________________________________________________________________
Example 1:

Input:
N=3
Dictionary=["WelcomeGeek",
"WelcomeToGeeksForGeeks","GeeksForGeeks"]
Pattern="WTG"
Output:
WelcomeToGeeksForGeeks
Explanation:
Since only WelcomeToGeeksForGeeks matches 
the pattern, it is the only answer.
Example 2:

Input:
N=8
Dictionary=["Hi","Hello","HelloWorld",
"HiTech","HiGeek","HiTechWorld",
"HiTechCity","HiTechLab"]
Pattern="HA"
Output:
-1
Explanation:
Since the pattern matches none of the words
of the string,the output is -1.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

//User function Template for Java

class Solution{
ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        //code here
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<Dictionary.length;i++){
            int k=0;
            for(int j=0;j<Dictionary[i].length();j++){
                if(k<Pattern.length() && Dictionary[i].charAt(j)==Pattern.charAt(k))k++;
                else if(Dictionary[i].charAt(j)>='A' && Dictionary[i].charAt(j)<='Z')break;
            }
            if(k==Pattern.length())ans.add(Dictionary[i]);
        }
        if(ans.isEmpty())ans.add("-1");
        Collections.sort(ans);
        return ans;
    }
}
