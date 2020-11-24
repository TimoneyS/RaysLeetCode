package com.ray.leetcode.resolved;

import com.ray.util.Out;
import com.ray.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 653.两数之和 IV - 输入 BST
 * ==========================================
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * Example:
 *      示例 1
 *      输入: 
 *          5
 *         / \
 *        3   6
 *       / \   \
 *      2   4   7
 *      Target = 9
 *      输出: True
 *      示例 2
 *      输入: 
 *          5
 *         / \
 *        3   6
 *       / \   \
 *      2   4   7
 *      Target = 28
 *      输出: False
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * @since   2020-11-24 23:56:15
 */
public class L0653_Two_Sum_IV_Input_is_a_BST {
    static class Solution {
        public boolean findTarget(TreeNode root, int k) {
            return helper(new HashSet<>(), root, k);
        }

        private boolean helper(Set<Integer> walked, TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            if (walked.contains(k - root.val)) {
                return true;
            }
            walked.add(root.val);
            return helper(walked, root.left, k) || helper(walked, root.right, k);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
