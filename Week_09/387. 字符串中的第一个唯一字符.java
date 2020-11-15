// 1.HashMap计数
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}

// 2.由于题目已说明只会包含26个小写字母，用一个长度为26的数组来计数即可
class Solution {
    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}