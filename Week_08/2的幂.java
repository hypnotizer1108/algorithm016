// 如果一个整数是2的幂次方，那么对应的二进制表示有且仅有一个1，所以打掉最低位的1之后值一定为0
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1 ) == 0;
    }
}