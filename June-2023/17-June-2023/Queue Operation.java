/******************************************************************************************************************************************************
-----------------------
Level- Easy
---------------------------
Given N integers, the task is to insert those elements in the queue. Also, given M integers, the task is to find the frequency of each number in the Queue.
Note:

insert() will be called N times by main().
findFrequency() will be called M times by main();
Where k is each element passing through respective function calls.
___________________________________________________________________________________________________

Example 1:

Input:
N = 8
1 2 3 4 5 2 3 1
M = 5
1 3 2 9 10
Output:
2
2
2
-1
-1
Explanation:
After inserting 1, 2, 3, 4, 5, 2, 3 and 1 into the queue, frequency of 1 is 2, 3 is 2 and 2 is 2. Since 9 and 10 are not there in the queue we output -1 for them.
Example 2:

Input:
N = 6
1 2 1 1 1 4
M = 4
1 5 4 3
Output:
4
-1
1
-1
Explanation:
After inserting 1, 2, 1, 1, 1 and 4 into the queue, frequency of 1 is 4 and that of 4 is 1. Since 5 and 3 are not there in the queue we output -1 for them.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

// Helper class Geeks to implement 
// insert() and findFrequency()
class Geeks{
    static int[] arr=new int[1000000];
    // Function to insert element into the queue
    static void insert(Queue<Integer> q, int k){
        
        // Your code here
        q.add(k);
        
        // arr[k]+=1;
        
    }
    
    // Function to find frequency of an element
    // rteturn the frequency of k
    static int findFrequency(Queue<Integer> q, int k){
        
        // Your code here
        int count=0;
        
        for(Integer e:q){
            if(e==k){
                count++;
            }
        }
        
        return count;
        
    }
    
}
