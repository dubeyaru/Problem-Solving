/**
https://leetcode.com/problems/bulls-and-cows/
 */

class Solution {
    public String getHint(String secret, String guess) {
        int[] secretCt = new int[10];
        int[] guessCt = new int[10];
        int sLen = secret.length();
        int gLen = guess.length();
        int i = 0;
        int j = 0;
        int bullCount = 0;
        while (i < sLen && j < gLen) {
            char s = secret.charAt(i);
            char g = guess.charAt(j);
            if (s == g) {
                bullCount++;
            } else {
                secretCt[s - '0']++;
                guessCt[g - '0']++;
            }
            i++;
            j++;
        }
        while (i < sLen) {
            secretCt[secret.charAt(i) - '0']++;
            i++;
        }
        while (j < gLen) {
            guessCt[guess.charAt(j) - '0']++;
            j++;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(bullCount + "A");
        sb.append(findCowCount(secretCt, guessCt) + "B");
        return sb.toString();
    }
    
    private int findCowCount (int[] s, int[] g) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count += Math.min(s[i], g[i]);
        }
        return count;
    }
}