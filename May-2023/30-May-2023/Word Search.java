/******************************************************************************************************************************************************
--------------------------
Level- Medium
---------------------------
Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent cells only. 
ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.
___________________________________________________________________________________________________

Example 1:

Input: board = {{a,g,b,c},{q,e,e,l},{g,b,k,s}},
word = "geeks"
Output: 1
Explanation: The board is-
a g b c
q e e l
g b k s
The letters which are used to make the
"geeks" are colored.
Example 2:

Input: board = {{a,b,c,e},{s,f,c,s},{a,d,e,e}},
word = "sabfs"
Output: 0
Explanation: The board is-
a b c e
s f c s
a d e e
Same letter can not be used twice hence ans is 0

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


class Solution
{
    boolean adjacentSearch(char[][] board, String word, int i, int j, int len)
    {
        if(len == word.length())
            return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        if(board[i][j] != word.charAt(len))
            return false;
        board[i][j] = '*';
        boolean ans = 
            adjacentSearch(board, word, i-1, j, len+1) || //up
            adjacentSearch(board, word, i+1, j, len+1) || //down
            adjacentSearch(board, word, i, j-1, len+1) || //left
            adjacentSearch(board, word, i, j+1, len+1);   // right
        board[i][j] = word.charAt(len);
        return ans;
    }
    
    public boolean isWordExist(char[][] board, String word)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0) && adjacentSearch(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
}
