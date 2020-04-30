package com.ray.leetcode.resolved;

import com.ray.leetcode.util.TreeNode;
import com.ray.util.Out;

/**
 * Trim a Binary Search Tree
 * -----------------------------------------------------------------------------
 * 
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 *
 * Example:
 *      Example 1
 *      Input: 
 *          1
 *         / \
 *        0   2
 *        L = 1
 *        R = 2
 *      Output: 
 *          1
 *            \
 *             2
 *      Example 2
 *      Input: 
 *          3
 *         / \
 *        0   4
 *         \
 *          2
 *         /
 *        1
 *        L = 1
 *        R = 3
 *      Output: 
 *            3
 *           / 
 *         2   
 *        /
 *       1
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 * @since   2020-04-30 20:30:37
 */
public class L0669_Trim_a_Binary_Search_Tree {
    /**
     *  如果 root 的值在二者之间，则 root 的位置不需要变更，
     *  如果 root 的值小于最小，则 root 和其左子树全部删除，新的根在右子树中
     *  如果 root 的值大于最大，则 root 和其右子树全部删除，新的根在左子树中
     */
    static class Solution {
        public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
            if (root == null) return root;
            if (root.val >= minimum && root.val <= maximum) {
                root.left = trimBST(root.left, minimum, maximum);
                root.right = trimBST(root.right, minimum, maximum);
                return root;
            } else if (root.val < minimum) {
                return trimBST(root.right, minimum, maximum);
            } else {
                return trimBST(root.left, minimum, maximum);
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
