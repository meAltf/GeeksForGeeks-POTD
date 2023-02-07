/******************************************************************************************************************************************************

Given an array arr[] consisting of n integers, find the length of the longest subarray with positive (non zero) product.

---------------------------------------------------------------------------------------

Example 1:

Input:
arr[] ={0, 1, -2, -3, -4} 
Output:
3
Explanation: 
The longest subarray with positive product is: 
{1, -2, -3}.Therefore, the required length is 3.

Example 2:

Input:
arr[]={-1, -2, 0, 1, 2}
Output:
2
Explanation:
The longest subarray with positive products 
are: {-1, -2}, {1, 2}. Therefore, the required 
length is 2.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

---------------------------
Approach-1
------------------------
  
  //User function Template for J//

class Solution{

    /* Function to return the length of the

       longest subarray with ppositive product */

       

     int maxLength(int arr[], int n) { 
         
         int pos=0;
           int neg=0;
           int ans=0;
           
           for(int i=0;i<n; i++)
           {
               if(arr[i]==0)
               {
                   pos=0;
                   neg=0;
               }
               else if(arr[i]>0)
               {
                   if(neg==0)
                   {
                       pos++;
                   }
                   else
                   {
                       pos++;
                       neg++;
                   }
               }
               else
               {
                   if(neg==0)
                   {
                       neg=pos+1;
                       pos=0;
                   }
                   else
                   {
                       int temp=pos;
                       pos=neg+1;
                       neg=temp+1;
                   }
               }
               
               ans=Math.max(ans,pos);
               
           }
           
           return ans;
       
     }
}
