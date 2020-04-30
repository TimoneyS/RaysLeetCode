package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Sum of Square Numbers
 * -----------------------------------------------------------------------------
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example:
 *      Example 1
 *      Input: 5
 *      Output: True
 *      Explanation: 1 * 1 + 2 * 2 = 5
 *      Example 2
 *      Input: 3
 *      Output: False
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @since   2020-04-30 20:11:32
 */
public class L0633_Sum_of_Square_Numbers {
    static class Solution {
        public boolean judgeSquareSum(int c) {
            for (int i = 0; i <= Math.sqrt(c); i++) {
                int t = (int) Math.sqrt(c - i * i);
                if (t * t + i * i == c) return true;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
