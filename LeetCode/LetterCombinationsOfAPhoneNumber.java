/**
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

class Solution {
    public List<String> letterCombinations(String digits) {
    	LinkedList<String> result = new LinkedList<String>();
        int dLen = digits.length();
        char[] digit = digits.toCharArray();
        if (dLen == 0) {
        	return result;
        }
        String[] map = new String[] {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        result.add("");
        while (result.peek().length() != dLen) {
        	String rem = result.remove();
        	String temp = map[digit[rem.length()] - '0'];
        	for (char c: temp.toCharArray()) {
        		result.addLast(rem + c);
        	}
        }
        return result;
    }
}