public class 礼物的最大值 {
    public int maxValue(int[][] grid) {
        //行
        int x = grid.length;
        //列
        int y = grid[0].length;
        //dp数组
        int[][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[x - 1][y - 1];
    }

    public int maxValue2(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        for (int i = 1; i < x; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < y; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[x - 1][y - 1];
    }
}
