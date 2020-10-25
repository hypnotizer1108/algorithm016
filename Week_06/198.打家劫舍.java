// 解法1：dp[i]表示从1号房屋到到第i+1（i是下标）号房能偷到的最高金额，由于不能连续偷两间，所以dp[i]能偷到的最大金额要么是dp[i - 2] + nums[i]，要么是dp[i - 1]，取二者中较大者。
// 时间复杂度O(n)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}

// 解法2：空间优化
// 不需要保存全部状态，只需要用两个变量记录dp[i-2]和dp[i-1]的值
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(first + nums[i], second);
            first = second;
            second = current;
        }
        return second;
    }
}