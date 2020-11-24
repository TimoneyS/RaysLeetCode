package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 931.最大频率栈
 * ==========================================
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 * FreqStack 有两个函数：
 * 	push(int x)，将整数 x 推入栈中。
 * 	pop()，它移除并返回栈中出现最频繁的元素。
 * 		如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 *
 * Example:
 *      示例 1
 *      输入：
 *      [FreqStack,push,push,push,push,push,push,pop,pop,pop,pop],
 *      [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 *      输出：[null,null,null,null,null,null,null,5,7,5,4]
 *      解释：
 *      执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
 *      pop() -> 返回 5，因为 5 是出现频率最高的。
 *      栈变成 [5,7,5,7,4]。
 *      pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
 *      栈变成 [5,7,5,4]。
 *      pop() -> 返回 5 。
 *      栈变成 [5,7,4]。
 *      pop() -> 返回 4 。
 *      栈变成 [5,7]。
 *      提示：
 *      	对 FreqStack.push(int x) 的调用中 0 <= x <= 10^9。
 *      	如果栈的元素数目为零，则保证不会调用  FreqStack.pop()。
 *      	单个测试样例中，对 FreqStack.push 的总调用次数不会超过 10000。
 *      	单个测试样例中，对 FreqStack.pop 的总调用次数不会超过 10000。
 *      	所有测试样例中，对 FreqStack.push 和 FreqStack.pop 的总调用次数不会超过 150000。
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/maximum-frequency-stack/
 * @since   2020-11-25 00:04:48
 */
public class L0931_Maximum_Frequency_Stack {
    static class FreqStack {
        TreeMap<Integer, Node> chains = new TreeMap<>();
        HashMap<Integer, Integer> eleCount = new HashMap<>();
        static class Node {
            Node next;
            int value;

            @Override
            public String toString() {
                return value + " -> " + next;
            }
        }

        public void push(int x) {
            int count = 1;
            if (eleCount.containsKey(x)) {
                count = eleCount.get(x) + 1;
            }
            eleCount.put(x, count);
            Node node = new Node();
            node.value = x;
            if (chains.containsKey(count)) {
                node.next = chains.get(count);
            }
            chains.put(count, node);
        }

        public int pop() {
            if (chains.size() <= 0) {
                return  -1;
            }
            Map.Entry<Integer, Node> maxChain = chains.lastEntry();
            int level = maxChain.getKey();
            Node node = maxChain.getValue();
            int rs = node.value;
            eleCount.put(rs, eleCount.get(rs) - 1);
            if (node.next != null) {
                node = node.next;
                chains.put(level, node);
            } else {
                chains.remove(level);
            }
            return rs;
        }

        public static void main(String[] args) {
            FreqStack freqStack = new FreqStack();
            int[] arr = {5, 7, 5, 7, 4, 5};
            for (int i : arr) {
                freqStack.push(i);
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.println(freqStack.pop());
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p();
    }
}
