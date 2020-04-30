package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Reordered Power of 2
 * -----------------------------------------------------------------------------
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 *
 * Example:
 *      Example 1
 *      Input: 1
 *      Output: true
 *      Example 2
 *      Input: 10
 *      Output: false
 *      Example 3
 *      Input: 16
 *      Output: true
 *      Example 4
 *      Input: 24
 *      Output: false
 *      Example 5
 *      Input: 46
 *      Output: true
 *      Note:
 *      	1 <= N <= 10^9
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reordered-power-of-2/
 * @since   2020-04-30 20:15:02
 */
public class L0900_Reordered_Power_of_2 {
    /**
     * 暴力算法
     */
    static class Solution {
        public boolean reorderedPowerOf2(int N) {
            int n = 1;
            for (int i = 0; i < 32; i ++) {
                if (match(n, N)) {
                    return true;
                }
                n <<= 1;
            }
            return false;
        }

        private boolean match(int n, int N) {
            if ((int)Math.log10(n) != (int)Math.log10(N)) {
                return false;
            }
            int size = 0;
            int[] arr = new int[10];
            while ( n != 0) {
                arr[n % 10] ++;
                n /= 10;
                size ++;
            }
            while ( N != 0) {
                int k = N % 10;
                if (arr[k] > 0) {
                    arr[k] --;
                    size --;
                }
                N /= 10;
            }
            return size == 0;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
