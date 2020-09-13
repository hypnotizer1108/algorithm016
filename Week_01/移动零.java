// 双指针，慢指针始终指向下一个非零元素应该放入的位置，快指针遍历整个数组
// 时间复杂度为O(n)，因为最多只需要遍历整个数组一次。空间复杂度O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                // 注意：当前位置已经是非0元素，则无需处理
                if (i != j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                // 每找到一个非0元素并处理完成后，i指向下一个位置
                i++;
            }
        }
    }
}