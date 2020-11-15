class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        String[] words = s.trim().split(" +");// 按空格分隔，可以是多个连续的空格
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}