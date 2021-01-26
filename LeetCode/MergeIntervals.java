/**
https://leetcode.com/problems/merge-intervals/
 */

class Solution {
    class ComparePair implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new ComparePair());
        List<int[]> result = new ArrayList<int[]>();
        int i = 0;
        int j = 1;
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
        
        int[][] arr = new int[result.size()][2];
        i = 0;
        for (int[] each : result) {
            arr[i++] = each;
        }
        return arr;
    }
}