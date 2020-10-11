/**
 * 问题可以转换为：无向图中两个顶点之间的最短路径，通过广度优先遍历来求解
 * 1. 对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在字典中，键是通用状态，值是所有具有通用状态的单词。
 * 2. 将键值对 <beginWord，1> 放入队列中，1 代表节点的层次。我们需要返回 endWord 的层次也就是从 beginWord 出发的最短距离。
 * 3. 为了防止出现环，使用访问数组记录当前单词已访问过。
 * 4. 当队列中有元素的时候，取出第一个元素，记为 current_word。
 * 5. 找到 current_word 的所有通用状态，并根据这些通用状态得到其对应的单词列表w1，w2，即从currWord能达到给定字典中的list中的w1和w2
 * 6. w1和w2都和 current_word 相连，因此将他们加入到队列中。
 * 7. 对于新获得的所有单词，向队列中加入元素 (word, level + 1) 其中 level 是 current_word 的层次。
 * 8. 最终当你到达期望的单词，对应的层次就是最短变换序列的长度
 * 也就是一个广度优先遍历，因此需要借助 [队列] ，且要避免重复遍历
 */
class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 给定单词列表中不包括endword，直接返回
        if (!wordList.contains(endWord)) return 0;
        // 题目说明，每个单词长度相同
        int len = beginWord.length();
        // 处理给出的单词字典，转换为全部的通用状态及每个通配词映射的单词集合
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
        wordList.forEach(curWord -> {
            for (int i = 0; i < len; i++) {
                // 得到通配词
                String comboWord = curWord.substring(0, i) + "*" + curWord.substring(i + 1, len);
                // 从通配字典全集中拿到这个通配词对应的单词集合
                ArrayList<String> comboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<>());
                comboWordList.add(curWord);
                allComboDict.put(comboWord, comboWordList);
            }
        });
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        queue.add(new Pair<>(beginWord, 1));
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String currWord = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                // 从当前单词，得到len个通配词
                String currComboWord = currWord.substring(0, i) + "*" + currWord.substring(i + 1, len);
                // 拿到这个通配词映射的单词集合(也就是从当前单词一次转换能得到哪些单词)
                ArrayList<String> currComboWordList = allComboDict.getOrDefault(currComboWord, new ArrayList<>());
                for (String word : currComboWordList) {
                    // 包含目标单词，说明当前单词能一次转换到目标单词，经历的步骤数是当前单词的层级 + 1
                    if (word.equals(endWord))
                        return level + 1;
                    if (!visited.containsKey(word)){
                        queue.add(new Pair<>(word, level + 1));
                        visited.put(word, true);
                    }
                }
            }
        }
        return 0;
    }
}