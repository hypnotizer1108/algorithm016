// 从右向左遍历，对每一位进行加一，没有进位，则可以直接返回。遇到进位则当前位置为0，再看更高位。循环结束还没有return，说明原数组每一位都是9，需扩展长度，首位填1，其余位全部为0
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            // 没有进位，直接返回
            if (digits[i] != 0) {
                return digits;  
            }
        }
        // 最高位仍需进位
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}