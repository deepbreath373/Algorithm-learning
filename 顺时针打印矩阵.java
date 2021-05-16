/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 */
public class 顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1},
                              {1, 0},
                              {0, -1},
                              {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
    public int[] spiralOrder2(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;
        int l = 0, r = cols - 1, t = 0, b = rows - 1, x = 0;
        int[] res = new int[total];
        while(true){
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if(--r < l) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if(--b < t) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if(++l > r) break;
        }
        return res;
    }
}
