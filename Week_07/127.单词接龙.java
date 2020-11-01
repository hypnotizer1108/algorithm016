// 1.BFS：从beginword向endword扩散，当转换后的新单词等于endword时，此时遍历的深度即为所求
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
		// 这里必须用set，否则后续检查目标单词在wordList中的时间复杂度是O(n)会超时
        Set<String> wordSet = new HashSet<>(wordList);
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {0
                String curWord = queue.remove();
                if (curWord.equals(endWord)) return level;
                // 这行代码很关键，相当于剪枝，去掉重复的计算，否则会超时
                if (visited.contains(curWord)) continue;
                for (int j = 0; j < curWord.length(); j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] chArr = curWord.toCharArray();
                        char oldCh = chArr[j];
                        chArr[j] = ch;
                        String newWord = new String(chArr);
                        // 转换后的单词在wordList中存在，且未被访问过
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(curWord);
                        }
                        chArr[j] = oldCh;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

// 2.单向BFS优化版，无需每次都从a-z遍历26次，用*占位符即可
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int len = beginWord.length();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        wordList.forEach(w -> {
            for (int i = 0; i < len; i++) {
                String comboWord = w.substring(0, i) + "*" + w.substring(i + 1, len);
                ArrayList<String> words = map.getOrDefault(comboWord, new ArrayList<>());
                words.add(w);
                map.put(comboWord, words);
            }
        });
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        queue.add(new Pair<>(beginWord, 1));
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                String comboWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                ArrayList<String> comboWords = map.getOrDefault(comboWord, new ArrayList<>());
                for (String curWord : comboWords) {
                    if (curWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(curWord)){
                        queue.add(new Pair<>(curWord, level + 1));
                        visited.put(curWord, true);
                    }
                }
            }
        }
        return 0;
    }
}

// 3.双向BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int len = 1;
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 始终bfs size小的那一端
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            
            Set<String> tmp = new HashSet<>();
            for (String word : beginSet) {
                char[] charArr = word.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = charArr[i];
                        charArr[i] = c;
                        String target = String.valueOf(charArr);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            tmp.add(target);
                            visited.add(target);
                        }
                        charArr[i] = old;
                    }
                }
            }
            beginSet = tmp;
            len++;
        }
        return 0;
    }
}