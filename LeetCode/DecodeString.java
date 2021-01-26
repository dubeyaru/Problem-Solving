/**
https://leetcode.com/problems/decode-string/
 */

class Solution {
    public String decodeString(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<Integer> stackCt = new Stack<Integer>();
        Stack<StringBuilder> stackStr = new Stack<StringBuilder>();
        char[] ch = s.toCharArray();
        StringBuilder result = new StringBuilder();
        stackStr.push(new StringBuilder());
        int i = 0;
        while (i < ch.length) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                int count = ch[i] - '0';
                i++;
                while (ch[i] >= '0' && ch[i] <= '9') {
                    count = count * 10 + (ch[i] - '0');
                    i++;
                }
                stackCt.push(count);
                stackStr.push(new StringBuilder());
            } else if (ch[i] == ']') {
                int number = stackCt.pop();
                String pat = stackStr.peek().toString();
                for (int j = 1; j < number; j++) {
                    stackStr.peek().append(pat);
                }
                String temp = stackStr.pop().toString();
                stackStr.peek().append(temp);
            } else {
                stackStr.peek().append(ch[i]);
            }
            i++;
        }
        return stackStr.pop().toString();
    }
}