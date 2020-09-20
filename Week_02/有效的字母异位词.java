// 方法一：比较排序后的字符串是否相等。
// 时间复杂度：O(nlogn)。排序的时间复杂度为nlogn，比较为n。
// 空间复杂度：O(n)。java的toCharArray()制作了一个字符串的拷贝，所以它花费O(n)额外的空间
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}

// 方法二（推荐解法）：时间复杂度O(n)，空间复杂度O(1)
// 由于题干说明只包含小写字母，故可以用一个长度为26的数组来记录a-z每个字符出现的次数。s中出现的字母数组对应为计数加1，t中出现的字母数组对应位计数减1。最后检查数组是否每一位都为0（0表示s和t中该字母出现的次数相同） 
// 熟悉并掌握这种技巧！！！对于这种数组中每个元素范围已确定（本题就是字母a-z）的情况，用一个数组来分别统计每个字符出现的次数，并且一个数组做+1操作，另一个数组做-1操作。
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}

// 方法三：基于方法二的变体，区别在于用map记录所有出现过的结果，当字符范围不确定时也适用。进阶题目即可用本方法解决。
// 时间复杂度O(n)，空间复杂度O(n), n是s和t所出现过的所有字符的种类 
// s中出现的字母对应位计数加1，t中出现的字母对应位计数减1。最后检查map中是否所有的value都为0（0表示s和t中该字母出现的次数相同） 
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char char1 = s.charAt(i);
            int preVal1 = map.getOrDefault(char1, 0);
            map.put(char1, ++preVal1);
            char char2 = t.charAt(i);
            int preVal2 = map.getOrDefault(char2, 0);
            map.put(char2, --preVal2);
        }
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {// 这里用lamda表达式也可以return map.values().stream().allMatch(v -> v == 0);
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}