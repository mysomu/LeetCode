import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.'); // ✅ Initialize board with '.'
        solve(0, n, 0, 0, 0, board, res);
        return res;
    }

    private void solve(int row, int n, int cols, int diag1, int diag2, char[][] board, List<List<String>> res) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] r : board) list.add(new String(r));
            res.add(list);
            return;
        }
        int available = ((1 << n) - 1) & ~(cols | diag1 | diag2);
        while (available != 0) {
            int pos = available & -available;
            available ^= pos;
            int col = Integer.bitCount(pos - 1);
            board[row][col] = 'Q';
            solve(row + 1, n, cols | pos, (diag1 | pos) << 1, (diag2 | pos) >> 1, board, res);
            board[row][col] = '.'; // ✅ Reset backtracking
        }
    }
}