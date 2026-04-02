class Solution {
    public void replace(char[][] board, int i, int j, char replace, char with) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return;
        }

        if (board[i][j] != replace) {
            return;
        }

        board[i][j] = with;
        replace(board, i - 1, j, replace, with);
        replace(board, i, j - 1, replace, with);
        replace(board, i + 1, j, replace, with);
        replace(board, i, j + 1, replace, with);
    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i ++) {
            replace(board, i, 0, 'O', '#');
            replace(board, i, board[0].length - 1, 'O', '#');
        }

        for (int j = 1; j < board[0].length - 1; j ++) {
            replace(board, 0, j, 'O', '#');
            replace(board, board.length - 1, j, 'O', '#');
        }

        for (int i = 1; i < board.length - 1; i ++) {
            for (int j = 1; j < board[0].length - 1; j ++) {
                replace(board, i, j, 'O', 'X');
            }
        }
        
        for (int i = 0; i < board.length; i ++) {
            replace(board, i, 0, '#', 'O');
            replace(board, i, board[0].length - 1, '#', 'O');
        }

        for (int j = 1; j < board[0].length - 1; j ++) {
            replace(board, 0, j, '#', 'O');
            replace(board, board.length - 1, j, '#', 'O');
        }
    }
}
