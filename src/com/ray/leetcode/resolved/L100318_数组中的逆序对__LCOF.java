package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * 数组中的逆序对  LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @since   2020-04-25 19:28:58
 */
public class L100318_数组中的逆序对__LCOF {

    /**
     * 平衡二叉树的解法
     */
    static class Solution {

        class Node {
            Node left;
            Node right;
            int index;
            int value;
            int count;
            public Node(int index, int value) {
                this.index = index;
                this.value = value;
                this.count = 1;
            }
        }

        Node root;

        // 排名
        private int order(Node n, int[] nums, int i) {
            if (n == null) {
                return 0;
            }
            return (less(i, n.index, nums[i], n.value)) ? order(n.left, nums, i) : count(n.left) + 1 + order(n.right, nums, i);
        }

        // 添加节点
        private Node add(Node n, int index, int value) {
            if (n == null) {
                return new Node(index, value);
            }
            // i < 当前节点
            if (less(index, n.index, value, n.value)) {
                n.left = add(n.left, index, value);
            } else {
                n.right = add(n.right, index, value);
            }
            if (count(n.left) - count(n.right) == 2) {
                // 左移动到右
                Node t = max(n.left);
                n.left = deleteMax(n.left);
                n.right = add(n.right, n.index, n.value);
                n.index = t.index;
                n.value = t.value;
            } else if (count(n.left) - count(n.right) == -2) {
                // 右移动到左
                Node t = min(n.right);
                n.right = deleteMin(n.right);
                n.left = add(n.left, n.index, n.value);
                n.index = t.index;
                n.value = t.value;
            }
            // 重新计数
            recount(n);
            return n;
        }

        private Node min(Node n) {
            return n.left == null ? n : min(n.left);
        }

        private Node max(Node n) {
            return n.right == null ? n : max(n.right);
        }

        // 删除最大
        private Node deleteMax(Node n) {
            if (n.right == null) return n.left;
            n.right = deleteMax(n.right);
            recount(n);
            return n;
        }

        private Node deleteMin(Node n) {
            if (n.left == null) return n.right;
            n.left = deleteMin(n.left);
            recount(n);
            return n;
        }

        private void recount(Node n) {
            n.count = 1 + count(n.left) + count(n.right);
        }

        // 判断两个索引的大小
        private boolean less(int i, int j, int vi, int vj) {
            return vi < vj || vi == vj && i < j;
        }

        private int count(Node n) {
            return n == null ? 0 : n.count;
        }

        public int reversePairs(int[] nums) {
            int rs = 0;
            for (int i = nums.length - 1; i >= 0; i --) {
                rs += order(root, nums, i);
                root = add(root, i, nums[i]);
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        Out.p(new Solution().reversePairs(nums));
    }
}
