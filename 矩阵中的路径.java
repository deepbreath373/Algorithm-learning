/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 */
public class 矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        char[] words = word.toCharArray();
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(board, rows, cols, row, col, words, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[][] board, int rows, int cols, int row, int col, char[] words, int pathLength, boolean[][] visited) {
        if (pathLength == words.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && board[row][col] == words[pathLength]
                && !visited[row][col]) {
            pathLength++;
            visited[row][col] = true;
            hasPath = hasPathCore(board, rows, cols, row, col - 1, words, pathLength, visited)
                    || hasPathCore(board, rows, cols, row, col + 1, words, pathLength, visited)
                    || hasPathCore(board, rows, cols, row - 1, col, words, pathLength, visited)
                    || hasPathCore(board, rows, cols, row + 1, col, words, pathLength, visited);
            if (!hasPath) {
                pathLength--;
                visited[row][col] = false;
            }

        }
        return hasPath;
    }

    public static void main(String[] args) {
        矩阵中的路径 lj = new 矩阵中的路径();
        char[][] board = {{'a'}};
        boolean ab = lj.exist(board, "ab");
        System.out.println(ab);
    }
}
