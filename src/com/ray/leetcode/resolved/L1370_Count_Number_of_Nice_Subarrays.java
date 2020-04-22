package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Count Number of Nice Subarrays
 * -----------------------------------------------------------------------------
 * Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
 * Return the number of nice sub-arrays.
 *
 * Example:
 *      Example 1
 *      Input: nums = [1,1,2,1,1], k = 3
 *      Output: 2
 *      Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 *      Example 2
 *      Input: nums = [2,4,6], k = 1
 *      Output: 0
 *      Explanation: There is no odd numbers in the array.
 *      Example 3
 *      Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 *      Output: 16
 *      Constraints:
 *      	1 <= nums.length <= 50000
 *      	1 <= nums[i] <= 10^5
 *      	1 <= k <= nums.length
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * @since   2020-04-22 22:33:47
 */
public class L1370_Count_Number_of_Nice_Subarrays {
    static class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int rs = 0;
            for (int count = 0, i = -1, j = 0; j < nums.length; j ++) {
                // 统计奇数元素的个数
                if ((nums[j] & 1) == 1) {
                    count++;
                }
                // 如果统计奇数元素为 k，则左右指针离右侧最近的奇数距离的乘积就是子数组的个数
                if (count == k) {
                    count --;
                    // 统计左指针到最近的奇数的距离
                    int l = 1;
                    while (++i < nums.length && (nums[i] & 1) != 1) {
                        l++;
                    }
                    // 统计右指针到最近的奇数的距离（或者终点的距离）
                    int r = 1;
                    while (j + 1 <nums.length && (nums[j+1] & 1) != 1) {
                        j ++;
                        r ++;
                    }
                    rs += r * l;
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
