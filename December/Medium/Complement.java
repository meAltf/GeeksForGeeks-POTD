/******************************************************************************************************************************************************

You are given a binary string str. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and complement the characters between L and R 
i.e strL, strL+1, , strR. By complement, we mean change character 0 to 1 and vice-versa.

You task is to perform ATMOST one operation such that in final string number of 1s is maximised. If there is no need to completement, i.e.,
string contains all 1s, return -1. Else, return the two values denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 3
str = "111"
Output: -1
Explanation: As all characters are '1', 
so don't need to complement any.

Example 2:

Input:
N = 2
str = "01"
Output: 1 1
Explanation: After complementing [1, 1] 
the string becomes "11".

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/



// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
         
    Vector<Integer> vector = new Vector<>();
       int maxl=0,maxr=0,msf=0,meh=0,s=0;
       
       for(int i=0;i<str.length();i++){
           meh += (str.charAt(i)=='0')?1:-1; 
           if(msf<meh){
               msf=meh;
               maxl=s;
               maxr=i;
           }
           if(meh<0){
               meh=0;
               s=i+1;
           }
       }

       if((maxl==0|| maxr==0) && msf==0){
           vector.add(-1);
           return vector;
       }
       vector.add(maxl+1);
       vector.add(maxr+1);
       
       return vector;
    }
}
