package com.ray.leetcode.resolved;

import com.ray.leetcode.util.TreeNode;
import com.ray.util.Out;

/**
 * 对称的二叉树  LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @since   2020-04-14 22:59:11
 */
public class L100289_对称的二叉树__LCOF {
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            // 如果跟不为空，则看左右结点是否是镜像
            return root == null || isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode n1, TreeNode n2) {
            // 如果两个都不为空，则看 结点的左右子结点是否互相对称。
            return n1 == null || n2 == null ? n1 == n2 : n1.val == n2.val && isSymmetric(n1.right, n2.left) && isSymmetric(n1.left, n2.right);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
