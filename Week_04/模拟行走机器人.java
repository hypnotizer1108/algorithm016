class Solution {    
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 坐标格式表示为x,y 先记录下所有障碍物
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(obstacle[0] + "," + obstacle[1]);
        }
        int x = 0, y = 0, direction = 0, res = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) { // 左转
                direction = (direction + 3) % 4;
            } else if (commands[i] == -1) { // 右转
                direction = (direction + 1) % 4;
            } else { // 前进
                int j = 0;
                while (j < commands[i]) {
                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    // 遇到障碍
                    if (obstaclesSet.contains(nextX + "," + nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    j++;
                }
                res = Math.max(res, x * x + y * y);
            }
        }
        return res;
    }
}