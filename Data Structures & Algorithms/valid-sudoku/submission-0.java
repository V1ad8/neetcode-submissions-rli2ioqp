class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] cells = new HashSet[9];
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            cells[i] = new HashSet();
            rows[i] = new HashSet();
            cols[i] = new HashSet();
        }

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (rows[i].contains(board[i][j])) {
                    return false;
                }
                rows[i].add(board[i][j]);

                if (cols[j].contains(board[i][j])) {
                    return false;
                }
                cols[j].add(board[i][j]);

                if (cells[(i / 3) * 3 + (j / 3)].contains(board[i][j])) {
                    return false;
                }
                cells[(i / 3) * 3 + (j / 3)].add(board[i][j]);
            }
        }

        return true;
    }
}
