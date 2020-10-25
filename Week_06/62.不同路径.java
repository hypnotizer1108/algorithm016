// 从终点位置分析，最下面一行以及最右边一列都只有一种走法，其余位置每个格子的走法都等于右边相邻格子的走法+下边相邻格子走法
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0 ; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}

// 从起点位置开始分析也可以，dp[i][j]表示从起点到该位置的不用走法，则第一行的每个位置都只有一种走法（起点向右），第一列的每个位置也只有一种走法（起点向下）
class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];
       for (int i = 0; i < m; i++) {
           dp[i][0] = 1;
       }
       for (int j = 0; j < n; j++) {
           dp[0][j] = 1;
       }
       for (int i = 1; i < m; i++) {
           for (int j = 1; j < n; j++) {
               dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
           }
       }
       return dp[m - 1][n - 1];
    }
}