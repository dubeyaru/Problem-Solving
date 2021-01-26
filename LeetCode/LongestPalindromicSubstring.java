/**
https://leetcode.com/problems/longest-palindromic-substring/
 */

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        return solve(s, n);
    }
    
    private String solve(String s, int n) {
        int begin = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
            }
            while (right < n && s.charAt(i) == s.charAt(right)) {
                right++;
            }
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            if (right - left > end - begin) {
                end = right;
                begin = left;
            }
        }
        return s.substring(begin, end);
    }
}