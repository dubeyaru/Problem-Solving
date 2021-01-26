/**
https://leetcode.com/problems/isomorphic-strings/
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] t1 = new int[256];
        int[] t2 = new int[256];
        int N = s.length();
        for(int i = 0; i < N; i++) {
            if(t1[s.charAt(i)] != t2[t.charAt(i)]) {
                return false;
            }
            t1[s.charAt(i)] = i + 1;
            t2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}