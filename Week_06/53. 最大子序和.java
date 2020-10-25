// 以指定位置结尾为连续数组的最大子序和要么是以前一个位置结尾的连续数组的最大子序和加上当前位置的元素得到的新值，要么就是当前位置的元素。dp[i] = max(dp[i-1]+nums[i], nums[i]),所求结果是dp状态数组中的最大值

// 解法1：最基本的DP，用dp数组记录状态。
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// 解法2：空间优化：由于dp与nums长度相同，且对于每一个dp[i]，只在遍历该元素时进行修改，处理后面元素的过程中不会再更改dp[i]的值，所以可以在遍历nums的过程中直接修改nums[i]，用nums来保存状态，节省dp数组额外占用的空间
// 时间复杂度O(n),空间复杂度O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}

// 解法3：空间优化。由于dp[i]的结果只跟dp[i-1]和nums[i]有关，不需要记录全部状态，只需用一个变量记录上一个状态即可。
// 时间复杂度O(n),空间复杂度O(1)
class Solution {
    public int maxSubArray(int[] nums) {
		int pre = 0, max = nums[0];
        for (int i : nums.length) {
            pre = Math.max(pre + i, pre);
            max = Math.max(max, pre);
        }
        return max;
    }
}

