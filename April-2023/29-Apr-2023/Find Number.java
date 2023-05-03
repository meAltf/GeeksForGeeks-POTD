/******************************************************************************************************************************************************
------------------------
Level- Medium
---------------------------
Given an integer N, You need to find the Nth smallest number which only contains odd digits i.e. 1,3,5,7,9 
means no even digits are allowed on that number (12 will not consider). For example, the starting numbers which only contain odd digits
are 1,3,5,7,9,11,13,15,17,19,31,33,35 and so on.
___________________________________________________________________________________________________

Example 1:

Input:
N=3
Output:
5
Explanation:
First three numbers are 1, 3, 5.
Here 5 is the 3rd number, where contains
only odd digits.
Example 2:

Input:
N=13
Output:
35
Explanation:
First 13 numbers are 1,3,5,7,9,
11,13,15,17,19,31,33,35, here 35 
is the answer.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java
class Solution
{
    //public long findNumber(long N)
    //{
        
    //}
    
public long findNumber(long N)
    {
        long ans=0;
        while(N!=0){
            ans*=10;
            if(N%5==0){
                ans+=9;
                N/=5;
                N--;
            }
            else if(N%5==1){
                ans+=1;
                N/=5;
            }
            else if(N%5==2){
                ans+=3;
                N/=5;
            }
            else if(N%5==3){
                ans+=5;
                N/=5;
            }
            else{
                ans+=7;
                N/=5;
            }
        }
        long temp = 0;
        while(ans!=0){
            temp = temp*10+ans%10;
            ans/=10;
        }
        return temp;
    }
}
