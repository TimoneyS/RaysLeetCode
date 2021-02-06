package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * ==========================================
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * Example:
 *      示例 1
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/two-sum/
 * @since   2020-02-13 17:46:36
 */
public class L0001_TwoSum {
    /**
     * 如果当前数字是 a，那么我们只要找到数组中所有的 target - a 的位置
     * 为了快速的寻找，可以用map建立数字和下标的映射
     */
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> remain = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (remain.containsKey(nums[i])) {
                    return new int[]{remain.get(nums[i]), i};
                }
                remain.put(target - nums[i], i);
            }
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
