package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.*;

/**
 * 15.三数之和
 * ==========================================
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * Example:
 *      示例 1
 *      给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *      满足要求的三元组集合为：
 *      [
 *        [-1, 0, 1],
 *        [-1, -1, 2]
 *      ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/3sum/
 * @since   2020-02-24 23:32:10
 */
public class L0015_3Sum {
    /**
     * 若 S[i] + S[j] + S[k] = 0
     * 则 S[i] =  - (S[j] + S[k])
     * 问题可以转化为若干个 TwoSum 问题
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rs = new ArrayList<>();
            for (int i = 0; i < nums.length; i ++) {
                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                twoSum(nums, i, rs);
            }
            return rs;
        }

        private void twoSum(int[] nums, int start, List<List<Integer>> rs) {
            Set<Integer> walked = new HashSet<>();
            Set<Integer> unique = new HashSet<>();
            for (int i = start + 1; i < nums.length; i++) {
                if (walked.contains(-nums[start] - nums[i]) && !unique.contains(nums[i])) {
                    unique.add(nums[i]);
                    rs.add(Arrays.asList(nums[start], -nums[start] - nums[i], nums[i]));
                }
                walked.add(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        Out.p(new Solution().threeSum(nums));
    }
}
