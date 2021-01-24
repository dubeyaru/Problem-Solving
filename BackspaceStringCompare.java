/**
https://leetcode.com/problems/backspace-string-compare/
 */

 class Solution {
    public boolean backspaceCompare(String S, String T) {
        return solveWithoutExtraMemory(S, T);
    }
    
    private boolean solve(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Stack<Character> st1 = new Stack<Character>();
        Stack<Character> st2 = new Stack<Character>();
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == '#' && !st1.isEmpty()) {
                st1.pop();
            } else if (c1[i] != '#') {
                st1.push(c1[i]);
            }
        }
        for (int i = 0; i < c2.length; i++) {
            if (c2[i] == '#' && !st2.isEmpty()) {
                st2.pop();
            } else if (c2[i] != '#') {
                st2.push(c2[i]);
            }
        }
        while (!st1.isEmpty() && !st2.isEmpty()) {
            char a = st1.pop();
            char b = st2.pop();
            if (a != b) {
                return false;
            }
        }
        if (st1.isEmpty() && st2.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean solveWithoutExtraMemory(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int back1 = 0, back2 = 0;
        while(i >= 0 || j >= 0){
            while(i >= 0 && (s1.charAt(i) == '#' || back1 > 0)) {
                if (s1.charAt(i) == '#'){
                    back1++;
                } else {
                    back1--;
                }
                i--;
            }
            while(j >= 0 && (s2.charAt(j) == '#' || back2 > 0)) {
                if(s2.charAt(j) == '#') {
                    back2++;
                } else {
                    back2--;
                }
                j--;
            }
            if(i < 0 || j < 0) 
                return i == j;
            if(s1.charAt(i) != s2.charAt(j)) 
                return false;
            i--;
            j--;
        }
        return i == j;
    }
}