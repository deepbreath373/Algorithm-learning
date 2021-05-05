public class 机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        int count = movingCountCore(k, m, n, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int k, int m, int n, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(k, m, n, row, col, visited)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(k, m, n, row, col - 1, visited)
                    + movingCountCore(k, m, n, row, col + 1, visited)
                    + movingCountCore(k, m, n, row - 1, col, visited)
                    + movingCountCore(k, m, n, row + 1, col, visited);
        }
        return count;
    }

    private boolean check(int k, int m, int n, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < m && col >= 0 && col < n
                && getDigitSum(row) + getDigitSum(col) <= k
                && !visited[row][col]) {
            return true;
        }
        return false;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
