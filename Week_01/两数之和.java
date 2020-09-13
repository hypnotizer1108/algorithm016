// 方法一：暴力解法。
// 时间复杂度为O(n^2)，空间复杂度O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}

// 方法二：空间换时间，使用hashmap保存已经遍历过的数字的索引，当所需的数字在hashmap中存在时，说明已经找到，直接返回索引。
// 时间复杂度为O(n)，因为最多需要遍历完整个数组。最坏情况下每个元素都需要放入map，所以空间复杂度O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) { // 注意：题干说明假设每种输入只有一种答案，因此index小的在前
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}