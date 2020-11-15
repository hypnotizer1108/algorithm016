// 1:将前一半索引为i的字符跟length - i - 1位置上的字符交换
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = tmp;
        }
    }
}

// 2:双指针，一个指向头，一个指向尾。交换left和right
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}