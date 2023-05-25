/******************************************************************************************************************************************************
-----------------
Level- Hard
-----------------
Given a string S that contains only digits (0-9) and an integer target, return all possible strings to insert the 
binary operator ' + ', ' - ', or ' * ' between the digits of S so that the resultant expression evaluates to the target value.

Note:

Operands in the returned expressions should not contain leading zeros. For example, 2 + 03 is not allowed whereas 20 + 3 is fine. 
It is allowed to not insert any of the operators.

If no solution is found, return an empty string array.

___________________________________________________________________________________________________

Example 1:

Input:
S = "123"
target = 6
Output: { "1*2*3", "1+2+3"}
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

Example 2:

Input:
S = "3456237490"
target = 9191
Output: { } 
Explanation: There are no expressions that can be created from "3456237490"  to evaluate to 9191.

Example 3:

Input:
S = "12"
target = 12
Output: { "12"} 
Explanation: S itself matches the target. No other strings are possible.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



class Solution {
    public static ArrayList<String> addOperators(String S, int target) {
        // code here
         ArrayList<String> result = new ArrayList<>();
        backtrack(result, S, target, "", 0, 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, String num, int target, String expr, int index, long eval, long prev) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break; // Avoid leading zeros in operands
            }

            long current = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                backtrack(result, num, target, expr + current, i + 1, current, current);
            } else {
                backtrack(result, num, target, expr + "+" + current, i + 1, eval + current, current);
                backtrack(result, num, target, expr + "-" + current, i + 1, eval - current, -current);
                backtrack(result, num, target, expr + "*" + current, i + 1, eval - prev + prev * current, prev * current);
            }
        }
    }
}
