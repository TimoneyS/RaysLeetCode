package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Fruit Into Baskets
 * -----------------------------------------------------------------------------
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * 	Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * 	Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * What is the total amount of fruit you can collect with this procedure?
 *
 * Example:
 *      Example 1
 *      Input: [1,2,1]
 *      Output: 3
 *      Explanation: We can collect [1,2,1].
 *      Example 2
 *      Input: [0,1,2,2]
 *      Output: 3
 *      Explanation: We can collect [1,2,2].
 *      If we started at the first tree, we would only collect [0, 1].
 *      Example 3
 *      Input: [1,2,3,2,2]
 *      Output: 4
 *      Explanation: We can collect [2,3,2,2].
 *      If we started at the first tree, we would only collect [1, 2].
 *      Example 4
 *      Input: [3,3,3,1,2,1,1,2,3,3,4]
 *      Output: 5
 *      Explanation: We can collect [1,2,1,1,2].
 *      If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 *      Note:
 *      	1 <= tree.length <= 40000
 *      	0 <= tree[i] < tree.length
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/fruit-into-baskets/
 * @since   2020-04-30 20:14:29
 */
public class L0940_Fruit_Into_Baskets {
    static class Solution {
        public int totalFruit(int[] tree) {
            // 准备两个篮子，每个篮子里记录该水果最后一次出现的位置
            // 算法保证第二个篮子中出现的是比较旧的水果，每次出现新水果就扔掉第二个篮子的水果，重新计算能够摘取的水果数量
            // 这样能够计算出到该位置为止，能够摘取的最大数量
            int basket1 = -1, basket2 = -1;
            int max = 0, curr = 0;
            for (int i = 0; i < tree.length; i ++) {
                if (basket1 >= 0 && tree[basket1] != tree[i]) {
                    // 水果可以放入第二个篮子
                    if (basket2 >= 0 && tree[basket2] != tree[i])
                        curr = i - basket2 - 1;
                    basket2 = basket1;
                }
                basket1 = i;
                max = Math.max(max, ++curr); // 可收集的水果+1
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
