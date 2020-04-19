package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Monotone Increasing Digits
 * -----------------------------------------------------------------------------
 * 
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x .)
 *
 * Example:
 *      Example 1
 *      Input: N = 10
 *      Output: 9
 *      Example 2
 *      Input: N = 1234
 *      Output: 1234
 *      Example 3
 *      Input: N = 332
 *      Output: 299
 *      Note:
 *      N is an integer in the range [0, 10^9].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/monotone-increasing-digits/
 * @since   2020-04-15 23:39:40
 */
public class L0738_Monotone_Increasing_Digits {
    static class Solution {
        public int monotoneIncreasingDigits(int num) {
            while (true) {
                if (isInc(num)) break;
                num --;
            }
            return num;
        }

        private boolean isInc(int num) {
            int prev = 9;
            while (true) {
                if (num % 10 > prev) return false;
                prev = num % 10;
                num = num /10;
                if (num == 0) break;
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
