package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * 数组中数字出现的次数 LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @since   2020-04-30 20:10:31
 */
public class L100320_数组中数字出现的次数_LCOF {
    static class Solution {
        public int[] singleNumbers(int[] nums) {
            int xor = 0;
            for (int n : nums) xor ^= n;
            int lastBit = xor - (xor & (xor-1));
            int n1 = 0, n2 = 0;
            for (int n : nums) {
                if ((lastBit & n) == 0) {
                    n1 ^= n;
                } else {
                    n2 ^= n;
                }
            }
            return new int[]{n1, n2};
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
