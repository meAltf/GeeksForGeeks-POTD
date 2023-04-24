/******************************************************************************************************************************************************
---------------------
Level- Medium
---------------------
Given an array where each element (arr[i]) represents the height of the tower. Find for each tower, the nearest possible tower that is shorter than it. 
You can look left or right on both sides.
Note : 

If two smaller towers are at the same distance, pick the smallest tower.

If two towers have the same height then we choose the one with a smaller index.

___________________________________________________________________________________________________

Example 1:

Input: 
arr[] = {1,3,2}
Output: 
{-1,0,0}
Explanation:
For 0th Index : no tower is smallest, so -1.
For 1st Index : For 3, here 1 & 2 both are 
small & at a same distance, so we will pick 1, 
beacuse it has smallest value, so 0(Index)
For 2nd Index : here 1 is smaller, so 0(Index)
So the final output will be which consistes 
Indexes are {-1,0,0}.
Example 2:

Input: 
arr[] = {4,8,3,5,3}
Output: 
{2,2,-1,2,-1}

Explanation: 
For 0th Index : here 3 is the smaller, so 2(Index) 
For 1st Index : For 8, here 4 & 3 both are
small & at a same distance, so we will pick 3, so 2(Index)
For 2nd Index : no tower is smallest, so -1.
For 3rd Index : For 5, here 3 & 3 both are
small & at a same distance, so we will pick 
3(2nd Index) because it smaller Index, so 2(Index)
For 4th Index : no tower is smallest, so -1.
So the final output will be which consistes
Indexes are {2,2,-1,2,-1}.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution{
    int [] nearestSmallestTower(int [] a){
        int n = a.length; 
        int[] left = new int[n];
        int[] right = new int[n]; 
        
        Stack<Integer> st = new Stack<>(); 
        
        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                left[i] =-1; 
            }else{
                while(!st.isEmpty() &&a[st.peek()] >= a[i]){
                    st.pop(); 
                }
                if(st.isEmpty()){
                    left[i] = -1; 
                }else{
                    left[i] = st.peek(); 
                }
            }
            st.push(i); 
        }
        st = new Stack<>(); 
        for(int i=n-1; i>=0; i--){
            if(st.isEmpty()){
                right[i] =-1; 
            }else{
                while(!st.isEmpty() &&a[st.peek()] >= a[i]){
                    st.pop(); 
                }
                if(st.isEmpty()){
                    right[i] = -1; 
                }else{
                    right[i] = st.peek(); 
                }
            }
            st.push(i); 
        }
        
        int[] ans = new int[n]; 
        for(int i=0; i<n; i++){
            if(left[i]==-1 && right[i] == -1){
                ans[i] =-1; 
            }else if(left[i]==-1){
                ans[i]= right[i]; 
            }else if(right[i]==-1){
                ans[i] = left[i]; 
            }else{
                if(Math.abs(right[i] - i)==Math.abs(i -left[i])){
                    ans[i] = a[right[i]] < a[left[i]] ? right[i] : left[i]; 
                }else if(Math.abs(right[i] - i) > Math.abs(i -left[i])){
                    ans[i] = left[i]; 
                }else{
                    ans[i] =right[i]; 
                }
            }            
        }
        return ans; 
    }
}
