/******************************************************************************************************************************************************
-----------------------
Level- Medium
---------------------
Given n ranges of the form [p, q] which denotes all the numbers in the range [p, p + 1, p + 2,...q]. 
Given another integer q denoting the number of queries. The task is to return the kth smallest element for each query (assume k>1) after 
combining all the ranges.
In case the kth smallest element doesn't exist return -1. 

___________________________________________________________________________________________________

Example 1:

Input:
n = 2, q = 3
range[] = {{1, 4}, {6, 8}}
queries[] = {2, 6, 10}
Output: 
2 7 -1
Explanation: 
After combining the given ranges, 
the numbers become 1 2 3 4 6 7 8. As here 2nd 
element is 2, so we print 2. As 6th element is 
7, so we print 7 and as 10th element doesn't 
exist, so weprint -1.
Example 2:

Input:
n = 2, q = 2
range[] = {{2, 6}, {5, 7}} 
queries[] = {5, 8}
Output: 
6 -1
Explantion: 
After combining the ranges, we'll take Union of 
range= {2,3,4,5,6,7}, here  5th smallest number 
will be 6 and 8th smallest number does not exists.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/





class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        Arrays.sort(range,new Comparator<int[]>(){
           public int compare(int[] a,int[] b)
           {
               return a[0]-b[0];
           }
        });
        List<int[]> list=new ArrayList<>();
        list.add(new int[]{range[0][0],range[0][1]});
        for(int i=1;i<n;i++)
        {
            if(list.get(list.size()-1)[1]>=range[i][0])
            {
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],range[i][1]);
            }else
            {
                list.add(new int[]{range[i][0],range[i][1]});
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<q;i++)
        {
            int el=queries[i];
            boolean flag=false;
            for(int j=0;j<list.size();j++)
            {
                int size=list.get(j)[1]-list.get(j)[0]+1;
                if(size<el)
                el-=size;
                else
                {
                    res.add(list.get(j)[0]+el-1);
                    flag=true;
                    break;
                }
            }
            if(!flag)res.add(-1);
        }
        return res;
    }
}
        
