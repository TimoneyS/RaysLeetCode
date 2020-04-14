package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ray.util.Out;

/**
 * 描述：
 *      Check whether the original sequence `org` can be uniquely reconstructed from the sequences in `seqs`. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4. Reconstruction means building a shortest common supersequence of the sequences in `seqs` (i.e., a shortest sequence so that all sequences in `seqs` are subsequences of it). Determine whether there is only one sequence that can be reconstructed from `seqs` and it is the `org` sequence.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:org = [1,2,3], seqs = [[1,2],[1,3]]
 *      Output: false
 *      Explanation:
 *      [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
 *      ```
 *      Example 2:
 *      ```
 *      Input: org = [1,2,3], seqs = [[1,2]]
 *      Output: false
 *      Explanation:
 *      The reconstructed sequence can only be [1,2].
 *      ```
 *      Example 3:
 *      ```
 *      Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
 *      Output: true
 *      Explanation:
 *      The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 *      ```
 *      Example 4:
 *      ```
 *      Input:org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 *      Output:true
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sequence-reconstruction/description
 * @date   2019-07-11 18:34:27
 */
public class L_0605_Sequence_Reconstruction {

    /**
     * 原始的序列构成图的一个路径，序列表构成一张具体的图
     * 这张具体的图，拓扑排序的顺序只有一个，且就是原始序列
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean sequenceReconstruction(int[] org, int[][] seqs) {
            Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
            Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
            
            for (int num : org) {
                graph.put(num, new HashSet<Integer>());
                indegree.put(num, 0);
            }

            int n = org.length, count = 0;
            for (int[] seq : seqs) {
                count += seq.length;
                if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n)) return false;
                for (int i = 1; i < seq.length; i++) {
                    if (seq[i] <= 0 || seq[i] > n) return false;
                    if (graph.get(seq[i - 1]).add(seq[i]))
                        indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }

            // case: [1], []
            if (count < n) return false;
            
            Queue<Integer> q = new ArrayDeque<Integer>();
            for (int key : indegree.keySet()) 
                if (indegree.get(key) == 0)
                    q.add(key);
            
            int cnt = 0;
            while (q.size() == 1) {
                int ele = q.poll();
                for (int next : graph.get(ele)) {
                    indegree.put(next, indegree.get(next) - 1);
                    if (indegree.get(next) == 0) q.add(next);
                }
                if (ele != org[cnt]) {
                    return false;
                }
                cnt++;
            }
            
            return cnt == org.length;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
