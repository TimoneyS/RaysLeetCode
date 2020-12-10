package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.TreeMap;

/**
 * 164.最大间距
 * ==========================================
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 *
 * Example:
 *      示例 1
 *      输入: [3,6,9,1]
 *      输出: 3
 *      解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *      示例 2
 *      输入: [10]
 *      输出: 0
 *      解释: 数组元素个数小于 2，因此返回 0。
 *      说明:
 *      	你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 *      	请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/maximum-gap/
 * @since   2020-03-07 22:04:34
 */
public class L0164_Maximum_Gap {
    static class Solution {
        public int maximumGap(int[] nums) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            int max = 0;
            for (int i : nums) {
                if (map.get(i) == 1) {
                    map.remove(i);
                } else {
                    map.put(i, map.get(i)-1);
                }
                Integer u = map.higherKey(i);
                Integer l = map.lowerKey(i);
                if (u != null) {
                    max = Math.max(u - i, max);
                }
                if (l != null) {
                    max = Math.max(i - l, max);
                }
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {100,3,2,1};
        Out.p(new Solution().maximumGap(nums));
    }
}
