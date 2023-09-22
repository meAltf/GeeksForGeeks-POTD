/******************************************************************************************************************************************************
----------------------
Level- Medium
-----------------------
Given a sorted array arr containing n elements with possibly duplicate is to find indexes of first elements, 
the task is to find the first and last occurrences of an element x in the given array.
Note: If the number x is not found in the array then return both the indices as -1.

___________________________________________________________________________________________________

Example 1:

Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  
2 5
Explanation: 
First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5. 

Example 2:

Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  
6 6
Explanation: 
First and last occurrence of 7 is at index 6.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = n-1;
        list.add(-1);
        list.add(-1);
             
        while(left <= right) {
            if(arr[left] == x && arr[right] == x) {
                list.add(0,left);
                list.add(1,right);
                break;
            }
            if(arr[left] != x ) left++;
            
            if(arr[right] != x ) right--;
         }
        return list;
    }
}
