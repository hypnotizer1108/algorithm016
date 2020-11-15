class Solution {
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示word1前0到i个位置构成的字符串与word2前0到j个位置构成的字符串之间转换的最少操作数
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化边界：空串转换成长度为n的字符串最少操作数等于n
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                //以相同字符结尾，转换次数等于w1和w2都去掉最后相同的字符后前面的子串转换需要的操作数
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 不同字符结尾，分三种情况，替换、增加、删除
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}