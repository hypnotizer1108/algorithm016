// 与198.打家劫舍（https://leetcode-cn.com/problems/house-robber/）唯一区别在于环状结构，首尾不能同时取，问题转化为不偷第一间时198题的解和不偷最后一间时198题的解，取二者中较大者即为本题解
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int excludeFirst = myRob(Arrays.copyOfRange(nums, 1, nums.length));
        int excludeLast = myRob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        return Math.max(excludeFirst, excludeLast);
    }

    private int myRob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(second, first + nums[i]);
            first = second;
            second = current;
        }
        return second;
    }
}