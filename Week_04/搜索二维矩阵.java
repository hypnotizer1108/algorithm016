// 虽然题目看起来是个二维矩阵，但是由于其满足二分查找的三个前提条件，所以可以通过二分法来查找
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            int midVal = matrix[midIndex / n][midIndex % n];
            if (target == midVal) return true;
            if (target < midVal) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }
        return false;
    }
}