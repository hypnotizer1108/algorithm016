## Trie树(前缀树、字典树)

字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排
序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

操作时间复杂度取决于单词的长度

#### 基本性质

- 结点本身不存完整单词
- 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
- 每个结点的所有子结点路径代表的字符都不相同

#### 代码模板
以[leetcode 208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description)为例，模板如下
```java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
		/** 题干已说明只会包含小写字母，故可以用一个长度为26的数组来记录下一个子母，要应对更通用的情况，可以使用map*/
        next = new Trie[26];
    }
	
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
	
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
	
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }
	
    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```

## 并查集

用来解决群组问题，解题套路相对固定，套代码模板即可

#### 代码模板
```Java
// Java
class UnionFind {
	private int count = 0;
	private int[] parent;
	public UnionFind(int n) {
		count = n;
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	public int find(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) return;
		parent[rootP] = rootQ;
		count--;
	}
}
```