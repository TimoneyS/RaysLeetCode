package com.ray.leetcode.resolved;

import com.ray.util.Out;
import com.ray.util.TreeNode;

/**
 * Sum Root to Leaf Numbers
 * -----------------------------------------------------------------------------
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,3]
 *          1
 *         / \
 *        2   3
 *      Output: 25
 *      Explanation:
 *      The root-to-leaf path 1->2 represents the number 12.
 *      The root-to-leaf path 1->3 represents the number 13.
 *      Therefore, sum = 12 + 13 = 25.
 *      Example 2
 *      Input: [4,9,0,5,1]
 *          4
 *         / \
 *        9   0
 *       / \
 *      5   1
 *      Output: 1026
 *      Explanation:
 *      The root-to-leaf path 4->9->5 represents the number 495.
 *      The root-to-leaf path 4->9->1 represents the number 491.
 *      The root-to-leaf path 4->0 represents the number 40.
 *      Therefore, sum = 495 + 491 + 40 = 1026.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * @since   2020-03-07 13:03:33
 */
public class L0129_Sum_Root_to_Leaf_Numbers {
    /**
     * 直接遍历，比计算路径构成的数字
     * 只有叶子结点才反馈路径和
     */
    static class Solution {
        public int sumNumbers(TreeNode root) {
            return sum(root, 0);
        }

        int sum(TreeNode root, int base) {
            if (root == null) {
                return 0;
            }
            base = base * 10 +root.val;
            if (root.left == null && root.right == null) {
                return base;
            }
            return sum(root.left, base) + sum(root.right, base);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("{4,9,0,5,1}");
        Out.p(new Solution().sumNumbers(root));
    }
}
