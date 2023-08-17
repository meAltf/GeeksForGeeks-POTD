/******************************************************************************************************************************************************
----------------------------
Level- Hard
------------------------------
Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive). The task is to find the next smallest palindrome strictly larger than 
the given number.

___________________________________________________________________________________________________

Example 1:

Input:
N = 11
Num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}
Output: 9 4 1 8 8 0 8 8 1 4 9
Explanation: Next smallest palindrome is
9 4 1 8 8 0 8 8 1 4 9
Example 2:

Input:
N = 5
Num[] = {2, 3, 5, 4, 5}
Output: 2 3 6 3 2
Explanation: Next smallest palindrome is
2 3 6 3 2

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        Vector<Integer> v = new Vector<>();
        if(isnine(num)){//check whether all the numbers in the given digit are 9
            for(int i=0;i<n+1;i++){
                if(i==0||i==n) v.add(1);//add 1 at start and end as it will be the smallest palindrome
                else v.add(0);
            }
            return v;
        }
        
        
        boolean flag=isRight(num,n);
        
        int i=(n-1)/2;
        int j=n/2;
        while(i>=0){
            if(flag){
                if(num[i]==9){
                    num[i]=0;
                }else{
                    num[i]++;
                    flag=false;
                }
            }
            num[j++]=num[i--];
            
        }
        
        for(i=0;i<n;i++){
            v.add(num[i]);
        }
        
        return v;
    }
    
    //check whether the right half is greater than the left half
    boolean isRight(int[] num,int n){
        int i=(n-1)/2;
        int j=n/2;
        
        while(i>=0&&j<n){
            if(num[i]<num[j]) return true; 
            else if(num[i]>num[j]) return false;
            
            i--;
            j++;
        }
        return true;
    }
    
    //function to check whether all the numbers in the given digit are 9
    boolean isnine(int[] num){
        for(int i=0;i<num.length;i++){
            if(num[i]!=9) return false;
        }
        
        return true;
    }
}
