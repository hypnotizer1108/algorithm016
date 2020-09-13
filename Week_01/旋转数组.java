// 思路：从左至右遍历数组中的每一个元素，将其放到移动后应该到达的目标位置，挤出目标位置的元素，同时被挤出的元素也要去找自己移动后应该到达的位置，挤出已经存在的元素，以此类推。
// 每一次遍历虽然看起来目的仅仅是为了把一个元素移动到目标位置，但是，会由此引发一轮多个元素移动，直到最后一个被挤出的元素移动后的目标位置正好等于本轮所遍历的这个元素移动前所在的位置时，说明本轮所有的元素都找到了自己的位置，就可以开始遍历下一个元素了。
class Solution {
	public static void rotate(int[] nums, int k) {
		int count = 0;// count表示已经换完的元素个数
		for (int start = 0; count < nums.length; start++) {
			// 当前元素的位置
			int curIndex = start;
			// 当前元素的值
			int curVal = nums[start];
            // 一个挤一个，被挤出的元素再去找自己应该在的位置。当最后一个元素移动后被放置到本轮第一个移动的元素最初所在的位置时，说明这一轮已经移动完毕，可以开始下一轮移动了，共有nums.length轮。
			do {
				// 当前元素移动后要存放的位置
				int targetIndex = (curIndex + k) % nums.length;
				// 记录下目标位置即将被替换的元素的旧值
				int temp = nums[targetIndex];
				// 把当前元素的值设置到目标位置
				nums[targetIndex] = curVal;
				// 将被挤出来的元素放到它移动后应该所在的位置
				curVal = temp;
				curIndex = targetIndex;
				count++;
			} while (start != curIndex);
		}
	}
}

// 方法二（空间复杂度O(n)，不符合O(1)的要求）：当前索引加上k之后对长度取模即可得到新的索引，遍历整个数组，计算出每个元素的新索引，然后逐个设置到新的位置上。
class Solution {
    public void rotate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            map.put(index, nums[i]);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[entry.getKey()] = entry.getValue();
        }
    }
}




