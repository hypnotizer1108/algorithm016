## 一、高级DP

**关键点和难点**

1.状态如何定义

2.Z态转移方程

**复杂度来源**

1.状态拥有更多维度

2.DP方程更难

不同路径II的状态转移方程
```Java
// 有障碍，该位置不可达，则走法直接为0
if (obstacleGrid[i][j] == 1) {
	dp[i][j] = 0;
} else {// 非障碍，只能从上面一个格子或者左边一个格子走过来
	dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
}
```

基础版[爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
```Java
dp[0] = 1, dp[1] = 2;
for (int 2 = 0; i < n) {
	dp[i] = dp[i- 1] + dp[i - 2];
}
```
进阶：
1.可以走1步、2步、3步
```Java
dp[0] = 1, dp[1] = 2, dp[2] = 4;
for (int 2 = 0; i < n; i++) {
	dp[i] = dp[i - 1] + dp[i -2] + dp[i -3];
}
```

2.可以走的步伐数不固定，定义为数组int[] steps
```Java
for (int i = 0; i < n; i++) {
	for (int j = 0; j < steps.length; j++) {
		// 从i-step[j]走step[j]步
		dp[i] += dp[i - steps[j]];
	}
}
```

3.不能走相同的步伐 
状态增加一个维度，记录下当前走多少步

#### 二、字符串算法

两个字符串之间的最值问题，通常可以用DP来解决，关键是要将状态定义成二维数组。

[1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
dp[i][j]表示第一个s1前0到i个字符串与s2前0-j个字符串之间的最长公共子序列

[72.编辑距离](https://leetcode-cn.com/problems/edit-distance/)
dp[i][j]表示word1前0到i个位置构成的字符串与word2前0到j个位置构成的字符串之间转换的最少操作数
