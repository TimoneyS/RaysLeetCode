package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Hamming Distance
 * -----------------------------------------------------------------------------
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *      Example 1
 *      Input: x = 1, y = 4
 *      Output: 2
 *      Explanation:
 *      1   (0 0 0 1)
 *      4   (0 1 0 0)
 *             &uarr;   &uarr;
 *      The above arrows point to positions where the corresponding bits are different.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/hamming-distance/
 * @since   2020-04-15 23:11:42
 */
public class L0461_Hamming_Distance {
    static class Solution {
        public int hammingDistance(int x, int y) {
            int d = 0;
            while (x+y != 0) {
                if ((x % 2) != (y % 2)) d++;
                x /= 2;
                y /= 2;
            }
            return d;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
