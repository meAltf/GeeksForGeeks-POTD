/******************************************************************************************************************************************************

There is a string of size n containing only 'A' and 'O'. 'A' stands for Apple, and 'O' stands for Orange. We have m number of spells, each spell allows us to convert
an orange into an apple.

Find the longest sequence of apples you can make, given a string and the value of m.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 5
M = 1
arr[] = 'AAOAO'
Output: 4 
Explanation: Changing the orange at 
3rd position into an apple gives 
us the maximum possible answer.

Example 2:

Input:
N = 5
M = 1
arr = 'AOOAO'
Output: 2
Explanation: Changing any orange into 
an apple will give us a sequence 
of length 2.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/


class Solution{
    public static int appleSequence(int n, int m, String arr){
        //code here
        int i=0,j=0,o=0,ans=0;
        while(j<n) {
            if(arr.charAt(j)=='O') {
                if(o<m) {
                    o++;
                    j++;
                } else {
                    if(arr.charAt(i)=='O') o--;
                    i++;
                }
            } else {
                j++;
            }
            ans = Math.max(ans,j-i);
        }
        return ans;
    }
}

