package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Snapshot Array
 * -----------------------------------------------------------------------------
 * Implement a SnapshotArray that supports the following interface:
 * 	SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
 * 	void set(index, val) sets the element at the given index to be equal to val.
 * 	int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 * 	int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 *
 * Example:
 *      Example 1
 *      Input: [SnapshotArray,set,snap,set,get]
 *      [[3],[0,5],[],[0,6],[0,0]]
 *      Output: [null,null,0,null,5]
 *      Explanation: 
 *      SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 *      snapshotArr.set(0,5);  // Set array[0] = 5
 *      snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 *      snapshotArr.set(0,6);
 *      snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 *      Constraints:
 *      	1 <= length <= 50000
 *      	At most 50000 calls will be made to set, snap, and get.
 *      	0 <= index < length
 *      	0 <= snap_id < (the total number of times we call snap())
 *      	0 <= val <= 10^9
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/snapshot-array/
 * @since   2020-04-14 23:02:35
 */
public class L1249_Snapshot_Array {
    static class SnapshotArray {
        private int snap = 0;
        private List<TreeMap<Integer, Integer>> inner;

        public SnapshotArray(int length) {
            inner = new ArrayList<>();
            for (int i = 0; i < length; i ++) {
                TreeMap<Integer, Integer> treeMap = new TreeMap<>();
                treeMap.put(0, 0);
                inner.add(treeMap);
            }
        }

        public void set(int index, int val) {
            TreeMap<Integer, Integer> treeMap = inner.get(index);
            treeMap.put(snap, val);
        }

        public int snap() {
            return snap++;
        }

        public int get(int index, int snap_id) {
            TreeMap<Integer, Integer> treeMap = inner.get(index);
            return treeMap.floorEntry(snap_id).getValue();
        }
    }
    
    public static void main(String[] args) {
    }
}
