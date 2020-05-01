package com.ray.leetcode.resolved;

import com.ray.util.TreeNode;
import com.ray.util.Out;

/**
 * Subtree of Another Tree
 * -----------------------------------------------------------------------------
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example:
 *      Example 1
 *      Given tree s:
 *           3
 *          / \
 *         4   5
 *        / \
 *       1   2
 *      Given tree t:
 *         4 
 *        / \
 *       1   2
 *      Return true, because t has the same structure and node values with a subtree of s.
 *      Example 2
 *      Given tree s:
 *           3
 *          / \
 *         4   5
 *        / \
 *       1   2
 *          /
 *         0
 *      Given tree t:
 *         4
 *        / \
 *       1   2
 *      Return false.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @since   2020-05-08 22:40:33
 */
public class L0572_Subtree_of_Another_Tree {
    static class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null || t == null) return s == t;
            return equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean equals(TreeNode s, TreeNode t) {
            if (s == null || t == null) return s == t;
            return s.val == t.val && equals(s.right, t.right) && equals(s.left, t.left);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
