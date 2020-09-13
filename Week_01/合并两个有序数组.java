// 最优解：p1指向数组1的尾部，p2指向数组2尾部，p始终指向当前两个数组尾部的两个元素中较大者要放入的位置。两两比较两个数组当前尾部的元素，较大者的值放在p处，然后将其对应的p1或者p2指向前一个元素。
// 时间复杂度O(m+n)，空间复杂度O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n -1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        // 循环结束，至少有一个数组中的元素已经全部合并到nums1，如果nums2已经合并完，说明已经是最终结果了，如果nums1合并完，但nums2还有未合并元素，则需要将nums2中p2及其之前的元素全部合并到nums1
        if (p2 >= 0) { //nums2还有元素没有合并到nums1，全部复制到nums1
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
}

// 暴力1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }
        for(int i = 0; i < n; i++) {
            list.add(nums2[i]);
        }
        list.sort(Integer::compare);
        for(int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
    }
}

// 暴力2
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
	    System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}