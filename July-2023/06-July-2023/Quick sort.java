/******************************************************************************************************************************************************
----------------------
Level- Medium
---------------------
Quick Sort is a Divide and Conquer algorithm. It picks an element as a pivot and partitions the given array around the picked pivot.
Given an array arr[], its starting position is low (the index of the array) and its ending position is high(the index of the array).

Note: The low and high are inclusive.

Implement the partition() and quickSort() functions to sort the array.

___________________________________________________________________________________________________

Example 1:

Input: 
N = 5 
arr[] = { 4, 1, 3, 9, 7}
Output:
1 3 4 7 9

Example 2:

Input: 
N = 9
arr[] = { 2, 1, 6, 10, 4, 1, 3, 9, 7}
Output:
1 1 2 3 4 6 7 9 10

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


class Solution
{
    //Function to sort an array using quick sort algorithm.
   static void quickSort(int arr[], int low, int high)
    {
        // code here
      if (low < high)
      {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
         int pivot = arr[high];
 
        int i = (low - 1);
  
        for (int j = low; j <= high - 1; j++) {
  
            if (arr[j] < pivot) {
  
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
        
    } 
    
     static void swap(int[] arr, int i, int j)
     {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
     }
}
