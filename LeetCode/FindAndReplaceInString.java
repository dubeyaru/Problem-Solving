/**
https://leetcode.com/problems/find-and-replace-in-string/
 */

class Solution {
    class Info implements Comparable<Info> {
        int index;
        String source;
        String dest;
        
        Info(int index, String source, String dest) {
            this.index = index;
            this.source = source;
            this.dest = dest;
        }
        @Override
        public int compareTo(Info info) {
            return Integer.compare(this.index, info.index);
        }
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (indexes.length == 0) {
            return S;
        }
        Info[] info = new Info[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            info[i] = new Info(indexes[i], sources[i], targets[i]);
        }
        Arrays.sort(info);
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int i = 0; i < indexes.length; i++) {
            if (info[i].index > prev) {
                sb.append(S.substring(prev, info[i].index));
            }
            int len = info[i].source.length();
            if (S.substring(info[i].index, info[i].index + len).equals(info[i].source)) {
                sb.append(info[i].dest);
                prev = info[i].index + len;
            } else {
                prev = info[i].index;
            }
        }
        int strLen = S.length();
        if (prev < strLen) {
            sb.append(S.substring(prev));
        }
        return sb.toString();
    }
}