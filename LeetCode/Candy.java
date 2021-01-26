/**
https://leetcode.com/problems/candy/
 */

 class Solution {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        return calculate(ratings);
    }
    
    private int calculate(int[] ratings) {
        int[] count = new int[ratings.length];
        count[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
        }
        int result = count[ratings.length - 1];
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                count[i - 1] = Math.max(count[i] + 1, count[i - 1]);
            }
            result += count[i - 1];
        }
        return result;
    }
}