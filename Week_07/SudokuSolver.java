class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) 
			return;
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') 
					continue;
                int num = board[i][j] - '1', k = (i / 3) * 3 + j / 3;
                row[i][num] = col[j][num] = box[k][num] = true;
            }
        }
        solveSudokuHelper(board, 0, row, col, box);
    }

    boolean solveSudokuHelper(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (n == 81) 
			return true;
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') 
			return solveSudokuHelper(board, n + 1, row, col, box);

        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[k][num]) 
				continue;
            board[i][j] = (char) (num + '1');
            row[i][num] = col[j][num] = box[k][num] = true;
            if (solveSudokuHelper(board, n + 1, row, col, box)) 
				return true;
            row[i][num] = col[j][num] = box[k][num] = false;
        }
        board[i][j] = '.';
        return false;
    }
}