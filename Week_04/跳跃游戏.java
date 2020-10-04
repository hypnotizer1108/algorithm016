// 贪心：从后往前推。时间复杂度O(n)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        // 从后往前推
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果位置i可以跳到endReachable，更新endReachable为i
            if (i + nums[i] >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }
}