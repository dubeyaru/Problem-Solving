/**
https://leetcode.com/problems/word-ladder/
 */

 class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        setA.add(beginWord);
        setB.add(endWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        return bfs(setA, setB, visited, wordSet);
    }
    
    private int bfs(Set<String> setA, Set<String> setB, Set<String> visited, Set<String> wordSet) {
        int length = 1;
        while (!setA.isEmpty() && !setB.isEmpty()) {
            Set<String> temp;
            if (setA.size() > setB.size()) {
                temp = setA;
                setA = setB;
                setB = temp;
            }
            temp = new HashSet<>();
            for (String word : setA) {
                char[] str = word.toCharArray();
                for (int i = 0; i < str.length; i++) {
                    char orig = str[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == orig) {
                            continue;
                        }
                        str[i] = ch;
                        String newWord = String.valueOf(str);
                        if (setB.contains(newWord)) {
                            return length + 1;
                        }
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            temp.add(newWord);
                        }
                        str[i] = orig;
                    }
                }
            }
            setA = temp;
            length++;
        }
        return 0;
    }
}