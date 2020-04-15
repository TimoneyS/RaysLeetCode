package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Reach a Number
 * -----------------------------------------------------------------------------
 * 
 * You are standing at position 0 on an infinite number line.  There is a goal at position target.
 * On each move, you can either go left or right.  During the n-th move (starting from 1), you take n steps.
 * Return the minimum number of steps required to reach the destination.
 *
 * Example:
 *      Example 1
 *      Input: target = 3
 *      Output: 2
 *      Explanation:
 *      On the first move we step from 0 to 1.
 *      On the second step we step from 1 to 3.
 *      Example 2
 *      Input: target = 2
 *      Output: 3
 *      Explanation:
 *      On the first move we step from 0 to 1.
 *      On the second move we step  from 1 to -1.
 *      On the third move we step from -1 to 2.
 *      Note:
 *      target will be a non-zero integer in the range [-10^9, 10^9].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reach-a-number/
 * @since   2020-04-15 23:17:35
 */
public class L0755_Reach_a_Number {
    /**
     * 技巧性题目，灵活度较大
     * 首先一次相加直到和大于目标，比较差值，如果是偶数，说明只需要将几个数又加号变为减号（里外里2倍，所以一定是偶数），
     * 若是奇数，就要想办法制造1，减去一个奇数加上下一个偶数即可，所以如果当前n是个奇数，就需要加上下一个偶数，
     * 如果当前是个偶数就需要减去下一个奇数，加上下一个偶数
     */
    static class Solution {
        public int reachNumber(int target) {
            long t = Math.abs(target);
            long n = (long) Math.ceil((-1.0 + Math.sqrt(1 + 8.0 * t)) / 2);

            long sum = n * (n + 1) / 2;
            long diff = sum - target;
            if (diff == 0) {
                return (int)n;
            } else if (diff % 2 == 0) {
                return (int)n;
            } else if ((diff + n + 1) % 2 == 0) {
                return (int)n + 1;
            } else {
                return (int)n + 2;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
