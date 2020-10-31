// 方法1.单向BFS
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