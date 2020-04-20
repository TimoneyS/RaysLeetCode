package com.ray.leetcode.resolved;

import java.util.*;

/**
 * All O`one Data Structure
 * -----------------------------------------------------------------------------
 * Implement a data structure supporting the following operations:
 * Inc(Key) - Inserts a new key  with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/all-oone-data-structure/
 * @since   2020-04-20 23:35:04
 */
public class L0432_All_O_one_Data_Structure {
    static class AllOne {

        private static final class Node {
            private Node left;
            private Node right;
            private Set<String> keys;
            private int value;
            public Node(int value) {
                this.value = value;
                keys = new HashSet<>();
            }

            @Override
            public String toString() {
                return "Node{" +
                        "keys=" + keys +
                        ", value=" + value +
                        '}';
            }
        }

        private Node head;
        private Node tail;
        private Map<String, Node> nodes;

        public AllOne() {
            head = new Node(0);
            tail = new Node(Integer.MAX_VALUE);
            nodes = new HashMap<>();
            combine(head, tail);
        }

        // 增加 key 值
        public void inc(String key) {
            Node node = nodes.containsKey(key) ? nodes.get(key) : head;
            // 确保值为 node.value + 1 的结点存在
            if (node.right.value != node.value + 1) {
                Node n = new Node(node.value + 1);
                combine(n, node.right);
                combine(node, n);
            }
            // 将 key 加入到右侧
            node.right.keys.add(key);
            // 如果当前结点只有一个key，则删除结点
            if (node.keys.size() == 1) {
                combine(node.left, node.right);
            } else {
                node.keys.remove(key);
            }
            nodes.put(key, node.right);
        }

        // 减少 key 的值
        public void dec(String key) {
            Node node = nodes.get(key);
            if (node == null) {
                return;
            }
            // 确保左侧的结点的值是 node.value - 1
            if (node.left.value != node.value - 1) {
                combine(node.left, new Node(node.value - 1));
                combine(node.left.right, node);
            }

            // 如果当前的size是1 ，删除当前结点
            if (node.keys.size() == 1) {
                combine(node.left, node.right);
                nodes.remove(key);
            } else {
                node.keys.remove(key);
            }

            // 最终如果结点值不为 1 当将会移动到左侧一个结点
            if (node.value != 1) {
                node.left.keys.add(key);
                nodes.put(key, node.left);
            }
        }

        // 最大值
        public String getMaxKey() {
            return tail.left.keys.size() == 0 ? "" : tail.left.keys.iterator().next();
        }

        // 最小值
        public String getMinKey() {
            return head.right.keys.size() == 0 ? "" : head.right.keys.iterator().next();
        }

        private void combine(Node head, Node tail) {
            head.right = tail;
            tail.left = head;
        }
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();

        allOne.inc("1");
        allOne.inc("1");
        allOne.inc("1");
        allOne.inc("2");
        allOne.inc("2");
        allOne.inc("3");
        allOne.inc("3");
        allOne.dec("3");
        allOne.inc("4");
        allOne.dec("4");


    }
}
