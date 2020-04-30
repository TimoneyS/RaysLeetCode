package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Coin Change 2
 * -----------------------------------------------------------------------------
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 * Example:
 *      Example 1
 *      Input: amount = 5, coins = [1, 2, 5]
 *      Output: 4
 *      Explanation: there are four ways to make up the amount:
 *      5=5
 *      5=2+2+1
 *      5=2+1+1+1
 *      5=1+1+1+1+1
 *      Example 2
 *      Input: amount = 3, coins = [2]
 *      Output: 0
 *      Explanation: the amount of 3 cannot be made up just with coins of 2.
 *      Example 3
 *      Input: amount = 10, coins = [10] 
 *      Output: 1
 *      Note:
 *      You can assume that
 *      	0 <= amount <= 5000
 *      	1 <= coin <= 5000
 *      	the number of coins is less than 500
 *      	the answer is guaranteed to fit into signed 32-bit integer
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/coin-change-2/
 * @since   2020-04-22 22:39:22
 */
public class L0518_Coin_Change_2 {
    /**
     * 设 dp[i][j] 指到 i 为止，可以构成面值 j 的组合数
     *
     * dp[i][j] = dp[i-1][j] + dp[i][j-v[i]]
     *
     * dp[i][j] 的组合 包含 dp[i-1][j] 的所有组合
     * dp[i][j] 的组合 包含 dp[i][j-v[i]] 的每个组合加上一个 v[i] 后的组合，
     */
    static class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount+1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= amount; j++) {
                    dp[j] += coins[i] <= j ? dp[j-coins[i]] : 0;
                }
            }
            return dp[amount];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
