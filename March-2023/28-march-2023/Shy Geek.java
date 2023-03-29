/******************************************************************************************************************************************************
-----------------------
Level- Medium
----------------------
Geek went to buy some chocolates from a nearby shop with k coins in his pocket. He found that the shop contains n chocolates which are arranged
in sorted order (increasing) of their prices.

Now geek wants to taste costlier chocolates so he decided that he will buy the costliest chocolate (of course among the ones that he can afford)
till there exists at least one type of chocolate he can afford. You may assume that there is an infinite supply of chocolates in the shop Geek visited.

As you know, Geek is a shy person and hence he will enquire about the prices of the chocolates at most 50 times from the shopkeeper. 
Now, your task is to find the number of chocolates he had enjoyed. 

Note: If you call the Shop.get function more than 50 times it will return -1. Price of chocolates are pairwise distinct.

---------------------------------------------------------------------------------------

Example 1:

Input:
3 5 
2 4 6

Output:
1

Explanation: The prices of chocolates are [2, 4, 6] and Geek had 5 coins with him. So he can only buy chocolate that costs 4 coins 
(since he always picks the costliest one).
Example 2:

Input:
4 9 
1 2 3 4

Output:
3

Explanation: The prices of chocolates are [1, 2, 3, 4] and Geek had 9 coins with him. So he can buy two chocolates that cost 4 coins.
Thereafter, he had only 1 coin with him, hence he will have 1 more chocolate (that costs 1 coin).

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

/*
Instructions - 

    1. 'shop' is object of class Shop.
    2. User 'shop.get(int i)' to enquire about the price
            of the i^th chocolate.
    3. Every chocolate in shop is arranged in increasing order
            i.e. shop.get(i) <= shop.get(i + 1) for all 0 <= i < n - 1
*/
class Solution{
    
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    static long find(int n, long k){
        // Return the number of chocolates Geek had
        // enjoyed out of 'n' chocolates availabe in the
        // 'shop'.
        
        int l = 0, h = n - 1;
        int count = 0;
      
        
         Map<Integer, Long> hm = new HashMap<>();
        while(k > 0)
        {
            l = 0;
            while(l <= h){
                int mid = l +(h-l)/2;
                long temp;
                
                if(hm.containsKey(mid))
                    temp = hm.get(mid);
                else
                    {
                        temp =shop.get(mid);
                         hm.put(mid, temp);
                    }
                
                if(temp <= k)
                    l = mid + 1;
                else 
                    h = mid - 1;
            }
            if(h == -1)
                break;
            count += (k/hm.get(h));
            
            k=  k%hm.get(h);
           
            
        }
        return count;
    }

}
