package com.ray.leetcode.resolved;

import com.ray.util.TreeNode;
import com.ray.util.Out;

import java.util.*;

/**
 * Vertical Order Traversal of a Binary Tree
 * -----------------------------------------------------------------------------
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 *
 * Example:
 *      Example 1
 *      Input: [3,9,20,null,null,15,7]
 *      Output: [[9],[3,15],[20],[7]]
 *      Explanation: 
 *      Without loss of generality, we can assume the root node is at position (0, 0):
 *      Then, the node with value 9 occurs at position (-1, -1);
 *      The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 *      The node with value 20 occurs at position (1, -1);
 *      The node with value 7 occurs at position (2, -2).
 *      Example 2
 *      Input: [1,2,3,4,5,6,7]
 *      Output: [[4],[2],[1,5,6],[3],[7]]
 *      Explanation: 
 *      The node with value 5 and the node with value 6 have the same position according to the given scheme.
 *      However, in the report [1,5,6], the node value of 5 comes first since 5 is smaller than 6.
 *      Note:
 *      	The tree will have between 1 and 1000 nodes.
 *      	Each node's value will be between 0 and 1000.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 * @since   2020-04-14 23:07:24
 */
public class L1029_Vertical_Order_Traversal_of_a_Binary_Tree {
    /**
     * 广度优先遍历，使用 TreeMap记录元素的相对的垂直索引。
     */
    static class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            TreeMap<Integer, List<Integer>> map = new TreeMap<>();

            Map<TreeNode, Integer> verticalIndex = new HashMap<>();
            Map<TreeNode, Integer> horizonIndex = new HashMap<>();

            PriorityQueue<TreeNode> pq = new PriorityQueue<>((a, b) -> {
                int c = verticalIndex.get(a) - verticalIndex.get(b);
                return c == 0 ? a.val - b.val : c;
            });
            if (root != null) {
                verticalIndex.put(root, 0);
                horizonIndex.put(root, 0);
                pq.offer(root);
            }
            while (!pq.isEmpty()) {
                TreeNode node = pq.poll();

                int hindex = horizonIndex.remove(node);
                int vindex = verticalIndex.remove(node);

                map.putIfAbsent(hindex, new ArrayList<>());
                map.get(hindex).add(node.val);

                if (node.left != null) {
                    horizonIndex.put(node.left, hindex - 1);
                    verticalIndex.put(node.left, vindex + 1);
                    pq.offer(node.left);
                }
                if (node.right != null) {
                    horizonIndex.put(node.right, hindex + 1);
                    verticalIndex.put(node.right, vindex + 1);
                    pq.offer(node.right);
                }
            }
            return new ArrayList<>(map.values());
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
