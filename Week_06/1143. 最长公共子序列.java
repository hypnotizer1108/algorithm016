// 固定套路：转换为一个二维数组dp[text1.length + 1][text2.length + 1]，字符串都是从i、j索引为1的位置开始算起，dp[i][j]表示text1的1-i子串和text2的1-j子串之间的最大公共序列长度，dp[text1.length][text2.length]即为所求。
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        } 
        return dp[m][n];
    }
}