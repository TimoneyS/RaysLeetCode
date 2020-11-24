package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.*;

/**
 * 1217.数组的相对排序
 * ==========================================
 * 给你两个数组，arr1 和 arr2，
 * 	arr2 中的元素各不相同
 * 	arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *  
 *
 * Example:
 *      示例 1
 *      输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 *      输出：[2,2,2,1,4,3,3,9,6,7,19]
 *       
 *      提示：
 *      	arr2 中的元素 arr2[i] 各不相同
 *      	arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/relative-sort-array/
 * @since   2020-11-25 00:07:16
 */
public class L1217_Relative_Sort_Array {
    static class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr2.length; i ++) {
                map.put(arr2[i], i);
            }
            List<Integer> l = new ArrayList<>(arr1.length);
            Arrays.stream(arr1).forEach(l::add);
            l.sort((i, j) -> {
                if (map.containsKey(i) && map.containsKey(j)) {
                    return map.get(i) - map.get(j);
                } else if (map.containsKey(i)) {
                    return -1;
                } else if (map.containsKey(j)) {
                    return 1;
                } else {
                    return i-j;
                }
            });

            for (int i = 0; i < arr1.length; i ++) {
                arr1[i] = l.get(i);
            }

            return arr1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
