/**
https://leetcode.com/problems/plus-one/
 */

 class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int len = digits.length - 1;
        digits[len] = digits[len] + 1;
        carry = digits[len] / 10;
        digits[len] = digits[len] % 10;
        len--;
        while (len >= 0 && carry > 0) {
            digits[len] = digits[len] + carry;
            carry = digits[len] / 10;
            digits[len] = digits[len] % 10;
            len--;
        }
        if (carry == 0) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = carry;
        for (int i = 1; i < result.length; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }
}