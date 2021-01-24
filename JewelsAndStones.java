/**
https://leetcode.com/problems/jewels-and-stones/
 */


 class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        int len = S.length();
        while (len-- > 0) {
            if(J.contains(S.charAt(len)+"")) {
                count++;
            }
        }
        return count;
    }
}