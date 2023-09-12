/******************************************************************************************************************************************************
------------------------
Level- EAsy
--------------------

Given a number N, check if a number is perfect or not. A number is said to be perfect if sum of all its factors excluding the number itself is equal to the number. 
Return 1 if the number is Perfect otherwise return 0.

___________________________________________________________________________________________________

Example 1:

Input:
N = 6
Output:
1 
Explanation:
Factors of 6 are 1, 2, 3 and 6.
Excluding 6 their sum is 6 which
is equal to N itself. So, it's a
Perfect Number.

Example 2:

Input:
N = 10
Output:
0
Explanation:
Factors of 10 are 1, 2, 5 and 10.
Excluding 10 their sum is 8 which
is not equal to N itself. So, it's
not a Perfect Number.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

int isPerfectNumber(long long n) {
        // code here
        long long sum = 0;
        
        for(int i=2; i<=sqrt(n); i++){
            
            if(n%i == 0){
                if(i != n/i){
                    sum += (i+n/i);
                }else{
                    sum += i;
                }
            }
        }
        return n!=1 && sum+1 == n;
    }
};
