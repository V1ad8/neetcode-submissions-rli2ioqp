class Solution {
    public boolean explore(char[][] board, String word, int idx, Set<Pair<Integer, Integer>> set, Pair<Integer, Integer> last) {
        boolean res = false;

        if (idx >= word.length()) {
            return true;
        }

        if (idx == 0) {
            for (int i = 0; i < board.length; i ++) {
                for (int j = 0; j < board[0].length; j ++) {
                    if (board[i][j] == word.charAt(0)) {
                        Pair<Integer, Integer> pair = new Pair(i, j);

                        set.add(pair);
                        res |= explore(board, word, 1, set, pair);
                        set.remove(pair);
                    }
                }
            }

            return res;
        }

        int x = last.getKey();
        int y = last.getValue();

        if (x < board.length - 1) {
            Pair<Integer, Integer> pair = new Pair(x + 1, y);
            if (board[x + 1][y] == word.charAt(idx) && !set.contains(pair)) {
                set.add(pair);
                res |= explore(board, word, idx + 1, set, pair);
                set.remove(pair);
            }
        }

        if (x > 0) {
            Pair<Integer, Integer> pair = new Pair(x - 1, y);
            if (board[x - 1][y] == word.charAt(idx) && !set.contains(pair)) {
                set.add(pair);
                res |= explore(board, word, idx + 1, set, pair);
                set.remove(pair);
            }
        }

        if (y < board[0].length - 1) {
            Pair<Integer, Integer> pair = new Pair(x, y + 1);
            if (board[x][y + 1] == word.charAt(idx) && !set.contains(pair)) {
                set.add(pair);
                res |= explore(board, word, idx + 1, set, pair);
                set.remove(pair);
            }
        }

        if (y > 0) {
            Pair<Integer, Integer> pair = new Pair(x, y - 1);
            if (board[x][y - 1] == word.charAt(idx) && !set.contains(pair)) {
                set.add(pair);
                res |= explore(board, word, idx + 1, set, pair);
                set.remove(pair);
            }
        }

        return res;
    }

    public boolean exist(char[][] board, String word) {
        return explore(board, word, 0, new HashSet(), null);
    }
}
