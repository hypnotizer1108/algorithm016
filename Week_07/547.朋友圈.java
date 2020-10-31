// 方法一：参考岛屿数量的dfs思路，凡是未访问过的则计数加一，并且将其关联的朋友(M[i][j]=1)一个个都标记为访问过，直到所有的学生都已被访问过，说明全部统计完毕。
// 注意：跟岛屿数量题目的区别在于，岛屿数量问题不能跨越中间的0，本题可以，例如下面表示0和2是朋友，2和1是朋友，则012都是朋友，则朋友圈数量应该为1.但是按照岛屿数量的方式来统计得到的结果则是2
/*
 1 0 1
 0 1 1
 1 1 1
*/

class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int res = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfsMark(i, M, visited);
                res++;
            }   
        }
        return res;
    }

    private void dfsMark(int i, int[][] M, boolean[] visited) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfsMark(j, M, visited);
            }
        }
    }
}