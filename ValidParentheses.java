/**
https://leetcode.com/problems/valid-parentheses/
 */

 class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        return solve(s.toCharArray());
    }
    
    private boolean solve(char[] ch) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                st.push(ch[i]);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    char c = st.pop();
                    if (c == '(' && ch[i] != ')') {
                        return false;
                    }
                    if (c == '{' && ch[i] != '}') {
                        return false;
                    }
                    if (c == '[' && ch[i] != ']') {
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}