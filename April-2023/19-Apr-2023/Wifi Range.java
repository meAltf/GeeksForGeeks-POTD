/******************************************************************************************************************************************************
--------------------
Level- Easy
--------------------
There are N rooms in a straight line in Geekland State University's hostel, you are given a binary string S of length N where S[i] = '1' 
represents that there is a wifi in ith room or S[i] = '0' represents no wifi. Each wifi has range X i.e.
if there is a wifi in ith room then its range will go upto X more rooms on its left as well as right. 
You have to find whether students in all rooms can use wifi.

___________________________________________________________________________________________________

Example 1: 

Input:
N = 3, X = 0
S = "010"
Output:
0
Explanation: 
Since the range(X)=0, So Wifi is only 
accessible in second room & 1st & 2nd
room have no wifi.
Example 2: 

Input:
N = 5, X = 1
S = "10010"
Output:
1
Explanation: 
Index 0 : Wifi is available
Index 1 : Since range of 0th Index is 1
          so, here wifi will be available.
Index 2 : Since range of 3rd Index is 1
          so, here also wifi available.
Index 3 : Wifi is available
Index 4 : here range of 3rd Index is available.
So all the rooms have wifi, so return true.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        // code here
        
        for(int i=0;i<N;i++){
            int left=(i-X)<0?0:i-X;
            int right = (i+X)>=N?N-1:i+X;
            
            if(S.substring(left,right+1).contains("1")==false){
                return false;
            }
        }
        return true;
    }
} 
