// 思路：由于只包含小写字母，每一个trieNode都维护了一个长度为26的TrieNode数组，下一个字母为a-z的节点
// 如果前缀不限于小写字母，甚至数量不定，可以把TrieNode的属性next从数组改为Map<String, TrieNode>
class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.contains(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

    private static class TrieNode {
        private static final int CAPACITY = 26;
        private TrieNode[] next;
        private boolean end;

        public TrieNode() {
            next = new TrieNode[CAPACITY];
        }

        public boolean contains(char ch) {
            return next[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            next[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return next[ ch - 'a'];
        }

        public void setEnd() {
            end = true;
        }

        public boolean isEnd() {
            return end;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */