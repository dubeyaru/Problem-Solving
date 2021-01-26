/**
https://leetcode.com/problems/minimum-area-rectangle/
 */

 class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < points.length; i++) {
            if (!map.containsKey(points[i][0])) {
                map.put(points[i][0], new HashSet<Integer>());
            }
            map.get(points[i][0]).add(points[i][1]);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                    // ignoring points on the same line
                    continue;
                }
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    min = Math.min(min, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                }
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return min;
    }
}