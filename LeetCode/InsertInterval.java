/**
https://leetcode.com/problems/insert-interval/
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        boolean flag = false;
        List<int[]> result = new ArrayList<int[]>();
        while (i < intervals.length) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                flag = true;
                break;
            } else if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else {
                flag = true;
                intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
                intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
                break;
            }
            i++;
        }
        
        if (flag) {
            int j = i + 1;
            while (j < intervals.length) {
                if (intervals[i][1] >= intervals[j][0]) {
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                } else {
                    result.add(intervals[i]);
                    i = j;
                }
                j++;
            }
            if (i < intervals.length) {
                result.add(intervals[i]);
            }
        } else {
            result.add(newInterval);
        }
        
        int[][] arr = new int[result.size()][2];
        i = 0;
        for (int[] each : result) {
            arr[i++] = each;
        }
        return arr;
    }
}