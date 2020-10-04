// 先找到元素'1'，计数加一，然后通过dfs将周围所有'1'替换成'0'以免后续重复计数
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // 递归地将某一个值为'1'周围的'1'设置为'0'，表示该处已经处理过
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int i, int j, char[][] grid) {
        // 检查边界
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }
}