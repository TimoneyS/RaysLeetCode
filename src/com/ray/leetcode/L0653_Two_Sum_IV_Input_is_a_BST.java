package com.ray.leetcode;

import com.ray.leetcode.util.TreeNode;
import com.ray.util.Out;

/**
 * Two Sum IV - Input is a BST
 * -----------------------------------------------------------------------------
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example:
 *      Example 1
 *      Input: 
 *          5
 *         / \
 *        3   6
 *       / \   \
 *      2   4   7
 *      Target = 9
 *      Output: True
 *      Example 2
 *      Input: 
 *          5
 *         / \
 *        3   6
 *       / \   \
 *      2   4   7
 *      Target = 28
 *      Output: False
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * @since   2020-04-30 20:37:57
 */
public class L0653_Two_Sum_IV_Input_is_a_BST {
    static class Solution {
        public int[] twoSum(TreeNode root, int n) {
            return dfs(root, n, root);
        }

        int[] dfs(TreeNode node, int n, TreeNode root) {
            int[] rs = null;

            if (node == null) {

            } else if (findTarget(root, n-node.val, node)) {
                rs = new int[] {node.val, n-node.val};
            } else {
                rs = dfs(node.left, n, root);
                if (rs == null)
                    dfs(node.right, n, root);
            }

            return rs;
        }

        public boolean findTarget(TreeNode root, int n, TreeNode diff) {
            if (root == null) return false;
            if (root.val == n) {
                if (root != diff) {
                    return true;
                } else {
                    return findTarget(root.left, n, diff) || findTarget(root.right, n, diff);
                }
            } else if (root.val < n) {
                return findTarget(root.right, n, diff);
            } else {
                return findTarget(root.left, n, diff);
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
