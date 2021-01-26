/**
https://leetcode.com/problems/swap-adjacent-in-lr-string/
 */

class Solution {
    public boolean canTransform(String start, String end) {
        String str = start.replaceAll("X", "");
        String pat = end.replaceAll("X", "");
        if (!str.equals(pat)) {
            return false;
        }
        int i = 0, j = 0;
        while (i < start.length() && j < end.length()) { 
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            while (j < end.length() && end.charAt(j) == 'X') {
                j++;
            }
            if (i == start.length() && j == end.length()) {
                return true;
            }
            if (i == start.length() || j == end.length()) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            } else if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}