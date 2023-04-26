/******************************************************************************************************************************************************
-----------------
Level- Easy
-------------------
You are given an integer n, denoting the number of people who needs to be seated, and a list of m integers seats, 
where 0 represents a vacant seat and 1 represents an already occupied seat.

Find whether all n people can find a seat, provided that no two people can sit next to each other.
___________________________________________________________________________________________________

Example 1:

Input:
n = 2
m = 7
seats[] = {0, 0, 1, 0, 0, 0, 1}
Output:
Yes
Explanation:
The two people can sit at index 0 and 4.
Example 2:

Input:
n = 1
m = 3
seats[] = {0, 1, 0}
Output:
No
Explanation:
There is no way to get a seat for one person.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        // code here
         if(n==0)return true;
        if(m==1){
            if(n==1 && seats[0]==0)return true;
            return false;
        }
        int c=0;
        for(int i=0;i<m;i++){
            if(seats[i]==0){
                if(i==0){
                    if(seats[1]==0){
                        c++;
                        seats[i]=1;
                    }
                }
                else if(i==m-1){
                    if(seats[i-1]==0){
                        c++;
                        seats[i]=1;
                    }
                }
                else{
                    if(seats[i-1]==0 && seats[i+1]==0){
                        c++;
                        seats[i]=1;
                    }
                }
            }
        }
        return c>=n;
    }
}
