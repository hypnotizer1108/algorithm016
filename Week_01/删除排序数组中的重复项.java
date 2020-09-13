// 双指针法：慢指针i记录已经保存的非重复数的位置，j是遍历数组的快指针。
// 由于只需遍历整个数组一次，时间复杂度为O(n)，空间复杂度O(1) */
class Solution {
    public int removeduplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 慢指针i表示已经记录的非重复元素的位置
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // 当nums[j]与nums[i]不相同，则说明已经找到新的不重复元素，需要放在i+1的位置
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;// 长度为最后一个非0元素的索引+1
    }
}