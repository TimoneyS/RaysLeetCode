package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Open the Lock
 * -----------------------------------------------------------------------------
 * 
 * You have a lock in front of you with 4 circular wheels.  Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.  The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.  Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 * Example:
 *      Example 1
 *      Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 *      Output: 6
 *      Explanation:
 *      A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 *      Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 *      because the wheels of the lock become stuck after the display becomes the dead end "0102".
 *      Example 2
 *      Input: deadends = ["8888"], target = "0009"
 *      Output: 1
 *      Explanation:
 *      We can turn the last wheel in reverse to move from "0000" -> "0009".
 *      Example 3
 *      Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 *      Output: -1
 *      Explanation:
 *      We can't reach the target without getting stuck.
 *      Example 4
 *      Input: deadends = ["0000"], target = "8888"
 *      Output: -1
 *      Note:
 *      The length of deadends will be in the range [1, 500].
 *      target will not be in the list deadends.
 *      Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/open-the-lock/
 * @since   2020-04-15 23:19:01
 */
public class L0753_Open_the_Lock {
    /**
     * A * 算法
     *
     * 记录每个状态从0状态而来需要转动的次数和预期转动到目标状态所需的次数 step + diff
     * 每次选择 step+diff 最小的状态。
     * 每个状态可以到达新的8个状态，这些状态中有些是无效的（会锁住，或者一定达到过的状态）。
     * 将这些新的状态加入队列
     */
    static class Solution {

        class Phase {
            int   steps;
            int   diff;
            String   stat;
            public Phase(int steps, int diff, String stat) {
                this.steps = steps;
                this.stat = stat;
                this.diff = diff;
            }
            @Override
            public String toString() {
                return stat;
            }
        }

        public int openLock(String[] deadends, String target) {
            HashSet<String> marked = new HashSet<>();
            for (String dn : deadends) marked.add(dn);

            PriorityQueue<Phase> pq = new PriorityQueue<>((p1, p2) -> p1.steps+p1.diff - p2.steps - p2.diff);
            if (marked.contains("0000")) return -1;


            pq.add(new Phase(0, diff("0000", target), "0000"));
            marked.add("0000");

            while (!pq.isEmpty()) {
                Phase p = pq.poll();
                if (p.stat.equals(target)) {
                    return p.steps;
                }
                if (marked.contains(target)) continue;
                adj(p, target, pq, marked);
            }

            return -1;
        }

        private void adj(Phase p, String target, PriorityQueue<Phase> pq, HashSet<String> marked) {
            for (int i = 0; i < 4; i++) {
                String next = next(p.stat, i, true);
                if (!marked.contains(next)) {
                    marked.add(next);
                    pq.add(new Phase(p.steps+1, diff(next, target), next));
                }
                next = next(p.stat, i, false);
                if (!marked.contains(next)) {
                    marked.add(next);
                    pq.add(new Phase(p.steps+1,diff(next, target), next));
                }
            }
        }

        private String next(String s1, int i, boolean flag) {
            char c = s1.charAt(i);
            if (flag) {
                if (c == '9') c = '0';
                else c = (char) (c + 1);
            } else {
                if (c == '0') c = '9';
                else c = (char)(c - 1);
            }
            return s1.substring(0,i) + c + s1.substring(i+1);
        }

        private int diff(String s1, String s2) {
            int diff = 0;
            for (int i = 0; i < s1.length(); i++) {
                diff += Math.abs(s1.charAt(i) - s2.charAt(i));
            }
            return diff;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
