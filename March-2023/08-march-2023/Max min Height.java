/******************************************************************************************************************************************************
---------------------------
LEVEL- HARD
--------------------------
You have a garden with n flowers lined up in a row. The height of ith flower is ai units. You will water them for k days.
In one day you can water w continuous flowers (you can do this only once in a single day). Whenever you water a flower its height increases by 1 unit. 
You need to maximize the height of the smallest flower all the time.
---------------------------------------------------------------------------------------

Example 1:

Input:
n=6
k=2
w=3
a[]={2,2,2,2,1,1}
Output:
2
Explanation:
Water last three flowers for first day & 
first three flowers for second day.The 
new heights will be {3,3,3,3,2,2}
Example 2:

Input:
n=2
k=5
w=1
a[]={5,8}
Output:
9
Explanation:
For the first four days water the first flower then
water the last flower once.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution{

static boolean possible(int n,int a[],int k,int w,int mid){
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i]=a[i];
        for(int i=0;i<n;i++){
            if(arr[i]<mid){
                int temp = mid-arr[i];
                if(temp>k)return false;
                k-=temp;
                arr[i]=mid;
                for(int j=i+1;j<n && j<i+w;j++){
                    arr[j]+=temp;
                }
            }
        }
        return true;
    }
	long maximizeMinHeight(int N, int K, int W,int [] a)
    {
        //Write your code here
        int mn=Integer.MAX_VALUE,mx;
        for(int i=0;i<N;i++)mn=Math.min(mn,a[i]);
        mx=mn+K;
        long ans=0;
        while(mn<=mx){
            int mid = (mn+mx)/2;
            if(possible(N,a,K,W,mid)){
                ans=mid;
                mn=mid+1;
            }
            else mx=mid-1;
        }
        return ans;
    }
}
