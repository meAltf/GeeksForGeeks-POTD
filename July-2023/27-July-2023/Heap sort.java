--------------------------------------------------------------------------------------------------------------------------------------
Level-Medium
-----------------

----------------------------------------------------------------------------------

Given an array of size N. The task is to sort the array elements by completing functions heapify() and buildHeap() which are used to implement Heap Sort.

-----------------------------------------------------------------------------------

Example 1:

Input:
N = 5
arr[] = {4,1,3,9,7}
Output:
1 3 4 7 9
Explanation:
After sorting elements
using heap sort, elements will be
in order as 1,3,4,7,9.
  
Example 2:

Input:
N = 10
arr[] = {10,9,8,7,6,5,4,3,2,1}
Output:
1 2 3 4 5 6 7 8 9 10
Explanation:
After sorting elements
using heap sort, elements will be
in order as 1, 2,3,4,5,6,7,8,9,10.

---------------------------------------------------------------------------------------

class Solution
{
    //Function to build a Heap from array.
   void buildHeap(int arr[], int n)
    {
        //code
        for(int i = n/2 -1; i>=0; i--)
            heapify(arr, n, i);
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        //code
        int largest = i;
        int l = 2*i +1; int r = 2*i+ 2;
        
        if( l < n && arr[l] > arr[largest] ){
            largest = l;
        }
        if( r < n && arr[r] > arr[largest] ){
            largest = r;
        }
        if( largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr, n, largest );
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr, n);
        for( int i = n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
        }
    }
 }
 
 
