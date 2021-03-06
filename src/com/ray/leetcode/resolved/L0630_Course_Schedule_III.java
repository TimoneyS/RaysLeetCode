package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Course Schedule III
 * -----------------------------------------------------------------------------
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
 *
 * Example:
 *      Example 1
 *      Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 *      Output: 3
 *      Explanation: 
 *      There're totally 4 courses, but you can take 3 courses at most:
 *      First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
 *      Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day. 
 *      Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day. 
 *      The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 *      Note:
 *      	The integer 1 <= d, t, n <= 10,000.
 *      	You can't take two courses simultaneously.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/course-schedule-iii/
 * @since   2020-04-30 20:34:42
 */
public class L0630_Course_Schedule_III {
    /**
     * 贪心算法
     *
     * 只要在截至日期内，课程的过程就像可以随意移动的滑块。
     * 这些滑块可以是按照顺序先后排列的，当遇到一个新的滑块，如果这个滑块不能和已经排列的滑块兼容，则用这个滑块替换最长的滑块。
     * 这样排列后的滑块整体会后移，后移长度为两个滑块之差。
     *
     *               ||||====             ========
     *               ====|||===           ===|||====
     *               =======||=      ==>  ======||==
     *               =========||          ========||=
     *               =====|||=====        |||==========
     *
     * 这样就构成了该截至日期内最优解。依次寻找每个截止日期的最优解，最终可以寻找到包含最后截至的课程的最优解，也就是问题的最优解。
     *
     *
     * dp[j] = dp[i] + 1 （课程 i 和 dp[i] 兼容）
     *         dp[j] = dp[i] （课程 i 和 dp[i] 不兼容，用课程 i 替换最大课程）
     */
    static class Solution {
        public int scheduleCourse(int[][] courses) {
            // 排序
            Arrays.sort(courses, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
            // PQ
            PriorityQueue<Integer> pq = new PriorityQueue<>( (o1, o2) -> o2- o1);
            int timeline = 0;
            for (int[] cours : courses) {
                if (cours[0] > cours[1]) continue;

                // 不兼容
                if (timeline + cours[0] > cours[1]) {
                    if (cours[0] < pq.peek()) {
                        timeline += cours[0] - pq.poll();
                        pq.add(cours[0]);
                    }
                } else {
                    timeline += cours[0];
                    pq.add(cours[0]);
                }

            }
            return pq.size();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
